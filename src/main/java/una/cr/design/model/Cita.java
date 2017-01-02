package una.cr.design.model;

public class Cita {

    Paciente paciente;
    Consultorio consultorio;
    String fecha;
    boolean confirmar;

    public Cita() {
    }

    public Cita(Paciente paciente, Consultorio consultorio, String fecha, boolean confirmar) {
        this.paciente = paciente;
        this.consultorio = consultorio;
        this.fecha = fecha;
        this.confirmar = confirmar;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean isConfirmar() {
        return confirmar;
    }

    public void setConfirmar(boolean confirmar) {
        this.confirmar = confirmar;
    }

    @Override
    public String toString() {
        return paciente.toString() + consultorio.toString() + "\nDia de la consulta: " + fecha;
    }
}
