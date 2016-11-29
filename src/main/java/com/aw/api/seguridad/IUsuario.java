package com.aw.api.seguridad;

/**
 *
 * @author Angelo Wolf angelowolf21@gmail.com
 */
public interface IUsuario {

    /**
     * Retorna el ID del usuario.
     *
     * @return
     */
    public Long getId();

    /**
     * Setea el ID del usuario.
     *
     * @param id
     */
    public void setId(Long id);

    public String getToken();

    public void setToken(String token);
}
