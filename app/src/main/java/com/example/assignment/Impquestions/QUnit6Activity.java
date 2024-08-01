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

public class QUnit6Activity extends AppCompatActivity {
    private String[] unit3Questions = {
            "1. What is a ListView in Android, and why is it used?",
            "2. What are the key features of ListView in Android?",
            "3. How do you implement a ListView in an Android application?",
            "4. Explain how to customize the items displayed in a ListView.",
            "5. How can you handle item clicks in a ListView?"
    };
    private String[] unit3Answers = {
            "1. A ListView in Android is a view group that displays a list of scrollable items. It is used to show a large number of items efficiently by reusing views as they scroll in and out of the screen. ListView is ideal for displaying data in a list format and supports various functionalities like scrolling and item selection.",
            "2. Key features of ListView include its ability to display a scrollable list of items, efficient view recycling to handle large data sets, support for custom adapters to bind data to views, and built-in item selection and event handling.",
            "3. To implement a ListView in an Android application, follow these steps: 1) Define the ListView in the XML layout file, 2) Create a layout resource for the individual list items, 3) Create an Adapter (such as ArrayAdapter or custom adapter) to bind data to the ListView, 4) Set the Adapter to the ListView in your activity or fragment.",
            "4. To customize the items displayed in a ListView, create a custom layout XML file for the list items and extend the ArrayAdapter or BaseAdapter class to inflate this layout and bind the data. Override the getView() method in your adapter to provide the custom layout and populate it with data.",
            "5. To handle item clicks in a ListView, set an OnItemClickListener on the ListView. Implement the onItemClick() method to respond to user interactions with list items. This method provides the position of the clicked item, allowing you to perform actions such as displaying detailed information or navigating to another screen."
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_qunit6);
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
                Intent intent = new Intent(QUnit6Activity.this, AUnit6Activity.class);
                intent.putExtra("question", selectedQuestion);
                intent.putExtra("answer", selectedAnswer);
                startActivity(intent);
            }
        });
    }
}