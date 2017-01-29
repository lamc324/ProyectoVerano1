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
import java.awt.Dimension;
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import una.cr.design.controller.EliminarPacienteController;

/**
 *
 * @author Grupo Tango
 */
public class EliminarPacienteView extends JFrame {

    JTextField searchTermTextField = new JTextField(26);
    JButton buscarButton = new JButton("Búsqueda");
    JButton cerrarButton = new JButton("Cerrar");
    JLabel nombreLabel = new JLabel("Busqueda por ID o Nombre Completo:");

    /**
     * Constructor del view
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    public EliminarPacienteView() throws JsonGenerationException, JsonMappingException, IOException, Exception {

        super("Eliminar Paciente");

        // Create table model
        searchTermTextField.setName("texto");
        buscarButton.setName("buscar");
        cerrarButton.setName("cerrar");
        nombreLabel.setName("label");

        // Set the view layout
        JPanel ctrlPane = new JPanel();
        JPanel ctrlPane2 = new JPanel();
        JPanel ctrlPane3 = new JPanel();

        ctrlPane.setName("ctrlPanel1");
        ctrlPane2.setName("ctrlPanel2");
        ctrlPane3.setName("ctrlPanel3");
        ctrlPane.add(nombreLabel);
        ctrlPane.add(searchTermTextField);
        ctrlPane.add(buscarButton);
        ctrlPane2.add(cerrarButton);
        
        ctrlPane3.setLayout(new BoxLayout(ctrlPane3, BoxLayout.Y_AXIS));
        ctrlPane3.add(ctrlPane);
        ctrlPane3.add(ctrlPane2);
        
        // Display it all in a scrolling window and make the window appear
        add(ctrlPane3);
        pack();
        
        this.setMinimumSize(new Dimension(700, 100));
        setLocationRelativeTo(null);
        setVisible(true);
        
        EliminarPacienteController controller = new EliminarPacienteController(searchTermTextField, this);
        buscarButton.setActionCommand("clicBuscar");
        buscarButton.addActionListener(controller);
        cerrarButton.setActionCommand("clicCerrar");
        cerrarButton.addActionListener(controller);
    }
    
}
