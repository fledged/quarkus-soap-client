package org.fluegge;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.fluegge.ws.service.MyService;

import io.quarkiverse.cxf.annotation.CXFClient;

@Path("/client")
public class ServiceResource {
    
    @Inject
    @CXFClient("myService") 
    MyService myService;

    @GET
    @Path("/date")
    @Produces(MediaType.TEXT_PLAIN)
    public String date() {
        return myService.date(); 
    }

    @GET
    @Path("/add")
    @Produces(MediaType.TEXT_PLAIN)
    public int add(@QueryParam("a") int a, @QueryParam("b") int b) {
        return myService.add(a, b); 
    }
}