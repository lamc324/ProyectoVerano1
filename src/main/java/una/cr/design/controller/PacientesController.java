/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.cr.design.controller;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import una.cr.design.icons.Constants;
import una.cr.design.patterns.view.AgregarPacienteView;
import una.cr.design.patterns.view.PacientesView;
import una.cr.design.service.PacientesService;

/**
 *
 * @author John
 */
public class PacientesController implements ActionListener, KeyListener {

    private JTextField searchTermTextField = new JTextField(26);
    private DefaultTableModel tableModel;
    private Object[][] pacientes;
    private PacientesView view;
    private PacientesService pacientesService;


    public PacientesController(JTextField searchTermTextField, PacientesView view,
            DefaultTableModel tableModel) throws JsonGenerationException,
            JsonMappingException, IOException {
        
        super();
        pacientesService = new PacientesService();
        pacientes = pacientesService.cargarPersonasObjWrapper();
        this.searchTermTextField = searchTermTextField;
        this.tableModel = tableModel;
        this.view = view;
        tableModel.setDataVector(pacientes, Constants.PACIENTES_TABLE_HEADER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "clicBuscar":
                String searchTerm = searchTermTextField.getText();
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
                System.out.println("eliminar");
                break;
            case "clicCerrar":
                view.setVisible(false);
                break;
        }
    }

    private void updateTableSearchTerms(String searchTerm) {
        if (searchTerm != null && !"".equals(searchTerm)
                && pacientes != null && pacientes.length >= 1) {
            Object[][] newData = new Object[pacientes.length][];
            int idx = 0;
            for (Object[] obj : pacientes) {
                String fullText = obj[1].toString().toLowerCase();

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

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
       
    }

    @Override
    public void keyReleased(KeyEvent e) {
        String keyReleased = searchTermTextField.getText().toLowerCase();
        if (!"".equals(keyReleased)) {
            updateTableSearchTerms(keyReleased);
        }
        else{
            updateTableSearchTerms(" ");
        }
    }
}
