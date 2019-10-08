package com.google.external.assignment.movie.manager;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Converter;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class BaseManager {

    protected abstract  String getBaseAPIUrl();

    protected abstract  String getBaseAPIKey();

    protected abstract Map<Object, Object> getQueryParams();

    protected Converter.Factory getConverterFactory(){
        return GsonConverterFactory.create();
    }
}
