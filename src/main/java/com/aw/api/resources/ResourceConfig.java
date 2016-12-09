/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aw.api.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

/**
 *
 * @author angelo
 */
public class ResourceConfig extends org.glassfish.jersey.server.ResourceConfig {

    public ResourceConfig() {
        super();
        registerJacksonProvider();
        packages("com.rest");
    }

    /**
     * Custom provider to handle JSON and XML request
     */
    private void registerJacksonProvider() {
        ObjectMapper mapper = new ObjectMapper();

        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider();

        provider.setMapper(mapper);

        register(provider);
    }

}
