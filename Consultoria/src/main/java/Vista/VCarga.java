package Vista;

import Controlador.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VCarga {
    private JPanel panel1;
    private JProgressBar barraCarga;
    private JButton iniciarButton;
    private JLabel imagen;
    private Timer t;
    private ActionListener al;

    public VCarga() {
        imagen.setIcon(new ImageIcon("src/main/java/Imagenes/logo.png"));


        iniciarButton.setBorderPainted(false);
        iniciarButton.setFocusable(false);
        iniciarButton.setRolloverEnabled(true);

        iniciarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                iniciarButton.setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                iniciarButton.setBackground(UIManager.getColor("control"));
            }
        });

        al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (barraCarga.getValue() < 100){
                    barraCarga.setValue(barraCarga.getValue()+10);
                }
                else{
                    t.stop();
                    Main.VUsuario();
                }
            }
        };
        t = new Timer(150, al);//milisegungos --> 1000ms = 1s

        iniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!t.isRunning()){
                    t.start();
                }
            }
        });
    }

    private ImageIcon createImageIcon(String path, String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null){
            return new ImageIcon(imgURL, description);
        }
        else{
            System.out.println("No se ha encontrado el archivo: " + path);
            return null;
        }
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
