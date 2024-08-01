package com.example.assignment.Impquestions;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.assignment.R;

public class QUnit1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_qunit1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        String[] questions = {
                "1. What do you mean by mobile device? Explain its features.",
                "2. Explain different categories of mobile devices.",
                "3. Explain about history of mobile device in detail.",
                "4. Explain different brands, models and platforms of mobile devices in detail.",
                "5. What do you mean by mobile programming? Explain life cycle of mobile application development.",
                "6. List and explain any five popular programming languages used for developing mobile applications.",
                "7. What are different mobile app development approaches? Explain in detail.",
                "8. Discuss the advantages and disadvantages of using mobile devices.",
                "9. Compare and contrast smartphones and tablets in terms of their features and use cases.",
                "10. Explain the role of operating systems in mobile devices. Provide examples of popular mobile operating systems.",
                "11. Describe the evolution of mobile network technologies (e.g., 1G, 2G, 3G, 4G, 5G).",
                "12. How has the adoption of mobile devices impacted different sectors such as education, healthcare, and business?",
                "13. What are the key security concerns associated with mobile devices, and how can they be addressed?",
                "14. Discuss the impact of mobile device hardware advancements on application development and user experience.",
                "15. Explain the concept of mobile device management (MDM) and its importance in enterprise environments."
        };
        ListView listView = findViewById(R.id.questions_list_view);

        // Create an ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, questions);

        // Set the adapter to the ListView
        listView.setAdapter(adapter);
    }
}