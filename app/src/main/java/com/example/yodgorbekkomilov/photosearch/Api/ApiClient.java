package com.example.yodgorbekkomilov.photosearch.Api;

import android.provider.Contacts;

import com.example.yodgorbekkomilov.photosearch.Model.Photos;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by yodgorbekkomilov on 8/24/17.
 */

public interface ApiClient {
    @GET("?method=flickr.photos.search&\n" +
            " api_key=51f4537c67655a4b1593215e066b5631&format=json&nojsoncallback=1")
    Call<Photos> getPhotos(
            @Query("page") String page,
            @Query("text") String text
    );
}
