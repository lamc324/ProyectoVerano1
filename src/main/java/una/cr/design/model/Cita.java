package una.cr.design.model;

public class Cita {

    Paciente paciente;
    Consultorio consultorio;
    String fecha;

    public Cita() {
    }

    public Cita(Paciente paciente, Consultorio consultorio, String fecha) {
        this.paciente = paciente;
        this.consultorio = consultorio;
        this.fecha = fecha;
    }

    public void horaConsulta() {
    }

    @Override
    public String toString() {
        return paciente.toString() + consultorio.toString() + "\nDia de la consulta: " + fecha;
    }
}
