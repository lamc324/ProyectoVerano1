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
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import una.cr.design.controller.AgregarConsultorioController;
import una.cr.design.utils.SpringUtilities;

/**
 *
 * @author venegas97k
 */
public class AgregarConsultorioView extends JFrame {
    
    JTextField nombre = new JTextField(20);
    JTextField fechaAtencion = new JTextField(20);
    JTextField telefonoContacto = new JTextField(20);
    JButton aceptar = new JButton("Aceptar");
    JButton cancelar = new JButton("Cancelar");
    
    public AgregarConsultorioView() {
        super("Agregar Consultorio");
        String[] labels = {"Nombre: ", "Horario de Atencion: ", "Teléfono: "};
        int numPairs = labels.length;

        //Create and populate the panel.
        JPanel stringPane = new JPanel(new SpringLayout());
        for (int i = 0; i < numPairs; i++) {
            JLabel l = new JLabel(labels[i], JLabel.TRAILING);
            stringPane.add(l);
            JTextField textField = new JTextField(10);
            l.setLabelFor(textField);
            stringPane.add(textField);
        }

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

        /*frame.*/
        pack();
        /*frame.*/
        this.setMinimumSize(new Dimension(300, 200));
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
