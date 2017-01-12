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
package una.cr.design.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import una.cr.design.patterns.view.AgregarCitaView;
import una.cr.design.patterns.view.AgregarPacienteView;

/**
 *
 * @author Grupo Tango
 */
public class AgregarCitaController implements ActionListener {

    private AgregarCitaView view;
    private JComboBox consultorioBox;
    private JEditorPane campoDescrip;

    /**
     *
     * @param consultorioBox
     * @param campoDescrip
     * @param view
     */
    public AgregarCitaController(JComboBox consultorioBox, JEditorPane campoDescrip, AgregarCitaView view) {
        this.consultorioBox = consultorioBox;
        this.campoDescrip = campoDescrip;
        this.view = view;
    }

    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String aux = (String) consultorioBox.getSelectedItem();

        switch (e.getActionCommand()) {
            case "clicSeleccion":
                if ("Hospital CIMA".equals(aux)) {
                    campoDescrip.setText("Hospital CIMA\nHorario de Atencion:\nLunes y Martes de 8 am a 8 pm");
                } else if ("Centro Medico del Este".equals(aux)) {
                    campoDescrip.setText("Centro Medico del Este\nHorario de Atencion:\nJueves y Viernes de 8 am a 6 pm");
                }
                break;
            case "clicAtras":
                AgregarPacienteView ap = new AgregarPacienteView();
                view.setVisible(false);
                break;
            case "clicTerminar":

                if ("Hospital CIMA".equals(aux) || "Centro Medico del Este".equals(aux)) {
                    JOptionPane.showMessageDialog(view, "Cita Agregada", "", JOptionPane.INFORMATION_MESSAGE);
                    view.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(view, "Por favor, seleccione un consultorio para continuar", "Error", JOptionPane.ERROR_MESSAGE);
                }

                break;
        }
    }
}
