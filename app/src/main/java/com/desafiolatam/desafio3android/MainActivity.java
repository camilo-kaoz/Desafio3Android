package com.desafiolatam.desafio3android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.desafiolatam.desafio3android.api.Api;
import com.desafiolatam.desafio3android.api.RetrofitClient;
import com.desafiolatam.desafio3android.model.RespuestaApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class MainActivity extends AppCompatActivity {

    private String primera, segunda, tercera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Api api = RetrofitClient.getRetrofit().create(Api.class);
        Call<RespuestaApi> call = api.getQuestion();
        call.enqueue(new Callback<RespuestaApi>() {

            @Override
            public void onResponse(Call<RespuestaApi> call, Response<RespuestaApi> response) {
                primera = response.body().getResults().get(0).getQuestion();
                segunda = response.body().getResults().get(0).getCategory();
                tercera = response.body().getResults().get(0).getDifficulty();

            initializerFragment(primera,segunda,tercera);
            }

            @Override
            public void onFailure(Call<RespuestaApi> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Algo Fallo, intentelo despues", Toast.LENGTH_SHORT).show();
            Log.e("ERROR", t.toString());

            }
        });
    }
    private void initializerFragment (String primera, String segunda,String tercera){
        Log.e("ERROR", "SI PASA ");
        FirstFragment firstFragment = FirstFragment.newInstance(primera, segunda, tercera);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.framelayout, firstFragment,"FIRSTFRAGMENT")
                .commit();

    }
}


