package una.cr.design.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class Paciente implements Serializable {

    @JsonProperty("id")
    private String id;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("telefono")
    private String telefono;
    @JsonProperty("direccion")
    private String direccion;
    @JsonProperty("fechaNacimiento")
    private String fechaNacimiento;
    @JsonProperty("enfermedades")
    private String[] enfermedades;
    @JsonProperty("observaciones")
    private String observaciones;

    public Paciente() {
    }

    public Paciente(String id, String nombre, String telefono, String direccion,
            String fechaNacimiento, String[] enfermedades, String observaciones) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.enfermedades = enfermedades;
        this.observaciones = observaciones;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String[] getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(String[] enfermedadesAsociadas) {
        this.enfermedades = enfermedadesAsociadas;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    public String getEnfermedad() {

        String enfermedad = "";
        for (String enf : enfermedades) {
            enfermedad += enf + ", ";
        }
        return enfermedad;
    }

    @Override
    public String toString() {
        return "Paciente{" + "id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion + ", fechaNacimiento=" + fechaNacimiento + ", enfermedadesAsociadas=" + enfermedades + ", observaciones=" + observaciones + '}';
    }

}
