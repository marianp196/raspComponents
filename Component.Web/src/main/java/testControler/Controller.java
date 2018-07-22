/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testControler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/helloworld/{id}")
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
    
    @POST
    @Consumes("application/json")
    public Response post(@PathParam("id") String id, String body) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        
        Dto dto = mapper.readValue(body, Dto.class);
        dto.test = id;
        
        return Response.ok(mapper.writeValueAsString(dto), MediaType.APPLICATION_JSON).build();
    }
    
}

