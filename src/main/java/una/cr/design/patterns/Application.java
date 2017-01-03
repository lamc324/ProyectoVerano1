package una.cr.design.patterns;

import una.cr.design.patterns.view.AgregarCitaView;
import una.cr.design.patterns.view.AgregarConsultorioView;
import una.cr.design.patterns.view.AgregarPacienteView;
import una.cr.design.patterns.view.CitasView;
import una.cr.design.patterns.view.ConsultorioView;
import una.cr.design.patterns.view.MenuView;
import una.cr.design.patterns.view.PacientesView;

public class Application {

    public static void main(String[] args) {
        MenuView v = new MenuView();
        AgregarPacienteView av = new AgregarPacienteView();
    }
}
