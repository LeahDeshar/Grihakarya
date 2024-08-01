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

public class QUnit3Activity extends AppCompatActivity {
    private String[] unit3Questions = {
            "1. Explain different Android layout types (Linear, Relative, Table, Absolute, Constraint).",
            "2. Describe the attributes of different layout types in Android.",
            "3. Explain the usage and attributes of TextView in Android.",
            "4. Explain the usage and attributes of EditText in Android.",
            "5. Explain the usage and attributes of CheckBox in Android.",
            "6. Explain the usage and attributes of RadioButton in Android.",
            "7. Explain the usage and attributes of Spinner in Android.",
            "8. Discuss how to handle events in Android applications.",
            "9. Explain working with strings and string arrays in Android.",
            "10. Describe how to work with colors in Android.",
            "11. Explain working with resources in Android.",
            "12. Explain working with drawables in Android.",
            "13. Discuss how to add an icon to an Android project."
    };
    private String[] unit3Answers = {
            "Answer to question 1: Android layout types include LinearLayout, RelativeLayout, TableLayout, AbsoluteLayout, and ConstraintLayout. Each layout type has specific characteristics and usage scenarios.",
            "Answer to question 2: Layout attributes define the behavior and appearance of views within a layout. Common attributes include width, height, margins, padding, and gravity.",
            "Answer to question 3: TextView is a widget that displays text to the user. It can be customized with various attributes such as text size, color, style, and alignment.",
            "Answer to question 4: EditText is a widget that allows the user to enter and edit text. Attributes include input type, hint, max length, and text color.",
            "Answer to question 5: CheckBox is a widget that provides a checkbox with two states: checked and unchecked. Attributes include text, checked, and onCheckedChange.",
            "Answer to question 6: RadioButton is a widget that represents a single choice within a set of mutually exclusive choices. Attributes include text, checked, and onCheckedChange.",
            "Answer to question 7: Spinner is a widget that provides a dropdown list of items for the user to select from. Attributes include entries, prompt, and onItemSelected.",
            "Answer to question 8: Event handling in Android involves responding to user interactions such as clicks, touches, and gestures. This can be done using listeners and callbacks.",
            "Answer to question 9: Working with strings and string arrays in Android involves defining them in XML resources and accessing them in Java code. String resources help with localization.",
            "Answer to question 10: Working with colors in Android involves defining color resources in XML and applying them to views and widgets. Colors can be defined using hexadecimal values.",
            "Answer to question 11: Working with resources in Android includes managing different types of resources like strings, colors, dimensions, and images in a structured way using XML.",
            "Answer to question 12: Working with drawables in Android involves using bitmap images, vector graphics, and other drawable resources to provide visual elements for the UI.",
            "Answer to question 13: Adding an icon to an Android project involves placing the icon image in the appropriate drawable directories and referencing it in the app manifest and layout files."
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_qunit3);
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