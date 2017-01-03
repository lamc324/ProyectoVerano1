/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.cr.design.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import una.cr.design.patterns.view.AgregarCitaView;
import una.cr.design.patterns.view.CitasView;

/**
 *
 * @author Usuario
 */
public class CitasController implements ActionListener {
    
    private CitasView view;

    public CitasController(CitasView view) {
        this.view = view;
    }        

    @Override
    public void actionPerformed(ActionEvent e) {
                switch (e.getActionCommand()) {
            case "clicBuscar":
                System.out.println("buscar");
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
    
}
