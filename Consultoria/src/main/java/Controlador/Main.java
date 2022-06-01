package Controlador;
import Excepciones.Validaciones;
import Modelo.Factory.DatosJornadasXML;
import Modelo.Factory.ReadXmlDomParser;
import Modelo.UML.*;
import Vista.*;
import javax.swing.*;
import javax.swing.border.Border;
import Modelo.BD.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

/**
 * MAIN
 * @author EQUIPO-6
 */
public class Main {
    private static TemporadasDAO temporada_dao;
    private static JornadasDAO jornada_dao;
    private static PartidosDAO partido_dao;
    private static JugadoresDAO jugador_dao;
    private static EntrenadoresDAO entrenador_dao;
    private static AsistentesDAO asistente_dao;
    private static EquiposDAO equipo_dao;
    private static UsuariosDAO usuario_dao;
    private static AlmacenXML_DAO almacenXML_dao;

    private static final DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private static JFrame VLogin, VRegistrar, VAdmin, VCarga, VUsuario;

    private static ReadXmlDomParser xmlParser;

    private static ImageIcon icon = new ImageIcon("resources\\Imagenes\\icon.png");

    /**
     *
     * CONTRUCTOR MAIN
     *
     * @param args
     *
     **/
    public static void main(String[] args) {
        try {
            System.out.println("CONSULTORIA E-SPORTS ");

            VentanaCarga();
        } catch (Exception e) {
            System.out.println("Problemas " + e.getMessage());
        }

    }

    /**
     *
     * GENERAR OBJETOS DAO
     *
     **/
    private static void generarDAO() {
        temporada_dao = new TemporadasDAO();
        jornada_dao = new JornadasDAO();
        partido_dao = new PartidosDAO();
        jugador_dao  = new JugadoresDAO();
        entrenador_dao = new EntrenadoresDAO();
        asistente_dao = new AsistentesDAO();
        equipo_dao = new EquiposDAO();
        usuario_dao = new UsuariosDAO();
        almacenXML_dao = new AlmacenXML_DAO();
    }
    /**
     *
     * GENERAR VENTANA ADMINISTRADOR
     *
     **/

    public static void VentanaAdmin() {
        VAdmin = new JFrame("VentanaAdmin");
        VAdmin.setContentPane(new VAdmin().getPanelPrincipal());
        VAdmin.setLocationRelativeTo(null);
        VAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        VAdmin.setIconImage(icon.getImage());
        VAdmin.pack();
        VAdmin.setVisible(true);
    }

    /**
     *
     * GENERAR VENTANA DE LOGIN
     *
     **/
    public static void VentanaLogin() {
        VLogin = new JFrame("Inicio de sesion");
        VLogin.setContentPane(new VLogin().getpPrincipal());
        VLogin.setLocationRelativeTo(null);
        VLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        VLogin.setIconImage(icon.getImage());
        VLogin.pack();
        VLogin.setVisible(true);
    }

    /**
     *
     * GENERAR VENTANA DE REGISTRO
     * @param email
     **/
    public static void VentanaRegistrar(String email) {
        VRegistrar = new JFrame("VRegistrar");
        VRegistrar.setContentPane(new VRegistrar(email).getpPrincipal());
        VRegistrar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        VRegistrar.setIconImage(icon.getImage());
        VRegistrar.setLocationRelativeTo(null);
        VRegistrar.pack();
        VRegistrar.setVisible(true);
    }

    /**
     *
     * GENERAR VENTANA DE CARGA
     *
     **/

    public static void VentanaCarga() {
        VCarga = new JFrame("VCarga");
        VCarga.setContentPane(new VCarga().getpPrincipal());
        VCarga.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        VCarga.setIconImage(icon.getImage());
        VCarga.setLocationRelativeTo(null);
        VCarga.pack();
        VCarga.setVisible(true);
    }

    /**
     *
     * GENERAR VENTANA USUARIO
     * @param admin
     **/

