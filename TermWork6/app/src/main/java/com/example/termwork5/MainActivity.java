package com.example.termwork5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    String[] titles = {"Name One",
            "Name Two",
            "Name Three",
            "Name Four",
            "Name Five",
            "Name Six",
            "Name Seven",
            "Name Eight"};
    String[] phoneno = {"99999999",
            "888888", "7777777",
            "666666", "555555",
            "4444444", "33333333",
            "22222222"};
    int[] images = { R.drawable.android_image_1,
            R.drawable.android_image_2,R.drawable.android_image_3,
            R.drawable.android_image_4,R.drawable.android_image_5,
            R.drawable.android_image_6,R.drawable.android_image_7,
            R.drawable.android_image_8};
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.myrecycler);

        RecyclerAdapter recyclerAdapter= new RecyclerAdapter(this,titles,phoneno,images);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}