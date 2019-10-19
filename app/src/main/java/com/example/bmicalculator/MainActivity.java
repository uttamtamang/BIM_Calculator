package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private EditText weight;
    private EditText height;
    //DecimalFormat formated_value= new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        result = (TextView) findViewById(R.id.result);

    }
    public void calculateBMI(View v) {
        String heightStr= height.getText().toString();
        String weightStr = weight.getText().toString();

        if (heightStr != null && !"".equals(heightStr) &&
                weightStr != null && !"".equals(weightStr))
        {
            float heightValue = Float.parseFloat(heightStr);
            float weightValue = Float.parseFloat(weightStr);

            float bmi= weightValue / (heightValue * heightValue);
//            bmi= Math.round(bmi*100.00)/100.00;
            displayBMI(bmi);

        }


    }
    private void displayBMI(float bmi) {
        String bmiLabel = "";
        result.setText(bmiLabel);
        if (bmi < 18.5)
        {
            bmiLabel = getString(R.string.underweight);
        }
        else if (bmi >= 18.5 && bmi <= 24.9 )
        {
            bmiLabel = getString(R.string.healthy);
        }
        else{
            bmiLabel= getString(R.string.overweight);
        }
        bmiLabel = "BMI = " +roundTwoDecimals(bmi) +"\n" + bmiLabel;
        //bmiLabel = "BMI = " + bmi + "\n\n" + bmiLabel;
        result.setText(bmiLabel);
    }
    double roundTwoDecimals(double a){
        DecimalFormat form_value= new DecimalFormat("#.##");
        return Double.valueOf(form_value.format(a));
    }


}
