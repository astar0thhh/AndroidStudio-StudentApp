package com.example.oop_assessment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class GradeActivity extends AppCompatActivity {
    EditText etLastName, etFirstName, etAttendance, etQuiz1, etQuiz2, etQuiz3, etQuiz4, etExam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Grade Activity");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etLastName = findViewById(R.id.surnametxt);
        etFirstName = findViewById(R.id.firstnametxt);
        etAttendance = findViewById(R.id.attendanceInt);
        etQuiz1 = findViewById(R.id.quiz1Int);
        etQuiz2 = findViewById(R.id.quiz2Int);
        etQuiz3 = findViewById(R.id.quiz3Int);
        etQuiz4 = findViewById(R.id.quiz4Int);
        etExam = findViewById(R.id.examInt);

        Button btnCalculate = findViewById(R.id.submitbtn);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String lastName = etLastName.getText().toString();
                    String firstName = etFirstName.getText().toString();
                    String attendanceStr = etAttendance.getText().toString();
                    String quiz1Str = etQuiz1.getText().toString();
                    String quiz2Str = etQuiz2.getText().toString();
                    String quiz3Str = etQuiz3.getText().toString();
                    String quiz4Str = etQuiz4.getText().toString();
                    String examStr = etExam.getText().toString();

                    if (lastName.isEmpty() || firstName.isEmpty() || attendanceStr.isEmpty()
                            || quiz1Str.isEmpty() || quiz2Str.isEmpty() || quiz3Str.isEmpty()
                            || quiz4Str.isEmpty() || examStr.isEmpty()) {
                        Toast.makeText(GradeActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    } else {
                        int attendance = Integer.parseInt(attendanceStr);
                        int quiz1 = Integer.parseInt(quiz1Str);
                        int quiz2 = Integer.parseInt(quiz2Str);
                        int quiz3 = Integer.parseInt(quiz3Str);
                        int quiz4 = Integer.parseInt(quiz4Str);
                        int exam = Integer.parseInt(examStr);

                        if (attendance < 1 || attendance > 100 || quiz1 < 1 || quiz1 > 100
                                || quiz2 < 1 || quiz2 > 100 || quiz3 < 1 || quiz3 > 100
                                || quiz4 < 1 || quiz4 > 100 || exam < 1 || exam > 100) {
                            Toast.makeText(GradeActivity.this, "Invalid input. The values must be between 1 and 100", Toast.LENGTH_SHORT).show();
                        } else {
                            Intent intent = new Intent(GradeActivity.this, ViewGradeActivity.class);
                            intent.putExtra("lastName", lastName);
                            intent.putExtra("firstName", firstName);
                            intent.putExtra("attendance", attendance);
                            intent.putExtra("quiz1", quiz1);
                            intent.putExtra("quiz2", quiz2);
                            intent.putExtra("quiz3", quiz3);
                            intent.putExtra("quiz4", quiz4);
                            intent.putExtra("exam", exam);
                            startActivity(intent);
                        }
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(GradeActivity.this, "Invalid input. Please enter numeric values for attendance, quizzes, and exam", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    }

