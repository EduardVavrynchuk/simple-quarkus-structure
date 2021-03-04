package com.evavrynchuk.converter.rest.api;

import com.evavrynchuk.converter.rest.model.MultipartBody;
import com.evavrynchuk.converter.service.ExcelService;
import com.evavrynchuk.converter.util.ExtensionValidator;

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
        ExtensionValidator.validateExcelDocuments(body.file);

        return null;
    }

    @Override
    public Response toPDF(MultipartBody body) {
        ExtensionValidator.validateExcelDocuments(body.file);

        return null;
    }
}
