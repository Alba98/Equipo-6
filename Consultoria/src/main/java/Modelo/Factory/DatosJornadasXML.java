package Modelo.Factory;

import java.util.ArrayList;

public class DatosJornadasXML {

    public class Partido {

        private int codPartido;
        private String horaPartido;
        private String resultado;

        private ArrayList<String> equipos;

        public Partido(int codPartido, String horaPartido, String resultado) {
            equipos = new ArrayList<>();
            this.codPartido = codPartido;
            this.horaPartido = horaPartido;
            this.resultado = resultado;
        }

        public void addEquipo(String nombre) {
            this.equipos.add(nombre);
        }

        public ArrayList<String> getEquipos() {
            return equipos;
        }

        public int getCodPartido() {
            return codPartido;
        }

        public String getHoraPartido() {
            return horaPartido;
        }

        public String getResultado() {
            return resultado;
        }
    }

    public class Jornada {
        private int num_jornada;
        private String fecha_jornada;

        private ArrayList<Partido> partidos;

        public Jornada(int num_jornada, String fecha_jornada) {
            partidos = new ArrayList<>();
            this.num_jornada = num_jornada;
            this.fecha_jornada = fecha_jornada;
        }

        public Partido addPartido(int codPartido, String horaPartido, String resultado) {
            Partido partido = new Partido(codPartido, horaPartido, resultado);
            this.partidos.add(partido);
            return partido;
        }

        public ArrayList<Partido> getPartidos() {
            return partidos;
        }

        public int getNum_jornada() {
            return num_jornada;
        }

        public String getFecha_jornada() {
            return fecha_jornada;
        }
    }

    private ArrayList<Jornada> jornadas;

    public DatosJornadasXML() {
        jornadas = new ArrayList<>();
    }

    public Jornada addJornada(String num_jornada, String fecha_jornada) {
        Jornada jornada = new Jornada(Integer.parseInt(num_jornada), fecha_jornada);
        this.jornadas.add(jornada);
        return jornada;
    }

    public ArrayList<Jornada> getJornadas() {
        return jornadas;
    }
}
