/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.cr.design.patterns.view;

import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
public class CitasView extends JFrame {

    String[] consultorios = {"Elegir Consultorio de preferencia: ","Hospital CIMA", "Centro Medico del Este"};
    JButton buscarButton = new JButton("Filtrar");
    JButton cerrarButton = new JButton("Cerrar");
    JComboBox consultorioBox = new JComboBox();
    JTable table = new JTable();
    DefaultTableModel tableModel = new DefaultTableModel();

    public CitasView() {
        super("Citas");

        // Create table model
        table.setName("mainTable");
        table.setModel(tableModel);

        for (int i = 0; i < consultorios.length; i++) {
            consultorioBox.addItem(consultorios[i]);
        }
        
        // Set the view layout
        JPanel ctrlPane = new JPanel();
        JPanel ctrlPane2 = new JPanel();
        JPanel ctrlPane3 = new JPanel();

        ctrlPane.setName("ctrlPanel");
        ctrlPane.add(consultorioBox);
        ctrlPane.add(buscarButton);
        ctrlPane2.add(cerrarButton);

        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setName("scrollTablePaneStudent");
        tableScrollPane.setPreferredSize(new Dimension(700, 182));
        tableScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Lista de Pacientes",
                TitledBorder.CENTER, TitledBorder.TOP));

        ctrlPane3.setLayout(new BoxLayout(ctrlPane3, BoxLayout.Y_AXIS));
        ctrlPane3.add(ctrlPane);
        ctrlPane3.add(tableScrollPane);
        ctrlPane3.add(ctrlPane2);

        // Display it all in a scrolling window and make the window appear
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(ctrlPane3);
        pack();

        setLocationRelativeTo(null);
        setVisible(true);
    }

}
