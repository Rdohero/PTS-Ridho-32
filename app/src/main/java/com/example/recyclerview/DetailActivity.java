package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.recyclerview.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    private ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
        int poster = intent.getIntExtra("poster",R.drawable.sukarno);
        String title = intent.getStringExtra("title");
        String description = intent.getStringExtra("description");

        binding.foodImage.setImageResource(poster);
        binding.foodName.setText(title);
        binding.foodDescription.setText(description);
    }
}