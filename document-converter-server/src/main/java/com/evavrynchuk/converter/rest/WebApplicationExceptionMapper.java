package com.evavrynchuk.converter.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class WebApplicationExceptionMapper implements ExceptionMapper<WebApplicationException> {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebApplicationExceptionMapper.class);

    @Override
    public Response toResponse(WebApplicationException exception) {

        int status = exception.getResponse().getStatus();
        String message = exception.getMessage();

        LOGGER.info("status=" + status + "; message=" + message);
        LOGGER.debug("Uncaught exception", exception);

        return Response
                .status(status)
                .type(MediaType.TEXT_PLAIN_TYPE)
                .entity(message)
                .build();
    }
}
