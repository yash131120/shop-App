package com.example.mainactivity.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.mainactivity.Adapter.PopularListAdapter;
import com.example.mainactivity.Domain.PopularDomain;
import com.example.mainactivity.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterPupolar;
    private RecyclerView recyclerViewPupolar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerview();
        bottom_navigation();

    }

    private void bottom_navigation() {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout cartBtn = findViewById(R.id.cartBtn);

        homeBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, MainActivity.class)));
        cartBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, CartActivity.class)));
    }


    private void initRecyclerview() {
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("MacBook Pro 13 M2 chip", "Discover the new MacBook Pro 13 featuring the powerful M2 chip. This cutting-edge laptop redefines performance and portability. With its sleek design and advanced technology, the MacBook Pro 13 M2 chip is your ultimate companion for productivity, creativity, and entertainment. Experience seamless multitasking, stunning visuals on the Retine display, and enhanced security  with touch ID. Take your computing experience to the next level with the MacBook Pro 13 M2 chip.", "pic1", 15, 4, 1000000));
        items.add(new PopularDomain("Ps-5 Digital", "Discover the new MacBook Pro 13 featuring the powerful M2 chip. This cutting-edge laptop redefines performance and portability. With its sleek design and advanced technology, the MacBook Pro 13 M2 chip is your ultimate companion for productivity, creativity, and entertainment. Experience seamless multitasking, stunning visuals on the Retine display, and enhanced security  with touch ID. Take your computing experience to the next level with the MacBook Pro 13 M2 chip.", "pic2", 10, 4.5, 50000));
        items.add(new PopularDomain("IPhone 14", "Discover the new MacBook Pro 13 featuring the powerful M2 chip. This cutting-edge laptop redefines performance and portability. With its sleek design and advanced technology, the MacBook Pro 13 M2 chip is your ultimate companion for productivity, creativity, and entertainment. Experience seamless multitasking, stunning visuals on the Retine display, and enhanced security  with touch ID. Take your computing experience to the next level with the MacBook Pro 13 M2 chip.", "pic3", 13, 4.6, 150000));

        recyclerViewPupolar = findViewById(R.id.view1);
        recyclerViewPupolar.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        adapterPupolar = new PopularListAdapter(items);
        recyclerViewPupolar.setAdapter(adapterPupolar);

    }
}