    public static void VentanaUsuario(boolean admin) {
        VUsuario = new JFrame("VUsuario");
        VUsuario.setContentPane(new VUsuario(admin).getpPrincipal());
        VUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        VUsuario.setIconImage(icon.getImage());
        VUsuario.setLocationRelativeTo(null);
        VUsuario.pack();
        VUsuario.setVisible(true);

    }

    /**
     *
     * GENERAR CALENDARIO
     * @return
     * @throws Exception
     **/

    public static void CrearCalendario(String fechaPrimera) throws Exception {
        String[] botones = {"Si", "No"};
        int ventana = JOptionPane.showOptionDialog(null,
                "¿Estás seguro de crear el calendario? No se podrá modificar ni personas ni equipos",
                "Se va a crear el calendario de esta temporada",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);
        if (ventana == 0){
            System.out.println("Realizando el calendario");
            LocalDate fecha = LocalDate.parse(fechaPrimera, formatoFecha);
            OrganizarCalendario(fecha);
        }
        else
        if (ventana == 1){
            System.out.println("Se le devolverá a la pantalla anterior");
            return;
        }
    }

    /**
     *
     * GENERAR ORGANIZACION DEL CALENDARIO
     * @return
     * @throws Exception
     **/

    public static void OrganizarCalendario(LocalDate fechaJornada) throws Exception {
        int codTemporada = temporada_dao.getUltimaTemporada();

        if(codTemporada == -1 || temporada_dao.getTemporada(codTemporada).getAbierta() == "N") {
            temporada_dao.crearTemporada();
            codTemporada = temporada_dao.getUltimaTemporada();
        }

        //comprobar si se puede cerrar la temporada
        temporada_dao.cerrarTemporada(codTemporada);

        jornada_dao.crearJornadas(codTemporada, fechaJornada);

        //generar emparejamientos partidos
        generarEmparejamientos(temporada_dao.getTemporada(codTemporada));
    }

    private static void generarEmparejamientos(TemporadasEntity temporada) throws Exception {
        List<EquiposEntity> equipos = equipo_dao.consultarEquipos();
        List<JornadasEntity> jornadas = jornada_dao.getJornadasTemporada(temporada.getCodTemporada());
        int partidos = (equipos.size()/2)*(jornadas.size())/2;


        int countJornada = 0;

        for (int eq1=0; eq1 < equipos.size(); eq1++)
        {
            LocalTime startTime = LocalTime.parse("11:00");
            System.out.println("Jornada " + countJornada);

            for (int eq2 = eq1+1, e1 = eq1; eq2 <= eq1 + partidos/2; eq2++, e1 = (e1 + 3) % equipos.size() )
            {
                if(eq2 != e1)
                {
                    partido_dao.crearPartido(startTime.toString(),
                            jornadas.get(countJornada).getCodJornada(),
                            equipos.get(e1).getNombre(),
                            equipos.get(eq2 % equipos.size()).getNombre());

                    startTime = startTime.plusHours(2);

                    // System.out.println(equipos.get(e1).getCodEquipo() + " vs "+ equipos.get(eq2 % equipos.size()).getCodEquipo());
                }
            }
            countJornada++;
        }
    }

    /**
     *
     * OBTENER DATOS DE LA CLASIFICACION DESDE EL ALMACEN XML
     * @return almacenXML_dao
     * @throws Exception
     **/


    public static String getDatosClasificacionXML() throws Exception{
        almacenXML_dao.borrarDatos();
        almacenXML_dao.generarClasificion();

        return almacenXML_dao.getDatos().getResultXml();
    }


    /**
     *
     * OBTENER DATOS DE LAs JORNADAS DESDE EL ALMACEN XML
     * @return almacenXML_dao
     * @throws Exception
     *
     **/

    public static String getDatosJornadasXML() throws Exception{
        almacenXML_dao.borrarDatos();
        almacenXML_dao.generarJornadas();

        return almacenXML_dao.getDatos().getResultXml();
    }

    /**
     *
     * REGISTRAR JUGADOR
     * @param  nombre
     * @param  apellido
     * @param  sueldo
     * @param  fechaNacimiento
     * @param  nacionalidad
     * @param  nickname
     * @param  rol
     * @throws Exception
     **/

