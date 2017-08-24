package com.example.yodgorbekkomilov.photosearch.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yodgorbekkomilov on 8/24/17.
 */

public class ApiClientGenerator {

    public static final String API_BASE_URL = "https://api.flickr.com/services/rest/";

    //private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        //Retrofit retrofit = builder.client(httpClient.build()).build();
        Retrofit retrofit = builder.build();
        return retrofit.create(serviceClass);
    }
}


