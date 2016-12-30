package una.cr.design.patterns.view;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class AgregarCitaView extends JFrame{
    String[] horas = {"8:00","8:30","9:00","9:30","10:00","10:30",
        "11:00","11:30","12:00"};
    JComboBox horaBox = new JComboBox(horas);
}
