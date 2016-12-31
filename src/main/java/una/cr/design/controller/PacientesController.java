/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.cr.design.controller;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import una.cr.design.model.Paciente;

/**
 *
 * @author John
 */
public class PacientesController {

    private JTextField searchTermTextField = new JTextField(26);
    private DefaultTableModel tableModel;
    private Paciente Paciente;
    private Object[][] personas;
}
