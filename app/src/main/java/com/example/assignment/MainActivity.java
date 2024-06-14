package com.example.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.assignment.Assignment1.AssignmentDetailsActivity;
import com.example.assignment.Hello.HelloWorldActivity;
import com.example.assignment.UnitEight.UnitEightActivity;
import com.example.assignment.UnitFive.UnitFiveActivity;
import com.example.assignment.UnitFour.UnitFourActivity;
import com.example.assignment.UnitOne.unitOne;
import com.example.assignment.UnitSeven.UnitSevenActivity;
import com.example.assignment.UnitSix.UnitSixActivity;
import com.example.assignment.UnitThree.UnitThreeActivity;
import com.example.assignment.UnitTwo.UnitTwoActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
//    private ListView listView;
//    private String[] titles = {"Hello World", "Assignment:1", "Coming Soon"};
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

//        listView = findViewById(R.id.listView);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titles);
//        listView.setAdapter(adapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                String title = titles[position];
//                Intent intent;
//                switch (title) {
//                    case "Hello World":
//                         intent = new Intent(MainActivity.this, HelloWorldActivity.class);
//                        intent.putExtra("title", title);
//                        startActivity(intent);
//                        break;
//                    case "Assignment:1":
//                         intent = new Intent(MainActivity.this, AssignmentDetailsActivity.class);
//                        intent.putExtra("title", title);
//                        startActivity(intent);
//                        break;
//                    case "Coming Soon":
//                        intent = new Intent(MainActivity.this, TextActivity.class);
//                        intent.putExtra("title", title);
//                        startActivity(intent);
//                        break;
//                    default:
//                        // Handle default case
//                        break;
//                }
//            }
//
//        });

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


        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                // Handle click action, for example, navigate to corresponding activity
                String selectedUnit = listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);

                // Create an intent to navigate to the corresponding activity
                Intent intent = new Intent(MainActivity.this, getCorrespondingActivity(selectedUnit).getClass());
                startActivity(intent);

                return true;
            }
        });
    }

    private AppCompatActivity getCorrespondingActivity(String selectedUnit) {
        switch (selectedUnit) {
            case "Unit-1 Introduction to Mobile Programming":
                return new unitOne();
            case "Unit-2 Introduction to Android Programming":
                return new UnitTwoActivity();
            case "Unit-3 Designing the User Interface":
                return new UnitThreeActivity();
            case "Unit-4 Android Activity":
                return new UnitFourActivity();
            case "Unit-5 Fragments, Menus and Dialogs":
                return new UnitFiveActivity();
            case "Unit-6 ListView,GridView and RecyclerView":
                return new UnitSixActivity();
            case "Unit-7 Advance Android Concepts":
                return new UnitSevenActivity();
            case "Unit-8 Introduction to ios Programming":
                return new UnitEightActivity();

            default:
                return this;
        }

    }
}