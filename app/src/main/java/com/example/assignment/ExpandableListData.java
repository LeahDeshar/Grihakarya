package com.example.assignment;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListData {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<>();

        List<String> group1 = getListing();


        List<String> group2 = new ArrayList<>();
        group2.add("Hello World");
        group2.add("Assignment 1");
        group2.add("Layout Exercise: Profile Book");
        group2.add("Layout Exercise: Profile Book Refined");
        group2.add("Widget Exercise");
        group2.add("Quiz Game");
        group2.add("Calculate Simple Interest");
        group2.add("Rectangle Calculation");
        group2.add("Calculator");
        group2.add("Design Login Form");
        group2.add("Design a Visiting card");
        group2.add("Design Table with Table Layout");

        group2.add("Example");

//        group2.add("Item 2.3");

        expandableListDetail.put("Course", group1);
        expandableListDetail.put("Assignment", group2);

        return expandableListDetail;
    }

    @NonNull
    private static List<String> getListing() {
        List<String> group1 = new ArrayList<>();
        group1.add("Unit-1 Introduction to Mobile Programming");
        group1.add("Unit-2 Introduction to Android Programming");
        group1.add("Unit-3 Designing the User Interface");
        group1.add("Unit-4 Android Activity");
        group1.add("Unit-5 Fragments, Menus and Dialogs");
        group1.add("Unit-6 ListView,GridView and RecyclerView");
        group1.add("Unit-7 Advance Android Concepts");
        group1.add("Unit-8 Introduction to ios Programming");
        return group1;
    }
}
