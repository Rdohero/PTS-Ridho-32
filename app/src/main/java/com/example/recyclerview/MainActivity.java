package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;

import com.example.recyclerview.databinding.ActivityMainBinding;
import com.example.recyclerview.databinding.TextRowItemBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

//        String[] heroes = getResources().getStringArray(R.array.heroes_name);
        ArrayList<Resep> heroes = getListHeroes();
        ResepAdapter adapter = new ResepAdapter(heroes);
        binding.rvHero.setLayoutManager(new GridLayoutManager(this,2));
        binding.rvHero.setAdapter(adapter);
    }

    private ArrayList<Resep> getListHeroes(){
        String[] name = getResources().getStringArray(R.array.food_name);
        String[] description = getResources().getStringArray(R.array.food_description);
        TypedArray image = getResources().obtainTypedArray(R.array.food_image);

        ArrayList<Resep> Resep = new ArrayList<>();

        for(int i = 0; i< name.length; i++){
//            Buat objek baru, dan berikan data name, description ke objek baru tersebut
            Resep resep = new Resep();
            resep.setName(name[i]);
            resep.setDescription(description[i]);
            resep.setImage(image.getResourceId(i,-1));

//            tambahkan objek baru tersebut ke variable list hero
            Resep.add(resep);
        }
        return Resep;
    }
}