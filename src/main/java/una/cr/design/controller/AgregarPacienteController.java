/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.cr.design.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import una.cr.design.model.Paciente;
import una.cr.design.patterns.view.AgregarCitaView;
import una.cr.design.patterns.view.AgregarPacienteView;

/**
 *
 * @author venegas97k
 */
public class AgregarPacienteController implements ActionListener {

    private JTextField id;
    private JTextField nombre;
    private JTextField telefono;
    private JTextField direccion;
    private JTextField fechaNac;
    private JTextField enfermedades;
    private JTextArea observaciones;
    private JTextField[] informacion;
    private AgregarPacienteView view;

    public AgregarPacienteController(
            JTextField id,
            JTextField nombre,
            JTextField telefono,
            JTextField direccion,
            JTextField fechaNac,
            JTextField enfermedades,
            JTextArea observaciones,
            AgregarPacienteView view) {
        super();

        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNac = fechaNac;
        this.enfermedades = enfermedades;
        this.observaciones = observaciones;
        this.view = view;
        this.informacion = new JTextField[6];
    }

    public JTextField[] getInfoPaciente() {
        informacion[0] = id;
        informacion[1] = nombre;
        informacion[2] = telefono;
        informacion[3] = direccion;
        informacion[4] = fechaNac;
        informacion[5] = enfermedades;
        return informacion;
    }

    public Paciente asignaPaciente() {
        Paciente p = new Paciente();
        p.setId(id.getText());
        p.setNombre(nombre.getText());
        p.setTelefono(telefono.getText());
        p.setDireccion(direccion.getText());
        p.setFechaNacimiento(fechaNac.getText());

        String txt = enfermedades.getText();
        String[] arrayTxt = txt.split(",");

        p.setEnfermedades(arrayTxt);
        p.setObservaciones(observaciones.getText());
        return p;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case "clicSiguiente":
                informacion = getInfoPaciente();
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

                Paciente p = asignaPaciente();

                view.setVisible(false);
                AgregarCitaView viewAgregarCita = new AgregarCitaView();
                viewAgregarCita.setVisible(true);
                System.out.println(p.toString());
                break;
            case "clicCancelar":
                view.setVisible(false);
                break;
        }
    }

}
