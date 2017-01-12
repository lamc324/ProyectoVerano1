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
 * John Herrera Jimenez, Kevin Venegas, Caleb Villalta, Josue David Matamorros.
 */
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
