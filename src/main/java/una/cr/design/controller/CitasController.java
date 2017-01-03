/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.cr.design.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import una.cr.design.patterns.view.AgregarCitaView;

/**
 *
 * @author Usuario
 */
public class CitasController implements ActionListener {

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
                System.out.println("cerrar");
                break;
        }  
    }
    
}
