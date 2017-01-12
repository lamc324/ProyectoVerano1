/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import una.cr.design.patterns.view.AgregarCitaView;
import una.cr.design.patterns.view.CitasView;
import una.cr.design.service.ServiceCita;

/**
 *
 * @author Usuario
 */
public class CitasController implements ActionListener {

    private JComboBox consultorioBox = new JComboBox();
    private final DefaultTableModel tableModel;
    private final ServiceCita citaService;
    private final Object[][] cita;
    private CitasView view;

    public CitasController(JComboBox consultorioBox,
            DefaultTableModel tableModel, CitasView view) throws JsonGenerationException,
            JsonMappingException, IOException, ParseException {
        super();
        this.view = view;
        citaService = new ServiceCita();
        cita = citaService.loadCitaObjWrapper();

        this.consultorioBox = consultorioBox;
//        this.consultorioBox.addKeyListener(this);
        this.tableModel = tableModel;

        // Load the table with the list of students
        this.tableModel.setDataVector(cita, Constants.CITAS_TABLE_HEADER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "clicBuscar":
                String aux = (String) consultorioBox.getSelectedItem();
                if("Elegir Consultorio de preferencia: ".equals(aux)){
                updateTableSearchTerms(" ");
                }
                else
                    updateTableSearchTerms(aux);
                break;
            case "clicAgregar":
                AgregarCitaView viewAgregarCita = new AgregarCitaView();
                viewAgregarCita.setVisible(true);
                break;
            case "clicCerrar":
                view.setVisible(false);
                break;
        }

    }

    private void updateTableSearchTerms(String searchTerm) {
        if (searchTerm != null && !"".equals(searchTerm)
                && cita != null && cita.length >= 1) {
            Object[][] newData = new Object[cita.length][];
            int idx = 0;
            for (Object[] obj : cita) {
                String fullText = obj[0].toString() + obj[1].toString()
                        + obj[2].toString() + obj[3].toString();

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

}
