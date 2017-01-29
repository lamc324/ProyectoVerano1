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

/**
 *
 * @author Grupo Tango
 */
public class Cita {

    @JsonProperty("id_cita")
    private String id_cita;
    
    @JsonProperty("id_paciente")
    private String id_paciente;

    @JsonProperty("id_consultorio")
    private String id_consultorio;

    @JsonProperty("fecha")
    private String fecha;

    @JsonProperty("confirmado")
    private boolean confirmado;

    /**
     * Constructor sin parametro
     */
    public Cita() {
    }

    public Cita(String id_cita, String id_paciente, String id_consultorio, String fecha, boolean confirmar) {
        this.id_cita = id_cita;
        this.id_paciente = id_paciente;
        this.id_consultorio = id_consultorio;
        this.fecha = fecha;
        this.confirmado = confirmar;
    }

    public String getIdCita() {
        return id_cita;
    }

    public void setIdCita(String id_cita) {
        this.id_cita = id_cita;
    }

    public String getIdPaciente() {
        return id_paciente;
    }

    public void setIdPaciente(String id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getIdConsultorio() {
        return id_consultorio;
    }

    public void setIdConsultorio(String id_consultorio) {
        this.id_consultorio = id_consultorio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmar) {
        this.confirmado = confirmar;
    }

    /**
     * Verifica el estado de confirmacion de la cita
     * @return aux
     */
    public String confirmado() {
        String aux;
        if (isConfirmado() == true) {
            aux = "Confirmado";
        } else {
            aux = "No Confirmado";
        }

        return aux;
    }

    @Override
    public String toString() {
        return "Cita{" + "id_cita=" + id_cita + ", id_paciente=" + id_paciente + ", id_consultorio=" + id_consultorio + ", fecha=" + fecha + ", confirmado=" + confirmado + '}';
    }



}
