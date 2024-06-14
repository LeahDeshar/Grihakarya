package com.example.assignment;

import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TextActivity extends AppCompatActivity {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_text);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

//        TextView titleTextView = findViewById(R.id.titleTextView);
//        String title = getIntent().getStringExtra("title");
//        titleTextView.setText(title);


        expListView = (ExpandableListView) findViewById(R.id.expandableListView);

        // preparing list data
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        // Adding child data
        listDataHeader.addAll(ExpandableListData.getData().keySet());

        // Adding child data
        listDataChild.putAll(ExpandableListData.getData());

        // setting list adapter
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);
    }
}