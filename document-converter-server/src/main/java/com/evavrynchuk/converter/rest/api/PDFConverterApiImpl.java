package com.evavrynchuk.converter.rest.api;

import com.evavrynchuk.converter.rest.model.MultipartBody;
import com.evavrynchuk.converter.service.PDFService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.core.Response;

@Singleton
public class PDFConverterApiImpl implements PDFConverterApi {

    @Inject
    PDFService pdfService;

    public PDFConverterApiImpl() {
    }

    PDFConverterApiImpl(PDFService pdfService) {
        this.pdfService = pdfService;
    }

    @Override
    public Response toWord(MultipartBody body) {
        return null;
    }

    @Override
    public Response toExcel(MultipartBody body) {
        return null;
    }

    @Override
    public Response toImage(MultipartBody body) {
        return null;
    }
}
