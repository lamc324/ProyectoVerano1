/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.cr.design.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import una.cr.design.patterns.view.AgregarConsultorioView;

/**
 *
 * @author VQ-Caleb
 */
public class AgregarConsultorioController implements ActionListener {

    private JTextField nombre;
    private JTextField fechaAtencion;
    private JTextField telefonoContacto;
    private JTextField[] informacion;
    private AgregarConsultorioView view;

    public AgregarConsultorioController(JTextField nombre, JTextField fechaAtencion,
            JTextField telefonoContacto, AgregarConsultorioView view) {
        this.nombre = nombre;
        this.fechaAtencion = fechaAtencion;
        this.telefonoContacto = telefonoContacto;
        this.view = view;
        this.informacion = new JTextField[3];
    }

    public JTextField[] getInfoConsultorio() {
        informacion[0] = nombre;
        informacion[1] = fechaAtencion;
        informacion[2] = telefonoContacto;
        return informacion;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "clicAceptar":
                informacion = getInfoConsultorio();
                boolean caseNull = false;

                for (JTextField t : informacion) {
                    if ("".equals(t.getText())) {
                        JOptionPane.showMessageDialog(view, "Por favor, "
                                + "rellene todos los campos para continuar", "Error", JOptionPane.ERROR_MESSAGE);
                        caseNull = true;
                        break;
                    }
                }

                if (caseNull == true) {
                    break;
                }
                JOptionPane.showMessageDialog(view, "Consultorio Agregado", "", JOptionPane.INFORMATION_MESSAGE);
                view.setVisible(false);
                System.out.println("aceptar");
                break;
            case "clicCancelar":
                view.setVisible(false);
                break;
        }
    }

}
