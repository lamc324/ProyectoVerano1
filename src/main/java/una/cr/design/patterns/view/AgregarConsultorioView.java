/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.cr.design.patterns.view;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import una.cr.design.controller.AgregarConsultorioController;

/**
 *
 * @author venegas97k
 */
public class AgregarConsultorioView extends JFrame {

    JTextField nombre = new JTextField(20);
    JTextField fechaAtencion = new JTextField(20);
    JTextField telefonoContacto = new JTextField(20);
    JLabel nombreLabel = new JLabel("Nombre: ");
    JLabel horarioLabel = new JLabel("Horario de Atencion: ");
    JLabel telefonoLabel = new JLabel("Telefono: ");
    JButton aceptar = new JButton("Aceptar");
    JButton cancelar = new JButton("Cancelar");

    public AgregarConsultorioView() {
        super("Agregar Consultorio");

        //Create and populate the panel.
        JPanel stringPane = new JPanel();
        stringPane.setLayout(new BoxLayout(stringPane, BoxLayout.Y_AXIS));
        
        stringPane.add(nombreLabel);
        stringPane.add(nombre);
        stringPane.add(horarioLabel);
        stringPane.add(fechaAtencion);
        stringPane.add(telefonoLabel);
        stringPane.add(telefonoContacto);

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

        /*frame.*/
        pack();
        /*frame.*/
        this.setMinimumSize(new Dimension(500, 200));
        setLocationRelativeTo(null);
        setVisible(true);

        //Controller        
        AgregarConsultorioController controller = new AgregarConsultorioController(this);
        aceptar.setActionCommand("clicAceptar");
        aceptar.addActionListener(controller);
        cancelar.setActionCommand("clicCancelar");
        cancelar.addActionListener(controller);

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
