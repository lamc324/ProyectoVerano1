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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import una.cr.design.icons.Constants;
import una.cr.design.patterns.view.AgregarConsultorioView;
import una.cr.design.patterns.view.ConsultorioView;
import una.cr.design.service.ConsultorioService;

/**
 *
 * @author Grupo Tango
 */
public class ConsultorioController implements ActionListener, KeyListener {

    JTextField searchTermTextField;
    DefaultTableModel tableModel;
    Object[][] consultorios;
    ConsultorioService consultorioService;
    ConsultorioView view;

    /**
     * Constructor del controller con parametros
     *
     * @param searchTermTextField
     * @param view
     * @param tableModel
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     * @throws ParseException
     */
    public ConsultorioController(JTextField searchTermTextField, ConsultorioView view,
            DefaultTableModel tableModel) throws JsonGenerationException,
            JsonMappingException, IOException, ParseException, Exception {

        super();
        consultorioService = new ConsultorioService();
        consultorios = consultorioService.loadConsultorioObjWrapper();
        this.searchTermTextField = searchTermTextField;
        this.view = view;
        this.tableModel = tableModel;
        tableModel.setDataVector(consultorios, Constants.CONSULTORIOS_TABLE_HEADER);

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
                String searchTerm = searchTermTextField.getText().toLowerCase();
                if (!"".equals(searchTerm)) {
                    updateTableSearchTerms(searchTerm);
                }                 
                    try {
                        consultorios = consultorioService.loadConsultorioObjWrapper();
                    } catch (IOException ex) {
                        Logger.getLogger(ConsultorioController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(ConsultorioController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                updateTableSearchTerms(" ");
                break;
            case "clicAgregar":
                AgregarConsultorioView agregarConsultorio = new AgregarConsultorioView();
                agregarConsultorio.setVisible(true);

                break;
            case "clicEliminar":
                String deleteTerm = searchTermTextField.getText().toLowerCase();
                if (!"".equals(deleteTerm)) {
                    deleteTableSearchTerms(deleteTerm);
                }
                updateTableSearchTerms(deleteTerm);
                break;
            case "clicCerrar":
                view.setVisible(false);
                break;

        }
    }

    //Actualiza la tabla conforme a la busqueda
    private void updateTableSearchTerms(String searchTerm) {
        if (searchTerm != null && !"".equals(searchTerm)
                && consultorios != null && consultorios.length >= 1) {
            Object[][] newData = new Object[consultorios.length][];
            int idx = 0;
            for (Object[] obj : consultorios) {
                String fullText = obj[0].toString().toLowerCase()
                        + obj[0].toString().toUpperCase();

                if (fullText.contains(searchTerm.trim())) {
                    newData[idx++] = obj;
                }
            }
            tableModel.setDataVector(newData, Constants.CONSULTORIOS_TABLE_HEADER);
        } else {
            JOptionPane.showMessageDialog(null,
                    "El campo de búsqueda esta vacío", "Error",
                    JOptionPane.ERROR_MESSAGE);
            tableModel.setDataVector(consultorios, Constants.CONSULTORIOS_TABLE_HEADER);
        }
    }

    private void deleteTableSearchTerms(String deleteTerm) {
        try {
            if (deleteTerm != null && !"".equals(deleteTerm)
                    && consultorios != null && consultorios.length >= 1) {
                int borrar = Integer.parseInt(deleteTerm);
                consultorioService.deleteConsultorio(borrar);
                JOptionPane.showMessageDialog(view, "Consultorio Eliminado", "", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "No se encontró el consultorio", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     *
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {

    }

    /**
     *
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {
        String keyReleased = searchTermTextField.getText().toLowerCase();
        if (!"".equals(keyReleased)) {
            updateTableSearchTerms(keyReleased);
        } else {
            updateTableSearchTerms(" ");
        }
    }

}
