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
    private int id_consultorio;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("dias")
    private String dias;
    @JsonProperty("horario")
    private String horario;
    @JsonProperty("telefono")
    private String telefono;

    /**
     * Constructor sin parametros
     */
    public Consultorio() {
    }

    public Consultorio(int idConsultorio, String nombre, String diasConsulta, String horarioAtencion, String telefono) {
        this.id_consultorio = idConsultorio;
        this.nombre = nombre;
        this.dias = diasConsulta;
        this.horario = horarioAtencion;
        this.telefono = telefono;
    }

    public Consultorio(String nombre, String diasConsulta, String horarioAtencion, String telefono) {
        this.nombre = nombre;
        this.dias = diasConsulta;
        this.horario = horarioAtencion;
        this.telefono = telefono;
    }

    public int getIdConsultorio() {
        return id_consultorio;
    }

    public void setIdConsultorio(int idConsultorio) {
        this.id_consultorio = idConsultorio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDiasConsulta() {
        return dias;
    }

    public void setDiasConsulta(String diasConsulta) {
        this.dias = diasConsulta;
    }

    public String getHorarioAtencion() {
        return horario;
    }

    public void setHorarioAtencion(String horarioAtencion) {
        this.horario = horarioAtencion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Consultorio{" + "id_consultorio=" + id_consultorio + ", nombre=" + nombre + ", dias=" + dias + ", horario=" + horario + ", telefono=" + telefono + '}';
    }

    
    
}
