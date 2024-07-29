package com.example.assignment.labassignment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.assignment.R;

public class LabThreeActivity extends AppCompatActivity {
    EditText nameEt,rollEt, addressEt;
    RadioGroup genderRg;
    Button submitBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab_three);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        nameEt = findViewById(R.id.etName);
        rollEt = findViewById(R.id.etRollNo);
        addressEt = findViewById(R.id.etAddress);
        submitBtn = findViewById(R.id.btnSubmit);
        genderRg = findViewById(R.id.rgGender);


        submitBtn.setOnClickListener(v -> {
            String name = nameEt.getText().toString();
            String roll = rollEt.getText().toString();
            String address = addressEt.getText().toString();
            int genderId = genderRg.getCheckedRadioButtonId();




            if(name.isEmpty() || roll.isEmpty() || address.isEmpty()){
                nameEt.setError("Please enter name");
                rollEt.setError("Please enter roll number");
                addressEt.setError("Please enter address");
            }else{
                Intent intent = new Intent(LabThreeActivity.this, LabThreeDetailsActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("roll", roll);
                intent.putExtra("address", address);

                   if(genderId == R.id.rbMale){
                       intent.putExtra("gender","Male");
                   }
                     else{

                       intent.putExtra("gender","Female");

                   }
                startActivity(intent);



            }



             });

    }
}