package com.example.oop_assessment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usernameText, passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Student Login");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        Button btnlogIn = findViewById(R.id.button);
        usernameText = findViewById(R.id.txtUserName);
        passwordText = findViewById(R.id.txtPassword);

        btnlogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameText.getText().toString();
                String password = passwordText.getText().toString();

                try {
                    
                    if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                        throw new IllegalArgumentException("Username or password cannot be empty.");
                    }
                    if (username.equals("ferrari") && password.equals("schumacher")) {
                        Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                        startActivity(intent);
                    } else {
                        throw new IllegalArgumentException("Incorrect username or password.");
                    }
                } catch (IllegalArgumentException e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        resetTextFields();
    }

    private void resetTextFields() {
        usernameText.setText("");
        passwordText.setText("");
    }
}