    public static void registrarJugador(String nombre, String apellido, String sueldo, String fechaNacimiento,
                                        String nacionalidad, String nickname, String rol)
            throws Exception{
        LocalDate fecha = LocalDate.parse(fechaNacimiento, formatoFecha);
        jugador_dao.crearJugador(nickname, rol, nombre, apellido, fecha, nacionalidad, Double.parseDouble(sueldo));
    }

    /**
     *
     * REGISTRAR ENTRENADOR
     * @param  nombre
     * @param  apellido
     * @param  sueldo
     * @param  fechaNacimiento
     * @param  nacionalidad
     * @param  nickname
     * @throws Exception
     **/

    public static void registrarEntrenador(String nombre, String apellido, String sueldo, String fechaNacimiento,
                                           String nacionalidad, String nickname) throws Exception{
        LocalDate fecha = LocalDate.parse(fechaNacimiento, formatoFecha);
        entrenador_dao.crearEntrenador(nickname, nombre, apellido, fecha, nacionalidad, Double.parseDouble(sueldo));
    }

    /**
     *
     * REGISTRAR ASISTENTES
     * @param  nombre
     * @param  apellido
     * @param  sueldo
     * @param  fechaNacimiento
     * @param  nacionalidad
     * @param  nickname
     * @param entrenador
     * @throws Exception
     **/

    public static void registrarAsistente(String nombre, String apellido, String sueldo, String fechaNacimiento,
                                          String nacionalidad, String nickname, String entrenador) throws Exception{
        LocalDate fecha = LocalDate.parse(fechaNacimiento, formatoFecha);
        asistente_dao.crearAsistente(nickname, nombre, apellido, fecha, nacionalidad, Double.parseDouble(sueldo), entrenador);
    }

    /**
     *
     * REGISTRAR EQUIPO
     * @param  nombre
     * @param  creacion
     * @param  ciudad
     * @param  sponsor
     * @param  duenio
     * @throws Exception
     *
     **/


    public static void registrarEquipo(String nombre, String creacion, String ciudad, String sponsor, String duenio) throws Exception {
        LocalDate fecha = LocalDate.parse(creacion, formatoFecha);
        equipo_dao.crearEquipos(nombre, fecha, ciudad, sponsor, duenio);
    }

    //Borrar jugadores, entrenadores, asistentes y entrenadores:

    /**
     *
     * BORRAR EQUIPO
     * @param  jugadorBorrar
     * @throws Exception
     *
     **/

    public static void borrarJugador(String jugadorBorrar) throws Exception{
        jugador_dao.borrarJugador(jugadorBorrar);
    }
    /**
     *
     * BORRAR ENTRENADOR
     * @param  nomEntre
     * @throws Exception
     *
     **/


    public static void borrarEntrenador(String nomEntre) throws Exception{
        entrenador_dao.borrarEntrenador(nomEntre);
    }

    /**
     *
     * BORRAR ASISTENTE
     * @param nomAsis
     * @throws Exception
     *
     **/

    public static void borrarAsistente(String nomAsis) throws Exception{
        asistente_dao.borrarAsistente(nomAsis);
    }

    /**
     *
     * BORRAR EQUIPO
     * @param nomEqui
     * @throws Exception
     *
     **/

    public static void borrarEquipo(String nomEqui) throws Exception{
        equipo_dao.borrarEquipo(nomEqui);
    }


    /**
     *
     * GETTER ENTRENADORES DESDE UN ARRAYLIST Y OBTENER LOS NOMBRES
     * @return nombres
     * @throws Exception
     *
     **/

    public static ArrayList<String> getEntrenadores() throws Exception {
        List<EntrenadoresEntity> entrenadores = entrenador_dao.consultarEntrenadores();
        ArrayList<String> nombres = new ArrayList<>(entrenadores.size());
        for (EntrenadoresEntity entrenador : entrenadores) {
            nombres.add(entrenador.getPersonasByCodEntrenador().getNickname());
        }
        return nombres;
    }

