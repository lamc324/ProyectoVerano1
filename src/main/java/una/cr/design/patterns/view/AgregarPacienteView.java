package una.cr.design.patterns.view;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Spring;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import una.cr.design.controller.AgregarPacienteController;
import una.cr.design.utils.SpringUtilities;

/**
 *
 * @author John
 */
public class AgregarPacienteView extends JFrame {

    JTextField id = new JTextField(15);
    JTextField nombre = new JTextField(15);
    JTextField telefono = new JTextField(15);
    JTextField direccion = new JTextField(15);
    JTextField fechaNac = new JTextField(15);
    JTextField enfermedades = new JTextField(15);
    JTextArea observaciones = new JTextArea(4, 15);
    JLabel idLabel = new JLabel("Identificacion: ");
    JLabel nombreLabel = new JLabel("Nombre: ");
    JLabel telefLabel = new JLabel("Telefono: ");
    JLabel dirLabel = new JLabel("Direccion: ");
    JLabel fechaLabel = new JLabel("Fecha Nacimiento: ");
    JLabel EnfermLabel = new JLabel("Enfermedades Asociadas: ");
    JLabel ObvsLabel = new JLabel("Observaciones: ");
    JButton aceptar = new JButton("Aceptar");
    JButton cancelar = new JButton("Cancelar");

    public AgregarPacienteView() {
        super("Agregar Paciente");

        //Create and populate the panel.
        JPanel stringPane = new JPanel();
        stringPane.setLayout(new BoxLayout(stringPane, BoxLayout.Y_AXIS));
        stringPane.add(idLabel);
        stringPane.add(id);
        stringPane.add(nombreLabel);
        stringPane.add(nombre);
        stringPane.add(telefLabel);
        stringPane.add(telefono);
        stringPane.add(dirLabel);
        stringPane.add(direccion);
        stringPane.add(fechaLabel);
        stringPane.add(fechaNac);
        stringPane.add(EnfermLabel);
        stringPane.add(enfermedades);
        stringPane.add(ObvsLabel);
        stringPane.add(observaciones);

        JPanel buttonPane = new JPanel();
        buttonPane.add(aceptar);
        buttonPane.add(cancelar);

        JPanel controlPane = new JPanel();
        controlPane.add(stringPane);
        controlPane.add(buttonPane);

        controlPane.setLayout(new BoxLayout(controlPane, BoxLayout.Y_AXIS));
        stringPane.setOpaque(true);
        /*frame.*/
        setContentPane(controlPane);

        // Create controller
        AgregarPacienteController controller = new AgregarPacienteController(id, nombre, telefono, direccion, fechaNac, enfermedades, observaciones);
        aceptar.setActionCommand("clicAceptar");
        aceptar.addActionListener(controller);
        cancelar.setActionCommand("clicCancelar");
        cancelar.addActionListener(controller);

        /*frame.*/
        pack();
        /*frame.*/
        setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(300, 300));
        
        setVisible(true);

    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }

}

