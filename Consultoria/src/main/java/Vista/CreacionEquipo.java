package Vista;

import javax.swing.*;
import java.awt.event.*;

public class CreacionEquipo extends JDialog {
    private JPanel CEQPrincipal;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JLabel NNombre;
    private JLabel NFecha;
    private JLabel NCiudad;
    private JLabel NEsponsor;
    private JLabel NDueño;

    public CreacionEquipo() {
        setContentPane(CEQPrincipal);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        CEQPrincipal.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);


        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Equipo creado");
                return;
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        CreacionEquipo dialog = new CreacionEquipo();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    @Override
    public JPanel getContentPane() {
        return CEQPrincipal;
    }

    public void setContentPane(JPanel contentPane) {
        this.CEQPrincipal = contentPane;
    }

    public JButton getButtonOK() {
        return buttonOK;
    }

    public void setButtonOK(JButton buttonOK) {
        this.buttonOK = buttonOK;
    }

    public JButton getButtonCancel() {
        return buttonCancel;
    }

    public void setButtonCancel(JButton buttonCancel) {
        this.buttonCancel = buttonCancel;
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public void setTextField1(JTextField textField1) {
        this.textField1 = textField1;
    }

    public JTextField getTextField2() {
        return textField2;
    }

    public void setTextField2(JTextField textField2) {
        this.textField2 = textField2;
    }

    public JTextField getTextField3() {
        return textField3;
    }

    public void setTextField3(JTextField textField3) {
        this.textField3 = textField3;
    }

    public JTextField getTextField4() {
        return textField4;
    }

    public void setTextField4(JTextField textField4) {
        this.textField4 = textField4;
    }

    public JTextField getTextField5() {
        return textField5;
    }

    public void setTextField5(JTextField textField5) {
        this.textField5 = textField5;
    }

    public JLabel getNNombre() {
        return NNombre;
    }

    public void setNNombre(JLabel NNombre) {
        this.NNombre = NNombre;
    }

    public JLabel getNFecha() {
        return NFecha;
    }

    public void setNFecha(JLabel NFecha) {
        this.NFecha = NFecha;
    }

    public JLabel getNCiudad() {
        return NCiudad;
    }

    public void setNCiudad(JLabel NCiudad) {
        this.NCiudad = NCiudad;
    }

    public JLabel getNEsponsor() {
        return NEsponsor;
    }

    public void setNEsponsor(JLabel NEsponsor) {
        this.NEsponsor = NEsponsor;
    }

    public JLabel getNDueño() {
        return NDueño;
    }

    public void setNDueño(JLabel NDueño) {
        this.NDueño = NDueño;
    }

    public JPanel getCEQPrincipal() {
        return CEQPrincipal;
    }

    public void setCEQPrincipal(JPanel CEQPrincipal) {
        this.CEQPrincipal = CEQPrincipal;
    }
}
