package com.example.termwork4;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        CoordinatorLayout mainLayout=(CoordinatorLayout)findViewById(R.id.activity_main);
        switch (item.getItemId()){
            case R.id.red: {
                mainLayout.setBackgroundColor(Color.RED);
                return true;
            }case R.id.green: {
                mainLayout.setBackgroundColor(Color.GREEN);
                return true;
            }
        }
        return true;
    }
}