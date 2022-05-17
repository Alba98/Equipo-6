package Excepciones;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Validaciones {

    public static boolean validarTexto(JTextField textField) {
        try {
            String nombre = textField.getText();
            if (nombre.isEmpty())
                throw new Exception("El " +  textField.getName() + " es un dato obligatorio");

            // Pattern patron = Pattern.compile("^[A-Z][a-z]+([ ][a-z]+)*$");
            // Matcher m = patron.matcher(nombre);
            // if (!m.matches())
            //     throw new Exception(textField.getName() + " no válido");

            //textField.setEditable(false);
            return true;
        } catch (Exception e) {
            mostrarError(e.getMessage());
            textField.setSelectionStart(0);
            textField.setSelectionEnd(textField.getText().length());
            textField.requestFocus();
            return false;
        }
    }

    public static boolean validarInt(JTextField textField) {
        try {
            String num_s = textField.getText();
            if (num_s.isEmpty())
                throw new Exception("El " +  textField.getName() + " es un dato obligatorio");

            int num = Integer.parseInt(num_s);
            if (num < 0)
                throw new Exception(textField.getName() + " no válido");

            //textField.setEditable(false);
            return true;

        } catch (Exception e) {
            mostrarError(e.getMessage());
            textField.setSelectionStart(0);
            textField.setSelectionEnd(textField.getText().length());
            textField.requestFocus();
            return false;
        }
    }

    public static boolean validarFloat(JTextField textField) {
        try {
            String num_s = textField.getText();
            if (num_s.isEmpty())
                throw new Exception("El " +  textField.getName() + " es un dato obligatorio");

            float num = Float.parseFloat(num_s);
            if (num < 0)
                throw new Exception(textField.getName() + " no válido");

            //textField.setEditable(false);
            return true;

        } catch (Exception e) {
            mostrarError(e.getMessage());
            textField.setSelectionStart(0);
            textField.setSelectionEnd(textField.getText().length());
            textField.requestFocus();
            return false;
        }
    }

    public static boolean validarFecha(JTextField textField) {
        try {
            String date_s = textField.getText();
            if (date_s.isEmpty())
                throw new Exception("El " +  textField.getName() + " es un dato obligatorio");

            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fecha = LocalDate.parse(textField.getText(), formato);

            LocalDate hoy = LocalDate.now();

            if (fecha.compareTo(hoy)<=0)
                throw new Exception("La hora de inicio no puede ser mayor que la de fin");

            return true;

        } catch (Exception e) {
            mostrarError(e.getMessage());
            textField.setSelectionStart(0);
            textField.setSelectionEnd(textField.getText().length());
            textField.requestFocus();
            return false;
        }
    }

    public static boolean validarHora(JTextField hora1, JTextField hora2) {
        try {
            String hora1_s = hora1.getText();
            String hora2_s = hora2.getText();
            if (hora1_s.isEmpty())
                throw new Exception("La hora de inicio es un dato obligatorio");
            if (hora2_s.isEmpty())
                throw new Exception("La hora de fin es un dato obligatorio");

            LocalTime horaI = LocalTime.parse(hora1_s);
            LocalTime horaF = LocalTime.parse(hora2_s);

            if (horaF.compareTo(horaI)<=0)
                throw new Exception("La no validas");

            return true;

        } catch (Exception e) {
            mostrarError(e.getMessage());
            hora1.setSelectionStart(0);
            hora1.setSelectionEnd(hora1.getText().length());
            hora1.requestFocus();
            return false;
        }
    }

    public static void mostrarError(String mensaje) {
        String[] botones = {"Aceptar"};
        JOptionPane.showOptionDialog(null, mensaje, "ERROR",
                JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, botones, botones[0]);
    }
}
