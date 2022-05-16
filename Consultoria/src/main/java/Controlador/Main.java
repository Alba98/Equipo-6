package Controlador;

import Modelo.BD.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    private static TemporadasDAO temporada_dao;
    private static JornadasDAO jornada_dao;
    private static PartidosDAO partido_dao;
    private static JugadoresDAO jugador_dao;
    private static EntrenadoresDAO entrenador_dao;
    private static AsistentesDAO asistente_dao;
    private static EquiposDAO equipo_dao;

    public static void main(String[] args) {
        try {
            System.out.println("CONSULTORIA E-SPORTS ");

            generarDAO();

        } catch (Exception e) {
            System.out.println("Problemas con la base de datos " + e.getMessage());
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
        LocalDate now = LocalDate.now();
        jornada_dao.crearJornadas(05,  now);
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
}
