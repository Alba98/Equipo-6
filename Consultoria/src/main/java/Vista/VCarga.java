package Vista;

import Controlador.ConexionThread;
import Controlador.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * VENTANA LOG IN
 * @author Equipo-6
 */
public class VCarga {
    private JPanel pPrincipal;
    private JProgressBar barraCarga;
    private JButton iniciarButton;
    private JLabel imagen;
    private Timer t;
    private ActionListener al;

    boolean cargarDatos = true;

    /**
     *
     * CONTRUCTOR DE LA VENTANA DE CARGA
     *
     **/
    public VCarga() {
        imagen.setIcon(new ImageIcon("src/main/java/Imagenes/logo.png"));

        iniciarButton.setBorderPainted(false);
        iniciarButton.setFocusable(false);
        iniciarButton.setRolloverEnabled(true);

        ConexionThread conexionThead = new ConexionThread();
        Thread thread = new Thread(conexionThead);

        iniciarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                iniciarButton.setBackground(new Color(150,237,217));
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
                if(cargarDatos){
                   //Main.cargarDatos();
                    thread.start();
                    cargarDatos = false;
                }

                if (barraCarga.getValue() < 100){
                    barraCarga.setValue(barraCarga.getValue()+5);
                }
                else{
                    try {
                        thread.join();
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    t.stop();
                    Main.cerrarVCarga();
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


    /**
     *
     * GETTER JPANEL PRINCIPAL DE LA VENTANA
     *
     * @return pPrincipal
     *
     **/
    public JPanel getpPrincipal() {
        return pPrincipal;
    }
}
