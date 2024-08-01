package com.example.assignment.Impquestions;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.assignment.R;

public class QUnit8Activity extends AppCompatActivity {
    private String[] unit3Questions = {
            "1. What is iOS programming, and how does it differ from Android programming?",
            "2. Describe the iOS platform and its main components.",
            "3. How do you set up the development environment for iOS programming?",
            "4. What are the steps to create a new Xcode project?",
            "5. Explain the process of building the user interface in Xcode.",
            "6. How do you make connections between UI elements and code in Xcode?",
            "7. How can you run an iOS application on the simulator?",
            "8. What is the Swift language, and why is it used for iOS development?",
            "9. Describe the view hierarchy in iOS and its importance.",
            "10. What is a storyboard in iOS development, and how is it used with view controllers?",
            "11. How do you work with widgets and their attributes in an iOS application?",
            "12. How would you create a simple iOS application using Swift and Xcode?"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_qunit8);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ListView listView = findViewById(R.id.questions_list_view);

        // Create an ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, unit3Questions);

        // Set the adapter to the ListView
        listView.setAdapter(adapter);

        // Set an item click listener on the ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected question and answer
                String selectedQuestion = unit3Questions[position];
                String selectedAnswer = unit3Answers[position];

                // Create an intent to start the AnswerActivity
                Intent intent = new Intent(QUnit3Activity.this, AUnit3Activity.class);
                intent.putExtra("question", selectedQuestion);
                intent.putExtra("answer", selectedAnswer);
                startActivity(intent);
            }
        });
    }
}