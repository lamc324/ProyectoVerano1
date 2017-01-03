/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.cr.design.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import una.cr.design.patterns.view.AgregarConsultorioView;

/**
 *
 * @author Usuario
 */
public class ConsultorioController implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "clicBuscar":
                System.out.println("buscar");
                break;
            case "clicAgregar":
                AgregarConsultorioView viewAgregarPaciente = new AgregarConsultorioView();
                viewAgregarPaciente.setVisible(true);
                break;    
            case "clicEliminar":
                System.out.println("eliminar");
                break;    
            case "clicCerrar":
                System.out.println("cerrar");
                break;
        }        
    }
    
    
}
