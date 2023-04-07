package com.example.companytask;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("comments?postId=1")
    Call<ArrayList<DataResponse>> getresponse(@Query("postId") int postId);
}
