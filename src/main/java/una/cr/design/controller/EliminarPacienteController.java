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

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import una.cr.design.patterns.view.AgregarPacienteView;
import una.cr.design.patterns.view.EliminarPacienteView;
import una.cr.design.service.EliminarPacienteService;

/**
 *
 * @author Grupo Tango
 */
public class EliminarPacienteController implements ActionListener {

    private JTextField searchTermTextField = new JTextField(26);
    private Object[][] pacientes;
    private EliminarPacienteView view;
    private EliminarPacienteService pacientesService;

    /**
     * Constructor del controller con parametros
     * @param searchTermTextField
     * @param view
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    public EliminarPacienteController(JTextField searchTermTextField,
            EliminarPacienteView view) throws JsonGenerationException,
            JsonMappingException, IOException {

        super();
        pacientesService = new EliminarPacienteService();
        pacientes = pacientesService.cargarPersonasObjWrapper();
        this.searchTermTextField = searchTermTextField;
        this.view = view;
    }

    /**
     * Obtiene el actionCommand del evento e implementa una accion especifica
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "clicBuscar":
                String searchTerm = searchTermTextField.getText();
                updateTableSearchTerms(searchTerm);
                break;
            case "clicCerrar":
                view.setVisible(false);
                break;
        }
    }

    //Actualiza la tabla de busqueda
    private void updateTableSearchTerms(String searchTerm) {
        if (searchTerm != null && !"".equals(searchTerm)
                && pacientes != null && pacientes.length >= 1) {
            Object[][] newData = new Object[pacientes.length][];
            int idx = 0;
            for (Object[] obj : pacientes) {
                String fullId = obj[0].toString();
                String fullTextMayus = obj[1].toString().toLowerCase();
                String fullTextMinus = obj[1].toString().toUpperCase();

                if (fullTextMayus.equals(searchTerm.trim())
                        || fullTextMinus.equals(searchTerm.trim())
                        || fullId.equals(searchTerm.trim())) {
                    JOptionPane.showMessageDialog(null,
                            "Paciente Eliminado:\n\n"
                            + obj[0].toString() + "\n"
                            + obj[1].toString() + "\n"
                            + obj[2].toString() + "\n"
                            + obj[3].toString() + "\n"
                            + obj[4].toString() + "\n"
                            + obj[5].toString(), "",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                } else {
                    JOptionPane.showMessageDialog(null,
                    "No se encontro ningún paciente", "Error",
                    JOptionPane.ERROR_MESSAGE);
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "El campo de búsqueda esta vacío", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
