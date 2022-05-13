package Controlador;

import Modelo.BD.*;
public class Main {
    private static TemporadasDAO temporada_dao;
    private static JornadasDAO jornada_dao;
    private static PartidosDAO partido_dao;

    public static void main(String[] args) {
        try {
            System.out.println("CONSULTORIA E-SPORTS ");

            temporada_dao = new TemporadasDAO();
            //jornada_dao = new JornadasDAO();
            //partido_dao = new PartidosDAO();

            System.out.println("Data Objects");

            temporada_dao.crearTemporada();

            System.out.println("Temporada creada");

        } catch (Exception e) {
            System.out.println("Problemas con la base de datos " + e.getMessage());
        }
    }
}
