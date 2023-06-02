package com.example.oop_assessment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Calendar;

public class ViewInfoActivity extends AppCompatActivity {
    TextView tvLastName, tvFirstName, tvCourse, tvYear, tvEmail, tvContactNumber, tvBirthYear, tvaddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewinfo);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Student Information");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvLastName = findViewById(R.id.surnameTv);
        tvFirstName = findViewById(R.id.firstnameTv);
        tvCourse = findViewById(R.id.courseTv);
        tvYear = findViewById(R.id.yearTv);
        tvEmail = findViewById(R.id.emailTv);
        tvaddress = findViewById(R.id.addressTv);
        tvContactNumber = findViewById(R.id.contactNumTv);
        tvBirthYear = findViewById(R.id.birthYearTv);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            try {
                String lastName = extras.getString("lastName");
                String firstName = extras.getString("firstName");
                String course = extras.getString("course");
                int year = extras.getInt("year");
                String email = extras.getString("email");
                String address = extras.getString("address");
                int contactNumber = extras.getInt("contactNumber");
                int birthYear = extras.getInt("birthYear");

                int currentYear = Calendar.getInstance().get(Calendar.YEAR);
                int age = currentYear - birthYear;

                tvLastName.setText("Surname: " + lastName);
                tvFirstName.setText("First Name: " + firstName);
                tvCourse.setText("Course: " + course);
                tvYear.setText("Year Level: " + year);
                tvEmail.setText("Email: " + email);
                tvaddress.setText("Address: " + address);
                tvContactNumber.setText("Contact Number: " + contactNumber);
                tvBirthYear.setText("Date of Birth: " + birthYear);
                TextView tvAge = findViewById(R.id.ageTv);
                tvAge.setText("Age: " + age);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        Button btnBackToMenu = findViewById(R.id.vgbtnMenu);
        btnBackToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewInfoActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
