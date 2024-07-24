package com.example.assignment.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.assignment.R;

import java.util.ArrayList;
import java.util.List;

public class QuizGameActivity extends AppCompatActivity {
    private TextView questionTextView,countQuestionTextView;
    private Button option1Button, option2Button, option3Button, option4Button;

    private List<Question> questions;
    private int currentQuestionIndex = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz_game);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        questionTextView = findViewById(R.id.question_text_view);
        countQuestionTextView = findViewById(R.id.countQuestion);
        option1Button = findViewById(R.id.option1_button);
        option2Button = findViewById(R.id.option2_button);
        option3Button = findViewById(R.id.option3_button);
        option4Button = findViewById(R.id.option4_button);

        loadQuestions();
        displayQuestion();
    }
    private void loadQuestions() {
        questions = new ArrayList<>();
        questions.add(new Question("What is a key characteristic of mobile applications compared to desktop applications?", new String[]{"Higher memory usage", "Larger screen size", "Battery dependency", "Lack of touch interaction"}, 2));
        questions.add(new Question("Which of the following is NOT a mobile operating system?", new String[]{"Android", "iOS", "Windows", "Linux"}, 3));
        questions.add(new Question("What language is primarily used for Android development?", new String[]{"Swift", "Java", "C++", "Python"}, 1));
        questions.add(new Question("What is the role of the AndroidManifest.xml file?", new String[]{"To define the UI layout", "To manage the app's permissions", "To store app's assets", "To compile the code"}, 1));
        questions.add(new Question("Which method is used to start an activity in Android?", new String[]{"startActivity()", "initActivity()", "createActivity()", "launchActivity()"}, 0));
        questions.add(new Question("What is an Intent in Android?", new String[]{"A background service", "A messaging object", "A UI component", "A database helper"}, 1));
        questions.add(new Question("Which layout is used to arrange components in a single column or row?", new String[]{"LinearLayout", "RelativeLayout", "GridLayout", "FrameLayout"}, 0));
        questions.add(new Question("What is an Android activity?", new String[]{"A service that runs in the background", "A component that provides a screen with which users can interact", "A broadcast receiver that listens for system events", "A content provider that manages access to data"}, 1));
        questions.add(new Question("Which file is used to define the layout of an Android application?", new String[]{"MainActivity.java", "strings.xml", "activity_main.xml", "styles.xml"}, 2));
        questions.add(new Question("What is the function of a ContentProvider in Android?", new String[]{"To handle background tasks", "To manage UI components", "To store and manage application data", "To handle network operations"}, 2));

    }

    private void displayQuestion() {
        if (currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            countQuestionTextView.setText((currentQuestionIndex + 1) + "/" + questions.size());
            questionTextView.setText(currentQuestion.getQuestionText());
            option1Button.setText(currentQuestion.getOptions()[0]);
            option2Button.setText(currentQuestion.getOptions()[1]);
            option3Button.setText(currentQuestion.getOptions()[2]);
            option4Button.setText(currentQuestion.getOptions()[3]);
        } else {
            showScore();
        }
    }

    public void onOptionClicked(View view) {
        if (currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            int selectedOptionIndex = -1;

            if (view.getId() == R.id.option1_button) {
                selectedOptionIndex = 0;
            } else if (view.getId() == R.id.option2_button) {
                selectedOptionIndex = 1;
            } else if (view.getId() == R.id.option3_button) {
                selectedOptionIndex = 2;
            } else if (view.getId() == R.id.option4_button) {
                selectedOptionIndex = 3;
            }

            if (selectedOptionIndex == currentQuestion.getCorrectAnswerIndex()) {
                score++;
            }

            currentQuestionIndex++;
            displayQuestion();
        }
    }

//    private void showScore() {
//        Toast.makeText(this, "Your score is: " + score + "/" + questions.size(), Toast.LENGTH_LONG).show();
//    }

    private void showScore() {
        Intent intent = new Intent(QuizGameActivity.this, SummaryActivity.class);
        intent.putExtra("score", score);
        intent.putExtra("questions", new ArrayList<>(questions)); // Use ArrayList to make it Serializable
        startActivity(intent);
    }
}