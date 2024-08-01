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

public class QUnit4Activity extends AppCompatActivity {
    private String[] unit4Questions = {
            "1. Explain the Activity life cycle in Android.",
            "2. How do you create multiple activities in an Android application?",
            "3. How do you declare activities in the Android manifest file?",
            "4. Explain how to connect activities using intents.",
            "5. Describe how to pass data between activities in Android.",
            "6. How do you get a result back from a child activity?",
            "7. Explain how to get and set data to/from the layout file in an activity."
    };

    private String[] unit4Answers = {
            "Answer to question 1: The Activity life cycle in Android consists of various states such as onCreate, onStart, onResume, onPause, onStop, and onDestroy. Each state corresponds to a specific stage in the activity's lifecycle, allowing developers to manage resources and perform necessary actions.",
            "Answer to question 2: To create multiple activities in an Android application, you define each activity as a separate class that extends the Activity class. You then declare each activity in the Android manifest file.",
            "Answer to question 3: To declare activities in the Android manifest file, you add an <activity> element inside the <application> element. The <activity> element specifies the activity class name and other configuration settings.",
            "Answer to question 4: Activities are connected using intents in Android. An intent is an abstract description of an operation to be performed. You can use explicit intents to start a specific activity or implicit intents to start an activity that can handle a given action.",
            "Answer to question 5: Data can be passed between activities in Android using intents. You can put extra data into an intent using the putExtra method and retrieve it in the target activity using the getIntent and getExtras methods.",
            "Answer to question 6: To get a result back from a child activity, you can use the startActivityForResult method in the parent activity. The child activity sends the result back using the setResult method, and the parent activity handles the result in the onActivityResult callback method.",
            "Answer to question 7: Getting and setting data to/from the layout file in an activity involves using the findViewById method to get references to UI elements and then using methods like setText and getText to set and get data from these elements."
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_qunit4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ListView listView = findViewById(R.id.questions_list_view);

        // Create an ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, unit4Questions);

        // Set the adapter to the ListView
        listView.setAdapter(adapter);

        // Set an item click listener on the ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected question and answer
                String selectedQuestion = unit4Questions[position];
                String selectedAnswer = unit4Answers[position];

                // Create an intent to start the AnswerActivity
                Intent intent = new Intent(QUnit4Activity.this, AUnit4Activity.class);
                intent.putExtra("question", selectedQuestion);
                intent.putExtra("answer", selectedAnswer);
                startActivity(intent);
            }
        });
    }
}