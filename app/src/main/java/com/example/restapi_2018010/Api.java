package com.example.restapi_2018010;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("posts")
    Call<List<GetData>> getPost();
}
