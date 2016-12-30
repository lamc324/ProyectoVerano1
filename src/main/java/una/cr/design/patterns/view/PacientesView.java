/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.cr.design.patterns.view;

import java.awt.Dimension;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author John
 */
public class PacientesView extends JFrame {

    JTextField searchTermTextField = new JTextField("Nombre",26);
    JButton buscarButton = new JButton("Buscar");
    JButton agregarButton = new JButton("Agregar");
    JButton eliminarButton = new JButton("Eliminar Paciente");
    JButton cerrarButton = new JButton("Cerrar");
    JTable table = new JTable();
    DefaultTableModel tableModel = new DefaultTableModel();

    public PacientesView() {

        super("Pacientes");

        
        // Create table model
        table.setName("mainTable");
        table.setModel(tableModel);

        // Create controller
        //PracticaController controller = new PracticaController(searchTermTextField, tableModel);
        //filterButton.addActionListener(controller);
        //searchTermTextField.addKeyListener(controller);

        // Set the view layout
        JPanel ctrlPane = new JPanel();
        ctrlPane.setName("ctrlPanel");
        ctrlPane.add(searchTermTextField);
        ctrlPane.add(buscarButton);
        ctrlPane.add(agregarButton);
        ctrlPane.add(eliminarButton);
        ctrlPane.add(cerrarButton);

        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setName("scrollTablePaneStudent");
        tableScrollPane.setPreferredSize(new Dimension(700, 182));
        tableScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Lista de Pacientes",
                TitledBorder.CENTER, TitledBorder.TOP));

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, ctrlPane, tableScrollPane);
        splitPane.setName("splitPane");
        splitPane.setDividerLocation(35);
        splitPane.setEnabled(false);
        
     

        // Display it all in a scrolling window and make the window appear
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(splitPane);
        pack();

        setLocationRelativeTo(null);
        setVisible(true);
    }

}
