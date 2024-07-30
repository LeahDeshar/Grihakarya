package com.example.assignment.labassignment;

import android.app.Dialog;
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

import com.example.assignment.R;

public class Lab11Activity extends AppCompatActivity {
    private Button showDialogBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab11);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        showDialogBtn = findViewById(R.id.show_dialog_btn);
        showDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog();
            }
        });
    }
    private void showCustomDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_calculate_area);

        final EditText widthInput = dialog.findViewById(R.id.width_input);
        final EditText heightInput = dialog.findViewById(R.id.height_input);
        Button calculateButton = dialog.findViewById(R.id.calculate_button);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String widthStr = widthInput.getText().toString();
                String heightStr = heightInput.getText().toString();

                if (!widthStr.isEmpty() && !heightStr.isEmpty()) {
                    double width = Double.parseDouble(widthStr);
                    double height = Double.parseDouble(heightStr);
                    double area = width * height;
                    Toast.makeText(Lab11Activity.this, "Area: " + area, Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                } else {
                    Toast.makeText(Lab11Activity.this, "Please enter both width and height", Toast.LENGTH_SHORT).show();
                }
            }
        });

        dialog.show();
    }
}