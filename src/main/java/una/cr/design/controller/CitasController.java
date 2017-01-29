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
import una.cr.design.icons.Constants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import una.cr.design.patterns.view.CitasView;
import una.cr.design.service.CitaService;
import una.cr.design.service.ConsultorioService;

/**
 *
 * @author Grupo Tango
 */
public class CitasController implements ActionListener {

    private JComboBox consultorioBox = new JComboBox();
    private final DefaultTableModel tableModel;
    private final CitaService citaService;
    private final ConsultorioService consultorioService;
    private final Object[][] cita;
    private final Object[][] consultorio;
    private final CitasView view;

    /**
     * Constructor del controller con parametros
     *
     * @param consultorioBox
     * @param tableModel
     * @param view
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     * @throws ParseException
     */
    public CitasController(JComboBox consultorioBox,
            DefaultTableModel tableModel, CitasView view) throws JsonGenerationException,
            JsonMappingException, IOException, ParseException, Exception {
        super();
        this.view = view;
        citaService = new CitaService();
        consultorioService = new ConsultorioService();
        cita = citaService.loadCitaObjWrapper();
        consultorio = consultorioService.loadConsultorioObjWrapper();

        this.consultorioBox = consultorioBox;
//        this.consultorioBox.addKeyListener(this);
        this.tableModel = tableModel;

        // Load the table with the list of students
        this.tableModel.setDataVector(cita, Constants.CITAS_TABLE_HEADER);
        updateComboBox();

    }

    /**
     * Obtiene el actionCommand del evento e implementa una accion especifica
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "clicBuscar":
                String aux = (String) consultorioBox.getSelectedItem();
                if ("Elegir Consultorio de preferencia: ".equals(aux)) {
                    updateTableSearchTerms(" ");
                } else {
                    updateTableSearchTerms(aux);
                }
                break;

            case "clicCerrar":
                view.setVisible(false);
                break;
        }

    }

    //Actualiza la tabla conforme a la busqueda
    private void updateTableSearchTerms(String searchTerm) {
        if (searchTerm != null && !"".equals(searchTerm)
                && cita != null && cita.length >= 1) {
            Object[][] newData = new Object[cita.length][];
            int idx = 0;
            for (Object[] obj : cita) {
                String fullText = obj[0].toString() + obj[1].toString()
                        + obj[2].toString() + obj[3].toString() + obj[4].toString() ;

                if (fullText.contains(searchTerm.trim())) {
                    newData[idx++] = obj;
                }
            }
            tableModel.setDataVector(newData, Constants.CITAS_TABLE_HEADER);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Search term is empty", "Error",
                    JOptionPane.ERROR_MESSAGE);
            tableModel.setDataVector(cita, Constants.CITAS_TABLE_HEADER);
        }
    }

    private void updateComboBox() {
        for (Object[] obj : consultorio) {
            String fullText = obj[0].toString();
            consultorioBox.addItem(fullText);
        }
    }

}
