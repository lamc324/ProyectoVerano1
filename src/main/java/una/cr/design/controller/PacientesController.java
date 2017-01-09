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
import una.cr.design.icons.Constants;
import una.cr.design.patterns.view.AgregarPacienteView;
import una.cr.design.patterns.view.PacientesView;

/**
 *
 * @author John
 */
public class PacientesController implements ActionListener {

    private JTextField searchTermTextField;
    private DefaultTableModel tableModel;
    private Object[][] personas;
    private PacientesView view; 

    public PacientesController() {
       searchTermTextField = new JTextField(26);
    }

    public PacientesController(JTextField searchTermTextField, PacientesView view, DefaultTableModel tableModel) {
        this.searchTermTextField = searchTermTextField;
        this.view = view;
        tableModel.setDataVector(personas, Constants.PACIENTES_TABLE_HEADER);
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
                view.setVisible(false);
                break;
        }        
    }
}
