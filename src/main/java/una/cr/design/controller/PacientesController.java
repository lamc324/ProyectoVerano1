/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.cr.design.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import una.cr.design.model.Paciente;
import una.cr.design.patterns.view.AgregarPacienteView;

/**
 *
 * @author John
 */
public class PacientesController implements ActionListener {

    private JTextField searchTermTextField;
    private DefaultTableModel tableModel;
    private Paciente Paciente;
    private Object[][] personas;

    public PacientesController() {
       searchTermTextField = new JTextField(26);
    }

    public PacientesController(JTextField searchTermTextField) {
        this.searchTermTextField = searchTermTextField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "clicBuscar":
                System.out.println("buscar");
                break;
            case "clicAgregar":
                AgregarPacienteView viewAgregarPaciente = new AgregarPacienteView();
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
