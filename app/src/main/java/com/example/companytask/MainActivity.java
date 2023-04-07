package com.example.companytask;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.companytask.databinding.ActivityMainBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mainBinding;
    ApiInterface apiInterface;
    MainActivityAdapter mainActivityAdapter;
    ArrayList<DataResponse> dataResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        dataResponse=new ArrayList<>();

        apiInterface=RetrofitClass.getclientci().create(ApiInterface.class);
        apiInterface.getresponse(1).enqueue(new Callback<ArrayList<DataResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<DataResponse>> call, Response<ArrayList<DataResponse>> response) {
                dataResponse=response.body();
                mainBinding.recyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                mainActivityAdapter=new MainActivityAdapter(MainActivity.this,dataResponse);
                mainBinding.recyclerview.setAdapter(mainActivityAdapter);
                Toast.makeText(MainActivity.this, "Sucses", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ArrayList<DataResponse>> call, Throwable t) {

            }
        });

    }
}