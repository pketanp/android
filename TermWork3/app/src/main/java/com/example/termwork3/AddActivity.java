package com.example.termwork3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Button btnAdd=(Button)findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(RESULT_OK);
            }
        });

    }
    public void finish(int a){
        EditText edtTitle=(EditText)findViewById(R.id.edtTitle);
        EditText edtDate=(EditText)findViewById(R.id.edtDate);
        EditText edtTime=(EditText)findViewById(R.id.edtTime);
        String title=edtTitle.getText().toString();
        String date=edtDate.getText().toString();
        String time=edtTime.getText().toString();
        Intent i=new Intent();
        i.putExtra("title",title);
        i.putExtra("date",date);
        i.putExtra("time",time);
        setResult(a,i);
        super.finish();
    }

    @Override
    public void onBackPressed() {
        Intent i=new Intent();
        i.putExtra("title","no value saved");
        setResult(RESULT_CANCELED,i);
        super.finish();
    }
}