package com.example.assignment.labassignment;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.assignment.R;

public class Lab14Activity extends AppCompatActivity {
    private ContactDatabaseHelper dbHelper;
    private EditText nameEditText, phoneEditText, idEditText;
    private ImageView  viewButton, updateButton, deleteButton;
    private ImageView addButton;
    private ListView contactListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab14);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        dbHelper = new ContactDatabaseHelper(this);

        nameEditText = findViewById(R.id.nameEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        idEditText = findViewById(R.id.idEditText);
        addButton = findViewById(R.id.addButton);
        viewButton = findViewById(R.id.viewButton);
        updateButton = findViewById(R.id.updateButton);
        deleteButton = findViewById(R.id.deleteButton);
        contactListView = findViewById(R.id.contactListView);

        addButton.setOnClickListener(v -> addContact());
        viewButton.setOnClickListener(v -> viewContacts());
        updateButton.setOnClickListener(v -> updateContact());
        deleteButton.setOnClickListener(v -> deleteContact());
    }
    private void addContact() {
        String name = nameEditText.getText().toString();
        String phone = phoneEditText.getText().toString();
        if (dbHelper.addContact(name, phone)) {
            Toast.makeText(this, "Contact added", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Failed to add contact", Toast.LENGTH_SHORT).show();
        }
    }

    private void viewContacts() {
        Cursor cursor = dbHelper.getAllContacts();
        String[] from = { "name", "phone" };
        int[] to = { R.id.nameTextView, R.id.phoneTextView };
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(Lab14Activity.this, R.layout.contact_item, cursor, from, to, 0);
        contactListView.setAdapter(adapter);
    }

    private void updateContact() {
        int id = Integer.parseInt(idEditText.getText().toString());
        String name = nameEditText.getText().toString();
        String phone = phoneEditText.getText().toString();
        if (dbHelper.updateContact(id, name, phone)) {
            Toast.makeText(this, "Contact updated", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Failed to update contact", Toast.LENGTH_SHORT).show();
        }
    }

    private void deleteContact() {
        int id = Integer.parseInt(idEditText.getText().toString());
        if (dbHelper.deleteContact(id)) {
            Toast.makeText(this, "Contact deleted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Failed to delete contact", Toast.LENGTH_SHORT).show();
        }
    }
}