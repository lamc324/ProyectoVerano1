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
package una.cr.design.service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import una.cr.design.model.Consultorio;
import una.cr.design.icons.Constants;

/**
 *
 * @author Grupo Tango
 */
public class ConsultorioService {

    /**
     * Carga el .JSON y envia un wrapper de los objetos
     * @return data
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    public Object[][] loadConsultorioObjWrapper() throws JsonGenerationException,
            JsonMappingException, IOException {
        Consultorio[] consultorio = cargarConsultoriosDeArchivo();
        Object[][] data = null;

        if (consultorio != null && consultorio.length > 0) {
            data = new Object[consultorio.length][4]; // filas y columnas
            int i = 0;
            for (Consultorio consultorios : consultorio) {
                data[i][0] = checkIfNull(consultorios.getNombre());
                data[i][1] = checkIfNull(consultorios.getDiasConsulta());
                data[i][2] = checkIfNull(consultorios.getHorarioAtencion());
                data[i][3] = checkIfNull(consultorios.getTelefono());
                i++;
            }
        }
        return data;
    }

    private Consultorio[] cargarConsultoriosDeArchivo() throws JsonGenerationException, JsonMappingException, IOException {
        Consultorio[] consultorios = null;
        ObjectMapper mapper = new ObjectMapper();
        // Ignora los atributos desconocidos que estan en el archivo .JSON
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        consultorios = mapper.readValue(new File(Constants.CONSULTORIOS_FILENAME), Consultorio[].class);
        return consultorios;
    }

    private String checkIfNull(Object obj) {
        String text;
        if (obj == null) {
            text = "";
        } else {
            text = obj.toString();
        }
        return text;
    }
}
