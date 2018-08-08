/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author marian
 */
import applicationBuilder.ApllicationBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import component.IComponent;
import component.IReadableComponent;
import component.PinState;
import java.io.IOException;
import java.security.KeyException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import services.IComponentProvider;
import component.IWriteableComponent;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

@Path("/gpio/{id}")
public class GPIOController {
    @POST
    @Consumes("application/json")
    public Response Write(@PathParam("id") String id, String body) throws IOException, Exception{
        ObjectMapper mapper = new ObjectMapper();
        
        PinState pinState = mapper.readValue(body, PinState.class);
        
        IComponentProvider provider = new ApllicationBuilder().Build();
        
        try{
            IWriteableComponent<PinState, PinState> comp = 
                provider.<PinState, PinState>GetExecuteable(id, "gpio"); 
            
            return Response.ok(mapper.writeValueAsString(comp.Write(pinState)), 
                    MediaType.APPLICATION_JSON).build();
        
        }catch(KeyException exception){
            return Response.status(404).build();
        } 
    }
    
    @GET
    @Produces("application/json")
    public Response Read(@PathParam("id") String id) throws Exception{
       
        ObjectMapper mapper = new ObjectMapper(); 
        
        IComponentProvider provider = new ApllicationBuilder().Build();   
       
        try{
            IReadableComponent<PinState> comp = 
                provider.<PinState>GetReadable(id, "gpio");
            
            return Response.ok(mapper.writeValueAsString(comp.Read()), 
                    MediaType.APPLICATION_JSON).build();
           // return Response.ok(mapper.writeValueAsString(new PinState()),MediaType.APPLICATION_JSON).build();
        }
        catch(KeyException exception){
            return Response.status(404).build();
        } 
               
    }
    
    
    
}


