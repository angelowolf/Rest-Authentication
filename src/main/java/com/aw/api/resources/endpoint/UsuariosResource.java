/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aw.api.resources.endpoint;

import com.aw.api.resources.filters.Secured;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import model.DTOUsuario;

/**
 *
 * @author angelo
 */
@Path("usuario")
public class UsuariosResource {

    @Context
    SecurityContext securityContext;

    @GET
    @Path("getTodos")
    @Secured
    @Produces(MediaType.APPLICATION_JSON)
    public List<DTOUsuario> getTodosUsuarios() {
//        Principal p = securityContext.getUserPrincipal();
//        System.out.println("Token del usuario que realiza el request: " + p.getName());
        List<DTOUsuario> lista = new ArrayList<>();
        DTOUsuario u = new DTOUsuario();
        u.setId(1L);
        u.setApellido("wolf");
        u.setNombre("angelo");
        u.setUsuario("annaldar");
        lista.add(u);
        u = new DTOUsuario();
        u.setId(3L);
        u.setApellido("peretti");
        u.setNombre("florencia");
        u.setUsuario("florence");
        lista.add(u);
        return lista;
    }

}
