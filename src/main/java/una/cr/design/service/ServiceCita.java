package una.cr.design.service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import una.cr.design.icons.Constants;
import una.cr.design.model.Cita;

/**
 *
 * @author John
 */


public class ServiceCita {
    
      public Object[][] loadCitaObjWrapper() throws JsonGenerationException,
            JsonMappingException, IOException {
        Cita[] cita = cargarCitasDeArchivo();
        Object[][] data = null;

        if (cita != null && cita.length > 0) {
            data = new Object[cita.length][4]; // filas y columnas
            int i = 0;
            for (Cita citas : cita) {
                data[i][0] = checkIfNull(citas.getId());
                data[i][1] = checkIfNull(citas.getConsultorio());
                data[i][2] = checkIfNull(citas.getFecha());
                data[i][3] = checkIfNull(citas.confirmado());
                i++;
            }
        }

        return data;
    }

private Cita[] cargarCitasDeArchivo() throws JsonGenerationException,
            JsonMappingException, IOException {

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
}


