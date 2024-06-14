package com.example.assignment.Assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.assignment.R;

public class AssignmentDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_assignment_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView titleTextView = findViewById(R.id.titleTextView);
        String title = getIntent().getStringExtra("title");
        titleTextView.setText(title);


        Button assignOneButton = findViewById(R.id.assignOneButton);
        Button assignTwoButton = findViewById(R.id.assignTwoButton);


        assignOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the title from the TextView associated with the button
                TextView assignOneTextView = findViewById(R.id.assignOne);
                String title = assignOneTextView.getText().toString();

                // Start the next activity with the title as an intent extra
                Intent intent = new Intent(AssignmentDetailsActivity.this, DemoOneActivity.class);
                intent.putExtra("title", title);
                startActivity(intent);
            }
        });

        assignTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the title from the TextView associated with the button
                TextView assignTwoTextView = findViewById(R.id.assignTwo);
                String title = assignTwoTextView.getText().toString();

                // Start the next activity with the title as an intent extra
                Intent intent = new Intent(AssignmentDetailsActivity.this, DemoTwoActivity.class);
                intent.putExtra("title", title);
                startActivity(intent);
            }
        });
    }
}