    /**
     *
     * GETTER ASISTENTES DESDE UN ARRAYLIST Y OBTENER LOS NOMBRES
     * @return nombres
     * @throws Exception
     *
     **/

    public static ArrayList<String> getAsistentes() throws Exception {
        List<AsistentesEntity> asistentes = asistente_dao.consultarAsistentes();
        ArrayList<String> nombres = new ArrayList<>(asistentes.size());
        for (AsistentesEntity asistente : asistentes) {
            nombres.add(asistente.getPersonasByCodAsistente().getNickname());
        }
        return nombres;
    }


    /**
     *
     * GETTER TOPLANERS  DESDE UN ARRAYLIST Y OBTENER LOS NOMBRES
     * @return nombres
     * @throws Exception
     *
     **/

    public static ArrayList<String> getToplaners() throws Exception {
        List<JugadoresEntity> toplaners = jugador_dao.consultarToplaners();
        ArrayList<String> nombres = new ArrayList<>(toplaners.size());
        for (JugadoresEntity toplaner : toplaners) {
            nombres.add(toplaner.getPersonasByCodJugador().getNickname());
        }
        return nombres;
    }

    /**
     *
     * GETTER JUNGLERS DESDE UN ARRAYLIST Y OBTENER LOS NOMBRES
     * @return nombres
     * @throws Exception
     *
     **/

    public static ArrayList<String> getJunglers() throws Exception {
        List<JugadoresEntity> junglers = jugador_dao.consultarJunglers();
        ArrayList<String> nombres = new ArrayList<>(junglers.size());
        for (JugadoresEntity jungler : junglers) {
            nombres.add(jungler.getPersonasByCodJugador().getNickname());
        }
        return nombres;
    }

    /**
     *
     * GETTER MIDLANERS  DESDE UN ARRAYLIST Y OBTENER LOS NOMBRES
     * @return nombres
     * @throws Exception
     *
     **/

    public static ArrayList<String> getMidlaners() throws Exception {
        List<JugadoresEntity> midlaners = jugador_dao.consultarMidlaners();
        ArrayList<String> nombres = new ArrayList<>(midlaners.size());
        for (JugadoresEntity midlaner : midlaners) {
            nombres.add(midlaner.getPersonasByCodJugador().getNickname());
        }
        return nombres;
    }

    /**
     *
     * GETTER ADCARRYS DESDE UN ARRAYLIST Y OBTENER LOS NOMBRES
     * @return nombres
     * @throws Exception
     *
     **/

    public static ArrayList<String> getADCarrys() throws Exception {
        List<JugadoresEntity> ADCarrys = jugador_dao.consultarADCarrys();
        ArrayList<String> nombres = new ArrayList<>(ADCarrys.size());
        for (JugadoresEntity ADCarry : ADCarrys) {
            nombres.add(ADCarry.getPersonasByCodJugador().getNickname());
        }
        return nombres;
    }

    /**
     *
     * GETTER SUPPORTS DESDE UN ARRAYLIST Y OBTENER LOS NOMBRES
     * @return nombres
     * @throws Exception
     *
     **/

    public static ArrayList<String> getSupports() throws Exception {
        List<JugadoresEntity> Supports = jugador_dao.consultarSupports();
        ArrayList<String> nombres = new ArrayList<>(Supports.size());
        for (JugadoresEntity Support : Supports) {
            nombres.add(Support.getPersonasByCodJugador().getNickname());
        }
        return nombres;
    }

    /**
     *
     * GETTER JUGADORES DESDE UN ARRAYLIST Y OBTENER LOS NOMBRES
     * @return nombres
     * @throws Exception
     *
     **/

    public static ArrayList<String> getJugadores() throws Exception {
        List<JugadoresEntity> jugadores = jugador_dao.consultarJugadores();
        ArrayList<String> nombres = new ArrayList<>(jugadores.size());
        for (JugadoresEntity jugador : jugadores) {
            nombres.add(jugador.getPersonasByCodJugador().getNickname());
        }
        return nombres;
    }

