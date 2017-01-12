/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author VQ-Caleb
 */
public class AgregarCitaController implements ActionListener {

    private AgregarCitaView view;
    private JComboBox consultorioBox;
    private JEditorPane campoDescrip;

    public AgregarCitaController(JComboBox consultorioBox, JEditorPane campoDescrip, AgregarCitaView view) {
        this.consultorioBox = consultorioBox;
        this.campoDescrip = campoDescrip;
        this.view = view;
    }

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
