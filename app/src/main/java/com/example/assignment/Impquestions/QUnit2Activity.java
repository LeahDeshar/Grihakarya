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

public class QUnit2Activity extends AppCompatActivity {
    private String[] unit2Questions = {
            "1. Explain the Android Platform and its architecture.",
            "2. Describe the history and evolution of Android.",
            "3. How do you create a new Android project in Android Studio?",
            "4. What is the view hierarchy in Android?",
            "5. Explain widget attributes in Android.",
            "6. How do you create string resources in Android?",
            "7. Discuss the importance of laying out the user interface in Android applications."
    };

    private String[] unit2Answers = {
            "Answer to question 1: Android is an open-source operating system for mobile devices developed by Google. It includes a software stack that consists of an operating system, middleware, and key applications.",
            "Answer to question 2: Android was developed by Android Inc., which was later acquired by Google in 2005. The first Android device was released in 2008, and since then, it has undergone several updates and versions.",
            "Answer to question 3: To create a new Android project in Android Studio, you can follow these steps: Open Android Studio, click on 'Start a new Android Studio project,' choose a template, configure your project, and click 'Finish.'",
            "Answer to question 4: The view hierarchy in Android represents the structure of views within an Android application. Each view in the hierarchy can contain other views, forming a tree-like structure.",
            "Answer to question 5: Widget attributes in Android are properties that define the appearance and behavior of UI elements (widgets). These attributes can be set in XML layout files or programmatically.",
            "Answer to question 6: String resources in Android are defined in XML files within the 'res/values' directory. You can create a strings.xml file and add string resources using the <string> tag.",
            "Answer to question 7: Laying out the user interface is crucial in Android applications to ensure a good user experience. It involves defining the layout structure, arranging UI elements, and ensuring responsiveness across different devices."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_qunit2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ListView listView = findViewById(R.id.questions_list_view);

        // Create an ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, unit2Questions);

        // Set the adapter to the ListView
        listView.setAdapter(adapter);

        // Set an item click listener on the ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected question and answer
                String selectedQuestion = unit2Questions[position];
                String selectedAnswer = unit2Answers[position];

                // Create an intent to start the AnswerActivity
                Intent intent = new Intent(QUnit2Activity.this, AUnit2Activity.class);
                intent.putExtra("question", selectedQuestion);
                intent.putExtra("answer", selectedAnswer);
                startActivity(intent);
            }
        });
    }
}