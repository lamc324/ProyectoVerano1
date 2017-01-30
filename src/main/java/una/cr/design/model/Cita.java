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

    @JsonProperty("idCita")
    private int id_cita;

    @JsonProperty("paciente")
    private Paciente paciente;

    @JsonProperty("consultorio")
    private Consultorio consultorio;

    @JsonProperty("fecha")
    private String fecha;

    @JsonProperty("confirmar")
    private boolean confirmar;

    /**
     * Constructor sin parametro
     */
    public Cita() {
    }

    /**
     *
     * @param id_cita
     * @param paciente
     * @param consultorio
     * @param fecha
     * @param confirmar
     */
    public Cita(int id_cita, Paciente paciente, Consultorio consultorio, String fecha, boolean confirmar) {
        this.id_cita = id_cita;
        this.paciente = paciente;
        this.consultorio = consultorio;
        this.fecha = fecha;
        this.confirmar = confirmar;
    }

    /**
     *
     * @param paciente
     * @param consultorio
     * @param fecha
     * @param confirmar
     */
    public Cita(Paciente paciente, Consultorio consultorio, String fecha, boolean confirmar) {
        this.paciente = paciente;
        this.consultorio = consultorio;
        this.fecha = fecha;
        this.confirmar = confirmar;
    }

    /**
     *
     * @return
     */
    public int getId_cita() {
        return id_cita;
    }

    /**
     *
     * @param id_cita
     */
    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    /**
     *
     * @return
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     *
     * @param paciente
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    /**
     *
     * @return
     */
    public Consultorio getConsultorio() {
        return consultorio;
    }

    /**
     *
     * @param consultorio
     */
    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }

    /**
     *
     * @return
     */
    public String getFecha() {
        return fecha;
    }

    /**
     *
     * @return
     */
    public boolean isConfirmar() {
        return confirmar;
    }

    /**
     *
     * @param confirmar
     */
    public void setConfirmar(boolean confirmar) {
        this.confirmar = confirmar;
    }

    /**
     * Verifica el estado de confirmacion de la cita
     *
     * @return aux
     */
    public String confirmado() {
        String aux;
        if (isConfirmar() == true) {
            aux = "Confirmado";
        } else {
            aux = "No Confirmado";
        }
        return aux;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Cita{" + "id_cita=" + id_cita + ", id_paciente=" + paciente + ", id_consultorio=" + consultorio + ", fecha=" + fecha + ", confirmado=" + confirmar + '}';
    }

}
