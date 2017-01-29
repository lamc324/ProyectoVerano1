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
    private int id_cita;
    
    @JsonProperty("id_paciente")
    private int id_paciente;

    @JsonProperty("id_consultorio")
    private int id_consultorio;

    @JsonProperty("fecha")
    private String fecha;

    @JsonProperty("confirmado")
    private boolean confirmado;

    /**
     * Constructor sin parametro
     */
    public Cita() {
    }

    public Cita(int id_cita, int id_paciente, int id_consultorio, String fecha, boolean confirmar) {
        this.id_cita = id_cita;
        this.id_paciente = id_paciente;
        this.id_consultorio = id_consultorio;
        this.fecha = fecha;
        this.confirmado = confirmar;
    }

    public int getId_cita() {
        return id_cita;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public int getId_consultorio() {
        return id_consultorio;
    }

    public void setId_consultorio(int id_consultorio) {
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

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
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
