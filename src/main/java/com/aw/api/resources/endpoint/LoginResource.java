/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aw.api.resources.endpoint;

import com.aw.api.seguridad.ContenedorSesiones;
import com.aw.api.seguridad.Credenciales;
import com.aw.api.seguridad.GeneradorToken;
import com.aw.api.seguridad.IUsuario;
import javax.naming.AuthenticationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.DTOUsuario;
import model.Token;

/**
 *
 * @author Angelo Wolf angelowolf21@gmail.com
 */
@Path("autorizar")
public class LoginResource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("login")
    /**
     * Este metodo se encarga de validar las credenciales, y en el caso que sean
     * correctas devolvera una token, la cual es necesaria para poder utilizar
     * la API. Se debe de enviar las credenciales en el body del request de la
     * siguiente forma: { "usuario": ejemplo, "clave": ejemplo }. A su vez el
     * Content-Type debe estar en application/json.
     *
     * @param credenciales
     * @return Token para utilizar la API.
     */
    public Response login(Credenciales credenciales) {
        try {
            IUsuario usuario = autentificar(credenciales.getUsuario(), credenciales.getClave());
            String token = GeneradorToken.getInstancia().generarToken();
            usuario.setToken(token);
            ContenedorSesiones.getInstancia().agregarUsuario(usuario);
            return Response.ok(new Token(token)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    /**
     * Verifica si las credenciales del usuario son correctas.
     *
     * @param usuario Nombre de usuario
     * @param clave Contraseña
     * @throws Exception Si las credenciales no son correctas.
     */
    private IUsuario autentificar(String usuario, String clave) throws Exception {
        if (!usuario.equals("admin") || !clave.equals("admin")) {
            throw new AuthenticationException();
        }
        IUsuario u = new DTOUsuario();
        u.setId(1L);
        return u;
    }

}
