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

import com.fasterxml.jackson.databind.JsonMappingException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import una.cr.design.model.Consultorio;
import una.cr.design.patterns.view.AgregarConsultorioView;
import una.cr.design.patterns.view.ConsultorioView;
import una.cr.design.service.ConsultorioService;

/**
 *
 * @author Grupo Tango
 */
public class AgregarConsultorioController implements ActionListener {

    private JTextField nombre;
    private JTextField dias;
    private JTextField horario;
    private JTextField telefonoContacto;
    private JTextField[] informacion;
    private AgregarConsultorioView view;
    private ConsultorioService consultorioService;

    /**
     * Constructor del controller con parametros
     *
     * @param nombre
     * @param dias
     * @param fechaAtencion
     * @param telefonoContacto
     * @param view
     */
    public AgregarConsultorioController(JTextField nombre, JTextField dias, JTextField horario,
            JTextField telefonoContacto, AgregarConsultorioView view) {
        this.nombre = nombre;
        this.dias = dias;
        this.horario = horario;
        this.telefonoContacto = telefonoContacto;
        this.view = view;
        this.informacion = new JTextField[4];
        consultorioService = new ConsultorioService();
    }

    /**
     * Retorna la informacion del consultorio
     *
     * @return informacion
     */
    public JTextField[] getInfoConsultorio() {
        informacion[0] = nombre;
        informacion[1] = dias;
        informacion[2] = horario;
        informacion[3] = telefonoContacto;
        return informacion;
    }

    public Consultorio asignaConsultorio() {
        Consultorio c = new Consultorio();
        c.setNombre(nombre.getText());
        c.setDiasConsulta(dias.getText());
        c.setHorarioAtencion(horario.getText());
        c.setTelefono(telefonoContacto.getText());
        return c;
    }

    /**
     * Obtiene el actionCommand del evento e implementa una accion especifica
     *
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
                } else {

                    try {
                        Consultorio c = asignaConsultorio();
                        consultorioService.createConsultorio(c);
                        System.out.println(c.toString());
                    } catch (JsonMappingException ex) {
                        Logger.getLogger(AgregarConsultorioController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(AgregarConsultorioController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(AgregarConsultorioController.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
