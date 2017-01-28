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
import java.text.ParseException;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import una.cr.design.controller.MenuController;

/**
 *
 * @author Grupo Tango
 */
public class MenuView extends JFrame {

    ImageIcon imagenPaciente = new ImageIcon("Paciente.png");
    ImageIcon imagenConsultorio = new ImageIcon("Consultorio.png");
    ImageIcon imagenCitas = new ImageIcon("Citas.png");
    ImageIcon imagenSalir = new ImageIcon("Salir.png");
    ImageIcon imagenAyuda = new ImageIcon("Ayuda.png");
    ImageIcon imagenMenu = new ImageIcon("Menu.png");

    JMenuBar barraMenu = new JMenuBar();
    JMenuItem menuHelp = new JMenuItem("Acerca De", imagenAyuda);
    JMenuItem fileSalir = new JMenuItem("Salir", imagenSalir);
    JMenuItem mostrarPacientes = new JMenuItem("Pacientes", imagenPaciente);
    JMenuItem mostrarCitas = new JMenuItem("Citas", imagenCitas);
    JMenuItem mostrarConsultorio = new JMenuItem("Consultorio", imagenConsultorio);
    JButton menuFondo = new JButton(imagenMenu);
    

    /**
     * Constructor del view
     *
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     * @throws ParseException
     */
    public MenuView() throws JsonGenerationException,
            JsonMappingException, IOException, ParseException, Exception {
        super("Gestor de Citas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        barraMenu.setName("menuBar");
        menuHelp.setName("itemHelp");
        fileSalir.setName("itemSalir");
        mostrarPacientes.setName("itemPacientes");
        mostrarCitas.setName("itemCitas");
        mostrarConsultorio.setName("itemConsultorios");

        JPanel ctrlPane = new JPanel();
//        ctrlPane.setLayout(new BoxLayout(ctrlPane, BoxLayout.Y_AXIS));      

        setJMenuBar(barraMenu);
        barraMenu.add(fileSalir);
        barraMenu.add(mostrarPacientes);
        barraMenu.add(mostrarCitas);
        barraMenu.add(mostrarConsultorio);
        barraMenu.add(menuHelp);
//        ctrlPane.add(barraMenu);
        ctrlPane.add(menuFondo);        
        add(ctrlPane);
        
        pack();
        setBounds(10, 20, 300, 200);
        this.setMinimumSize(new Dimension(750, 500));
        setLocationRelativeTo(null);
        setVisible(true);
        
        //Controller        
        MenuController controller = new MenuController(this);
        mostrarPacientes.setActionCommand("clicMostrarPacientes");
        mostrarPacientes.addActionListener(controller);
        mostrarCitas.setActionCommand("clicMostrarCitas");
        mostrarCitas.addActionListener(controller);
        mostrarConsultorio.setActionCommand("clicMostrarConsultorios");
        mostrarConsultorio.addActionListener(controller);
        fileSalir.setActionCommand("clicSalir");
        fileSalir.addActionListener(controller);
        menuHelp.setActionCommand("clicAyuda");
        menuHelp.addActionListener(controller);

    }

}
