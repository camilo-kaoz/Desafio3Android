package com.desafiolatam.desafio3android.api;

import com.desafiolatam.desafio3android.model.RespuestaApi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("api.php?amount=1&category=18&difficulty=medium&type=boolean")
    Call<RespuestaApi> getQuestion();

}
