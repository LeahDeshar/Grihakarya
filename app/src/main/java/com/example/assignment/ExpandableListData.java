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
        group2.add("Develop form to fill-in student information");
        group2.add("Save phone number");
        group2.add("Get a secret message ");
        group2.add("Options menu");
        group2.add("Context menu");
        group2.add("Popup menu");
        group2.add("Alert Dialog");
        group2.add("Area of a rectangle in a custom dialog");
        group2.add("Image gallery using GridView");
        group2.add("Image gallery using RecyclerView");
        group2.add("Contact App using SQLite");
        group2.add("Working with API");
        group2.add("Search action");
        group2.add("Sqlite example");
        group2.add("Example");

//        group2.add("Item 2.3");


        List<String> group3 = new ArrayList<>();
        group3.add("Q: Introduction to Mobile Programming");
        group3.add("Q: Introduction to Android Programming");
        group3.add("Q: Designing the User Interface");
        group3.add("Q: Android Activity");
        group3.add("Q: Fragments, Menus and Dialogs");
        group3.add("Q: ListView,GridView and RecyclerView");
        group3.add("Q: Advance Android Concepts");
        group3.add("Q: Introduction to ios Programming");

        expandableListDetail.put("Course", group1);
        expandableListDetail.put("Assignment", group2);
        expandableListDetail.put("Important Question", group3);


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
