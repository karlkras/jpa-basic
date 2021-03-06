package com.llts.rest;

import com.llts.ejb.ClientcompanyServiceBean;
import com.llts.model.Clientcompany;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JAX-RS Example
 * <p/>
 * This class produces a RESTful service to read/write the contents of the members table.
 */
@Path("cc/action")
@RequestScoped
public class ClientcompanyRestService {

    @Inject
    private ClientcompanyServiceBean ejb;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Clientcompany> listAllMembers() {
        return ejb.findAll();
    }

    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Clientcompany findById(@PathParam("id") int id) {

        Clientcompany p = ejb.findById(id);
        if (p == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return p;
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteMember(Clientcompany member) {
        Response.ResponseBuilder builder;
        Clientcompany p = findById(member.getKey());

        try {
            ejb.delete(p);
            // Create an "ok" response
            builder = Response.ok("Deleted!");

        } catch (Exception e) {
            // Handle generic exceptions
            Map<String, String> responseObj = new HashMap<>();
            responseObj.put("error", e.getMessage());
            builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
        }

        return builder.build();
    }



    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createMember(Clientcompany member) {

        Response.ResponseBuilder builder;

        try {

            ejb.put(member);
            // Create an "ok" response
            builder = Response.ok("Saved!");

        } catch (Exception e) {
            // Handle generic exceptions
            Map<String, String> responseObj = new HashMap<>();
            responseObj.put("error", e.getMessage());
            builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
        }

        return builder.build();
    }
}