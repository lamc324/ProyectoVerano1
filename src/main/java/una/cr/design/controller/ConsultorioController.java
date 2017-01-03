/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.cr.design.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import una.cr.design.patterns.view.AgregarConsultorioView;
import una.cr.design.patterns.view.ConsultorioView;

/**
 *
 * @author Usuario
 */
public class ConsultorioController implements ActionListener {

    private ConsultorioView view;

    public ConsultorioController(ConsultorioView view) {
        this.view = view;
    }

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
                view.setVisible(false);
                break;
        }
    }

}
