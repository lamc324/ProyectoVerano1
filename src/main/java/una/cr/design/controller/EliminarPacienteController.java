package una.cr.design.controller;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import una.cr.design.patterns.view.AgregarPacienteView;
import una.cr.design.patterns.view.EliminarPacienteView;
import una.cr.design.service.EliminarPacienteService;

/**
 *
 * @author luism
 */
public class EliminarPacienteController implements ActionListener {

    private JTextField searchTermTextField = new JTextField(26);
    private Object[][] pacientes;
    private EliminarPacienteView view;
    private EliminarPacienteService pacientesService;

    public EliminarPacienteController(JTextField searchTermTextField,
            EliminarPacienteView view) throws JsonGenerationException,
            JsonMappingException, IOException {

        super();
        pacientesService = new EliminarPacienteService();
        pacientes = pacientesService.cargarPersonasObjWrapper();
        this.searchTermTextField = searchTermTextField;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "clicBuscar":
                String searchTerm = searchTermTextField.getText();
                updateTableSearchTerms(searchTerm);
                break;
            case "clicCerrar":
                view.setVisible(false);
                break;
        }
    }

    private void updateTableSearchTerms(String searchTerm) {
        if (searchTerm != null && !"".equals(searchTerm)
                && pacientes != null && pacientes.length >= 1) {
            Object[][] newData = new Object[pacientes.length][];
            int idx = 0;
            for (Object[] obj : pacientes) {
                String fullId = obj[0].toString();
                String fullTextMayus = obj[1].toString().toLowerCase();
                String fullTextMinus = obj[1].toString().toUpperCase();

                if (fullTextMayus.equals(searchTerm.trim())
                        || fullTextMinus.equals(searchTerm.trim())
                        || fullId.equals(searchTerm.trim())) {
                    JOptionPane.showMessageDialog(null,
                            "Paciente Eliminado:\n\n"
                            + obj[0].toString() + "\n"
                            + obj[1].toString() + "\n"
                            + obj[2].toString() + "\n"
                            + obj[3].toString() + "\n"
                            + obj[4].toString() + "\n"
                            + obj[5].toString(), "",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                } else {
                    JOptionPane.showMessageDialog(null,
                    "No se encontro ningún paciente", "Error",
                    JOptionPane.ERROR_MESSAGE);
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "El campo de búsqueda esta vacío", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
