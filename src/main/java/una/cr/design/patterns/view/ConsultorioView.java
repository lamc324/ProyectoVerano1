/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.cr.design.patterns.view;

import java.awt.Dimension;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import una.cr.design.controller.ConsultorioController;

/**
 *
 * @author John
 */
public class ConsultorioView extends JFrame {

    JTextField searchTermTextField = new JTextField(26);
    JButton buscarButton = new JButton("Buscar");
    JButton agregarButton = new JButton("Agregar");
    JButton eliminarButton = new JButton("Eliminar");
    JButton cerrarButton = new JButton("Cerrar");
    JTable table = new JTable();
    JLabel nombreLabel = new JLabel("Nombre del Consultorio:");
    DefaultTableModel tableModel = new DefaultTableModel();

    public ConsultorioView() {

        super("Consultorios");

        // Create table model
        table.setName("mainTable");
        table.setModel(tableModel);

        // Set the view layout
        JPanel ctrlPane = new JPanel();
        JPanel ctrlPane2 = new JPanel();
        JPanel ctrlPane3 = new JPanel();

        ctrlPane.setName("ctrlPanel");
        ctrlPane.add(nombreLabel);
        ctrlPane.add(searchTermTextField);
        ctrlPane.add(buscarButton);
        ctrlPane.add(agregarButton);
        ctrlPane2.add(eliminarButton);
        ctrlPane2.add(cerrarButton);

        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setName("scrollTablePaneStudent");
        tableScrollPane.setPreferredSize(new Dimension(700, 182));
        tableScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Consultorios Disponibles",
                TitledBorder.CENTER, TitledBorder.TOP));

        ctrlPane3.setLayout(new BoxLayout(ctrlPane3, BoxLayout.Y_AXIS));
        ctrlPane3.add(ctrlPane);
        ctrlPane3.add(tableScrollPane);
        ctrlPane3.add(ctrlPane2);

        // Display it all in a scrolling window and make the window appear
        add(ctrlPane3);
        pack();

        this.setMinimumSize(new Dimension(700, 300));
        setLocationRelativeTo(null);
        setVisible(true);

        //Controller        
        ConsultorioController controller = new ConsultorioController(this);
        buscarButton.setActionCommand("clicBuscar");
        buscarButton.addActionListener(controller);
        agregarButton.setActionCommand("clicAgregar");
        agregarButton.addActionListener(controller);
        eliminarButton.setActionCommand("clicEliminar");
        eliminarButton.addActionListener(controller);
        cerrarButton.setActionCommand("clicCerrar");
        cerrarButton.addActionListener(controller);

    }

}
