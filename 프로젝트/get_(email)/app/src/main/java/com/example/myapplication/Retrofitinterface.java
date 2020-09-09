package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Retrofitinterface {
    @GET("api/users/2")
    public Call<User> getUser();
}
