package pl.aui.DateAndTime.rest;


import pl.aui.DateAndTime.rest.model.DateResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public interface DateResource {

    @GET
    @Path("/date")
    @Produces(MediaType.APPLICATION_JSON)
    DateResponse getDate();

}