    /**
     *
     * GETTER EQUIPOS DESDE UN ARRAYLIST Y OBTENER LOS NOMBRES
     * @return nombres
     * @throws Exception
     *
     **/

    public static ArrayList<String> getEquipos() throws Exception {
        List<EquiposEntity> equipos = equipo_dao.consultarEquipos();
        ArrayList<String> nombres = new ArrayList<>(equipos.size());
        for (EquiposEntity equipo : equipos) {
            nombres.add(equipo.getNombre());
        }
        return nombres;
    }

    /**
     *
     * MÉTODO PARA COMPROBAR EL REGISTRO DEL USUARIO Y ADMINISTRADOR
     * @param email
     * @param password
     *
     **/

    public static void login(String email, char[] password) {
        int rol = 0;
        try {
            rol = usuario_dao.login(email, password);
            switch (rol)
            {
                case 01:
                    //admin
                    System.out.println("admin");
                    VLogin.dispose();
                    VentanaAdmin();
                    break;
                case 02:
                    //usuario
                    System.out.println("usuario");
                    VLogin.dispose();
                    VentanaUsuario(false);
                    break;
            }
        } catch (Exception e) {
            if(e.getCause().getCause().getMessage().contains("Err. usuario no resgistrado"))
            {
                VLogin.dispose();
                VentanaRegistrar(email);
            }
            if(e.getCause().getCause().getMessage().contains("Err. contrasena incorrecta"))
            {
                Validaciones.mostrarError("Credencial incorrecta. Pruebe de nuevo");
            }
        }
    }

    /**
     *
     *GENERAR EL REGISTRO DEL USUARIO
     * @param nombre
     * @param passwrd
     * @param  email
     * @param nacimiento
     * @throws Exception
     **/


    public static void registrarUsuario(String nombre, String passwrd, String email, String nacimiento) throws Exception {
        LocalDate fecha = LocalDate.parse(nacimiento, formatoFecha);
        usuario_dao.crearUsuario(nombre, fecha, passwrd, email);

        VRegistrar.dispose();
        Main.VentanaUsuario(false);
    }

    /**
     *
     *GENERAR LA SECCION DE RESULTADOS DE LA JORNADA
     *
     **/


    public static void PanelJornada() {

        JFrame frame = new JFrame("Resultados Jornadas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(525, 800);


        JPanel pPincipal = new JPanel();
        pPincipal.setBackground(Color.green);
        pPincipal.setBounds(0, 0, 800, 800);
        pPincipal.setLayout(null);
        JScrollPane scroll = new JScrollPane(pPincipal);
        JScrollPane s = new JScrollPane(scroll, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        JScrollBar bar = new JScrollBar();
        s.add(bar);

        Border border = BorderFactory.createLineBorder(Color.PINK, 3);

        int initH_j = 300;
        int offset_j_y = 50;

        int initPos_p_h = 200;

        for (DatosJornadasXML.Jornada jornada : xmlParser.getDatosJornadasXML().getJornadas()) {
            //JORNADA

            int index_j = jornada.getNum_jornada() - 1;
            int n_partidos = jornada.getPartidos().size()-1;

            JPanel pJornada = new JPanel();
            if(index_j%2 == 0)
                pJornada.setBackground(Color.red);
            else
                pJornada.setBackground(Color.orange);

            pJornada.setBounds(25, 25 + (initH_j+offset_j_y)*index_j, 450, initH_j + (initPos_p_h*n_partidos));
            pJornada.setLayout(null);

            {
                JLabel jornada_num = new JLabel();
                jornada_num.setText("JORANADA " + (index_j+1));
                jornada_num.setHorizontalTextPosition(JLabel.CENTER);
                jornada_num.setForeground(Color.GREEN);
                jornada_num.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));

                jornada_num.setBackground(Color.black);
                jornada_num.setOpaque(true);
                jornada_num.setBorder(border);

                jornada_num.setVerticalAlignment(JLabel.CENTER);
                jornada_num.setHorizontalAlignment(JLabel.CENTER);

                jornada_num.setBounds(25, 25, 200, 50);

                pJornada.add(jornada_num);

                JLabel jornada_fecha = new JLabel();
                jornada_fecha.setText(jornada.getFecha_jornada());
                jornada_fecha.setHorizontalTextPosition(JLabel.CENTER);
                jornada_fecha.setForeground(Color.GREEN);
                jornada_fecha.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));

                jornada_fecha.setBackground(Color.black);
                jornada_fecha.setOpaque(true);
                jornada_fecha.setBorder(border);

                jornada_fecha.setVerticalAlignment(JLabel.CENTER);
                jornada_fecha.setHorizontalAlignment(JLabel.CENTER);

                jornada_fecha.setBounds(250, 25, 150, 50);

                pJornada.add(jornada_fecha);
            }

