package com.aw.api.seguridad;

import java.io.Serializable;

/**
 *
 * @author ang_2
 */
public class Credenciales implements Serializable {

    private String usuario;
    private String clave;

    public Credenciales() {
    }

    public Credenciales(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
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

}
