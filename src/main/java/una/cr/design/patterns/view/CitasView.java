/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.cr.design.patterns.view;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.awt.Dimension;
import java.io.IOException;
import java.text.ParseException;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import una.cr.design.controller.CitasController;

/**
 *
 * @author John
 */
public class CitasView extends JFrame {
    
    ImageIcon imagenAgregar = new ImageIcon("Agregar.png");
    ImageIcon imagenBuscar = new ImageIcon("Buscar.png");

    String[] consultorios = {"Elegir Consultorio de preferencia: ", "Hospital CIMA", "Centro Medico del Este"};
    JButton buscarButton = new JButton("Buscar",imagenBuscar);
    JButton agregarButton = new JButton("Agregar",imagenAgregar);
    JButton cerrarButton = new JButton("Cerrar");
    JComboBox consultorioBox = new JComboBox();
    JTable table = new JTable();
    DefaultTableModel tableModel = new DefaultTableModel();

    public CitasView() throws JsonGenerationException,
            JsonMappingException, IOException, ParseException {
        super("Citas");

        // Create table model
        table.setName("mainTable");
        table.setModel(tableModel);

        for (String consultorio : consultorios) {
            consultorioBox.addItem(consultorio);
        }

        // Set the view layout
        JPanel ctrlPane = new JPanel();
        JPanel ctrlPane2 = new JPanel();
        JPanel ctrlPane3 = new JPanel();

        ctrlPane.setName("ctrlPanel");
        ctrlPane.add(consultorioBox);
        ctrlPane.add(buscarButton);
        ctrlPane.add(agregarButton);
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
        add(ctrlPane3);
        pack();

        setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(700, 300));
        setVisible(true);

        //Controller        
        CitasController controller = new CitasController(consultorioBox, tableModel, this);
        buscarButton.setActionCommand("clicBuscar");
        buscarButton.addActionListener(controller);
        agregarButton.setActionCommand("clicAgregar");
        agregarButton.addActionListener(controller);
        cerrarButton.setActionCommand("clicCerrar");
        cerrarButton.addActionListener(controller);

    }

}
