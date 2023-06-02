package com.example.oop_assessment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ViewGradeActivity extends AppCompatActivity {
    TextView tvLastName, tvFirstName, tvAttendance, tvQuiz1, tvQuiz2, tvQuiz3, tvQuiz4, tvExam, tvAverage, tvStatus, tvRemarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewgrade);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Grade View");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvLastName = findViewById(R.id.lastnameTv);
        tvFirstName = findViewById(R.id.firstnameTv);
        tvAttendance = findViewById(R.id.attendanceInt);
        tvQuiz1 = findViewById(R.id.quiz1Int);
        tvQuiz2 = findViewById(R.id.quiz2Int);
        tvQuiz3 = findViewById(R.id.quiz3Int);
        tvQuiz4 = findViewById(R.id.quiz4Int);
        tvExam = findViewById(R.id.examInt);
        tvAverage = findViewById(R.id.averageTv);
        tvStatus = findViewById(R.id.statusTv);
        tvRemarks = findViewById(R.id.remarksTv);

        Intent intent = getIntent();
        String lastName = intent.getStringExtra("lastName");
        String firstName = intent.getStringExtra("firstName");
        int attendance = intent.getIntExtra("attendance", 0);
        int quiz1 = intent.getIntExtra("quiz1", 0);
        int quiz2 = intent.getIntExtra("quiz2", 0);
        int quiz3 = intent.getIntExtra("quiz3", 0);
        int quiz4 = intent.getIntExtra("quiz4", 0);
        int exam = intent.getIntExtra("exam", 0);

        try {
            double average = calculateAverage(attendance, quiz1, quiz2, quiz3, quiz4, exam);
            String status = calculateStatus(average);
            String remarks = calculateRemarks(average);

            tvLastName.setText("Surname: " + lastName);
            tvFirstName.setText("First Name: " + firstName);
            tvAttendance.setText("Attendance: " + attendance);
            tvQuiz1.setText("Quiz 1: " + quiz1);
            tvQuiz2.setText("Quiz 2: " + quiz2);
            tvQuiz3.setText("Quiz 3: " + quiz3);
            tvQuiz4.setText("Quiz 4: " + quiz4);
            tvExam.setText("Exam: " + exam);
            tvAverage.setText("Average: " + String.format("%.2f", average));
            tvStatus.setText(status);
            tvRemarks.setText("Remarks: " + remarks);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Button btnBack = findViewById(R.id.vgbtnMenu);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewGradeActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private double calculateAverage(int attendance, int quiz1, int quiz2, int quiz3, int quiz4, int exam) {
        double average = attendance * 0.2 + (quiz1 + quiz2 + quiz3 + quiz4) / 4.0 * 0.3 + exam * 0.5;
        return average;
    }

    private String calculateStatus(double average) {
        if (average >= 60) {
            return "Passed";
        } else {
            return "Failed";
        }
    }

    private String calculateRemarks(double average) {
        if (average >= 96) {
            return "4.00";
        } else if (average >= 90) {
            return "3.50";
        } else if (average >= 84) {
            return "3.00";
        } else if (average >= 78) {
            return "2.50";
        } else if (average >= 72) {
            return "2.00";
        } else if (average >= 66) {
            return "1.50";
        } else if (average >= 60) {
            return "1.00";
        } else {
            return "INC";
        }
    }
}