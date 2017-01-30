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
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import una.cr.design.model.Cita;
import una.cr.design.model.Consultorio;
import una.cr.design.model.Paciente;
import una.cr.design.patterns.view.CitasView;
import una.cr.design.patterns.view.ConsultorioView;
import una.cr.design.patterns.view.MenuView;
import una.cr.design.patterns.view.PacientesView;
import una.cr.design.service.CitaService;
import una.cr.design.service.ConsultorioService;
import una.cr.design.service.PacientesService;

/**
 *
 * @author Grupo Tango
 */
public class MenuController implements ActionListener {

    private final MenuView view;
    private final CitaService citaService;
    private final ConsultorioService consultorioService;
    private final PacientesService pacienteService;

    /**
     * Constructor del controller con parametro del view
     *
     * @param view
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     * @throws ParseException
     */
    public MenuController(MenuView view) throws JsonGenerationException,
            JsonMappingException, IOException, ParseException, Exception {
        this.view = view;
        this.citaService = new CitaService();
        this.consultorioService = new ConsultorioService();
        this.pacienteService = new PacientesService();
    }

    /**
     * Obtiene el actionCommand del evento e implementa una accion especifica
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "clicMostrarPacientes":
                PacientesView viewAgregarPaciente;

                try {
                    viewAgregarPaciente = new PacientesView();
                    viewAgregarPaciente.setVisible(true);
                } catch (JsonMappingException ex) {
                    Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "clicMostrarCitas":
                CitasView viewCitas;
                try {
                    viewCitas = new CitasView();
                    viewCitas.setVisible(true);
                } catch (JsonMappingException ex) {
                    Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException | ParseException ex) {
                    Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;
            case "clicMostrarConsultorios":
                ConsultorioView viewConsultorio;
                try {
                    viewConsultorio = new ConsultorioView();
                    viewConsultorio.setVisible(true);
                } catch (JsonMappingException ex) {
                    Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException | ParseException ex) {
                    Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Consultorio");
                break;
            case "clicSalir":
                System.exit(0);
                break;
            case "clicAyuda": /**
             * ********************************************************
             */
            {
                try {
                    Paciente p = pacienteService.getPaciente(1);
                    Paciente p2 = setAllP(p);
                    Consultorio c = consultorioService.getConsultorio(4);
                    Consultorio c2 = setAllC(c);
                    
                    
                    Cita cp = new Cita(p,c, "6667", true);
                    citaService.createCita(cp);
                } catch (JsonMappingException ex) {
                    Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }

            JOptionPane.showMessageDialog(null,
                    "Equipo Tango \nUniversidad Nacional de Costa Rica\n"
                    + "Escuela de Informática 2017"
                    + "\nEstudiantes:"
                    + "\nJohn Herrera Jimenez"
                    + "\nLuis Alonso Morgan Campos"
                    + "\nKevin Venegas Loria"
                    + "\nCaleb Villata Quesada"
                    + "\nJose David Matamoros Trejos", "",
                    JOptionPane.INFORMATION_MESSAGE);
            break;
        }
    }

    public Paciente setAllP(Paciente p){
        Paciente paciente = new Paciente();
        paciente.setNombre(p.getNombre());
        paciente.setTelefono(p.getTelefono());
        paciente.setDireccion(p.getDireccion());
        paciente.setFechaNacimiento(p.getFechaNacimiento());
        paciente.setEnfermedades(p.getEnfermedades());
        paciente.setObservaciones(p.getObservaciones());
        return paciente;
    }
    
    public Consultorio setAllC(Consultorio c){
        Consultorio consultorio = new Consultorio();
        consultorio.setNombre(c.getNombre());
        consultorio.setDiasConsulta(c.getDiasConsulta());
        consultorio.setHorarioAtencion(c.getHorarioAtencion());
        consultorio.setTelefono(c.getTelefono());
        return consultorio;
    }
}
