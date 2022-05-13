package Vista;

import javax.swing.*;
import java.awt.event.*;

public class CreacionAsistente extends JDialog {
    private JPanel CAPrincipal;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField Nombre;
    private JTextField Apellido;
    private JTextField Sueldo;
    private JTextField Nacimiento;
    private JTextField Nacionalidad;
    private JTextField Nickname;
    private JComboBox Entrenador;
    private JLabel NNombre;
    private JLabel NApellido;
    private JLabel NSueldo;
    private JLabel NNacimiento;
    private JLabel NNacionalidad;
    private JLabel NNickname;
    private JLabel NEntrenador;

    public CreacionAsistente() {
        setContentPane(CAPrincipal);
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
        CAPrincipal.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Asistente creado");
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
        CreacionAsistente dialog = new CreacionAsistente();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    public JPanel getCAPrincipal() {
        return CAPrincipal;
    }

    public void setCAPrincipal(JPanel CAPrincipal) {
        this.CAPrincipal = CAPrincipal;
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

    public JTextField getNombre() {
        return Nombre;
    }

    public void setNombre(JTextField nombre) {
        Nombre = nombre;
    }

    public JTextField getApellido() {
        return Apellido;
    }

    public void setApellido(JTextField apellido) {
        Apellido = apellido;
    }

    public JTextField getSueldo() {
        return Sueldo;
    }

    public void setSueldo(JTextField sueldo) {
        Sueldo = sueldo;
    }

    public JTextField getNacimiento() {
        return Nacimiento;
    }

    public void setNacimiento(JTextField nacimiento) {
        Nacimiento = nacimiento;
    }

    public JTextField getNacionalidad() {
        return Nacionalidad;
    }

    public void setNacionalidad(JTextField nacionalidad) {
        Nacionalidad = nacionalidad;
    }

    public JTextField getNickname() {
        return Nickname;
    }

    public void setNickname(JTextField nickname) {
        Nickname = nickname;
    }

    public JComboBox getEntrenador() {
        return Entrenador;
    }

    public void setEntrenador(JComboBox entrenador) {
        Entrenador = entrenador;
    }

    public JLabel getNNombre() {
        return NNombre;
    }

    public void setNNombre(JLabel NNombre) {
        this.NNombre = NNombre;
    }

    public JLabel getNApellido() {
        return NApellido;
    }

    public void setNApellido(JLabel NApellido) {
        this.NApellido = NApellido;
    }

    public JLabel getNSueldo() {
        return NSueldo;
    }

    public void setNSueldo(JLabel NSueldo) {
        this.NSueldo = NSueldo;
    }

    public JLabel getNNacimiento() {
        return NNacimiento;
    }

    public void setNNacimiento(JLabel NNacimiento) {
        this.NNacimiento = NNacimiento;
    }

    public JLabel getNNacionalidad() {
        return NNacionalidad;
    }

    public void setNNacionalidad(JLabel NNacionalidad) {
        this.NNacionalidad = NNacionalidad;
    }

    public JLabel getNNickname() {
        return NNickname;
    }

    public void setNNickname(JLabel NNickname) {
        this.NNickname = NNickname;
    }

    public JLabel getNEntrenador() {
        return NEntrenador;
    }

    public void setNEntrenador(JLabel NEntrenador) {
        this.NEntrenador = NEntrenador;
    }
}
