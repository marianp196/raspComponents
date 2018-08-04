/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GPIOController;

/**
 *
 * @author marian
 */
import applicationBuilder.ApllicationBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import component.IComponent;
import component.PinState;
import java.io.IOException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import services.IComponentProvider;

@Path("/GPIO/{id}")
public class GPIOController {
    @POST
    @Consumes("application/json")
    public Response post(@PathParam("id") String id, String body) throws IOException, Exception{
        ObjectMapper mapper = new ObjectMapper();
        
        PinState pinState = mapper.readValue(body, PinState.class);
        
        IComponentProvider provider = new ApllicationBuilder().Build();
        IComponent comp = provider.<PinState, PinState>Get("gpio", id);
        
        return Response.ok(mapper.writeValueAsString(comp.Excute(pinState)), MediaType.APPLICATION_JSON).build();
    }
    
}


