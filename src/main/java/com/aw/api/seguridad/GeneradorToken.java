package com.aw.api.seguridad;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/**
 *
 * @author Angelo Wolf angelowolf21@gmail.com
 */
public class GeneradorToken {

    private static GeneradorToken instancia;
    private final Random random;

    private GeneradorToken() {
        random = new SecureRandom();
    }

    /**
     * Crea una instancia de GeneradorToken y la devuelve.
     *
     * @return Una instancia unica de esta clase.
     */
    public static GeneradorToken getInstancia() {
        if (instancia == null) {
            instancia = new GeneradorToken();
        }
        return instancia;
    }

    /**
     * Genera una token random.
     *
     * @return La Token.
     */
    public String generarToken() {
        return new BigInteger(130, random).toString(32);
    }

}
