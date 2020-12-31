package com.example.termwork6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Button btn=findViewById(R.id.BtnRegister);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String path=null;
                String name=((EditText)findViewById(R.id.EdtUName)).getText().toString();
                int pin=Integer.parseInt(((EditText)findViewById(R.id.EdtPin1)).getText().toString());
                Bundle extras=getIntent().getExtras();
                if(extras!=null){
                    path=extras.getString("path");
                }
                //String path=new File(RegistrationActivity.this.getApplicationInfo().dataDir,"database").getPath();
                DBHelper dbHelper=new DBHelper(getApplicationContext(),path+"AccountsDB",null,1);
                String result=dbHelper.addAccount(name,pin);
                Toast.makeText(RegistrationActivity.this,result,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(RegistrationActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}