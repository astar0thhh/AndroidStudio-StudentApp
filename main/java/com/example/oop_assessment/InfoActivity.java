package com.example.oop_assessment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class InfoActivity extends AppCompatActivity {
    EditText etlastName, etfirstName, etcourse, etyear, etemail, etcontactNumber, etbirthYear, etaddress;
    Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Info Submission");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etlastName = findViewById(R.id.surnametxt);
        etfirstName = findViewById(R.id.firstnametxt);
        etcourse = findViewById(R.id.coursetxt);
        etyear = findViewById(R.id.yearInt);
        etemail = findViewById(R.id.emailtxt);
        etcontactNumber = findViewById(R.id.contactnumInt);
        etbirthYear = findViewById(R.id.birthYearInt);
        btnSubmit = findViewById(R.id.submitbtn);
        etaddress = findViewById(R.id.addresstxt);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String surname = etlastName.getText().toString().trim();
                    String firstname = etfirstName.getText().toString().trim();
                    String courseTxt = etcourse.getText().toString().trim();
                    int yearLvl = Integer.parseInt(etyear.getText().toString().trim());
                    String emailTxt = etemail.getText().toString().trim();
                    String addressTxt = etaddress.getText().toString().trim();
                    int contactnumber = Integer.parseInt(etcontactNumber.getText().toString().trim());
                    int birthyear = Integer.parseInt(etbirthYear.getText().toString().trim());

                    if (surname.isEmpty() || firstname.isEmpty() || courseTxt.isEmpty() || emailTxt.isEmpty()) {
                        showToast("Please fill in all the required details.");
                    } else {
                        Intent intent = new Intent(InfoActivity.this, ViewInfoActivity.class);

                        intent.putExtra("lastName", surname);
                        intent.putExtra("firstName", firstname);
                        intent.putExtra("course", courseTxt);
                        intent.putExtra("year", yearLvl);
                        intent.putExtra("email", emailTxt);
                        intent.putExtra("address", addressTxt);
                        intent.putExtra("contactNumber", contactnumber);
                        intent.putExtra("birthYear", birthyear);
                        startActivity(intent);
                    }
                } catch (NumberFormatException e) {
                    showToast("Invalid Input. Please only enter numbers for year, contact number, and birth year.");
                }
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
