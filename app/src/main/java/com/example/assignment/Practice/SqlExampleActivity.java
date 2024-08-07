package com.example.assignment.Practice;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.assignment.MainActivity;
import com.example.assignment.R;

public class SqlExampleActivity extends AppCompatActivity {
    private EditText nameEditText, phoneEditText;
    private Button addButton, viewButton, updateButton, deleteButton;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sql_example);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        nameEditText = findViewById(R.id.nameEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        addButton = findViewById(R.id.addButton);
        viewButton = findViewById(R.id.viewButton);
        updateButton = findViewById(R.id.updateButton);
        deleteButton = findViewById(R.id.deleteButton);

        dbHelper = new DatabaseHelper(this);


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String phone = phoneEditText.getText().toString();
                if (!name.isEmpty() && !phone.isEmpty()) {
                    long result = dbHelper.addContact(name, phone);
                    if (result != -1) {
                        Toast.makeText(SqlExampleActivity.this, "Contact Added", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(SqlExampleActivity.this, "Error Adding Contact", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(SqlExampleActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

        viewButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Range")
            @Override
            public void onClick(View v) {
                Cursor cursor = dbHelper.getAllContacts();
                if (cursor.getCount() == 0) {
                    Toast.makeText(SqlExampleActivity.this, "No contacts found", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuilder builder = new StringBuilder();
                while (cursor.moveToNext()) {
                    builder.append("ID: ").append(cursor.getLong(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID)))
                            .append(", Name: ").append(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME)))
                            .append(", Phone: ").append(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_PHONE)))
                            .append("\n");
                }
                Toast.makeText(SqlExampleActivity.this, builder.toString(), Toast.LENGTH_LONG).show();
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // For demo purposes, updating contact with ID 1
                long id = 1;
                String name = nameEditText.getText().toString();
                String phone = phoneEditText.getText().toString();
                if (!name.isEmpty() && !phone.isEmpty()) {
                    int result = dbHelper.updateContact(id, name, phone);
                    if (result > 0) {
                        Toast.makeText(SqlExampleActivity.this, "Contact Updated", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(SqlExampleActivity.this, "Error Updating Contact", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(SqlExampleActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // For demo purposes, deleting contact with ID 1
                long id = 1;
                int result = dbHelper.deleteContact(id);
                if (result > 0) {
                    Toast.makeText(SqlExampleActivity.this, "Contact Deleted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SqlExampleActivity.this, "Error Deleting Contact", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}