package com.example.assignment.assignment2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.assignment.R;

public class CalculatorActivity extends AppCompatActivity {

    private EditText firstEt, secondEt;
private TextView resultTv;
private Button addBtn, subBtn, mulBtn, divBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        firstEt = findViewById(R.id.first_number);
        secondEt = findViewById(R.id.second_number);
        resultTv = findViewById(R.id.result);
        addBtn = findViewById(R.id.add);
        subBtn = findViewById(R.id.subtract);
        mulBtn = findViewById(R.id.multiply);
        divBtn = findViewById(R.id.divide);

        addBtn.setOnClickListener(v -> {
            double first = Double.parseDouble(firstEt.getText().toString());
            double second = Double.parseDouble(secondEt.getText().toString());
            double result = first + second;
            resultTv.setText("Result: " + result);
        });

        subBtn.setOnClickListener(v -> {
            double first = Double.parseDouble(firstEt.getText().toString());
            double second = Double.parseDouble(secondEt.getText().toString());
            double result = first - second;
            resultTv.setText("Result: " + result);
        });

        mulBtn.setOnClickListener(v -> {
            double first = Double.parseDouble(firstEt.getText().toString());
            double second = Double.parseDouble(secondEt.getText().toString());
            double result = first * second;
            resultTv.setText("Result: " + result);
        });

        divBtn.setOnClickListener(v -> {
            double first = Double.parseDouble(firstEt.getText().toString());
            double second = Double.parseDouble(secondEt.getText().toString());
            double result = first / second;
            resultTv.setText("Result: " + result);
        });




    }
}