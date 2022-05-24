package Modelo.Factory;

import java.util.ArrayList;

/**
 * DATOS JORNADAS XML
 * @author Equipo-6
 */
public class DatosJornadasXML {

    /**
     * PARTIDO
     * @author Equipo-6
     */
    public class Partido {

        private int codPartido;
        private String horaPartido;
        private String resultado;

        private ArrayList<String> equipos;

        /**
         *
         * CONTRUCTOR PARTIDO
         *
         * @param codPartido
         * @param horaPartido
         * @param resultado
         *
         **/
        public Partido(int codPartido, String horaPartido, String resultado) {
            equipos = new ArrayList<>();
            this.codPartido = codPartido;
            this.horaPartido = horaPartido;
            this.resultado = resultado;
        }

        /**
         *
         * AÑADIR NOMBRE EQUIPO A LA LISTA DE EQUIPOS
         *
         * @param nombre
         *
         **/
        public void addEquipo(String nombre) {
            this.equipos.add(nombre);
        }

        /**
         *
         * GETTER A LA LISTA DE EQUIPOS
         *
         * @return  equipos
         *
         **/
        public ArrayList<String> getEquipos() {
            return equipos;
        }

        /**
         *
         * GETTER CODIGO PARTIDO
         *
         * @return  codPartido
         *
         **/
        public int getCodPartido() {
            return codPartido;
        }

        /**
         *
         * GETTER HORA PARTIDO
         *
         * @return  horaPartido
         *
         **/
        public String getHoraPartido() {
            return horaPartido;
        }

        /**
         *
         * GETTER RESULTADO PARTIDO
         *
         * @return  resultado
         *
         **/
        public String getResultado() {
            return resultado;
        }
    }

    /**
     * JORNADA
     * @author Equipo-6
     */
    public class Jornada {
        private int num_jornada;
        private String fecha_jornada;

        private ArrayList<Partido> partidos;

        /**
         *
         * CONTRUCTOR JORNADA
         *
         * @param num_jornada
         * @param fecha_jornada
         *
         **/
        public Jornada(int num_jornada, String fecha_jornada) {
            partidos = new ArrayList<>();
            this.num_jornada = num_jornada;
            this.fecha_jornada = fecha_jornada;
        }

        /**
         *
         * AÑADIR PARTIDO A LA LISTA DE PARTIDOS
         *
         * @param codPartido
         * @param horaPartido
         * @param resultado
         *
         **/
        public Partido addPartido(int codPartido, String horaPartido, String resultado) {
            Partido partido = new Partido(codPartido, horaPartido, resultado);
            this.partidos.add(partido);
            return partido;
        }

        /**
         *
         * GETTER LISTA PARTIDOS
         *
         * @return  partidos
         *
         **/
        public ArrayList<Partido> getPartidos() {
            return partidos;
        }

        /**
         *
         * GETTER NUMERO DE LA JORNADA
         *
         * @return  num_jornada
         *
         **/
        public int getNum_jornada() {
            return num_jornada;
        }

        /**
         *
         * GETTER FECHA JORNADA
         *
         * @return  fecha_jornada
         *
         **/
        public String getFecha_jornada() {
            return fecha_jornada;
        }
    }

    private ArrayList<Jornada> jornadas;

    /**
     *
     * CONTRUCTOR DATOS JORANADA XML
     *
     **/
    public DatosJornadasXML() {
        jornadas = new ArrayList<>();
    }

    /**
     *
     * AÑADIR JORNADA A LA LISTA DE JORNADA
     *
     * @param num_jornada
     * @param fecha_jornada
     *
     **/
    public Jornada addJornada(String num_jornada, String fecha_jornada) {
        Jornada jornada = new Jornada(Integer.parseInt(num_jornada), fecha_jornada);
        this.jornadas.add(jornada);
        return jornada;
    }

    /**
     *
     * GETTER LISTA JORNADAS
     *
     * @return  jornadas
     *
     **/
    public ArrayList<Jornada> getJornadas() {
        return jornadas;
    }
}
