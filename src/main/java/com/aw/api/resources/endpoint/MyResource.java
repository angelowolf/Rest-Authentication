package com.aw.api.resources.endpoint;

import com.aw.api.resources.filters.Secured;
import java.security.Principal;
import model.Auto;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("ejemplo")
public class MyResource {

    @Context
    SecurityContext securityContext;

    @GET
    @Path("publico")
    @Produces(MediaType.APPLICATION_JSON)
    public Auto publico() {
        Principal p = securityContext.getUserPrincipal();
        if (p != null) {
            //nunca va a entrar, ya que al no se @Secure no se puede obtener
            //quien es la persona que realiza el request.
            System.out.println("Token del usuario que realiza el request: " + p.getName());
        }
        return new Auto("Ford");
    }

    @GET
    @Path("privado")
    @Secured
    @Produces(MediaType.APPLICATION_JSON)
    public Auto privado() {
        Principal p = securityContext.getUserPrincipal();
        System.out.println("Token del usuario que realiza el request: " + p.getName());
        return new Auto("Ferrari");
    }
}
