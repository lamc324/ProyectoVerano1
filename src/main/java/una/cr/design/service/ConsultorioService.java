
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
 * @author John
 */


public class ConsultorioService {
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

private Consultorio[] cargarConsultoriosDeArchivo() throws JsonGenerationException,
            JsonMappingException, IOException {

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
