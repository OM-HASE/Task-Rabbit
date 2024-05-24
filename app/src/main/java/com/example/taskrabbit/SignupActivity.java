package com.example.taskrabbit;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    EditText Name, Email, Password, ComPassword;
    Button SignUp;
    TextView Login;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signupactivity);

        Name = findViewById(R.id.editTextName);
        Email = findViewById(R.id.editTextTextEmail1);
        Password = findViewById(R.id.editTextPassword1);
        ComPassword = findViewById(R.id.editTextPassword2);
        SignUp = findViewById(R.id.button);
        Login = findViewById(R.id.login);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
            }
        });

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = Name.getText().toString();
                String email = Email.getText().toString();
                String password = Password.getText().toString();
                String compassword = ComPassword.getText().toString();
                DataBase db = new DataBase(getApplicationContext());

                if (name.isEmpty() || email.isEmpty() || password.isEmpty() || compassword.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Please Fill All Details", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if (password.equals(compassword))
                    {
                        if (isValid(password))
                        {
                            db.register(name, email, password);
                            Toast.makeText(getApplicationContext(), "Record Inserted", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "Password must contain at least 8 characters, including a letter, a digit, and a special symbol", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Password and Confirm Password didn't match.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public static boolean isValid(String password) {
        int f1 = 0, f2 = 0, f3 = 0;
        if (password.length() < 8)
        {
            return false;
        }
        else
        {
            for (int i = 0; i < password.length(); i++)
            {
                if (Character.isLetter(password.charAt(i)))
                {
                    f1 = 1;
                }
            }

            for (int j = 0; j < password.length(); j++)
            {
                if (Character.isDigit(password.charAt(j)))
                {
                    f2 = 1;
                }
            }

            for (int k = 0; k < password.length(); k++)
            {
                char c = password.charAt(k);
                if ((c >= 33 && c <= 46) || c == 64)
                {
                    f3 = 1;
                }
            }
        }
        return f1 == 1 && f2 == 1 && f3 == 1;
    }
}
