package com.aw.api.seguridad;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Angelo Wolf angelowolf21@gmail.com
 */
public class ContenedorSesiones {

    private static ContenedorSesiones instancia;
    private HashMap<String, IUsuario> sesiones;

    private ContenedorSesiones() {
        sesiones = new HashMap<>();
    }

    /**
     * Crea una instancia de ContenedorSesiones y la devuelve.
     *
     * @return Una instancia unica de esta clase.
     */
    public static ContenedorSesiones getInstancia() {
        if (instancia == null) {
            instancia = new ContenedorSesiones();
        }
        return instancia;
    }

    /**
     * Agrega este usuario a un hashmap de usuarios, con su token como clave. Y
     * actualiza el token del usuario en la BD.
     *
     * @param usuario Usuario a agregar.
     */
    public void agregarUsuario(IUsuario usuario) {
        sesiones.put(usuario.getToken(), usuario);
        //llamda a la BD.
    }

    /**
     * Busca un usuario por su token. Primero en el contenedor, luego en la BD,
     * si no lo encuentra en ninguno de los dos casos se lanzara un error.
     *
     * @param token Token del usuario deseado.
     * @return El usuario solicitado.
     * @throws Exception Si no existe un token para algun usuario.
     */
    public IUsuario getUsuario(String token) throws Exception {
        IUsuario usuario = sesiones.get(token);
        if (usuario == null) {
//            usuario = buscarUsuarioEnBD();
//            if (usuario == null) {
//                throw new Exception();
//            }
            throw new Exception("No se encontro ningun token que concida.");
        }
        return usuario;
    }
    
    public void impirmir() {
        for (Map.Entry<String, IUsuario> entry : sesiones.entrySet()) {
            String key = entry.getKey();
            IUsuario value = entry.getValue();
            System.out.println("key " + key);
            System.out.println("value " + value.toString());
        }
}
}
