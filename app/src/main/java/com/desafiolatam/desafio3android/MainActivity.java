package com.desafiolatam.desafio3android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.desafiolatam.desafio3android.api.Api;
import com.desafiolatam.desafio3android.api.RetrofitClient;
import com.desafiolatam.desafio3android.model.RespuestaApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class MainActivity extends AppCompatActivity {

    private TextView question, category, dificulty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        Api api = RetrofitClient.getRetrofit().create(Api.class);
        Call<RespuestaApi> call = api.getQuestion();
        call.enqueue(new Callback<RespuestaApi>() {
            @Override
            public void onResponse(Call<RespuestaApi> call, Response<RespuestaApi> response) {
                question.setText(response.body().getResults().get(0).getQuestion());
                category.setText(response.body().getResults().get(0).getCategory());
                dificulty.setText(response.body().getResults().get(0).getDifficulty());
            }
            @Override
            public void onFailure(Call<RespuestaApi> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Algo Fallo, intentelo despues", Toast.LENGTH_SHORT).show();


            }
        });
    }
    private void initializeViews(){
        question = findViewById(R.id.texto1);
        category = findViewById(R.id.texto2);
        dificulty = findViewById(R.id.texto3);
    }
}