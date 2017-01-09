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
import una.cr.design.patterns.view.AgregarConsultorioView;
import una.cr.design.patterns.view.ConsultorioView;

/**
 *
 * @author venegas97k
 */
public class ConsultorioController implements ActionListener {

    private JTextField searchTermTextField;
    private DefaultTableModel tableModel;
    private Object[][] consultorios;
    private ConsultorioView view;

    public ConsultorioController(JTextField searchTermTextField, ConsultorioView view, DefaultTableModel tableModel) {
        this.searchTermTextField = searchTermTextField;
        this.view = view;
        tableModel.setDataVector(consultorios, Constants.CONSULTORIOS_TABLE_HEADER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "clicBuscar":
                System.out.println("buscar");
                break;
            case "clicAgregar":
                AgregarConsultorioView agregarConsultorio = new AgregarConsultorioView();
                agregarConsultorio.setVisible(true);
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
