/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.cr.design.patterns.view;

import java.awt.Container;
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
    JButton aceptar = new JButton("Aceptar");
    JButton cancelar = new JButton("Cancelar");

    public AgregarPacienteView() {
        super("Agregar Paciente");
        String[] labels = {"Identificación: ", "Nombre: ", "Teléfono: ", "Dirección: ", "Fecha Nacimiento: ",
            "Enfermedades Asociadas: ", "Observaciones: "};
        int numPairs = labels.length;

        //Create and populate the panel.
        JPanel stringPane = new JPanel(new SpringLayout());
        
//        for (int i = 0; i < numPairs; i++) {
//            JLabel l = new JLabel(labels[i], JLabel.TRAILING);
//            stringPane.add(l);
//            JTextField textField = new JTextField();
//            l.setLabelFor(textField);
//            stringPane.add(textField);
//        }

/////////////////////////////////////////////////////////////////////
        JLabel l0 = new JLabel(labels[0], JLabel.TRAILING);
        stringPane.add(l0);
        l0.setLabelFor(id);
        stringPane.add(id);
        
        JLabel l1 = new JLabel(labels[1], JLabel.TRAILING);
        stringPane.add(l1);
        l1.setLabelFor(nombre);
        stringPane.add(nombre);
        
        JLabel l2 = new JLabel(labels[2], JLabel.TRAILING);
        stringPane.add(l2);
        l2.setLabelFor(telefono);
        stringPane.add(telefono);
        
        JLabel l3 = new JLabel(labels[3], JLabel.TRAILING);
        stringPane.add(l3);
        l3.setLabelFor(direccion);
        stringPane.add(direccion);
        
        JLabel l4 = new JLabel(labels[4], JLabel.TRAILING);
        stringPane.add(l4);
        l4.setLabelFor(fechaNac);
        stringPane.add(fechaNac);
        
        JLabel l5 = new JLabel(labels[5], JLabel.TRAILING);
        stringPane.add(l5);
        l5.setLabelFor(enfermedades);
        stringPane.add(enfermedades);
        
        JLabel l6 = new JLabel(labels[6], JLabel.TRAILING);
        stringPane.add(l6);
        l6.setLabelFor(observaciones);
        stringPane.add(observaciones);
/////////////////////////////////////////////////////////////////////
        JPanel buttonPane = new JPanel();
        buttonPane.add(aceptar);
        buttonPane.add(cancelar);

        //Lay out the panel.
        SpringUtilities.makeCompactGrid(stringPane,
                numPairs, 2, //rows, cols
                6, 6, //initX, initY
                6, 6);       //xPad, yPad

        //JFrame frame = new JFrame("Informacion Paciente");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
