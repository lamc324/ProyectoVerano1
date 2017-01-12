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
import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import una.cr.design.icons.Constants;
import una.cr.design.patterns.view.AgregarConsultorioView;
import una.cr.design.patterns.view.ConsultorioView;
import una.cr.design.service.ConsultorioService;

/**
 *
 * @author venegas97k
 */
public class ConsultorioController implements ActionListener, KeyListener {

    JTextField searchTermTextField;
    DefaultTableModel tableModel;
    Object[][] consultorios;
    ConsultorioView view;

    public ConsultorioController(JTextField searchTermTextField, ConsultorioView view,
            DefaultTableModel tableModel) throws JsonGenerationException,
            JsonMappingException, IOException, ParseException {

        super();
        ConsultorioService consultorioService = new ConsultorioService();
        consultorios = consultorioService.loadConsultorioObjWrapper();
        this.searchTermTextField = searchTermTextField;
        this.view = view;
        this.tableModel = tableModel;
        tableModel.setDataVector(consultorios, Constants.CONSULTORIOS_TABLE_HEADER);

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
                AgregarConsultorioView agregarConsultorio = new AgregarConsultorioView();
                agregarConsultorio.setVisible(true);
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
                && consultorios != null && consultorios.length >= 1) {
            Object[][] newData = new Object[consultorios.length][];
            int idx = 0;
            for (Object[] obj : consultorios) {
                String fullText = obj[0].toString().toLowerCase() + 
                        obj[0].toString().toUpperCase();

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
        } else {
            updateTableSearchTerms(" ");
        }
    }

}
