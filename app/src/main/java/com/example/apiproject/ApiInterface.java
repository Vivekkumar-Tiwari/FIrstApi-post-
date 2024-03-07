package com.example.apiproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
@GET("posts")
    Call<List<post_pojo>> getpost();
}
