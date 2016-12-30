/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.cr.design.patterns.view;

import java.awt.Container;
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
import una.cr.design.utils.SpringUtilities;

/**
 *
 * @author John
 */
public class AgregarPacienteView extends JFrame {

    JTextField nombre = new JTextField(15);
    JTextField telefono = new JPasswordField(15);
    JTextField direccion = new JPasswordField(15);
    JTextField fechaNac = new JPasswordField(15);
    JTextField enfermedades = new JPasswordField(15);
    JTextArea observaciones = new JTextArea(4, 15);
    JButton aceptar = new JButton("Aceptar");
    JButton cancelar = new JButton("Cancelar");

    public AgregarPacienteView() {
        super("Agregar Paciente");
        String[] labels = {"Nombre: ", "Telefono: ", "Direccion: ", "Fecha Nacimiento: ",
            "Enfermedades Asociadas: ", "Observaciones: "};
        int numPairs = labels.length;

        //Create and populate the panel.
        JPanel p = new JPanel(new SpringLayout());
        for (int i = 0; i < numPairs; i++) {
            JLabel l = new JLabel(labels[i], JLabel.TRAILING);
            p.add(l);
            JTextField textField = new JTextField(10);
            l.setLabelFor(textField);
            p.add(textField);
        }

        //Lay out the panel.
        SpringUtilities.makeCompactGrid(p,
                numPairs, 2, //rows, cols
                6, 6, //initX, initY
                6, 6);       //xPad, yPad

        //JFrame frame = new JFrame("Informacion Paciente");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        p.setOpaque(true);
        /*frame.*/setContentPane(p);

        /*frame.*/pack();
        /*frame.*/setVisible(true);

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
