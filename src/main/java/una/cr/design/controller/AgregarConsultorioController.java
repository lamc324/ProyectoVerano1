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
import javax.swing.JTextField;
import una.cr.design.patterns.view.AgregarConsultorioView;

/**
 *
 * @author Grupo Tango
 */
public class AgregarConsultorioController implements ActionListener {

    private JTextField nombre;
    private JTextField fechaAtencion;
    private JTextField telefonoContacto;
    private JTextField[] informacion;
    private AgregarConsultorioView view;

    /**
     * Constructor del controller con parametros
     * @param nombre
     * @param fechaAtencion
     * @param telefonoContacto
     * @param view
     */
    public AgregarConsultorioController(JTextField nombre, JTextField fechaAtencion,
            JTextField telefonoContacto, AgregarConsultorioView view) {
        this.nombre = nombre;
        this.fechaAtencion = fechaAtencion;
        this.telefonoContacto = telefonoContacto;
        this.view = view;
        this.informacion = new JTextField[3];
    }

    /**
     * Retorna la informacion del consultorio
     * @return informacion
     */
    public JTextField[] getInfoConsultorio() {
        informacion[0] = nombre;
        informacion[1] = fechaAtencion;
        informacion[2] = telefonoContacto;
        return informacion;
    }

    /**
     * Obtiene el actionCommand del evento e implementa una accion especifica
     * @param e
     */
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
