package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface Retrofitinterface {
    @GET("api/users/2")
    public Call<User> getUser();

    @FormUrlEncoded
    @POST("api/users")
    Call<Createresponse> createUser(@Field ("name")String name, @Field("job")String job);

    @FormUrlEncoded
    @PUT("api/users/522")
    Call<Createresponse> updateUser(@Field("name")String name, @Field("job")String job);

    @DELETE ("api/users/522")
    Call<Void> deleteUser();
}
