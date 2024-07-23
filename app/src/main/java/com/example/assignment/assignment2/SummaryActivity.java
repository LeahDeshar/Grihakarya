package com.example.assignment.assignment2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.assignment.R;

import java.util.List;

public class SummaryActivity extends AppCompatActivity {
    private TextView summaryTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_summary);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        summaryTextView = findViewById(R.id.summary_text_view);

        // Get the data passed from the QuizGameActivity
        int score = getIntent().getIntExtra("score", 0);
        List<Question> questions = (List<Question>) getIntent().getSerializableExtra("questions");

        // Display the summary
        displaySummary(score, questions);
    }
    private void displaySummary(int score, List<Question> questions) {
        StringBuilder summary = new StringBuilder();
        summary.append("Your score is: ").append(score).append("/").append(questions.size()).append("\n\n");

        for (Question question : questions) {
            summary.append(question.getQuestionText()).append("\n");
            summary.append("Correct answer: ").append(question.getOptions()[question.getCorrectAnswerIndex()]).append("\n\n");
        }

        summaryTextView.setText(summary.toString());
    }
}