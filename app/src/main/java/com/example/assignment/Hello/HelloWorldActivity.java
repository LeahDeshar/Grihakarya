package com.example.assignment.Hello;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.assignment.R;

public class HelloWorldActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hello_world);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView titleTextView = findViewById(R.id.titleTextView);
        String title = getIntent().getStringExtra("title");
        titleTextView.setText(title);



        TextView expTitle = findViewById(R.id.title);
        TextView notesTextView = findViewById(R.id.notesTextView);


        String[] titlesArray = getResources().getStringArray(R.array.titles_array);
        String[] expArray = getResources().getStringArray(R.array.exp_array);

        StringBuilder allTitlesAndExplanations = new StringBuilder();

        for (int i = 0; i < titlesArray.length && i < expArray.length; i++) {
            allTitlesAndExplanations.append(titlesArray[i]).append("\n\n");
            allTitlesAndExplanations.append(expArray[i]).append("\n\n");
        }

        expTitle.setText(allTitlesAndExplanations.toString());
        notesTextView.setText("");
    }
}