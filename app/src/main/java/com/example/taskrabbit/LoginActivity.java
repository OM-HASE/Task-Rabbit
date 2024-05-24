package com.example.taskrabbit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText edEmail;
    EditText edPassword;
    Button Login;
    TextView Signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivity);

        edEmail = findViewById(R.id.editTextLoginEmail);
        edPassword = findViewById(R.id.editTextLoginPassword);
        Login = findViewById(R.id.LoginButton);
        Signup = findViewById(R.id.SignText);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = edEmail.getText().toString();
                String Password = edPassword.getText().toString();
                DataBase db = new DataBase(getApplicationContext());

                if (Email.isEmpty() || Password.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Please Fill All Details", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (db.login(Email, Password) == 1)
                    {
                        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "User Doesn't Exit Create A Account.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
            }
        });
    }
}
