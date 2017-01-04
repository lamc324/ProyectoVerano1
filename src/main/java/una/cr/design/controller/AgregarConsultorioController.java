/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.cr.design.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import una.cr.design.patterns.view.AgregarConsultorioView;

/**
 *
 * @author VQ-Caleb
 */
public class AgregarConsultorioController implements ActionListener {

    private AgregarConsultorioView view;

    public AgregarConsultorioController(AgregarConsultorioView view) {
        this.view = view;
    }        
    
    @Override
    public void actionPerformed(ActionEvent e) {
                switch (e.getActionCommand()) {
            case "clicAceptar":
                JOptionPane.showMessageDialog(view, "Paciente Agregado", "", JOptionPane.INFORMATION_MESSAGE);
                view.setVisible(false);
                System.out.println("aceptar");
                break;
            case "clicCancelar":                
                view.setVisible(false);
                break;    
        }
    }
    
}
