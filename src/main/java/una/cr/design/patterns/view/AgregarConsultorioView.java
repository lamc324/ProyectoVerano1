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
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.MaskFormatter;
import una.cr.design.controller.AgregarConsultorioController;

/**
 *
 * @author Grupo Tango
 */
public class AgregarConsultorioView extends JFrame {

    JTextField nombre = new JTextField(20);
    JTextField dias = new JTextField(20);
    JTextField horario = new JTextField(20);
    JFormattedTextField telefonoContacto;
    JLabel nombreLabel = new JLabel("Nombre: ");
    JLabel diasLabel = new JLabel("Dias: ");
    JLabel horarioLabel = new JLabel("Horario de Atencion: ");
    JLabel telefonoLabel = new JLabel("Telefono: ");
    JButton aceptar = new JButton("Aceptar");
    JButton cancelar = new JButton("Cancelar");

    /**
     * Constructor del view
     */
    public AgregarConsultorioView() {
        super("Agregar Consultorio");

        //Create and populate the panel.
        JPanel stringPane = new JPanel();

        MaskFormatter markFormatter = null;
        try {
            markFormatter = new MaskFormatter("(506) ####-####");
        } catch (ParseException ex) {
            Logger.getLogger(AgregarPacienteView.class.getName()).log(Level.SEVERE, null, ex);
        }
        markFormatter.setPlaceholderCharacter(' ');
        telefonoContacto = new JFormattedTextField(markFormatter);

        stringPane.setLayout(new BoxLayout(stringPane, BoxLayout.Y_AXIS));
        stringPane.add(nombreLabel);
        stringPane.add(nombre);
        stringPane.add(diasLabel);
        stringPane.add(dias);
        stringPane.add(horarioLabel);
        stringPane.add(horario);
        stringPane.add(telefonoLabel);
        stringPane.add(telefonoContacto);

        JPanel buttonPane = new JPanel();
        buttonPane.add(cancelar);
        buttonPane.add(aceptar);

        JPanel controlPane = new JPanel();
        controlPane.add(stringPane);
        controlPane.add(buttonPane);

        controlPane.setLayout(new BoxLayout(controlPane, BoxLayout.Y_AXIS));
        stringPane.setOpaque(true);
        /*frame.*/
        setContentPane(controlPane);

        /*frame.*/
        pack();
        /*frame.*/
        this.setMinimumSize(new Dimension(500, 200));
        setLocationRelativeTo(null);
        setVisible(true);

        //Controller        
        AgregarConsultorioController controller = new AgregarConsultorioController(nombre, dias, horario,
                telefonoContacto, this);
        aceptar.setActionCommand("clicAceptar");
        aceptar.addActionListener(controller);
        cancelar.setActionCommand("clicCancelar");
        cancelar.addActionListener(controller);

        //Setting name of each element
        nombre.setName("nombreTxt");
        dias.setName("diasTxt");
        horario.setName("horarioTxt");
        telefonoContacto.setName("telefonoContactoTxt");
        cancelar.setName("cancelarButton");
        aceptar.setName("aceptarButton");
        stringPane.setName("stringPane");
        buttonPane.setName("buttonPanel");
        controlPane.setName("controlPane");

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
