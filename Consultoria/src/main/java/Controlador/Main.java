package Controlador;
import Vista.*;
import javax.swing.*;

import Modelo.BD.*;

import java.time.LocalDate;
import java.time.LocalTime;

import Vistas.VCarga;
import Vistas.VUsuario;

import javax.swing.*;

public class Main {
    private static TemporadasDAO temporada_dao;
    private static JornadasDAO jornada_dao;
    private static PartidosDAO partido_dao;
    private static JugadoresDAO jugador_dao;
    private static EntrenadoresDAO entrenador_dao;
    private static AsistentesDAO asistente_dao;
    private static EquiposDAO equipo_dao;
    private static JFrame carga;
    private static JDialog usuario;

    private static JFrame frame;

    public static void main(String[] args) {
        try {
            System.out.println("CONSULTORIA E-SPORTS ");

            generarDAO();

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
    }

    /******************** TEST *************************/
    public static void GenerarTemporadaTest() {
        temporada_dao.crearTemporada();
    }
    private static void GenerarJornadasTest() {
        jornada_dao.crearJornadas(01,  LocalDate.of(2022, 04, 11));
    }

    private static void GenerarPartidosTest() {
        LocalTime now = LocalTime.now();
        partido_dao.crearPartido(now, 01, "Real Horses", "Gasteiz-Goya");
    }

    private static void ResultadosPartidosTest() {
        partido_dao.resultadosPartido(01, "3-2");
    }

    private static void GenerarJugadorTest() {
        jugador_dao.crearJugador("The_Core", "TOP", "DARCY", "Wuenz",
                LocalDate.of(2001, 05, 14), "Taiwanesa", 20000.0 );
    }

    private static void GenerarEntrenadorTest() {
        entrenador_dao.crearEntrenador("Slayo_15", "Andrea", "Birel",
                LocalDate.of(1997, 05, 14), "Espaniola", 1500.0 );
    }

    private static void GenerarAsistenteTest() {
        asistente_dao.crearAsistente("Destepo", "Juan", "Antonio",
                LocalDate.of(1997, 05, 14), "Alemana", 1500.0,
                "Slayo_15" );
    }

    private static void GenerarEquiposTest() {
        equipo_dao.crearEquipos( "Gasteiz-Goya", LocalDate.of(2021, 01, 23),
                "Vitoria", "Goya", "Eneko Alonso");
    }

    private static void ContratoJugadorTest() {
        equipo_dao.contratoJugador(06, 01,  LocalDate.of(2021, 04, 07),
                LocalDate.of(2023, 06, 30));
    }

    private static void ContratoEntrenadorTest() {
        equipo_dao.contratoJugador(12, 03,  LocalDate.of(2021, 04, 07),
                LocalDate.of(2023, 06, 30));
    }

    private static void ContratoAsistenteTest() {
        equipo_dao.contratoJugador(10, 03,  LocalDate.of(2021, 04, 07),
                LocalDate.of(2023, 06, 30));
    }

    private static void VentanaAdmin() {
        JFrame frame = new JFrame("VentanaAdmin");
        frame.setContentPane(new VAdmin().getPanelPrincipal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
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
            System.out.println("No");}
    }

    public static void VLogin() {
        frame = new JFrame("Inicio de sesion");
        frame.setContentPane(new VLogin().pPrincipal);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public static void VRegistrar() {
        JFrame frame = new JFrame("VRegistrar");
        frame.setContentPane(new VRegistrar().getpPrincipal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public static void CrearCuenta() {
        VRegistrar();
    }
    public static void VCarga() {
        carga = new JFrame("VCarga");
        carga.setContentPane(new VCarga().getPanel1());
        carga.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        carga.setLocationRelativeTo(null);
        carga.pack();
        carga.setVisible(true);
    }
    public static void VUsuario() {
        carga.dispose();
        usuario = new VUsuario();
        usuario.pack();
        usuario.setLocationRelativeTo(null);
        usuario.setVisible(true);
        System.exit(0);
    }
    public static void getDatosClasificacion(){
        //ClasificacionDAO ?:
    }
    public static void getDatosJornadaFinal(){
        //JornadaDAO where cod_jornada = max(cod_jornada):

    }
}

