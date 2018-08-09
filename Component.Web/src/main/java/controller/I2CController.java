/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import I2CBus.DeviceNotFoundException;
import I2CBus.IBusI2C;
import com.fasterxml.jackson.databind.ObjectMapper;
import factory.BusI2CFactory;
import java.io.IOException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author marian
 */
@Path("/i2c/device/{device}/register/{register}")
public class I2CController {
    @POST
    @Consumes("application/json")
    public Response Write(@PathParam("device") int device, @PathParam("register") int register, String body) throws IOException, Exception{
        ObjectMapper mapper = new ObjectMapper(); 
       
        I2CDto dto;
        try{
            dto = mapper.readValue(body, I2CDto.class);
        }catch(Exception e){
            return Response.status(Status.UNSUPPORTED_MEDIA_TYPE).build();
        }
        
        
        IBusI2C bus = createBus();
        
        try{
           bus.Write(device, register, dto.value); 
        }catch(DeviceNotFoundException e){
            return Response.status(Status.NOT_FOUND).build();
        }        
        
        return Response.ok().build();
    }
    
    @GET
    @Produces("application/json")
    public Response Read(@PathParam("device") int device, @PathParam("register") int register) throws Exception{       
        ObjectMapper mapper = new ObjectMapper(); 
        
        IBusI2C bus =  createBus();
        byte value;
        
        try{
            value = bus.Read(device, register);
        }catch(DeviceNotFoundException e){
            return Response.status(Status.NOT_FOUND).build();
        }
                
        I2CDto dto = new I2CDto();
        dto.value = value;
        
        return Response.ok(mapper.writeValueAsString(dto), 
                MediaType.APPLICATION_JSON).build();
    }
    
    private IBusI2C createBus() throws Exception{               
        return new BusI2CFactory().Create();
    }
   
}
