/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.cr.design.patterns.view;

import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTable;

/**
 *
 * @author luism
 */
public class MenuView extends JFrame {

    JMenuBar barraMenu = new JMenuBar();
    JMenu menuFile = new JMenu("Archivo");
    JMenu menuPaciente = new JMenu("Paciente");
    JMenu menuCita = new JMenu("Cita");
    JMenu menuConsulturio = new JMenu("Consultorio");
    JMenu menuHelp = new JMenu("Ayuda");
    JMenuItem fileSalir = new JMenuItem("Salir");
    JMenuItem mostrarPacientes = new JMenuItem("Mostrar Pacientes");
    JMenuItem mostrarCitas = new JMenuItem("Mostrar Citas");
    JMenuItem mostrarCosultorio = new JMenuItem("Mostrar Consultorio");
    //private JTable table;

    public MenuView() throws HeadlessException {
        super("Gestor de Citas");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        barraMenu.setName("menuBar");
        menuFile.setName("menuFile");
        menuPaciente.setName("menuPaciente");
        menuCita.setName("menuCita");
        menuHelp.setName("menuHelp");
        menuConsulturio.setName("Consultorio");

        setJMenuBar(barraMenu);

        barraMenu.add(menuFile);
        barraMenu.add(menuPaciente);
        barraMenu.add(menuCita);
        barraMenu.add(menuConsulturio);
        barraMenu.add(menuHelp);

        menuFile.add(fileSalir);
        menuPaciente.add(mostrarPacientes);
        menuCita.add(mostrarCitas);
        menuConsulturio.add(mostrarCosultorio);
        /*JPanel ctrlPane = new JPanel();
        ctrlPane.setName("ctrlPanel");
        ctrlPane.add(barraMenu);
        ctrlPane.setPreferredSize(new Dimension(700, 182));
        ctrlPane.setBounds(30, 30, 200, 200);
        
        add(ctrlPane);*/
        pack();
//
        setBounds(10, 20, 300, 200);
        this.setMinimumSize(new Dimension(700, 500));
        setLocationRelativeTo(null);
        setVisible(true);

    }

}
