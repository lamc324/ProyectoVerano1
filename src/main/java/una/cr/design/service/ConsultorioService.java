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
import una.cr.design.model.Consultorio;
import una.cr.design.icons.Constants;

/**
 *
 * @author Grupo Tango
 */
public class ConsultorioService {

    /**
     * Carga el .JSON y envia un wrapper de los objetos
     *
     * @return data
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    public Object[][] loadConsultorioObjWrapper() throws JsonGenerationException,
            JsonMappingException, IOException, Exception {

//        Consultorio[] consultorio = cargarConsultoriosDeArchivo();
        Consultorio[] consultorio = loadJsonFromWebService();

        Object[][] data = null;

        if (consultorio != null && consultorio.length > 0) {
            data = new Object[consultorio.length][5]; // filas y columnas
            int i = 0;
            for (Consultorio consultorios : consultorio) {
                data[i][0] = checkIfNull(consultorios.getIdConsultorio());
                data[i][1] = checkIfNull(consultorios.getNombre());
                data[i][2] = checkIfNull(consultorios.getDiasConsulta());
                data[i][3] = checkIfNull(consultorios.getHorarioAtencion());
                data[i][4] = checkIfNull(consultorios.getTelefono());
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

    private Consultorio[] loadJsonFromWebService() throws Exception {
        Consultorio[] consultorio;
        String jSonFile;
        ObjectMapper mapper = new ObjectMapper();

        Client client = Client.create();

        WebResource webResource = client
                .resource(Constants.WS_URL_CONSULTORIOS);

        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON_TYPE)
                .get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        jSonFile = response.getEntity(String.class);

        // Fix en linea 119
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        consultorio = mapper.readValue(jSonFile, Consultorio[].class);

        return consultorio;
    }

    /**
     * Create student
     *
     * @param paciente
     * @return
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    public boolean createConsultorio(Consultorio consultorio) throws JsonGenerationException,
            JsonMappingException, IOException {

        boolean isCreated = true;
        ObjectMapper mapper = new ObjectMapper();

        Client client = Client.create();

        WebResource webResource = client
                .resource(Constants.WS_URL_CONSULTORIOS);

        String jsonInString = mapper.writeValueAsString(consultorio);

        //POST del JSON
        ClientResponse response = webResource.type(MediaType.APPLICATION_JSON_TYPE)
                .post(ClientResponse.class, jsonInString);

        if (response.getStatus() != 200) {
            isCreated = false;
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        return isCreated;
    }

    public boolean deleteConsultorio(int id) {
        boolean isDeleted = false;

        Client client = Client.create();

        WebResource webResource = client
                .resource(Constants.WS_URL_CONSULTORIOS.concat("/").concat(String.valueOf(id)));

        //POST del JSON
        ClientResponse response = webResource.delete(ClientResponse.class);

        if (response.getStatus() != 200) {
            isDeleted = false;
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        return isDeleted;
    }

    public Consultorio getConsultorio(int id) throws Exception {
        Consultorio[] p = loadJsonFromWebService();
        Consultorio nuevo = new Consultorio();
        for (Consultorio consultorio : p) {
            if (consultorio.getIdConsultorio() == id) {
                nuevo = consultorio;
            }
        }
        return nuevo;
    }

    public Consultorio getConsultorioNombre(String nombre) throws Exception {
        Consultorio[] p = loadJsonFromWebService();
        Consultorio nuevo = new Consultorio();
        for (Consultorio consultorio : p) {
            if (consultorio.getNombre().equals(nombre)) {
                nuevo = consultorio;
            }
        }
        return nuevo;
    }
}
