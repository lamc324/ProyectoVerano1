package una.cr.design.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cita {

    @JsonProperty("id")
    private String id;

    @JsonProperty("consultorio")
    private String consultorio;

    @JsonProperty("fecha")
    private String fecha;

    @JsonProperty("confirmado")
    private boolean confirmar;

    public Cita() {
    }

    public Cita(String id, String consultorio, String fecha, boolean confirmar) {
        this.id = id;
        this.consultorio = consultorio;
        this.fecha = fecha;
        this.confirmar = confirmar;
    }

    public String getId() {
        return id;
    }

    public void setPaciente(String paciente) {
        this.id = paciente;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
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

    public String confirmado() {
        String aux;
        if (isConfirmar() == true) {
            aux = "Confirmado";
        } else {
            aux = "No Confirmado";
        }

        return aux;
    }

    @Override
    public String toString() {
        return "Cita{" + "id=" + id + ", consultorio=" + consultorio + ", fecha=" + fecha + ", confirmar=" + confirmar + '}';
    }

}
