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

    private JMenuBar barraMenu;
    private JMenu menuFile;
    private JMenu menuPaciente;
    private JMenu menuCita;
    private JMenu menuHelp;
    private JMenuItem fileSalir;
    private JMenuItem mostrarPacientes;
    private JMenuItem mostrarCitas;
    //private JTable table;

    public MenuView() throws HeadlessException {
        super("Gestor de Citas");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        barraMenu = new JMenuBar();
        menuFile = new JMenu("Archivo");
        menuPaciente = new JMenu("Paciente");
        menuCita = new JMenu("Cita");
        menuHelp = new JMenu("Ayuda");
        
        fileSalir = new JMenuItem("Salir");
        mostrarPacientes = new JMenuItem("Mostrar Pacientes");
        mostrarCitas = new JMenuItem("Mostrar Citas");

        barraMenu.setName("menuBar");
        menuFile.setName("menuFile");
        menuPaciente.setName("menuPaciente");
        menuCita.setName("menuCita");
        menuHelp.setName("menuHelp");

        setJMenuBar(barraMenu);

        barraMenu.add(menuFile);
        barraMenu.add(menuPaciente);
        barraMenu.add(menuCita);
        barraMenu.add(menuHelp);
        
        menuFile.add(fileSalir);
        menuPaciente.add(mostrarPacientes);
        menuCita.add(mostrarCitas);
        /*JPanel ctrlPane = new JPanel();
        ctrlPane.setName("ctrlPanel");
        ctrlPane.add(barraMenu);
        ctrlPane.setPreferredSize(new Dimension(700, 182));
        ctrlPane.setBounds(30, 30, 200, 200);
        
        add(ctrlPane);*/
        pack();

        setBounds(10, 20, 300, 200);
        setVisible(true);

    }

}
