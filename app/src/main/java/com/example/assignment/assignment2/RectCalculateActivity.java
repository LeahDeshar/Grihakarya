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

public class RectCalculateActivity extends AppCompatActivity {
    private EditText length,breadth;
    private TextView result;
    private Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rect_calculate);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        length = findViewById(R.id.lengthEt);
        breadth = findViewById(R.id.breadthEt);
        result = findViewById(R.id.result);
        calculate = findViewById(R.id.calculate);

        calculate.setOnClickListener(v -> {
            double l = Double.parseDouble(length.getText().toString());
            double b = Double.parseDouble(breadth.getText().toString());
            double area = l * b;
            double perimeter = 2 * (l + b);
            result.setText("Area of Rectangle: " + area + "\nPerimeter of Rectangle: " + perimeter);
        });
    }
}