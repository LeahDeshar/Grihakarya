package com.example.assignment.labassignment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.assignment.R;

public class LabSevenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab_seven);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
       if(item.getItemId() == R.id.action_settings) {
           Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT).show();
           return true;
       }
        else if (item.getItemId() == R.id.action_about) {
           Toast.makeText(this, "About selected", Toast.LENGTH_SHORT).show();
           return true;

       }else if(item.getItemId() == R.id.action_help){
           Toast.makeText(this, "Help selected", Toast.LENGTH_SHORT).show();
           return true;

       }
        else {

           return super.onOptionsItemSelected(item);
       }
    }
}