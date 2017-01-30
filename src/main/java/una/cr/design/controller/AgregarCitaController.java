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
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
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
    private JDatePickerImpl datePicker;
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
     * @param datePicker
     */
    public AgregarCitaController(JTextField agregarId, JComboBox consultorioBox, JEditorPane campoDescrip, AgregarCitaView view, JDatePickerImpl datePicker) throws IOException, JsonMappingException, Exception {
        this.agregarId = agregarId;
        this.consultorioBox = consultorioBox;
        this.campoDescrip = campoDescrip;
        this.view = view;
        this.datePicker = datePicker;
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
                String idPaciente;
                idPaciente = this.agregarId.getText();

                Paciente paciente;
                Cita cita;
                Consultorio cons;
                try {
                    paciente = pacienteService.getPaciente(Integer.parseInt(idPaciente));
                    cons = consultorioService.getConsultorioNombre(aux);
                    Date selectedDate = (Date) datePicker.getModel().getValue();
                    Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String fecha = formatter.format(selectedDate);
                    cita = new Cita(paciente, cons, fecha, true);
                    System.out.println(cita.toString());
                    citaService.createCita(cita);
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
