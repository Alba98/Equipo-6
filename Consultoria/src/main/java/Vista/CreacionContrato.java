package Vista;

import javax.swing.*;
import java.awt.event.*;

public class CreacionContrato extends JDialog {
    private JPanel CCPrincipal;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox Codejugador;
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox Codeequipo;
    private JLabel NJugador;
    private JLabel NEquipo;
    private JLabel FInicio;
    private JLabel FFinal;
    private JLabel Aviso;

    public CreacionContrato() {
        setContentPane(CCPrincipal);
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
        CCPrincipal.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Contrato creado");
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
        CreacionContrato dialog = new CreacionContrato();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    public JPanel getCCPrincipal() {
        return CCPrincipal;
    }

    public void setCCPrincipal(JPanel CCPrincipal) {
        this.CCPrincipal = CCPrincipal;
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

    public JComboBox getCodejugador() {
        return Codejugador;
    }

    public void setCodejugador(JComboBox codejugador) {
        Codejugador = codejugador;
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

    public JComboBox getCodeequipo() {
        return Codeequipo;
    }

    public void setCodeequipo(JComboBox codeequipo) {
        Codeequipo = codeequipo;
    }

    public JLabel getNJugador() {
        return NJugador;
    }

    public void setNJugador(JLabel NJugador) {
        this.NJugador = NJugador;
    }

    public JLabel getNEquipo() {
        return NEquipo;
    }

    public void setNEquipo(JLabel NEquipo) {
        this.NEquipo = NEquipo;
    }

    public JLabel getFInicio() {
        return FInicio;
    }

    public void setFInicio(JLabel FInicio) {
        this.FInicio = FInicio;
    }

    public JLabel getFFinal() {
        return FFinal;
    }

    public void setFFinal(JLabel FFinal) {
        this.FFinal = FFinal;
    }

    public JLabel getAviso() {
        return Aviso;
    }

    public void setAviso(JLabel aviso) {
        Aviso = aviso;
    }
}