            for (DatosJornadasXML.Partido partido : jornada.getPartidos()) {
                // PARTIDO

                int index_p = partido.getCodPartido() - 1;

                JPanel pPartido = new JPanel();
                if(index_p%2 == 0)
                    pPartido.setBackground(Color.blue);
                else
                    pPartido.setBackground(Color.green);
                //pPartido.setBounds(25, 25+50, 400, 200);
                pPartido.setBounds(25, 75 + (initPos_p_h)*index_p, 400, initPos_p_h );
                pPartido.setLayout(null);

                {
                    JLabel partido_num = new JLabel();
                    partido_num.setText("PARTIDO " + (index_p + 1));
                    partido_num.setHorizontalTextPosition(JLabel.CENTER);
                    partido_num.setForeground(Color.GREEN);
                    partido_num.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));

                    partido_num.setBackground(Color.black);
                    partido_num.setOpaque(true);
                    partido_num.setBorder(border);

                    partido_num.setVerticalAlignment(JLabel.CENTER);
                    partido_num.setHorizontalAlignment(JLabel.CENTER);

                    partido_num.setBounds(25, 25, 175, 50);

                    JLabel partido_h = new JLabel();
                    partido_h.setText(partido.getHoraPartido());
                    partido_h.setHorizontalTextPosition(JLabel.CENTER);
                    partido_h.setForeground(Color.GREEN);
                    partido_h.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));

                    partido_h.setBackground(Color.black);
                    partido_h.setOpaque(true);
                    partido_h.setBorder(border);

                    partido_h.setVerticalAlignment(JLabel.CENTER);
                    partido_h.setHorizontalAlignment(JLabel.CENTER);

                    partido_h.setBounds(250, 25, 125, 50);


                    //equipos
                    ArrayList<String> equipos = partido.getEquipos();

                    JLabel equipo1 = new JLabel();
                    equipo1.setText(equipos.get(0));
                    equipo1.setHorizontalTextPosition(JLabel.CENTER);
                    equipo1.setForeground(Color.GREEN);
                    equipo1.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));

                    equipo1.setBackground(Color.black);
                    equipo1.setOpaque(true);
                    equipo1.setBorder(border);

                    equipo1.setVerticalAlignment(JLabel.CENTER);
                    equipo1.setHorizontalAlignment(JLabel.CENTER);

                    equipo1.setBounds(25, 75, 100, 100);

                    JLabel puntuacion = new JLabel();
                    puntuacion.setText(partido.getResultado());
                    puntuacion.setHorizontalTextPosition(JLabel.CENTER);
                    puntuacion.setForeground(Color.blue);
                    puntuacion.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));

                    puntuacion.setBackground(Color.black);
                    puntuacion.setOpaque(true);
                    puntuacion.setBorder(border);

                    puntuacion.setVerticalAlignment(JLabel.CENTER);
                    puntuacion.setHorizontalAlignment(JLabel.CENTER);

                    puntuacion.setBounds(150, 75, 100, 100);

                    JLabel equipo2 = new JLabel();
                    equipo2.setText(equipos.get(1));
                    equipo2.setHorizontalTextPosition(JLabel.CENTER);
                    equipo2.setForeground(Color.GREEN);
                    equipo2.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));

                    equipo2.setBackground(Color.black);
                    equipo2.setOpaque(true);
                    equipo2.setBorder(border);

                    equipo2.setVerticalAlignment(JLabel.CENTER);
                    equipo2.setHorizontalAlignment(JLabel.CENTER);

                    equipo2.setBounds(275, 75, 100, 100);


                    pPartido.add(partido_num);
                    pPartido.add(partido_h);
                    pPartido.add(equipo1);
                    pPartido.add(puntuacion);
                    pPartido.add(equipo2);

                }

                pJornada.add(pPartido);
            }


            pPincipal.add(pJornada);
        }

        s.setVisible(true);
        frame.setVisible(true);
        frame.setContentPane(s);
    }

    /**
     *
     *OBTENER LOS RESULTADOS DE LA JORNADAS DESDE EL ALMACEN XML
     * @return xmlParser.getDatosJornadas()
     *
     **/

    public static String getResultadosJornadas() {
        // PanelJornada();
        return xmlParser.getDatosJornadas();
    }


    /**
     *
     *OBTENER LOS DATOS DE LA CLASIFICACION DESDE EL ALMACEN XML
     * @return xmlParser.getDatosJornadas()
     *
     **/

    public static String getClasificacion() {
        // PanelClasificacion();
        return xmlParser.getClasificacion();
    }

    /**
     *
     *GENERAR LA CARGA DE DATOS DAO
     *
     *
     **/


    public static void cargarDatos() {
        //load DAO + database conexion
        generarDAO();

        //generate Parser + parse xml
        xmlParser = new ReadXmlDomParser();
        xmlParser.checkXML();
    }

    /**
     *
     *CERRAR LA VENTANA DE CARGA DEL LOG IN
     *
     *
     **/

    public static void cerrarVCarga() {
        VCarga.dispose();
        VentanaLogin();
    }

    /**
     *
     *REGRESO A LA VENTANA DE REGISTRO DESDE EL LOG IN
     *
     *
     **/

    public static void volverLogInRegistrar() {
        VRegistrar.dispose();
        VentanaLogin();
    }

    /**
     *
     *REGRESO A LA VENTANA DEL USUARIO DESDE EL LOG IN
     *
     *
     **/


    public static void volverLogInUsuario() {
        VUsuario.dispose();
        VentanaLogin();
    }

    /**
     *
     *DIRIGIRE A LA VENTANA DEL USUARIO
     *
     *
     **/

    public static void irVUsuario() {
        VAdmin.dispose();
        VentanaUsuario(true);
    }

    /**
     *
     *DIRIGIRE A LA VENTANA DEL ADMIN
     *
     *
     **/
    public static void irVAdmin() {
        VUsuario.dispose();
        VentanaAdmin();
    }

    /**
     *
     *GENERAR LA CONSULTA DE LOS PARTIDOS
     * @throws Exception
     * @return nombres
     **/

    public static TreeMap<Integer, String> getPartidosEquipo() throws Exception{

        List<PartidosEntity> partidos = partido_dao.consultarPartidos();
        TreeMap<Integer, String> nombres = new TreeMap<Integer, String>();

        for (PartidosEntity partido : partidos) {
            for (ParticipaEntity participaEntity : partido.getParticipasByCodPartido()) {
                EquiposEntity equipo1 = participaEntity.getEquiposByCodEquipo1();
                EquiposEntity equipo2 = participaEntity.getEquiposByCodEquipo2();

                nombres.put((int) partido.getCodPartido(), equipo1.getNombre() + " vs " + equipo2.getNombre());
            }
        }
        return nombres;
    }

    /**
     *
     *ACTUALIZAR LOS RESULTADOS DEL PARTIDO
     * @throws Exception
     *
     **/



    public static void actualizaResutlado(int cod_partido, String resultado) throws Exception{
        partido_dao.resultadosPartido(cod_partido, resultado);
    }

    public static String verResultado(int cod_partido) throws Exception{
        List<PartidosEntity> partidos = partido_dao.consultarPartidos();
        for (PartidosEntity partido : partidos) {
            if(partido.getCodPartido() == cod_partido)
                return partido.getResultado();
        }

        return "";
    }
}

