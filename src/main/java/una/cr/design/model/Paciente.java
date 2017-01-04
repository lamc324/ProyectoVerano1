package una.cr.design.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import static jdk.nashorn.internal.runtime.Debug.id;
import una.cr.design.datos.PacienteDao;

@Entity(name="Paciente")
@Table(name = "Paciente", catalog = "Consulturio", uniqueConstraints = {
    @UniqueConstraint(columnNames = "id"),
    @UniqueConstraint(columnNames = "nombre"),
    @UniqueConstraint(columnNames = "telefono"),
    @UniqueConstraint(columnNames = "direccion"),
    @UniqueConstraint(columnNames = "fechaNacimiento"),
    @UniqueConstraint(columnNames = "enfermedades")
//    @UniqueConstraint(columnNames = "observaciones")
})


//@Table(name = "Paciente", uniqueConstraints = @UniqueConstraint(columNames = 
//        { "id", "nombre", "telefono", "direccion", "fechaNacimiento", "enfermedades", "observaciones" }))

//    @Table(name = "campaign_content", uniqueConstraints = @UniqueConstraint(columnNames = 
//            { "campaign_content_id", "campaign_id", "field_tag" }))

public class Paciente implements Serializable {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "fechaNacimiento")
    private String fechaNacimiento;
    
    @Column(name = "enfermedades")
    private String enfermedadesAsociadas;
  //  private String observaciones;

    public Paciente() {
    }

    public Paciente(String id, String nombre, String telefono, String direccion, String fechaNacimiento, String enfermedadesAsociadas) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.enfermedadesAsociadas = enfermedadesAsociadas;
        //    this.observaciones = observaciones;
    }

//    @Id
//    @GeneratedValue(strategy = IDENTITY)
//    @Column(name = "id", unique = true, nullable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
//    @Column(name = "nombre", unique = true, nullable = false)
    public String getNombre() {
        return nombre;
    }
//
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
//@Column(name = "telefono", unique = true, nullable = false)
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
//@Column(name = "direccion", unique = true, nullable = false)
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
//@Column(name = "fechaNacimiento", unique = true, nullable = false)
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
//@Column(name = "enfermedades", unique = true, nullable = false)
    public String getEnfermedadesAsociadas() {
        return enfermedadesAsociadas;
    }

    public void setEnfermedadesAsociadas(String enfermedadesAsociadas) {
        this.enfermedadesAsociadas = enfermedadesAsociadas;
    }

//    public String getObservaciones() {
//        return observaciones;
//    }
//
//    public void setObservaciones(String observaciones) {
//        this.observaciones = observaciones;
//    }

    @Override
    public String toString() {
        return "Paciente{" + "id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion + ", fechaNacimiento=" + fechaNacimiento + ", enfermedadesAsociadas=" + enfermedadesAsociadas + '}';
    }

}
