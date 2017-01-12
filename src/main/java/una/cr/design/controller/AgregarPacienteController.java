/*
 * Copyright (C) 2016 Grupo Tango
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Universidad Nacional de Costa Rica, Estudiantes: Luis Alonso Morgan Campos,
 * John Herrera Jimenez, Kevin Venegas Loria, Caleb Villalta Quesada, Josue David Matamorros.
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
 * @author Grupo Tango
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

    /**
     * Constructor del controller con parametros
     * @param id
     * @param nombre
     * @param telefono
     * @param direccion
     * @param fechaNac
     * @param enfermedades
     * @param observaciones
     * @param view
     */
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
        this.informacion = new JTextField[5];
    }

    /**
     *
     * @return informacion
     */
    public JTextField[] getInfoPaciente() {
        informacion[0] = id;
        informacion[1] = nombre;
        informacion[2] = telefono;
        informacion[3] = direccion;
        informacion[4] = fechaNac;
        return informacion;
    }

    /**
     * Crea un paciente y lo retorna
     * @return p
     */
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

    /**
     * Obtiene el actionCommand del evento e implementa una accion especifica
     * @param ae
     */
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
