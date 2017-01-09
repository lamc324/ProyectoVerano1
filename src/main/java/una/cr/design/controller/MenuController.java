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
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import una.cr.design.patterns.view.CitasView;
import una.cr.design.patterns.view.ConsultorioView;
import una.cr.design.patterns.view.MenuView;
import una.cr.design.patterns.view.PacientesView;

/**
 *
 * @author Usuario
 */
public class MenuController implements ActionListener {
    
    private MenuView view;

    public MenuController(MenuView view) throws JsonGenerationException,
            JsonMappingException, IOException, ParseException{
        this.view = view;
    }        

    @Override
    public void actionPerformed(ActionEvent e) {
                switch (e.getActionCommand()) {
            case "clicMostrarPacientes":
                PacientesView viewAgregarPaciente ;
                
                try {
                    viewAgregarPaciente = new PacientesView();
                    viewAgregarPaciente.setVisible(true);
                } catch (JsonMappingException ex) {
                    Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
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
                } catch (IOException ex) {
                    Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
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
                } catch (IOException ex) {
                    Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
                }   
                System.out.println("Consultorio");
                break;    
            case "clicSalir":
                System.exit(0);
                break;
        }
    }
    
}
