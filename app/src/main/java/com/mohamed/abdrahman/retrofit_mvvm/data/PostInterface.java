package com.mohamed.abdrahman.retrofit_mvvm.data;

import com.mohamed.abdrahman.retrofit_mvvm.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {

    @GET("posts")
    Call<List<PostModel>> getPosts();
}
