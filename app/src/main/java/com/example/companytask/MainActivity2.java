package com.example.companytask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.companytask.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {
    ActivityMain2Binding main2Binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        main2Binding=ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(main2Binding.getRoot());
        Intent intent=getIntent();
        main2Binding.name.setText(intent.getStringExtra("name"));
        main2Binding.email.setText(intent.getStringExtra("email"));
        main2Binding.details.setText(intent.getStringExtra("details"));
    }
}