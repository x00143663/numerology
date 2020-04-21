package com.example.numerology;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NumerologyApi {
    @GET("all")
    Call<List<Post>> getPosts();
}
