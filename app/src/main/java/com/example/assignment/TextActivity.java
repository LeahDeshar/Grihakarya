package com.example.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.example.assignment.UnitEight.UnitEightActivity;
import com.example.assignment.UnitFive.UnitFiveActivity;
import com.example.assignment.UnitFour.UnitFourActivity;
import com.example.assignment.UnitOne.ViewPagerAdapter;
import com.example.assignment.UnitSeven.UnitSevenActivity;
import com.example.assignment.UnitSix.UnitSixActivity;
import com.example.assignment.UnitThree.UnitThreeActivity;
import com.example.assignment.UnitTwo.UnitTwoActivity;
import com.example.assignment.UnitOne.unitOne;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TextActivity extends AppCompatActivity {

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

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        ViewPager2 viewPager = findViewById(R.id.view_pager);

        // Set up the adapter for ViewPager2
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);

        // Connect the TabLayout with ViewPager2
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Unit 1");
                    break;
                case 1:
                    tab.setText("Unit 2");
                    break;
                case 2:
                    tab.setText("Unit 3");
                    break;
                // Add more cases as needed
            }
        }).attach();

    }
}