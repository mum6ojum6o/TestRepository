package com.retrofit_example.anddevolver.geniusplaza.Networking;

import com.retrofit_example.anddevolver.geniusplaza.Model.APIResponse;
import com.retrofit_example.anddevolver.geniusplaza.Model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserWebService {
    @GET("users")
    Call<APIResponse> getAllUsers();
    @GET("users")
    Call<APIResponse> getAllUsersInPage(@Query("page")int page);
    @POST("users")
    Call<User> createUser(@Body User newUser);
}
