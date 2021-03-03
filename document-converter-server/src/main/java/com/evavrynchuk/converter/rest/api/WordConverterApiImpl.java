package com.evavrynchuk.converter.rest.api;

import com.evavrynchuk.converter.service.WordService;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class WordConverterApiImpl implements WordConverterApi {

    @Inject
    WordService wordService;

    public WordConverterApiImpl() {
    }

    WordConverterApiImpl(WordService wordService) {
        this.wordService = wordService;
    }
}
