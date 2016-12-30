package una.cr.design.patterns.model;

public class Paciente {

    private String nombre;
    private String telefono;
    private String direccion;
    private String fechaNacimiento;
    private String Enfermedades;

    public Paciente() {
    }

    public Paciente(String nombre, String telefono, String direccion, String fechaNacimiento, String Enfermedades) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.Enfermedades = Enfermedades;
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

    public String getEnfermedades() {
        return Enfermedades;
    }

    public void setEnfermedadesAsoc(String Enfermedades) {
        this.Enfermedades = Enfermedades;
    }
    

    @Override
    public String toString() {
        return "Paciente{" + "nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion + ", fechaNacimiento=" + fechaNacimiento + ", Enfermedades=" + Enfermedades + '}';
    }
}
