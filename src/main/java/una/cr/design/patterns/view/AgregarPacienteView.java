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

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import una.cr.design.controller.AgregarPacienteController;

/**
 *
 * @author Grupo Tango
 */
public class AgregarPacienteView extends JFrame {

    JTextField id = new JTextField(15);
    JTextField nombre = new JTextField(15);
    JTextField telefono = new JTextField(15);
    JTextField direccion = new JTextField(15);
    JTextField fechaNac = new JTextField(15);
    JTextField enfermedades = new JTextField(15);
    JTextArea observaciones = new JTextArea(4, 15);
    JLabel idLabel = new JLabel("Identificacion: ");
    JLabel nombreLabel = new JLabel("Nombre: ");
    JLabel telefLabel = new JLabel("Telefono: ");
    JLabel dirLabel = new JLabel("Direccion: ");
    JLabel fechaLabel = new JLabel("Fecha Nacimiento: ");
    JLabel EnfermLabel = new JLabel("Enfermedades Asociadas: ");
    JLabel ObvsLabel = new JLabel("Observaciones: ");
    JButton siguiente = new JButton("Siguiente");
    JButton cancelar = new JButton("Cancelar");

    /**
     * Constructor del view
     */
    public AgregarPacienteView() {
        super("Agregar Paciente");

        id.setName("id");
        nombre.setName("nombre");
        telefono.setName("telefono");
        direccion.setName("direccion");
        fechaNac.setName("fechaNac");
        enfermedades.setName("enfermedades");
        observaciones.setName("observaciones");
        siguiente.setName("siguiente");
        cancelar.setName("cancelar");
        
        // Crea y llena el panel
        JPanel stringPane = new JPanel();
        stringPane.setName("stringPane");
        stringPane.setLayout(new BoxLayout(stringPane, BoxLayout.Y_AXIS));
        stringPane.add(idLabel);
        stringPane.add(id);
        stringPane.add(nombreLabel);
        stringPane.add(nombre);
        stringPane.add(telefLabel);
        stringPane.add(telefono);
        stringPane.add(dirLabel);
        stringPane.add(direccion);
        stringPane.add(fechaLabel);
        stringPane.add(fechaNac);
        stringPane.add(EnfermLabel);
        stringPane.add(enfermedades);
        stringPane.add(ObvsLabel);
        //stringPane.add(observaciones);

        JPanel buttonPane = new JPanel();
        buttonPane.setName("buttonPane");
        buttonPane.add(cancelar);
        buttonPane.add(siguiente);

        JPanel controlPane = new JPanel();
        controlPane.setName("controlPane");
        controlPane.add(stringPane);
        controlPane.add(observaciones);
        controlPane.add(buttonPane);

        controlPane.setLayout(new BoxLayout(controlPane, BoxLayout.Y_AXIS));
        stringPane.setOpaque(true);
        /*frame.*/
        setContentPane(controlPane);

        // Crea el controller
        AgregarPacienteController controller = new AgregarPacienteController(id, nombre, telefono, direccion, fechaNac, enfermedades, observaciones,this);
        cancelar.setActionCommand("clicCancelar");
        cancelar.addActionListener(controller);
        siguiente.setActionCommand("clicSiguiente");
        siguiente.addActionListener(controller);

        
        pack();
        
        setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(300, 300));
        
        setVisible(true);

    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException exc) {
            System.out.println(exc.getMessage());
        }
    }

}

