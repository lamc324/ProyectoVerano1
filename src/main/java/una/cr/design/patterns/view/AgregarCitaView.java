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

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import una.cr.design.controller.AgregarCitaController;

/**
 *
 * @author Grupo Tango
 */
public class AgregarCitaView extends JFrame {

    String[] consultorios = {"Elegir Consultorio de preferencia: "};
    String[] horas = {"Elegir hora de atencion: ", "8:00", "8:30", "9:00", "9:30", "10:00", "10:30",
        "11:00", "11:30", "12:00"};
    String[] descripConsultorios = {"Hospital CIMA\nHorario de Atencion:\nLunes y Martes de 8 am a 8 pm",
        "Centro Medico del Este\nHorario de Atencion:\nJueves y Viernes de 8 am a 6 pm"};
    JComboBox horaBox = new JComboBox();
    JComboBox consultorioBox = new JComboBox();
    JEditorPane campoDescrip = new JEditorPane();
    JButton atras = new JButton("Atras");
    JButton terminar = new JButton("Terminar");
    JTextField agregarId = new JTextField(15);
    JLabel idPacientfLabel = new JLabel("Id Paciente");
    UtilDateModel model;
    JDatePanelImpl datePanel;
    JDatePickerImpl datePicker;
    JLabel fechaCita = new JLabel("Fecha de la cita");

    /**
     * Constructor del view
     * @throws java.lang.Exception
     */
    public AgregarCitaView() throws Exception {
        super("Agregar Cita");
        setSize(500, 360);
        JPanel ctrlPane = new JPanel();
        JPanel ctrlPane_1 = new JPanel();
        JPanel ctrlPane2 = new JPanel();
        JPanel ctrlPane2_1 = new JPanel();
        JPanel ctrlPane3 = new JPanel();
        JPanel fckngPane = new JPanel();

        atras.setName("atras");
        terminar.setName("terminar");
        consultorioBox.setName("box");

        ctrlPane.setName("ctrlPanel1");
        ctrlPane_1.setName("ctrlPanel1_1");
        ctrlPane2.setName("ctrlPanel2");
        ctrlPane2_1.setName("ctrlPanel2_1");
        ctrlPane3.setName("ctrlPanel3");

        ctrlPane.setLayout(new BorderLayout());
        for (String consultorio : consultorios) {
            consultorioBox.addItem(consultorio);
        }
        for (String hora : horas) {
            horaBox.addItem(hora);
        }

        JScrollPane tableScrollPane = new JScrollPane(campoDescrip);
        tableScrollPane.setName("scrollTablePane");
        tableScrollPane.setPreferredSize(new Dimension(400, 182));
        tableScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Descripcion del Consultorio: ",
                TitledBorder.CENTER, TitledBorder.TOP));

        ctrlPane.add(BorderLayout.NORTH, consultorioBox);
        ctrlPane.add(BorderLayout.CENTER, tableScrollPane);
        ctrlPane_1.add(idPacientfLabel);
        ctrlPane_1.add(agregarId);
        ctrlPane_1.add(ctrlPane);

        /////////////////////////////////
        model = new UtilDateModel();
        datePanel = new JDatePanelImpl(model);
        datePicker = new JDatePickerImpl(datePanel);
        fckngPane.add(fechaCita);
        fckngPane.add(datePicker);
        /////////////////////////////////

        ctrlPane2.add(atras);
        ctrlPane2.add(terminar);
        ctrlPane2_1.add(ctrlPane2);

        ctrlPane3.setLayout(new BoxLayout(ctrlPane3, BoxLayout.Y_AXIS));
        ctrlPane3.add(ctrlPane_1);
        ctrlPane3.add(fckngPane);
        ctrlPane3.add(ctrlPane2_1);

        add(ctrlPane3);

        this.setMinimumSize(new Dimension(500, 400));
        setLocationRelativeTo(null);
        setVisible(true);

        //Controller        
        AgregarCitaController controller = new AgregarCitaController(agregarId, consultorioBox, campoDescrip, this, datePicker);
        atras.setActionCommand("clicAtras");
        atras.addActionListener(controller);
        terminar.setActionCommand("clicTerminar");
        terminar.addActionListener(controller);
        consultorioBox.setActionCommand("clicSeleccion");
        consultorioBox.addActionListener(controller);
    }
}
