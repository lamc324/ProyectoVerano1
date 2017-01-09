package una.cr.design.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cita {

    @JsonProperty("id")
    Paciente id;
    
    @JsonProperty("consultorio")
    Consultorio consultorio;
    
    @JsonProperty("fecha")
    String fecha;
    
    @JsonProperty("confirmado")
    boolean confirmar;

    public Cita() {
    }

    public Cita(Paciente paciente, Consultorio consultorio, String fecha, boolean confirmar) {
        this.id = paciente;
        this.consultorio = consultorio;
        this.fecha = fecha;
        this.confirmar = confirmar;
    }

    public Paciente getPaciente() {
        return id;
    }

    public void setPaciente(Paciente paciente) {
        this.id = paciente;
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
        return "Cita{" + "id=" + id + ", consultorio=" + consultorio + ", fecha=" + fecha + ", confirmar=" + confirmar + '}';
    }


}
