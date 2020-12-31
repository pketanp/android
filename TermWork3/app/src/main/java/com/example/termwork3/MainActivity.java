package com.example.termwork3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.SharedPreferencesCompat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int request_code = 1;
    int count;
    SharedPreferences pref;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout li= findViewById(R.id.itemlist);
        pref=getApplicationContext().getSharedPreferences("myPref", MODE_PRIVATE);
        count=pref.getInt("count", -1);
        for (int i=0; i < pref.getInt("count", -1);i++){
            TextView textView=new TextView(this);
            textView.setId(count);
            textView.setText(pref.getString("title"+i,null)+" on "+pref.getString("date"+i,null)+" at "+pref.getString("time"+i,null));
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
            textView.setTextColor(Color.MAGENTA);
            textView.setTypeface(null, Typeface.BOLD_ITALIC);
            textView.setGravity(Gravity.CENTER);
            textView.requestLayout();
            li.addView(textView);
        }
        btnAdd=(Button)findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,AddActivity.class);
                startActivityForResult(i,request_code);
            }
        });

    }
    protected void onActivityResult(int requestCode,int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        String returnString;
        if(requestCode==request_code && resultCode == RESULT_OK){
            if(data.hasExtra("title")){
                count++;
                String title=data.getExtras().getString("title");
                String date=data.getExtras().getString("date");
                String time=data.getExtras().getString("time");
                LinearLayout li= (LinearLayout)findViewById(R.id.itemlist);
                TextView textView=new TextView(this);
                textView.setId(count);
                textView.setText(title+" on "+date+" at "+time);
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                textView.setTextColor(Color.MAGENTA);
                textView.setTypeface(null, Typeface.BOLD_ITALIC);
                textView.setGravity(Gravity.CENTER);
                textView.requestLayout();
                li.addView(textView);
                SharedPreferences.Editor editor=pref.edit();
                editor.putString("title"+count,title);
                editor.putString("date"+count,date);
                editor.putString("time"+count,time);
                editor.remove("count");
                editor.putInt("count",count);
                editor.apply();
                returnString = data.getExtras().getString("title");
                Toast.makeText(this,returnString,Toast.LENGTH_SHORT).show();
            }
        }else if (requestCode==request_code && resultCode == RESULT_CANCELED){
            if(data.hasExtra("title")){

                returnString = data.getExtras().getString("title");
                Toast.makeText(this,returnString,Toast.LENGTH_SHORT).show();
            }
        }
    }
}