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

public class QUnit5Activity extends AppCompatActivity {
    private String[] unit5Questions = {
            "1. What is the need for UI flexibility in Android applications?",
            "2. What is a fragment in Android, and how does it differ from an activity?",
            "3. Explain the lifecycle of a fragment.",
            "4. How do you create a UI fragment in Android?",
            "5. Describe the process of creating a fragment class.",
            "6. How do you wire widgets in a fragment?",
            "7. What is the role of the FragmentManager in Android?",
            "8. What are the main differences between activities and fragments in Android?"
    };
    private String[] unit5Answers = {
            "1. UI flexibility in Android applications is crucial for creating adaptive and responsive interfaces that work well on various screen sizes and orientations. It allows developers to design user interfaces that can dynamically adjust to different contexts and user interactions.",
            "2. A fragment is a modular section of an activity that has its own lifecycle, layout, and behavior. Unlike activities, fragments are reusable components that can be combined to form a complete user interface. Activities manage the UI and handle user interactions, while fragments are used to create more flexible and reusable UI components.",
            "3. The lifecycle of a fragment includes the following states: onAttach(), onCreate(), onCreateView(), onActivityCreated(), onStart(), onResume(), onPause(), onStop(), onDestroyView(), onDestroy(), and onDetach(). Each state represents different stages in the fragment's lifecycle, allowing for management of resources and interactions with the user.",
            "4. To create a UI fragment, you need to extend the Fragment class and override the onCreateView() method to specify the fragment's layout. You then use a FragmentTransaction to add or replace the fragment in an activity's layout.",
            "5. Creating a fragment class involves extending the Fragment class and implementing the necessary lifecycle methods, such as onCreate() and onCreateView(). You define the fragment's layout and manage its interactions with other UI components within these methods.",
            "6. To wire widgets in a fragment, you use the view returned by onCreateView() to find and manipulate UI elements. This involves calling findViewById() on the view to access widgets like buttons or text fields, and then setting up event listeners or updating their properties as needed.",
            "7. The FragmentManager is responsible for managing fragments within an activity. It handles fragment transactions, such as adding, replacing, or removing fragments, and also manages the back stack of fragment transactions to handle user navigation.",
            "8. The main differences between activities and fragments include their lifecycle management, modularity, and reuse. Activities represent a single screen with its own lifecycle, while fragments are modular components that can be combined to create flexible UIs. Fragments are typically used to manage UI elements within an activity and can be reused across multiple activities."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_qunit5);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ListView listView = findViewById(R.id.questions_list_view);

        // Create an ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, unit5Questions);

        // Set the adapter to the ListView
        listView.setAdapter(adapter);

        // Set an item click listener on the ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected question and answer
                String selectedQuestion = unit5Questions[position];
                String selectedAnswer = unit5Answers[position];

                // Create an intent to start the AnswerActivity
                Intent intent = new Intent(QUnit5Activity.this, AUnit5Activity.class);
                intent.putExtra("question", selectedQuestion);
                intent.putExtra("answer", selectedAnswer);
                startActivity(intent);
            }
        });
    }
}