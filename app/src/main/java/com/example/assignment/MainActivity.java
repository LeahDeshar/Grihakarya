package com.example.assignment;

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

import com.example.assignment.Assignment1.AssignmentDetailsActivity;
import com.example.assignment.Hello.HelloWorldActivity;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private String[] titles = {"Hello World", "Assignment:1", "Coming Soon"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listView = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titles);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String title = titles[position];
                Intent intent;
                switch (title) {
                    case "Hello World":
                         intent = new Intent(MainActivity.this, HelloWorldActivity.class);
                        intent.putExtra("title", title);
                        startActivity(intent);
                        break;
                    case "Assignment:1":
                         intent = new Intent(MainActivity.this, AssignmentDetailsActivity.class);
                        intent.putExtra("title", title);
                        startActivity(intent);
                        break;
                    case "Coming Soon":
                        intent = new Intent(MainActivity.this, TextActivity.class);
                        intent.putExtra("title", title);
                        startActivity(intent);
                        break;
                    default:
                        // Handle default case
                        break;
                }
            }

        });
    }
}