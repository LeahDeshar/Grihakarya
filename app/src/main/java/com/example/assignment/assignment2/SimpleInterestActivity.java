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

public class SimpleInterestActivity extends AppCompatActivity {
    private EditText principal, rate, time;
    private TextView result;
    private Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_simple_interest);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        principal = findViewById(R.id.principal);
        rate = findViewById(R.id.rate);
        time = findViewById(R.id.time);
        result = findViewById(R.id.result);
        calculate = findViewById(R.id.calculate);

        calculate.setOnClickListener(v -> {
            double p = Double.parseDouble(principal.getText().toString());
            double r = Double.parseDouble(rate.getText().toString());
            double t = Double.parseDouble(time.getText().toString());
            double si = (p * r * t) / 100;
            result.setText("Simple Interest: " + si);
        });


    }
}