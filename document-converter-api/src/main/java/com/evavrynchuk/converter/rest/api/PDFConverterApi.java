package com.evavrynchuk.converter.rest.api;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.Path;

@Path("/pdf")
@Tag(name = "PDF Converter API")
public interface PDFConverterApi {

    //TODO word -> pdf
    //TODO excel -> pdf
    //TODO image -> pdf

}
