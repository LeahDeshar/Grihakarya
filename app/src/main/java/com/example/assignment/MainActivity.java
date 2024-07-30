package com.example.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat.Type;
import androidx.core.view.WindowInsetsControllerCompat;
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
import com.example.assignment.assignment2.CalculatorActivity;
import com.example.assignment.assignment2.QuizGameActivity;
import com.example.assignment.assignment2.RectCalculateActivity;
import com.example.assignment.assignment2.SimpleInterestActivity;
import com.example.assignment.labassignment.LabEightActivity;
import com.example.assignment.labassignment.LabFiveActivity;
import com.example.assignment.labassignment.LabFourActivity;
import com.example.assignment.labassignment.LabNineActivity;
import com.example.assignment.labassignment.LabOneActivity;
import com.example.assignment.labassignment.LabSevenActivity;
import com.example.assignment.labassignment.LabSixActivity;
import com.example.assignment.labassignment.LabThreeActivity;
import com.example.assignment.labassignment.LabThreeDetailsActivity;
import com.example.assignment.labassignment.LabTwoActivity;
import com.example.assignment.layoutExample.ProfileBookActivity;
import com.example.assignment.layoutExample.ProfileBookRefineActivity;
import com.example.assignment.widget.WidgetActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enable edge-to-edge display
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);

        // Set window insets listener to adjust padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//

            return insets;
        });



        expListView = (ExpandableListView) findViewById(R.id.expandableListView);


        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();


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
            case "Hello World":
                return new HelloWorldActivity();
            case "Assignment 1":
                return new AssignmentDetailsActivity();
            case "Layout Exercise: Profile Book":
                return new ProfileBookActivity();
            case "Layout Exercise: Profile Book Refined":
                return new ProfileBookRefineActivity();
            case "Calculate Simple Interest":
                return new SimpleInterestActivity();
            case "Rectangle Calculation":
                return new RectCalculateActivity();
            case "Calculator":
                return new CalculatorActivity();
            case "Widget Exercise":
                return new WidgetActivity();
            case "Quiz Game":
                return new QuizGameActivity();
            case "Design Login Form":
                return new LabOneActivity();
            case "Design a Visiting card":
                return new LabTwoActivity();
            case "Develop form to fill-in student information":
                return new LabThreeActivity();
            case "Example":
                return new TextActivity();
            case "Design Table with Table Layout":
                return new LabFourActivity();
            case "Save phone number":
                return new LabFiveActivity();
            case "Get a secret message ":
                return new LabSixActivity();
            case "Options menu":
                return new LabSevenActivity();
             case "Context menu":
                 return new LabEightActivity();
            case "Popup menu":
                return new LabNineActivity();


            default:
                Toast.makeText(this, "No Screen", Toast.LENGTH_SHORT).show();
                return this;
        }

    }
}