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

/**
 *
 * @author Grupo Tango
 */
public class Consultorio {

    @JsonProperty("nombreConsultorio")
    private String nombre;
    @JsonProperty("diasConsulta")
    private String diasConsulta;
    @JsonProperty("horarioAtencion")
    private String horarioAtencion;
    @JsonProperty("telefonoConsultorio")
    private String telefono;

    /**
     * Constructor sin parametros
     */
    public Consultorio() {
    }

    /**
     * Constructor con parametros
     * @param nombre
     * @param diasConsulta
     * @param horarioAtencion
     * @param telefono
     */
    public Consultorio(String nombre, String diasConsulta, String horarioAtencion, String telefono) {
        this.nombre = nombre;
        this.diasConsulta = diasConsulta;
        this.horarioAtencion = horarioAtencion;
        this.telefono = telefono;
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
     * @return diaConsulta
     */
    public String getDiasConsulta() {
        return diasConsulta;
    }

    /**
     *
     * @param diasConsulta
     */
    public void setDiasConsulta(String diasConsulta) {
        this.diasConsulta = diasConsulta;
    }

    /**
     *
     * @return horarioAtencion
     */
    public String getHorarioAtencion() {
        return horarioAtencion;
    }

    /**
     *
     * @param horarioAtencion
     */
    public void setHorarioAtencion(String horarioAtencion) {
        this.horarioAtencion = horarioAtencion;
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
     * @return
     */
    @Override
    public String toString() {
        return "Consultorio{" + "nombre=" + nombre + ", diasConsulta=" + diasConsulta + ", horarioAtencion=" + horarioAtencion + ", telefono=" + telefono + '}';
    }  
}
