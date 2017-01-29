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
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.io.File;
import java.io.IOException;
import javax.ws.rs.core.MediaType;
import una.cr.design.icons.Constants;
import una.cr.design.model.Cita;

/**
 *
 * @author Grupo Tango
 */
public class CitaService {

    /**
     * Carga el .JSON y envia un wrapper de los objetos
     * @return data
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    public Object[][] loadCitaObjWrapper() throws JsonGenerationException, JsonMappingException, IOException, Exception {
        Cita[] cita = loadJsonFromWebService();
        Object[][] data = null;
        if (cita != null && cita.length > 0) {
            data = new Object[cita.length][5]; // filas y columnas
            int i = 0;
            for (Cita citas : cita) {
                data[i][0] = checkIfNull(citas.getId_cita());
                data[i][1] = checkIfNull(citas.getPaciente().getNombre());
                data[i][2] = checkIfNull(citas.getConsultorio().getNombre());
                data[i][3] = checkIfNull(citas.getFecha());
                data[i][4] = checkIfNull(citas.confirmado());
                i++;
            }
        }
        return data;
    }

    private Cita[] cargarCitasDeArchivo() throws JsonGenerationException, JsonMappingException, IOException {
        Cita[] citas = null;
        ObjectMapper mapper = new ObjectMapper();
        // Ignora los atributos desconocidos que estan en el archivo .JSON
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        citas = mapper.readValue(new File(Constants.CITAS), Cita[].class);
        return citas;
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
    
    private Cita[] loadJsonFromWebService() throws Exception {
        Cita[] cita;
        String jSonFile;
        ObjectMapper mapper = new ObjectMapper();

        Client client = Client.create();

        WebResource webResource = client
                .resource(Constants.WS_URL_CITAS);

        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON_TYPE)
                .get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        jSonFile = response.getEntity(String.class);

        // Fix en linea 119
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        cita = mapper.readValue(jSonFile, Cita[].class);

        return cita;
    }
    
    
    
}