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
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import una.cr.design.controller.MenuController;

/**
 *
 * @author luism
 */
public class MenuView extends JFrame {

    ImageIcon imagenPaciente = new ImageIcon("Paciente.png");
    ImageIcon imagenConsultorio = new ImageIcon("Consultorio.png");
    ImageIcon imagenCitas = new ImageIcon("Citas.png");
    ImageIcon imagenSalir = new ImageIcon("Salir.png");
    ImageIcon imagenAyuda = new ImageIcon("Ayuda.png");

    JMenuBar barraMenu = new JMenuBar();
    JMenuItem menuHelp = new JMenuItem("Ayuda", imagenAyuda);
    JMenuItem fileSalir = new JMenuItem("Salir", imagenSalir);
    JMenuItem mostrarPacientes = new JMenuItem("Pacientes", imagenPaciente);
    JMenuItem mostrarCitas = new JMenuItem("Citas", imagenCitas);
    JMenuItem mostrarConsultorio = new JMenuItem("Consultorio", imagenConsultorio);

    public MenuView() throws JsonGenerationException,
            JsonMappingException, IOException, ParseException {
        super("Gestor de Citas");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        barraMenu.setName("menuBar");
        menuHelp.setName("itemHelp");
        fileSalir.setName("itemSalir");
        mostrarPacientes.setName("itemPacientes");
        mostrarCitas.setName("itemCitas");
        mostrarConsultorio.setName("itemConsultorios");

        setJMenuBar(barraMenu);
        barraMenu.add(fileSalir);
        barraMenu.add(mostrarPacientes);
        barraMenu.add(mostrarCitas);
        barraMenu.add(mostrarConsultorio);
        barraMenu.add(menuHelp);

        pack();
//
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
