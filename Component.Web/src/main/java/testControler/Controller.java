/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testControler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/helloworld")
public class Controller {
    
    // The Java method will process HTTP GET requests
    @GET
   @Produces("text/json")
    public String getClichedMessage() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        
        Dto dto = new Dto();
        dto.test = "cmnjkjd";
        
        return mapper.writeValueAsString(dto);
    }
}

