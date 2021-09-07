package com.example.android_movieapp.utils;

import com.example.android_movieapp.models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.OPTIONS;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface BraveApi {

//        cors:
//        allowed-origins: "*"
//        allowed-methods: GET, PUT, POST, DELETE, OPTIONS
//        allowed-headers: "*"
//        exposed-headers:
//        allow-credentials: true
//        @Headers({
//                "allowed-origins: \"*\"",
//                "allowed-methods: GET, PUT, POST, DELETE, OPTIONS",
//                "allowed-headers: \"*\"",
//                "exposed-headers: ",
//                "allow-credentials: true",
//                "max-age:1800",
//                "access-control-allow-credentials: true"
//        })
        @GET("user/{user_ID}")
        Call<User> getUser(
                @Path("user_ID") String user_ID
        );

        @Headers("Content-type: application/json")
        @POST("user")
        Call<User> saveUser (
                @Body User user
        );
    }

