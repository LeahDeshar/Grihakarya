package com.example.assignment.assignment2;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.assignment.R;

import java.util.List;

public class SummaryActivity extends AppCompatActivity {
    private LinearLayout summaryLayout;
    private ImageView resultImageView;


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

        summaryLayout = findViewById(R.id.summary_layout);
        resultImageView = findViewById(R.id.result_image_view);

        // Get the data passed from the QuizGameActivity
        int score = getIntent().getIntExtra("score", 0);
        List<Question> questions = (List<Question>) getIntent().getSerializableExtra("questions");


        setResultImage(score);
        // Display the summary
        displaySummary(score, questions);
    }
    private void setResultImage(int score) {
        int imageResource;
        if (score == 10) {
            imageResource = R.drawable.winner;
        } else if (score == 9) {
            imageResource = R.drawable.runnerup;
        }
     else {
            imageResource = R.drawable.extra;
        }
        resultImageView.setImageResource(imageResource);
    }
    private void displaySummary(int score, List<Question> questions) {
        TextView scoreTextView = new TextView(this);
        scoreTextView.setText("Your score is: " + score + "/" + questions.size());
        scoreTextView.setGravity(Gravity.CENTER);
        scoreTextView.setTextSize(24);
        scoreTextView.setTextColor(getResources().getColor(R.color.black));
        scoreTextView.setPadding(0, 0, 0, 16);
        summaryLayout.addView(scoreTextView);



        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);

            TextView questionTextView = new TextView(this);
            questionTextView.setText((i + 1) + ". " + question.getQuestionText());
            questionTextView.setTextSize(18);
            questionTextView.setTextColor(getResources().getColor(R.color.black));
            questionTextView.setPadding(0, 8, 0, 8);
            summaryLayout.addView(questionTextView);

            TextView answerTextView = new TextView(this);
            answerTextView.setText("Correct answer: " + question.getOptions()[question.getCorrectAnswerIndex()]);
            answerTextView.setTextSize(16);
            answerTextView.setTextColor(getResources().getColor(R.color.green));
            answerTextView.setPadding(0, 0, 0, 16);
            summaryLayout.addView(answerTextView);
        }

//        int totalQuestions = questions.size();
//        for (Question question : questions) {
//            TextView questionTextView = new TextView(this);
////            set the text with the question number and the question text
//
////            questionTextView.setText(totalQuestions  + ")" + question.getQuestionText());
//            questionTextView.setTextSize(18);
//            questionTextView.setTextColor(getResources().getColor(R.color.black));
//            questionTextView.setPadding(0, 8, 0, 8);
//            summaryLayout.addView(questionTextView);
//
//            TextView answerTextView = new TextView(this);
//            answerTextView.setText("Correct answer: " + question.getOptions()[question.getCorrectAnswerIndex()]);
//            answerTextView.setTextSize(16);
//            answerTextView.setTextColor(getResources().getColor(R.color.primary));
//            answerTextView.setPadding(0, 0, 0, 16);
//            summaryLayout.addView(answerTextView);
//        }
    }
}