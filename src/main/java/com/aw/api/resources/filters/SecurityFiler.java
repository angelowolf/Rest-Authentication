/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aw.api.resources.filters;

import com.aw.api.seguridad.ContenedorSesiones;
import com.aw.api.seguridad.IUsuario;
import java.io.IOException;
import java.security.Principal;
import javax.annotation.Priority;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author ang_2
 */
@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class SecurityFiler implements ContainerRequestFilter {

//    //AUTENTIFICACION BASICA
//    private static final String AUTHORIZATION_HEADER = "Authorization";
//    private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
//
//    private String usuario, clave;
//
//    @Override
//    /**
//     * Para este caso se deve de colocar en el Header:
//     *
//     * Authorization : Basic "VALOR DEL TOKEN"
//     *
//     */
//    public void filter(ContainerRequestContext requestContext) throws IOException {
//        List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER);
//        if (authHeader != null && authHeader.size() > 0) {
//            String authToken = authHeader.get(0);
//            authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
//            String decodeString = Base64.decodeAsString(authToken);
//            StringTokenizer tokenizer = new StringTokenizer(decodeString, ":");
//            usuario = tokenizer.nextToken();
//            clave = tokenizer.nextToken();
//
//            if (usuario.equals("admin") && clave.equals("admin")) {
//                requestContext.setSecurityContext(new SecurityContext() {
//                    @Override
//                    public Principal getUserPrincipal() {
//                        return new Principal() {
//
//                            @Override
//                            public String getName() {
//                                return usuario;
//                            }
//                        };
//                    }
//
//                    @Override
//                    public boolean isUserInRole(String role) {
//                        return true;
//                    }
//
//                    @Override
//                    public boolean isSecure() {
//                        return false;
//                    }
//
//                    @Override
//                    public String getAuthenticationScheme() {
//                        return null;
//                    }
//                });
//                return;
//            }
//        }
//        Response noAutorizado = Response.status(Response.Status.UNAUTHORIZED).entity("NO PODES INGRESAR, LOGEA").build();
//        requestContext.abortWith(noAutorizado);
//    }
    //AUTENTIFICACION CON TOKEN    
    private static final String AUTHORIZATION_HEADER_PREFIX = "Bearer ";
    private IUsuario usuario;

    @Override
    /**
     * Para este caso se deve de colocar en el Header:
     *
     * Authorization : Bearer "VALOR DEL TOKEN"
     *
     */
    public void filter(ContainerRequestContext requestContext) throws IOException {
        try {
            String authHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
            if (authHeader == null || !authHeader.startsWith(AUTHORIZATION_HEADER_PREFIX)) {
                throw new NotAuthorizedException("Falta la token en el Header.");
            }
            String authToken = authHeader.substring(AUTHORIZATION_HEADER_PREFIX.length()).trim();
            usuario = ContenedorSesiones.getInstancia().getUsuario(authToken);
            requestContext.setSecurityContext(new SecurityContext() {
                @Override
                public Principal getUserPrincipal() {
                    return new Principal() {

                        @Override
                        public String getName() {
                            return usuario.getToken();
                        }
                    };
                }

                @Override
                public boolean isUserInRole(String role) {
                    return true;
                }

                @Override
                public boolean isSecure() {
                    return false;
                }

                @Override
                public String getAuthenticationScheme() {
                    return null;
                }
            });
        } catch (Exception ex) {
            System.out.println(ex.toString());
            Response noAutorizado = Response.status(Response.Status.UNAUTHORIZED).build();
            requestContext.abortWith(noAutorizado);
        }
    }

}
