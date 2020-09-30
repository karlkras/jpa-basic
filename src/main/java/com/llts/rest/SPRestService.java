package com.llts.rest;

import com.llts.ejb.SPServiceBean;
import com.llts.model.SimpleProperty;

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
@Path("sp/action")
@RequestScoped
public class SPRestService {

    @Inject
    private SPServiceBean ejb;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SimpleProperty> listAllMembers() {
        return ejb.findAll();
    }

    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public SimpleProperty findById(@PathParam("id") int id) {

        SimpleProperty p = ejb.findById(id);
        if (p == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return p;
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteMember(SimpleProperty member) {
        Response.ResponseBuilder builder;
        SimpleProperty p = findById(member.getKey());

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
    public Response createMember(SimpleProperty member) {

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