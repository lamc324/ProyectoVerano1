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
package una.cr.design.icons;

/**
 *
 * @author Grupo Tango
 */
public class Constants {

    /**
     * Pacientes.json
     */
    public static final String PACIENTES_FILENAME = "Pacientes.json";

    /**
     * Pacientes Table Header
     */
    public static final Object[] PACIENTES_TABLE_HEADER = {"Identificación", "Nombre", "Teléfono", "Dirección", "Fecha de Nacimiento", "Enfermedades", "Observaciones"};

    /**
     * Consultorios.json
     */
    public static final String CONSULTORIOS_FILENAME = "consultorios.json";

    /**
     * Consultorios Table Header
     */
    public static final Object[] CONSULTORIOS_TABLE_HEADER = {"ID", "Centro Médico", "Dias de Atención", "Horario", "Teléfono"};

    /**
     * Citas.json
     */
    public static final String CITAS = "Citas.json";

    /**
     * Citas Table Header
     */
    public static final Object[] CITAS_TABLE_HEADER = {"Id", "Paciente", "Consultorio", "Fecha", "Confirmado"};

    public static final String WS_URL_PACIENTES = "http://localhost:8080/BackEndProyecto/rest/pacientes";

    public static final String WS_URL_CONSULTORIOS = "http://localhost:8080/BackEndProyecto/rest/consultorios";

    public static final String WS_URL_CITAS = "http://localhost:8080/BackEndProyecto/rest/citas";

}
