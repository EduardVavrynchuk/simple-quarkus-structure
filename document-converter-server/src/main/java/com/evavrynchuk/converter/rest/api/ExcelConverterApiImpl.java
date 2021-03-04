package com.evavrynchuk.converter.rest.api;

import com.evavrynchuk.converter.rest.model.MultipartBody;
import com.evavrynchuk.converter.service.ExcelService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.core.Response;

@Singleton
public class ExcelConverterApiImpl implements ExcelConverterApi {

    @Inject
    ExcelService excelService;

    public ExcelConverterApiImpl() {
    }

    ExcelConverterApiImpl(ExcelService excelService) {
        this.excelService = excelService;
    }

    @Override
    public Response toWord(MultipartBody body) {
        return null;
    }

    @Override
    public Response toPDF(MultipartBody body) {
        return null;
    }
}
