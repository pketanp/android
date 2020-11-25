package com.example.termwork1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText edt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1=(EditText)findViewById(R.id.edtName);
                String edt=edt1.getText().toString();
                Toast.makeText(MainActivity.this,"Welcome "+edt,Toast.LENGTH_SHORT).show();
            }
        });
    }
}