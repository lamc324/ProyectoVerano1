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
 * @author VQ-Caleb
 */
public class AgregarCitaController implements ActionListener {

    private AgregarCitaView view;

    public AgregarCitaController(AgregarCitaView view) {
        this.view = view;
    }   
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "clicAtras":
                view.setVisible(false);
                break;
            case "clicTerminar":
                System.out.println("terminar");
                break;
        }
    }
}
