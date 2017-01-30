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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import una.cr.design.model.Cita;
import una.cr.design.model.Consultorio;
import una.cr.design.model.Paciente;
import una.cr.design.patterns.view.AgregarCitaView;
import una.cr.design.patterns.view.AgregarPacienteView;
import una.cr.design.service.CitaService;
import una.cr.design.service.ConsultorioService;
import una.cr.design.service.PacientesService;

/**
 *
 * @author Grupo Tango
 */
public class AgregarCitaController implements ActionListener {

    private AgregarCitaView view;
    private JComboBox consultorioBox;
    private JEditorPane campoDescrip;
    private JTextField agregarId;
    private final Object[][] consultorio;
    PacientesService pacienteService;
    ConsultorioService consultorioService;
    CitaService citaService;

    /**
     * Constructor del controller con parametros
     *
     * @param agregarId
     * @param consultorioBox
     * @param campoDescrip
     * @param view
     */
    public AgregarCitaController(JTextField agregarId, JComboBox consultorioBox, JEditorPane campoDescrip, AgregarCitaView view) throws IOException, JsonMappingException, Exception {
        this.agregarId = agregarId;
        this.consultorioBox = consultorioBox;
        this.campoDescrip = campoDescrip;
        this.view = view;
        pacienteService = new PacientesService();
        consultorioService = new ConsultorioService();
        citaService = new CitaService();
        consultorio = consultorioService.loadConsultorioObjWrapper();
        updateComboBox();
    }

    /**
     * Obtiene el actionCommand del evento e implementa una accion especifica
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String aux = (String) consultorioBox.getSelectedItem();
        switch (e.getActionCommand()) {
            case "clicSeleccion":
                if ("Hospital CIMA".equals(aux)) {
                    campoDescrip.setText("Hospital CIMA\nHorario de Atencion:\nLunes y Martes de 8 am a 8 pm");
                } else if ("Centro Medico del Este".equals(aux)) {
                    campoDescrip.setText("Centro Medico del Este\nHorario de Atencion:\nJueves y Viernes de 8 am a 6 pm");
                }
                break;
            case "clicAtras":
                AgregarPacienteView ap = new AgregarPacienteView();
                view.setVisible(false);
                ap.setVisible(false);
                break;
            case "clicTerminar":
//
//                if ("Hospital CIMA".equals(aux) || "Centro Medico del Este".equals(aux)) {
//                    JOptionPane.showMessageDialog(view, "Cita Agregada", "", JOptionPane.INFORMATION_MESSAGE);
//                    view.setVisible(false);
//                } else {
//                    JOptionPane.showMessageDialog(view, "Por favor, seleccione un consultorio para continuar", "Error", JOptionPane.ERROR_MESSAGE);
//                }
//
//                break;
                String idPaciente;
                idPaciente = this.agregarId.getText();

                Paciente p;
                try {
                    p = pacienteService.getPaciente(Integer.parseInt(idPaciente));
                    Consultorio c = consultorioService.getConsultorioNombre(aux);
                    System.out.println(c.toString());

                    Cita cp = new Cita(p, c, "6667", true);
                    citaService.createCita(cp);
                } catch (Exception ex) {
                    Logger.getLogger(AgregarCitaController.class.getName()).log(Level.SEVERE, null, ex);
                }

        }
    }
    
    private void updateComboBox() {
        for (Object[] obj : consultorio) {
            String fullText = obj[0].toString();
            consultorioBox.addItem(fullText);
        }
    }
}
