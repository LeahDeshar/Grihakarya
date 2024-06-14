package com.example.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.assignment.UnitOne.UnitThreeActivity;
import com.example.assignment.UnitOne.UnitTwoActivity;
import com.example.assignment.UnitOne.unitOne;

import org.w3c.dom.Text;

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

//


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

//        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//
//            @Override
//            public boolean onChildClick(ExpandableListView parent, View v,
//                                        int groupPosition, int childPosition, long id) {
//
//                // Handle click action, for example, navigate to another activity
//                String selectedChild = (String) listAdapter.getChild(groupPosition, childPosition);
//
//                // Create an intent to navigate to another activity (replace SecondActivity with your activity class)
//                Intent intent = new Intent(TextActivity.this, unitOne.class);
//                // Pass any data to the new activity if needed
//                intent.putExtra("childText", selectedChild);
//                startActivity(intent);
//
//                return true; // Return true to indicate the click was handled
//            }
//        });
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                // Handle click action, for example, navigate to corresponding activity
                String selectedUnit = listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);

                // Create an intent to navigate to the corresponding activity
                Intent intent = new Intent(TextActivity.this, getCorrespondingActivity(selectedUnit).getClass());
                startActivity(intent);

                return true; // Return true to indicate the click was handled
            }
        });
    }

    // Helper method to return corresponding activity based on selected unit
    private AppCompatActivity getCorrespondingActivity(String selectedUnit) {
        switch (selectedUnit) {
            case "Unit-1 Introduction to Mobile Programming":
                return new unitOne();
            case "Unit-2 Introduction to Android Programming":
                return new UnitTwoActivity();
            case "Unit-3 Designing the User Interface":
                return new UnitThreeActivity();

            // Add cases for other units as needed
            default:
                // Default to MainActivity if no corresponding activity found (optional)
                return this;
        }


    }
}