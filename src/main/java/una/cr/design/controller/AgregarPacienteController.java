/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.cr.design.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import una.cr.design.model.Paciente;
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

    public AgregarPacienteController(
            JTextField id,
            JTextField nombre,
            JTextField telefono,
            JTextField direccion,
            JTextField fechaNac,
            JTextField enfermedades,
            JTextArea observaciones) {
        super();
        
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNac = fechaNac;
        this.enfermedades = enfermedades;
        this.observaciones = observaciones;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case "clicAceptar":
                Paciente p = new Paciente();
                p.setId(id.getText());
                p.setNombre(nombre.getText());
                p.setDireccion(direccion.getText());
                p.setFechaNacimiento(fechaNac.getText());
                p.setEnfermedadesAsociadas(enfermedades.getText());
                p.setObservaciones(observaciones.getText());
                System.out.println(p.toString());
                break;
            case "clicCancelar":
                System.out.println("cancelar");
                break;
        }
    }
}
