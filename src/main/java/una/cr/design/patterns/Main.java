package una.cr.design.patterns;

import una.cr.design.patterns.view.AgregarPacienteView;
import una.cr.design.patterns.view.MenuView;
import una.cr.design.patterns.view.PacientesView;

public class Main {

    public static void main(String[] args) {
        MenuView v = new MenuView();
        PacientesView p = new PacientesView();
        AgregarPacienteView pv = new AgregarPacienteView();
    }
}
