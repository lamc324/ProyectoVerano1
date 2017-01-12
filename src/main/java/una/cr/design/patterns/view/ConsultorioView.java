/*
 * Copyright (C) 2016 Grupo Tango
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Universidad Nacional de Costa Rica, Estudiantes: Luis Alonso Morgan Campos,
 * John Herrera Jimenez, Kevin Venegas, Caleb Villalta, Josue David Matamorros.
 */
package una.cr.design.patterns.view;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.text.ParseException;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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

    ImageIcon imagenEliminar = new ImageIcon("Eliminar.png");
    ImageIcon imagenAgregar = new ImageIcon("Agregar.png");
    ImageIcon imagenBuscar = new ImageIcon("Buscar.png");
    ImageIcon imagenCerrar = new ImageIcon("Cerrar.png");

    JTextField searchTermTextField = new JTextField(26);
    JButton buscarButton = new JButton("Búsqueda", imagenBuscar);
    JButton agregarButton = new JButton("Agregar", imagenAgregar);
    JButton eliminarButton = new JButton("Eliminar", imagenEliminar);
    JButton cerrarButton = new JButton("Cerrar", imagenCerrar);
    JTable table = new JTable();
    JLabel nombreLabel = new JLabel("Nombre del Consultorio:");
    DefaultTableModel tableModel = new DefaultTableModel();

    public ConsultorioView() throws JsonGenerationException,
            JsonMappingException, IOException, ParseException {

        super("Consultorios");

        // Create table model
        table.setName("mainTable");
        table.setModel(tableModel);

        // Set the view layout
        JPanel ctrlPane = new JPanel();
        JPanel ctrlPane2 = new JPanel();
        JPanel ctrlPane3 = new JPanel();

        buscarButton.setBackground(Color.WHITE);
        agregarButton.setBackground(Color.WHITE);
        eliminarButton.setBackground(Color.WHITE);
        cerrarButton.setBackground(Color.WHITE);
        
        ctrlPane.setName("ctrlPanel");
        ctrlPane.add(nombreLabel);
        ctrlPane.add(searchTermTextField);
        ctrlPane.add(buscarButton);
        ctrlPane.add(agregarButton);
        ctrlPane.add(eliminarButton);
        ctrlPane2.add(cerrarButton);

        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setName("scrollTablePaneStudent");
        tableScrollPane.setPreferredSize(new Dimension(800, 182));
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
        ConsultorioController controller = new ConsultorioController(searchTermTextField, this, tableModel);
        buscarButton.setActionCommand("clicBuscar");
        buscarButton.addActionListener(controller);
        agregarButton.setActionCommand("clicAgregar");
        agregarButton.addActionListener(controller);
        eliminarButton.setActionCommand("clicEliminar");
        eliminarButton.addActionListener(controller);
        cerrarButton.setActionCommand("clicCerrar");
        cerrarButton.addActionListener(controller);
        searchTermTextField.addKeyListener(controller);

    }

}
