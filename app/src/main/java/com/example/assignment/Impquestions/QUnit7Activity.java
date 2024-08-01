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

public class QUnit7Activity extends AppCompatActivity {
    private String[] unit3Questions = {
            "1. How do you establish a connection to a local SQLite database in Android?",
            "2. Describe the process of creating a database and tables in SQLite for an Android application.",
            "3. What are the common methods for data manipulation in SQLite?",
            "4. What is an API, and why is it important in mobile applications?",
            "5. What are the different types of APIs commonly used in Android development?",
            "6. What is JSON, and how is it used in Android applications?",
            "7. How do you retrieve contents from a remote server in an Android application?",
            "8. Describe the process of sending contents to a remote server from an Android application.",
            "9. How can you implement Google Maps in an Android application?",
            "10. What are the steps involved in publishing an application on the Google Play Store?"
    };
    private String[] unit3Answers = {
            "1. To establish a connection to a local SQLite database in Android, you create a subclass of SQLiteOpenHelper. Override the onCreate() and onUpgrade() methods to manage database creation and version management. Use the getWritableDatabase() or getReadableDatabase() methods to get an instance of SQLiteDatabase for performing operations.",
            "2. To create a database and tables in SQLite, subclass SQLiteOpenHelper and override the onCreate() method. In this method, use the SQLiteDatabase object to execute SQL commands for creating tables. Define the schema (table name, columns, data types) within these SQL commands.",
            "3. Common methods for data manipulation in SQLite include insert(), update(), delete(), and query(). The insert() method adds new rows, update() modifies existing rows, delete() removes rows, and query() retrieves data based on specific criteria.",
            "4. An API (Application Programming Interface) allows different software applications to communicate with each other. In mobile applications, APIs are important for accessing remote services, integrating third-party functionalities, and exchanging data between the app and external servers.",
            "5. Different types of APIs used in Android development include RESTful APIs, which use HTTP methods and are commonly used for web services, and SOAP APIs, which use XML-based messaging protocols. Additionally, there are local APIs for interacting with device features and libraries.",
            "6. JSON (JavaScript Object Notation) is a lightweight data-interchange format used to represent structured data in a human-readable format. In Android applications, JSON is commonly used for exchanging data between the app and remote servers, as well as for parsing and storing data locally.",
            "7. To retrieve contents from a remote server in an Android application, use networking libraries like Retrofit or Volley. Perform HTTP GET requests to fetch data, and then parse the JSON response to handle the retrieved data within the app.",
            "8. To send contents to a remote server from an Android application, use libraries like Retrofit or Volley to perform HTTP POST requests. Include the data to be sent in the request body, and handle the server’s response to ensure successful data transmission.",
            "9. To implement Google Maps in an Android application, add the Google Maps SDK to your project, obtain an API key from the Google Cloud Console, and configure the AndroidManifest.xml file with the API key. Use the MapFragment or MapView to display the map and interact with Google Maps services.",
            "10. To publish an application on the Google Play Store, follow these steps: 1) Prepare the app for release by building a signed APK or AAB, 2) Create a developer account on the Google Play Console, 3) Upload the APK/AAB, set up the app listing (description, screenshots, pricing), 4) Set up content ratings and privacy policies, 5) Submit the app for review and publish it once approved."
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_qunit7);
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
                Intent intent = new Intent(QUnit7Activity.this, AUni7Activity.class);
                intent.putExtra("question", selectedQuestion);
                intent.putExtra("answer", selectedAnswer);
                startActivity(intent);
            }
        });
    }
}