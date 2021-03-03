package com.evavrynchuk.converter.rest.api;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.Path;

@Path("/doc")
@Tag(name = "Word Converter API")
public interface WordConverterApi {

    //TODO pdf -> word
    //TODO excel -> word
    //TODO image -> word

}
