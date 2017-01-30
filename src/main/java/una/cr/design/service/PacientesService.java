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
import una.cr.design.model.Paciente;

/**
 *
 * @author venegas97k
 */
public class PacientesService {

    /**
     * Constructor sin parametros.
     *
     */
    public PacientesService() {
    }

    /**
     * Carga el .JSON y envia un wrapper de los objetos
     * @return data
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    public Object[][] cargarPersonasObjWrapper() throws JsonGenerationException, 
            JsonMappingException, IOException, Exception {
        
        //Paciente[] pacientes = cargarPacientesDeArchivo();
        Paciente[] pacientes = loadJsonFromWebService();
        
        Object[][] data = null;
        if (pacientes != null && pacientes.length > 0) {
            data = new Object[pacientes.length][7]; // Filas y Columnas
            int i = 0;
            for (Paciente paciente : pacientes) {
                data[i][0] = checkIfNull(paciente.getIdPaciente());
                data[i][1] = checkIfNull(paciente.getNombre());
                data[i][2] = checkIfNull(paciente.getTelefono());
                data[i][3] = checkIfNull(paciente.getDireccion());
                data[i][4] = checkIfNull(paciente.getFechaNacimiento());
                data[i][5] = checkIfNull(paciente.getEnfermedades());
                data[i][6] = checkIfNull(paciente.getObservaciones());
                i++;
            }
        }
        return data;
    }

    private Paciente[] cargarPacientesDeArchivo() throws JsonGenerationException, JsonMappingException, IOException {
        Paciente[] pacientes = null;
        ObjectMapper mapper = new ObjectMapper();
        // Ignora los atributos desconocidos que estan en el archivo .JSON
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        pacientes = mapper.readValue(new File(Constants.PACIENTES_FILENAME), Paciente[].class);
        return pacientes;
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
    
    private Paciente[] loadJsonFromWebService() throws Exception {
        Paciente[] paciente;
        String jSonFile;
        ObjectMapper mapper = new ObjectMapper();

        Client client = Client.create();

        WebResource webResource = client
                .resource(Constants.WS_URL_PACIENTES);

        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON_TYPE)
                .get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        jSonFile = response.getEntity(String.class);

        // Fix en linea 119
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        paciente = mapper.readValue(jSonFile, Paciente[].class);

        return paciente;
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
    public boolean createPaciente(Paciente paciente) throws JsonGenerationException,
            JsonMappingException, IOException {

        boolean isCreated = true;
        ObjectMapper mapper = new ObjectMapper();

        Client client = Client.create();

        WebResource webResource = client
                .resource(Constants.WS_URL_PACIENTES);

        String jsonInString = mapper.writeValueAsString(paciente);

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

    public boolean deletePaciente(int id) {
        boolean isDeleted = false;

        Client client = Client.create();

        WebResource webResource = client
                .resource(Constants.WS_URL_PACIENTES.concat("/").concat(String.valueOf(id)));

        //POST del JSON
        ClientResponse response = webResource.delete(ClientResponse.class);

        if (response.getStatus() != 200) {
            isDeleted = false;
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        return isDeleted;
    }
    
    public Paciente getPaciente(int id) throws Exception {
        Paciente[] p = loadJsonFromWebService();
        Paciente nuevo = new Paciente();
        for(Paciente paciente : p){
            if(paciente.getIdPaciente() == id){
                nuevo = paciente;
            }
        }
        return nuevo;
    }
    
//    public Paciente getListaPacientes(int row) throws Exception {
//        Paciente[] p = loadJsonFromWebService();
//        List<Paciente> pList = Arrays.asList(p);
//        return pList.get(row);
//    }
}
