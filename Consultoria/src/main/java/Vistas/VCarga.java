package Vistas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VCarga {
    private JPanel panel1;
    private JProgressBar barraCarga;
    private JButton iniciarButton;
    private JButton button1;
    private Timer t;
    private ActionListener al;

    public VCarga() {
        al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (barraCarga.getValue() <= 100){
                    barraCarga.setValue(barraCarga.getValue()+10);
                }
                else{
                    t.stop();
                }
            }
        };
        t = new Timer(100, al);//milisegungos --> 1000ms = 1s

        iniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!t.isRunning()){
                    t.start();
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("VCarga");
        frame.setContentPane(new VCarga().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
