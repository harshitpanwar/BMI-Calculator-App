package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.Math;
import static android.icu.text.RelativeDateTimeFormatter.Direction.LAST;

public class MainActivity extends AppCompatActivity {
private EditText Height,Weight;
private TextView BMI;
private Button button;
private TextView Last;
private TextView youneedtoloose;
private Button clearAll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         Height=findViewById(R.id.textView);
         Weight=findViewById(R.id.textView1);
         BMI=findViewById(R.id.bmi);
         youneedtoloose = findViewById(R.id.youneedtoloose);
         clearAll = findViewById(R.id.clear);
         Button button=(Button)findViewById(R.id.button);
         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if(Height.getText().toString().length()==0)
                     Toast.makeText(getApplicationContext(), "please enter Height",Toast.LENGTH_SHORT).show();
                 else
                 if(Weight.getText().toString().length()==0)
                     Toast.makeText(getApplicationContext(), "please enter Weight",Toast.LENGTH_SHORT).show();
                else
                 bmi();
             }
         });


         clearAll.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Height.setText("");
                 Weight.setText("");
                 BMI.setText("");
                 youneedtoloose.setText("");
             }
         });


    }
    private void bmi()
    {

        float l,w,b;
        double net;
    l=Float.parseFloat(Height.getText().toString())/100;


    w=Float.parseFloat(Weight.getText().toString());

    b=w/(l*l);
    if(b<18.5){
    BMI.setText(" "+b+"    underweight");
    net = Math.ceil(18.5-b);
    youneedtoloose.setText(" you need to gain "+net+"kg of weight");

    }
    else {
        if((b>=18)&&(b<=24.9))
        BMI.setText(" "+b+"    normal");

    else{
        BMI.setText(" "+b+"    overweight");
        net = Math.ceil(b - 24.9);
        youneedtoloose.setText(" you need to loose "+net+"kg of weight");}

    }
    }
}
