package una.cr.design.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Consultorio {

    @JsonProperty("nombreConsultorio")
    private String nombre;
    @JsonProperty("diasConsulta")
    private String diasConsulta;
    @JsonProperty("horarioAtencion")
    private String horarioAtencion;
    @JsonProperty("telefonoConsultorio")
    private String telefono;

    public Consultorio() {
    }

    public Consultorio(String nombre, String diasConsulta, String horarioAtencion, String telefono) {
        this.nombre = nombre;
        this.diasConsulta = diasConsulta;
        this.horarioAtencion = horarioAtencion;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDiasConsulta() {
        return diasConsulta;
    }

    public void setDiasConsulta(String diasConsulta) {
        this.diasConsulta = diasConsulta;
    }

    public String getHorarioAtencion() {
        return horarioAtencion;
    }

    public void setHorarioAtencion(String horarioAtencion) {
        this.horarioAtencion = horarioAtencion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Consultorio{" + "nombre=" + nombre + ", diasConsulta=" + diasConsulta + ", horarioAtencion=" + horarioAtencion + ", telefono=" + telefono + '}';
    }
    
    // ----- Metodos de prueba para obtener la fecha por medio de Calendar ----- //
    
    /*public String mostrarFecha() {
        Calendar c = Calendar.getInstance();
        int dia = c.get(Calendar.DAY_OF_MONTH);
        int mes = c.get(Calendar.MONTH);
        int ano = c.get(Calendar.YEAR);

        return Integer.toString(dia) + "/" + Integer.toString(mes) + "/" + Integer.toString(ano);
    }*/

 /*
    public void mostrarFecha() {
        DateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        System.out.println(formatoFecha.format(c)); //2016/11/16 12:08:43
    }*/
   
}
