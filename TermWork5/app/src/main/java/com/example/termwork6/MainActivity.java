package com.example.termwork6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String Path= new File(MainActivity.this.getApplicationInfo().dataDir, "databases").getAbsolutePath();
        final DBHelper dbHelper = new DBHelper(getApplicationContext(), Path+"AccountsDB", null,1);

        final int pin=dbHelper.getPin();

        if(pin==0){
            Intent intent=new Intent(this,RegistrationActivity.class);
            intent.putExtra("path",Path);
            startActivity(intent);
        }
        else{
            Button btn = findViewById(R.id.btnLogin);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int enteredpin = Integer.parseInt(((EditText) findViewById(R.id.EdtPin)).getText().toString());
                    if (enteredpin == pin) {
                        Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Entered pin is invalid. Try again!",Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
}