package com.llts.rest;



import com.llts.ejb.ServiceBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.llts.model.Sponsor;

/**
 * JAX-RS Example
 * <p/>
 * This class produces a RESTful service to read/write the contents of the members table.
 */
@Path("/action")
@RequestScoped
public class RestService {

    @Inject
    private ServiceBean ejb;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sponsor> listAllMembers() {
        return ejb.findAll();
    }

    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Sponsor findById(@PathParam("id") int id) {

        Sponsor p = ejb.findById(id);
        if (p == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return p;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createMember(Sponsor member) {

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