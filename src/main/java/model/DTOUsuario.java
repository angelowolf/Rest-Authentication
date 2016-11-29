package model;

import com.aw.api.seguridad.IUsuario;
import java.io.Serializable;

/**
 * Objeto que representa la cuenta de una persona.
 *
 * @author Angelo Wolf angelowolf21@gmail.com
 */
public class DTOUsuario implements Serializable, IUsuario {

    private String token, usuario, clave;
    private Long id;

    /**
     * Cosntructor
     */
    public DTOUsuario() {
    }

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public void setToken(String token) {
        this.token = token;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

}
