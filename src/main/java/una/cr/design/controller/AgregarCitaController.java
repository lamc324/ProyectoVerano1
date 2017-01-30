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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
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
                if ("Elegir Consultorio de preferencia: ".equals(aux)) {
                    campoDescrip.setText("");
                } else {
                    try {
                        Consultorio co = consultorioService.getConsultorioNombre(aux);
                        campoDescrip.setText(co.detalleConsultorio());
                    } catch (Exception ex) {
                        Logger.getLogger(AgregarCitaController.class.getName()).log(Level.SEVERE, null, ex);
                    }
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

                    // Si hay algun campo vacio
                    if (agregarId.getText().equals("")
                            || consultorioBox.getSelectedItem().equals("Elegir Consultorio de preferencia: ")
                            || datePicker.getModel().getValue() == null) {

                        JOptionPane.showMessageDialog(view, "Por favor rellene todos los campos vacios",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        break;

                    }

                    // Creacion del paciente, consultorio y fecha a partir de los datos suministrados
                    paciente = pacienteService.getPaciente(Integer.parseInt(idPaciente));

                    cons = consultorioService.getConsultorioNombre(aux);
                    Date selectedDate = (Date) datePicker.getModel().getValue();
                    Format formatter = new SimpleDateFormat("dd-MM-yyyy");
                    String fecha = formatter.format(selectedDate);

                    // Si la fecha seleccionada es despues o igual que la fecha actual del sistema
                    if (fechaSeleccionada(selectedDate) == false) {
                        JOptionPane.showMessageDialog(view, "No es posible asignar una cita en la fecha seleccionada",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        break;

                        // Valida si el id del paciente existe o es 0
                    } else if (paciente.getIdPaciente() == 0) {
                        JOptionPane.showMessageDialog(view, "El paciente no existe",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    cita = new Cita(paciente, cons, fecha, true);
                    System.out.println(cita.toString());
                    citaService.createCita(cita);
                } catch (Exception ex) {
                    Logger.getLogger(AgregarCitaController.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(view, "Cita agregada", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                view.setVisible(false);
        }
    }

    /**
     * Actualiza el comboBox con la lista completa de consultorios Valida si hay
     * al menos un consultorio dentro
     *
     */
    private void updateComboBox() {

        // Si por defecto el comboBox solo tiene el string que indica a elegir el consultorio, no va a 
        // añadir consultorios para evitar agregar valores nulos
        if (consultorio != null) {
            for (Object[] obj : consultorio) {
                String fullText = obj[1].toString();
                consultorioBox.addItem(fullText);
            }
        }
    }

    public boolean fechaSeleccionada(Date selectedDate) {
        boolean result = false;
        Calendar fA = Calendar.getInstance();
        Calendar fS = Calendar.getInstance();
        fS.setTime(selectedDate);
        if (fS.get(Calendar.YEAR) >= fA.get(Calendar.YEAR)
                && fS.get(Calendar.MONTH) >= fA.get(Calendar.MONTH)
                && fS.get(Calendar.DAY_OF_MONTH) >= fA.get(Calendar.DAY_OF_MONTH)) {
            result = true;
        }
        if (fS.get(Calendar.YEAR) > fA.get(Calendar.YEAR)) {
            result = true;
        }
        if (fS.get(Calendar.YEAR) >= fA.get(Calendar.YEAR)
                && fS.get(Calendar.MONTH) > fA.get(Calendar.MONTH)) {
            result = true;
        }
        return result;
    }
}
