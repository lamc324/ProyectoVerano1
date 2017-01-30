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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import una.cr.design.icons.Constants;
import una.cr.design.patterns.view.AgregarPacienteView;
import una.cr.design.patterns.view.PacientesView;
import una.cr.design.service.PacientesService;

/**
 *
 * @author Grupo Tango
 */
public class PacientesController implements ActionListener, KeyListener, MouseListener {

    private JTextField searchTermTextField = new JTextField(26);
    private final DefaultTableModel tableModel;
    private final JTable table;
    private final Object[][] pacientes;
    private final PacientesView view;
    private final PacientesService pacientesService;

    /**
     * Constructor del controller con parametros
     *
     * @param searchTermTextField
     * @param view
     * @param tableModel
     * @param table
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    public PacientesController(JTextField searchTermTextField, PacientesView view,
            DefaultTableModel tableModel, JTable table) throws JsonGenerationException,
            JsonMappingException, IOException, Exception {

        super();
        pacientesService = new PacientesService();
        pacientes = pacientesService.cargarPersonasObjWrapper();
        this.searchTermTextField = searchTermTextField;
        this.tableModel = tableModel;
        this.table = table;
        this.view = view;
        tableModel.setDataVector(pacientes, Constants.PACIENTES_TABLE_HEADER);
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
                updateTableSearchTerms(searchTerm);
                break;
            case "clicAgregar":
                AgregarPacienteView viewAgregarPaciente = new AgregarPacienteView();
                viewAgregarPaciente.setVisible(true);
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
                && pacientes != null && pacientes.length >= 1) {
            Object[][] newData = new Object[pacientes.length][];
            int idx = 0;
            for (Object[] obj : pacientes) {
                String fullText = obj[0].toString()
                        + obj[1].toString().toLowerCase()
                        + obj[1].toString().toUpperCase();

                if (fullText.contains(searchTerm.trim())) {
                    newData[idx++] = obj;
                }
            }
            tableModel.setDataVector(newData, Constants.PACIENTES_TABLE_HEADER);
        } else {
            JOptionPane.showMessageDialog(null,
                    "El campo de búsqueda esta vacío", "Error",
                    JOptionPane.ERROR_MESSAGE);
            tableModel.setDataVector(pacientes, Constants.PACIENTES_TABLE_HEADER);
        }
    }

    private void deleteTableSearchTerms(String deleteTerm) {
        try {
            if (deleteTerm != null && !"".equals(deleteTerm)
                    && pacientes != null && pacientes.length >= 1) {
                int borrar = Integer.parseInt(deleteTerm);
                pacientesService.deletePaciente(borrar);
                JOptionPane.showMessageDialog(view, "Paciente Eliminado", "", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "No se encontró el paciente", "Error",
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
     * Realiza la busqueda luego de presionar una tecla
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

    @Override
    public void mouseClicked(MouseEvent e) {
//       if(e.getClickCount() == 2){
//           int row = this.table.getSelectedRow();
//           AgregarCitaView agregarCita = new AgregarCitaView();
//           try {
//               this.editar(row);
//           } catch (Exception ex) {
//               Logger.getLogger(PacientesController.class.getName()).log(Level.SEVERE, null, ex);
//           }
//       }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
