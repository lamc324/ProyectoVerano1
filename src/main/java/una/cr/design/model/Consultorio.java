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

    @JsonProperty("id_consultorio")
    private int idConsultorio;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("dias")
    private String diasConsulta;
    @JsonProperty("horario")
    private String horarioAtencion;
    @JsonProperty("telefono")
    private String telefono;

    /**
     * Constructor sin parametros
     */
    public Consultorio() {
    }

    public Consultorio(int idConsultorio, String nombre, String diasConsulta, String horarioAtencion, String telefono) {
        this.idConsultorio = idConsultorio;
        this.nombre = nombre;
        this.diasConsulta = diasConsulta;
        this.horarioAtencion = horarioAtencion;
        this.telefono = telefono;
    }

    public Consultorio(String nombre, String diasConsulta, String horarioAtencion, String telefono) {
        this.nombre = nombre;
        this.diasConsulta = diasConsulta;
        this.horarioAtencion = horarioAtencion;
        this.telefono = telefono;
    }

    public int getIdConsultorio() {
        return idConsultorio;
    }

    public void setIdConsultorio(int idConsultorio) {
        this.idConsultorio = idConsultorio;
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
        return "Consultorio{" + "idConsultorio=" + idConsultorio + ", nombre=" + nombre + ", diasConsulta=" + diasConsulta + ", horarioAtencion=" + horarioAtencion + ", telefono=" + telefono + '}';
    }

    
}
