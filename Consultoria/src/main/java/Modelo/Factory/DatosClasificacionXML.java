package Modelo.Factory;

import java.util.ArrayList;

/**
 * DATOS CLASIFICACION XML
 * @author Equipo-6
 */
public class DatosClasificacionXML {

    /**
     * JUGADOR
     * @author Equipo-6
     */
    public class Jugador {
        private String nickname;
        private String rol;

        /**
         *
         * CONTRUCTOR JUGADOR
         *
         * @param nickname
         * @param rol
         *
         **/
        public Jugador(String nickname, String rol) {
            this.nickname = nickname;
            this.rol = rol;
        }

        /**
         *
         * GETTER NICKNAME JUGADOR
         *
         * @return  nickname
         *
         **/
        public String getNickname() {
            return nickname;
        }

        /**
         *
         * GETTER ROL JUGADOR
         *
         * @return  rol
         *
         **/
        public String getRol() {
            return rol;
        }
    }

    /**
     * EQUIPO
     * @author Equipo-6
     */
    public class Equipo {
        private String nombre;
        private int cod_equipo;
        private int partidos_ganados;
        private ArrayList<Jugador> lista_jugadores;

        /**
         *
         * CONTRUCTOR EQUIPO
         *
         * @param nombre
         * @param cod_equipo
         * @param partidos_ganados
         *
         **/
        public Equipo(String nombre, int cod_equipo, int partidos_ganados) {
            lista_jugadores = new ArrayList<>();
            this.nombre = nombre;
            this.cod_equipo = cod_equipo;
            this.partidos_ganados = partidos_ganados;
        }

        /**
         *
         * AÑADIR JUGADOR A LA LISTA DE JUGADORES
         *
         * @param nickname
         * @param rol
         *
         **/
        public Jugador addJugador(String nickname, String rol) {
            Jugador jugador = new Jugador(nickname, rol);
            lista_jugadores.add(jugador);
            return  jugador;
        }

        /**
         *
         * GETTER LISTA JUGADORES
         *
         * @return  lista_jugadores
         *
         **/
        public ArrayList<Jugador> getLista_jugadores() {
            return lista_jugadores;
        }

        /**
         *
         * GETTER NOMBRE EQUIPO
         *
         * @return  nombre
         *
         **/
        public String getNombre() {
            return nombre;
        }

        /**
         *
         * GETTER CODIGO EQUIPO
         *
         * @return  cod_equipo
         *
         **/
        public int getCod_equipo() {
            return cod_equipo;
        }

        /**
         *
         * GETTER PARTIDOS GANADOS POR EL EQUIPO
         *
         * @return  partidos_ganados
         *
         **/
        public int getPartidos_ganados() {
            return partidos_ganados;
        }
    }

    /**
     * TEMPORADA
     * @author Equipo-6
     */
    public class Temporada {
        private int cod_temporada;
        private ArrayList<Equipo> equipos;

        /**
         *
         * CONTRUCTOR TEMPORADA
         *
         * @param cod_temporada
         *
         **/
        public Temporada(int cod_temporada) {
            equipos = new ArrayList<>();
            this.cod_temporada = cod_temporada;
        }

        /**
         *
         * AÑADIR EQUIPO A LA LISTA DE EQUIPOS
         *
         * @param nombre
         * @param cod_equipo
         * @param partidos_ganados
         *
         **/
        public Equipo addEquipo(String nombre, int cod_equipo, int partidos_ganados) {
            Equipo equipo = new Equipo(nombre, cod_equipo, partidos_ganados);
            equipos.add(equipo);
            return  equipo;
        }

        /**
         *
         * GETTER LISTA EQUIPOS
         *
         * @return  equipos
         *
         **/
        public ArrayList<Equipo> getEquipos() {
            return equipos;
        }

        /**
         *
         * GETTER COD TEMPORADA
         *
         * @return  cod_temporada
         *
         **/
        public int getCod_temporada() {
            return cod_temporada;
        }

    }

    private ArrayList<Temporada> temporadas;

    /**
     *
     * CONTRUCTOR DATOS CLASIFICACION XML
     *
     **/
    public DatosClasificacionXML() {
        temporadas = new ArrayList<Temporada>();
    }

    /**
     *
     * AÑADIR TEMPORADA A LA LISTA DE TEMPORADAS
     *
     * @param cod_temporada
     *
     **/
    public Temporada addTemporada(String cod_temporada) {
        Temporada temporada = new Temporada(Integer.parseInt(cod_temporada));
        this.temporadas.add(temporada);
        return  temporada;
    }

    /**
     *
     * GETTER LISTA TEMPORADAS
     *
     * @return  temporadas
     *
     **/
    public ArrayList<Temporada> getTemporadas() {
        return temporadas;
    }
}
