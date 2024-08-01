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
    private String[] unit3Answers = {
            "1. iOS programming involves developing applications for Apple's iOS operating system using languages like Swift or Objective-C. It differs from Android programming primarily in terms of development tools (Xcode vs. Android Studio), programming languages, and platform-specific APIs and design guidelines.",
            "2. The iOS platform is a mobile operating system developed by Apple for iPhone, iPad, and iPod touch devices. Key components include the iOS kernel, frameworks for app development (UIKit, SwiftUI), and the App Store for distributing apps.",
            "3. To set up the development environment for iOS programming, install Xcode from the Mac App Store, which includes the IDE, Swift compiler, and iOS SDK. Ensure that you have a macOS system, as Xcode is only available for macOS.",
            "4. To create a new Xcode project, open Xcode, select 'Create a new Xcode project' from the welcome screen or File menu, choose a template (e.g., App), enter project details (name, organization, etc.), and select a location to save the project.",
            "5. Building the user interface in Xcode involves using Interface Builder to drag and drop UI components onto the canvas. You can arrange and configure these components, set their properties, and create constraints to define the layout.",
            "6. To make connections between UI elements and code in Xcode, use Interface Builder to create IBOutlets and IBActions. Drag from UI elements in the storyboard to the code file to create connections that allow you to manipulate the elements programmatically.",
            "7. To run an iOS application on the simulator, select a simulator device from the device list in Xcode's toolbar, and click the 'Run' button (a play icon). Xcode will build the app and launch it on the chosen simulator.",
            "8. Swift is a modern, powerful programming language developed by Apple for iOS and macOS development. It is used for its performance, safety features, and easy-to-read syntax. Swift replaces Objective-C for many iOS developers due to its advantages in speed and developer productivity.",
            "9. The view hierarchy in iOS refers to the structure of views within a view controller. It represents the organization of UI elements, where views are nested within other views. Understanding the view hierarchy is crucial for managing layouts and handling user interactions.",
            "10. A storyboard in iOS development is a visual representation of an app's user interface and its transitions between different view controllers. It allows you to design and organize the app's navigation flow and UI elements in a single file, facilitating a more cohesive design process.",
            "11. Working with widgets (UI elements) in iOS involves configuring their attributes, such as text, images, and styles, either through Interface Builder or programmatically. You can set properties like color, font, and size, and use constraints to manage their layout.",
            "12. To create a simple iOS application using Swift and Xcode, follow these steps: 1) Open Xcode and create a new project, 2) Choose a template (e.g., Single View App), 3) Design the UI using Interface Builder, 4) Implement functionality in Swift code, 5) Run and test the app using the simulator or a physical device."
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
                Intent intent = new Intent(QUnit8Activity.this, AUnit8Activity.class);
                intent.putExtra("question", selectedQuestion);
                intent.putExtra("answer", selectedAnswer);
                startActivity(intent);
            }
        });
    }
}