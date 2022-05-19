package Modelo.Factory;

import java.util.ArrayList;

public class DatosClasificacionXML {

    public class Jugador {
        private String nickname;
        private String rol;

        public Jugador(String nickname, String rol) {
            this.nickname = nickname;
            this.rol = rol;
        }
    }
    public class Equipo {
        private String nombre;
        private int cod_equipo;
        private int partidos_ganados;
        private ArrayList<Jugador> lista_jugadores;

        public Equipo(String nombre, int cod_equipo, int partidos_ganados) {
            lista_jugadores = new ArrayList<>();
            this.nombre = nombre;
            this.cod_equipo = cod_equipo;
            this.partidos_ganados = partidos_ganados;
        }

        public Jugador addJugador(String nickname, String rol) {
            Jugador jugador = new Jugador(nickname, rol);
            lista_jugadores.add(jugador);
            return  jugador;
        }
    }
    public class Temporada {
        private int cod_temporada;
        private ArrayList<Equipo> equipos;

        public Temporada(int cod_temporada) {
            equipos = new ArrayList<>();
            this.cod_temporada = cod_temporada;
        }

        public Equipo addEquipo(String nombre, int cod_equipo, int partidos_ganados) {
            Equipo equipo = new Equipo(nombre, cod_equipo, partidos_ganados);
            equipos.add(equipo);
            return  equipo;
        }
    }

    private ArrayList<Temporada> temporadas;

    public DatosClasificacionXML() {
        temporadas = new ArrayList<Temporada>();
    }

    public Temporada addTemporada(String cod_temporada) {
        Temporada temporada = new Temporada(Integer.parseInt(cod_temporada));
        this.temporadas.add(temporada);
        return  temporada;
    }

}
