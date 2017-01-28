/*
 * Copyright (C) 2016 Grupo Tango
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Universidad Nacional de Costa Rica, Estudiantes: Luis Alonso Morgan Campos,
 * John Herrera Jimenez, Kevin Venegas Loria, Caleb Villalta Quesada, Josue David Matamorros.
 */
package una.cr.design.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

/**
 *
 * @author Grupo Tango
 */
public class Paciente implements Serializable {

    @JsonProperty("id_paciente")
    private String id_paciente;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("telefono")
    private String telefono;
    @JsonProperty("direccion")
    private String direccion;
    @JsonProperty("fecha_nacimiento")
    private String fecha_nacimiento;
    @JsonProperty("enfermedades")
    private String enfermedades;
    @JsonProperty("observaciones")
    private String observaciones;

    /**
     * Constructor sin parametros
     */
    public Paciente() {
    }

    /**
     * Constructor con parametros
     * @param idPaciente
     * @param nombre
     * @param telefono
     * @param direccion
     * @param fechaNacimiento
     * @param enfermedades
     * @param observaciones
     */
    public Paciente(String idPaciente, String nombre, String telefono, String direccion,
            String fechaNacimiento, String enfermedades, String observaciones) {
        this.id_paciente = idPaciente;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fecha_nacimiento = fechaNacimiento;
        this.enfermedades = enfermedades;
        this.observaciones = observaciones;
    }

    /**
     *
     * @return id
     */
    public String getIdPaciente() {
        return id_paciente;
    }

    /**
     *
     * @param idPaciente
     */
    public void setIdPaciente(String idPaciente) {
        this.id_paciente = idPaciente;
    }

    /**
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     *
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     *
     * @return direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     *
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     *
     * @return fechaNacimiento
     */
    public String getFechaNacimiento() {
        return fecha_nacimiento;
    }

    /**
     *
     * @param fechaNacimiento
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fecha_nacimiento = fechaNacimiento;
    }

    /**
     *
     * @return getEnfermedades
     */
    public String getEnfermedades() {
        return enfermedades;
    }

    /**
     *
     * @param enfermedadesAsociadas
     */
    public void setEnfermedades(String enfermedadesAsociadas) {
        this.enfermedades = enfermedadesAsociadas;
    }

    /**
     *
     * @return observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     *
     * @param observaciones
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    /**
     * Retorna solo un elemento del array de enfermedades
     * @return enfermedad
     */
//    public String getEnfermedad() {
//        String enfermedad = "";
//        for (String enf : enfermedades) {
//            enfermedad += enf + ", ";
//        }
//        return enfermedad;
//    }

    /**
     *
     * @return toString
     */
    @Override
    public String toString() {
        return "Paciente{" + "id=" + id_paciente + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion + ", fechaNacimiento=" + fecha_nacimiento + ", enfermedadesAsociadas=" + enfermedades + ", observaciones=" + observaciones + '}';
    }

}
