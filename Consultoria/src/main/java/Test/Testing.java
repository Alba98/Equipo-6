package Test;

import Controlador.Main;

import java.time.LocalDate;
import java.time.LocalTime;

public class Testing {

    public Testing() {

    }

    public static void GenerarTemporadaTest() throws Exception {
       // temporada_dao.crearTemporada();

    }
    private static void GenerarJornadasTest() throws Exception {
      //  jornada_dao.crearJornadas(01,  LocalDate.of(2022, 04, 11));
    }

    private static void GenerarPartidosTest() throws Exception {
        LocalTime now = LocalTime.now();
      //  partido_dao.crearPartido(now, 01, "Real Horses", "Gasteiz-Goya");

    }

    private static void ResultadosPartidosTest() throws Exception {
       // partido_dao.resultadosPartido(01, "3-2");
    }

    private static void GenerarJugadorTest() throws Exception {
       // jugador_dao.crearJugador("The_Core", "TOP", "DARCY", "Wuenz",
        //        LocalDate.of(2001, 05, 14), "Taiwanesa", 20000.0 );
    }

    private static void GenerarEntrenadorTest() throws Exception {
      //  entrenador_dao.crearEntrenador("Slayo_15", "Andrea", "Birel",
       //         LocalDate.of(1997, 05, 14), "Espaniola", 1500.0 );
    }

    private static void GenerarAsistenteTest() throws Exception {
     //   asistente_dao.crearAsistente("Destepo", "Juan", "Antonio",
       //         LocalDate.of(1997, 05, 14), "Alemana", 1500.0,
       //         "Slayo_15" );
    }

    private static void GenerarEquiposTest() throws Exception {
      //   equipo_dao.crearEquipos( "Gasteiz-Goya", LocalDate.of(2021, 01, 23),
      //           "Vitoria", "Goya", "Eneko Alonso");
    }

    private static void ContratoJugadorTest() throws Exception {
      //   equipo_dao.contratoJugador(06, 01,  LocalDate.of(2021, 04, 07),
      //           LocalDate.of(2023, 06, 30));
    }

    private static void ContratoEntrenadorTest() throws Exception {
      //  equipo_dao.contratoJugador(12, 03,  LocalDate.of(2021, 04, 07),
      //          LocalDate.of(2023, 06, 30));
    }

    private static void ContratoAsistenteTest() throws Exception {
      //  equipo_dao.contratoJugador(10, 03,  LocalDate.of(2021, 04, 07),
      //          LocalDate.of(2023, 06, 30));
    }

}
