package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editWt,editHtft,editHtIn;
        AppCompatButton btmCalculate;
        TextView textResult;
        editWt = findViewById(R.id.ed_wt);
        editHtft = findViewById(R.id.ed_HtFt);
        editHtIn = findViewById(R.id.ed_HtIn);
        btmCalculate = findViewById(R.id.btm_Calculate);
        textResult = findViewById(R.id.txt_Result);
        LinearLayout llMain = findViewById(R.id.llMain);
        btmCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(editWt.getText().toString());
                int htFt = Integer.parseInt(editHtft.getText().toString());
                int htIn = Integer.parseInt(editHtIn.getText().toString());
                int totalIn = htFt*12 + htIn;
                double totalCm = totalIn*2.53;
                double totalM = totalCm/100;
                double bmi = wt/(totalM*totalM);
                if(bmi>25){
                    textResult.setText("you are over weight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.red));
                }
                else if(bmi<18){
                    textResult.setText("you are under weight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.yellow));
                }
                else {
                    textResult.setText("you are healthy");
                    llMain.setBackgroundColor(getResources().getColor(R.color.green));
                }
            }
        });
    }
}