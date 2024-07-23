package com.example.assignment.assignment2;

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
    private TextView questionTextView;
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
        option1Button = findViewById(R.id.option1_button);
        option2Button = findViewById(R.id.option2_button);
        option3Button = findViewById(R.id.option3_button);
        option4Button = findViewById(R.id.option4_button);

        loadQuestions();
        displayQuestion();
    }
    private void loadQuestions() {
        questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?", new String[]{"Berlin", "Madrid", "Paris", "Lisbon"}, 2));
        questions.add(new Question("Who wrote 'Hamlet'?", new String[]{"Charles Dickens", "William Shakespeare", "Mark Twain", "Leo Tolstoy"}, 1));
        // Add more questions as needed
    }

    private void displayQuestion() {
        if (currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);
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

    private void showScore() {
        Toast.makeText(this, "Your score is: " + score + "/" + questions.size(), Toast.LENGTH_LONG).show();
    }
}