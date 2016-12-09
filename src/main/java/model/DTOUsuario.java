package model;

import com.aw.api.seguridad.IUsuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;

/**
 * Objeto que representa la cuenta de una persona.
 *
 * @author Angelo Wolf angelowolf21@gmail.com
 */
public class DTOUsuario implements Serializable, IUsuario {

    private String token, usuario;
    private transient String clave;
    private Long id;
    private String nombre;
    private String apellido;

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

    @JsonIgnore
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "DTOUsuario{" + "token=" + token + ", usuario=" + usuario + ", clave=" + clave + ", id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + '}';
    }

}
