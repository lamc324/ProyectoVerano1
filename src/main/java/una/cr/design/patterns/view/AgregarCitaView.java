package una.cr.design.patterns.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class AgregarCitaView extends JFrame {

    String[] horas = {"Elegir hora de atencion: ", "8:00", "8:30", "9:00", "9:30", "10:00", "10:30",
        "11:00", "11:30", "12:00"};
    String[] consultorios = {"Hospital CIMA\nHorario de Atencion:\nLunes y Martes de 8 am a 8 pm",
        "Centro Medico del Este\nHorario de Atencion:\nJueves y Viernes de 8 am a 6 pm"};
    JComboBox horaBox = new JComboBox(horas);
    JTextArea campoDescrip = new JTextArea();

    public AgregarCitaView() {
        super("Agregar Cita");
        setSize(600, 500);
        JPanel p = new JPanel();
        JPanel p2 = new JPanel();
        
        p.setLayout(new BorderLayout());
        for (int i = 0; i < horas.length; i++) {
            horaBox.addItem(horas[i]);
        }
        
        JScrollPane tableScrollPane = new JScrollPane(campoDescrip);
        tableScrollPane.setName("scrollTablePaneStudent");
        tableScrollPane.setPreferredSize(new Dimension(400, 182));
        tableScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Descripcion del Consultorio: ",
                TitledBorder.CENTER, TitledBorder.TOP));
        
        p.add(BorderLayout.NORTH, horaBox);
        p.add(BorderLayout.CENTER, tableScrollPane);
        p2.add(p);
        add(p2);

        setVisible(true);
    }
}
