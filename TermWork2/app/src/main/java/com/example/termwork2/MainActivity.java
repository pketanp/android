package com.example.termwork2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button add,div,mul,sub;
    EditText edtNo1,edtNo2;
    int num1,num2;
    TextView txt;
    String s1,s2;
    public boolean getNumbers() {
        edtNo1=(EditText)findViewById(R.id.edtNo1);
        edtNo2=(EditText)findViewById(R.id.edtNo2);
        s1=edtNo1.getText().toString();
        s2=edtNo2.getText().toString();
        if ((s1.equals(null) && s2.equals(null)) || (s1.equals("") && s2.equals(""))) {
            String result = "Please enter a value";
            txt.setText(result);
            return false;
        }else {
            // converting string to int.
            num1 = Integer.parseInt(edtNo1.getText().toString());
            // converting string to int.
            num2 = Integer.parseInt(edtNo2.getText().toString());
        }
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add=(Button)findViewById(R.id.btnAdd);
        div=(Button)findViewById(R.id.btnDiv);
        mul=(Button)findViewById(R.id.btnMul);
        sub=(Button)findViewById(R.id.btnSub);
        txt=(TextView)findViewById(R.id.tctAns);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if (getNumbers()) {
                    int sum = num1 + num2;
                    txt.setText("Addition : "+Integer.toString(sum));
                }
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                // get the input numbers
                if (getNumbers()) {
                    int sum = num1 - num2;
                    txt.setText(Integer.toString(sum));
                }
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if (getNumbers()) {
                    int sum = num1 * num2;
                    txt.setText(Integer.toString(sum));
                }
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                // get the input numbers
                if (getNumbers()) {
                    // displaying the text in text view assigned as t1
                    double sum = num1 / (num2 * 1.0);
                    txt.setText(Double.toString(sum));
                }
            }
        });
    }
}