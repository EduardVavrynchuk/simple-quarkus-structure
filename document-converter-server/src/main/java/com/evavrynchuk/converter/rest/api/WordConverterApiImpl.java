package com.evavrynchuk.converter.rest.api;

import com.evavrynchuk.converter.rest.model.MultipartBody;
import com.evavrynchuk.converter.service.WordService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.core.Response;

@Singleton
public class WordConverterApiImpl implements WordConverterApi {

    @Inject
    WordService wordService;

    public WordConverterApiImpl() {
    }

    WordConverterApiImpl(WordService wordService) {
        this.wordService = wordService;
    }

    @Override
    public Response toPDF(MultipartBody body) {
        return null;
    }
}
