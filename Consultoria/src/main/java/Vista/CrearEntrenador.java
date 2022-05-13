package Vista;

import javax.swing.*;
import java.awt.event.*;

public class CrearEntrenador extends JDialog {
    private JPanel CEPrincipal;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField Nombre;
    private JTextField Apellido;
    private JTextField Sueldo;
    private JTextField Nacimiento;
    private JTextField Nacionalidad;
    private JTextField Nickname;
    private JLabel NNombre;
    private JLabel NApellido;
    private JLabel NSueldo;
    private JLabel NNacimiento;
    private JLabel NNacionalidad;
    private JLabel NNickname;

    public CrearEntrenador() {
        setContentPane(CEPrincipal);
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
        CEPrincipal.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Entrenador/a creado");
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
        CrearEntrenador dialog = new CrearEntrenador();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    public JPanel getCEPrincipal() {
        return CEPrincipal;
    }

    public void setCEPrincipal(JPanel CEPrincipal) {
        this.CEPrincipal = CEPrincipal;
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
}
