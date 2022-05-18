package Controlador;
import Factory.ReadXmlDomParser;
import Modelo.UML.EntrenadoresEntity;
import Vista.*;
import javax.swing.*;

import Modelo.BD.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static TemporadasDAO temporada_dao;
    private static JornadasDAO jornada_dao;
    private static PartidosDAO partido_dao;
    private static JugadoresDAO jugador_dao;
    private static EntrenadoresDAO entrenador_dao;
    private static AsistentesDAO asistente_dao;
    private static EquiposDAO equipo_dao;

    private static UsuariosDAO usuario_dao;

    private static final DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private static JFrame VLogin, VRegistrar, VAdmin, VCarga;
    private static JDialog VUsuario;

    public static void main(String[] args) {
        try {
            System.out.println("CONSULTORIA E-SPORTS ");

            generarDAO();

            //VentanaCarga();
            //VentanaLogin();
            //VentanaRegistrar("test@gmail.com");
            //VentanaUsuario();
            //VentanaAdmin();

            ReadXmlDomParser xmlParser = new ReadXmlDomParser();
            xmlParser.checkXML();
            
        } catch (Exception e) {
            System.out.println("Problemas " + e.getMessage());
        }
    }

    private static void generarDAO() {
        temporada_dao = new TemporadasDAO();
        jornada_dao = new JornadasDAO();
        partido_dao = new PartidosDAO();
        jugador_dao  = new JugadoresDAO();
        entrenador_dao = new EntrenadoresDAO();
        asistente_dao = new AsistentesDAO();
        equipo_dao = new EquiposDAO();
        usuario_dao = new UsuariosDAO();
    }

    /******************** TEST *************************/
    public static void GenerarTemporadaTest() throws Exception {
        temporada_dao.crearTemporada();
    }
    private static void GenerarJornadasTest() throws Exception {
        jornada_dao.crearJornadas(01,  LocalDate.of(2022, 04, 11));
    }

    private static void GenerarPartidosTest() throws Exception {
        LocalTime now = LocalTime.now();
        partido_dao.crearPartido(now, 01, "Real Horses", "Gasteiz-Goya");
    }

    private static void ResultadosPartidosTest() throws Exception {
        partido_dao.resultadosPartido(01, "3-2");
    }

    private static void GenerarJugadorTest() throws Exception {
        jugador_dao.crearJugador("The_Core", "TOP", "DARCY", "Wuenz",
                LocalDate.of(2001, 05, 14), "Taiwanesa", 20000.0 );
    }

    private static void GenerarEntrenadorTest() throws Exception {
        entrenador_dao.crearEntrenador("Slayo_15", "Andrea", "Birel",
                LocalDate.of(1997, 05, 14), "Espaniola", 1500.0 );
    }

    private static void GenerarAsistenteTest() throws Exception {
        asistente_dao.crearAsistente("Destepo", "Juan", "Antonio",
                LocalDate.of(1997, 05, 14), "Alemana", 1500.0,
                "Slayo_15" );
    }

    private static void GenerarEquiposTest() throws Exception {
        equipo_dao.crearEquipos( "Gasteiz-Goya", LocalDate.of(2021, 01, 23),
                "Vitoria", "Goya", "Eneko Alonso");
    }

    private static void ContratoJugadorTest() throws Exception {
        equipo_dao.contratoJugador(06, 01,  LocalDate.of(2021, 04, 07),
                LocalDate.of(2023, 06, 30));
    }

    private static void ContratoEntrenadorTest() throws Exception {
        equipo_dao.contratoJugador(12, 03,  LocalDate.of(2021, 04, 07),
                LocalDate.of(2023, 06, 30));
    }

    private static void ContratoAsistenteTest() throws Exception {
        equipo_dao.contratoJugador(10, 03,  LocalDate.of(2021, 04, 07),
                LocalDate.of(2023, 06, 30));
    }

    /******************** fin TEST *************************/
    public static void VentanaAdmin() {
        VAdmin = new JFrame("VentanaAdmin");
        VAdmin.setContentPane(new VAdmin().getPanelPrincipal());
        VAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        VAdmin.pack();
        VAdmin.setVisible(true);
    }

    public static void CrearCalendario() {
        String[] botones = {"Si", "No"};
        int ventana = JOptionPane.showOptionDialog(null,
                "¿Estás seguro de crear el calendario? No se podrá modificar ni personas ni equipos",
                "Se va a crear el calendario de esta temporada",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);
        if (ventana == 0){
            System.out.println("Si");}
        else
        if (ventana == 1){
            System.out.println("No");
        }
    }

    public static void VentanaLogin() {
        VLogin = new JFrame("Inicio de sesion");
        VLogin.setContentPane(new VLogin().pPrincipal);
        VLogin.setLocationRelativeTo(null);
        VLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        VLogin.pack();
        VLogin.setVisible(true);

    }

    public static void VentanaRegistrar(String email) {
        VRegistrar = new JFrame("VRegistrar");
        VRegistrar.setContentPane(new VRegistrar(email).getpPrincipal());
        VRegistrar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        VRegistrar.pack();
        VRegistrar.setVisible(true);
    }

    public static void VentanaCarga() {
        VCarga = new JFrame("VCarga");
        VCarga.setContentPane(new VCarga().getPanel1());
        VCarga.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        VCarga.setLocationRelativeTo(null);
        VCarga.pack();
        VCarga.setVisible(true);
    }
    public static void VentanaUsuario() {
        //VCarga.dispose();
        VUsuario = new VUsuario();
        VUsuario.pack();
        VUsuario.setLocationRelativeTo(null);
        VUsuario.setVisible(true);
        System.exit(0);
    }
    public static void getDatosClasificacion(){
        //ClasificacionDAO ?:
    }
    public static void getDatosJornadaFinal(){
        //JornadaDAO where cod_jornada = max(cod_jornada):

    }

    public static void registrarJugador(String nombre, String apellido, String sueldo, String fechaNacimiento,
                                        String nacionalidad, String nickname, String rol) throws Exception{
        LocalDate fecha = LocalDate.parse(fechaNacimiento, formatoFecha);
        jugador_dao.crearJugador(nickname, rol, nombre, apellido, fecha, nacionalidad, Double.parseDouble(sueldo));
    }

    public static void registrarEntrenador(String nombre, String apellido, String sueldo, String fechaNacimiento,
                                           String nacionalidad, String nickname) throws Exception{
        LocalDate fecha = LocalDate.parse(fechaNacimiento, formatoFecha);
        entrenador_dao.crearEntrenador(nickname, nombre, apellido, fecha, nacionalidad, Double.parseDouble(sueldo));
    }

    public static void registrarAsistente(String nombre, String apellido, String sueldo, String fechaNacimiento,
                                          String nacionalidad, String nickname, String entrenador) throws Exception{
        LocalDate fecha = LocalDate.parse(fechaNacimiento, formatoFecha);
        asistente_dao.crearAsistente(nickname, nombre, apellido, fecha, nacionalidad, Double.parseDouble(sueldo), entrenador);
    }

    public static ArrayList<String> getEntrenadores() throws Exception {
        List<EntrenadoresEntity> entrenadores = entrenador_dao.consultarEntrenadores();
        ArrayList<String> nombres = new ArrayList<>(entrenadores.size());
        for (EntrenadoresEntity entrenador : entrenadores) {
             nombres.add(entrenador.getPersonasByCodEntrenador().getNickname());
        }
        return nombres;
    }

    public static void registrarEquipo(String nombre, String creacion, String ciudad, String sponsor, String duenio) throws Exception {
        LocalDate fecha = LocalDate.parse(creacion, formatoFecha);
        equipo_dao.crearEquipos(nombre, fecha, ciudad, sponsor, duenio);
    }

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
                    VentanaUsuario();
                    break;
            }
        } catch (Exception e) {
            if(e.getCause().getCause().getMessage().contains("ORA-20054: Err. email o contrasena incorrecta"))
            {
                VLogin.dispose();
                VentanaRegistrar(email);
            }
        }
    }

    public static void registrarUsuario(String nombre, String passwrd, String email, String nacimiento) throws Exception {
        LocalDate fecha = LocalDate.parse(nacimiento, formatoFecha);
        usuario_dao.crearUsuario(nombre, fecha, passwrd, email);

        VRegistrar.dispose();
        Main.VentanaUsuario();
    }
}

