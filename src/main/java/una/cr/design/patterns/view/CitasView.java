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
 * John Herrera Jimenez, Kevin Venegas Loria, Caleb Villalta Quesada, Josue David Matamorros.
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
 * @author Grupo Tango
 */
public class CitasView extends JFrame {

    ImageIcon imagenAgregar = new ImageIcon("Agregar.png");
    ImageIcon imagenBuscar = new ImageIcon("Buscar.png");
    ImageIcon imagenCerrar = new ImageIcon("Cerrar.png");

    String[] consultorios = {"Elegir Consultorio de preferencia: ", "Hospital CIMA", "Centro Medico del Este"};
    JButton buscarButton = new JButton("Buscar", imagenBuscar);
    JButton agregarCitaButton = new JButton("Nueva Cita");
    JButton cerrarButton = new JButton("Cerrar", imagenCerrar);
    JComboBox consultorioBox = new JComboBox();
    JTable table = new JTable();
    DefaultTableModel tableModel = new DefaultTableModel();

    /**
     * Constructor del view
     *
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     * @throws ParseException
     */
    public CitasView() throws JsonGenerationException,
            JsonMappingException, IOException, ParseException, Exception {
        super("Citas");

        // Create table model
        table.setName("mainTable");
        table.setModel(tableModel);
        buscarButton.setName("buscar");
        cerrarButton.setName("cerrar");
        consultorioBox.setName("box");
        agregarCitaButton.setName("Agregar Cita");

        for (String consultorio : consultorios) {
            consultorioBox.addItem(consultorio);
        }

        // Set the view layout
        JPanel ctrlPane = new JPanel();
        JPanel ctrlPane2 = new JPanel();
        JPanel ctrlPane3 = new JPanel();

        buscarButton.setBackground(Color.WHITE);
        cerrarButton.setBackground(Color.WHITE);

        ctrlPane.setName("ctrlPanel1");
        ctrlPane2.setName("ctrlPanel2");
        ctrlPane3.setName("ctrlPanel3");
        ctrlPane.add(consultorioBox);
        ctrlPane.add(buscarButton);
        ctrlPane.add(agregarCitaButton);
        ctrlPane2.add(cerrarButton);

        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setName("scrollTablePane");
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
        cerrarButton.setActionCommand("clicCerrar");
        cerrarButton.addActionListener(controller);
        agregarCitaButton.setActionCommand("clicAgregar");
        agregarCitaButton.addActionListener(controller);
    }
}
