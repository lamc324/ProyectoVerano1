package una.cr.design.patterns;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.text.ParseException;
import una.cr.design.patterns.view.MenuView;

public class Application {

    /**
     *
     * @param args
     */
    public static void main(String[] args) throws JsonGenerationException,
            JsonMappingException, IOException, ParseException{
        MenuView p = new MenuView(); 


    }
}
