package una.cr.design.model;

public class Paciente {

    private String id;
    private String nombre;
    private String telefono;
    private String direccion;
    private String fechaNacimiento;
    private String enfermedadesAsociadas;
    private String observaciones;

    public Paciente() {
    }

    public Paciente(String id, String nombre, String telefono, String direccion, String fechaNacimiento, String enfermedadesAsociadas, String observaciones) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.enfermedadesAsociadas = enfermedadesAsociadas;
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

    public String getEnfermedadesAsociadas() {
        return enfermedadesAsociadas;
    }

    public void setEnfermedadesAsociadas(String enfermedadesAsociadas) {
        this.enfermedadesAsociadas = enfermedadesAsociadas;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "Paciente{" + "id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion + ", fechaNacimiento=" + fechaNacimiento + ", enfermedadesAsociadas=" + enfermedadesAsociadas + ", observaciones=" + observaciones + '}';
    }

}
