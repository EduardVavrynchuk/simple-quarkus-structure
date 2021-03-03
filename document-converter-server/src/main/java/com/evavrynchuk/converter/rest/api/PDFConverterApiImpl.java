package com.evavrynchuk.converter.rest.api;

import com.evavrynchuk.converter.service.PDFService;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PDFConverterApiImpl implements PDFConverterApi {

    @Inject
    PDFService pdfService;

    public PDFConverterApiImpl() {
    }

    PDFConverterApiImpl(PDFService pdfService) {
        this.pdfService = pdfService;
    }

}
