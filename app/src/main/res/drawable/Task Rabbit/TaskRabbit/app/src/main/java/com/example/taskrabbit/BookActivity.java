package com.example.taskrabbit;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class BookActivity extends AppCompatActivity {

    EditText e1, e2, e3, e4, e5, e6;
    Button btnBack, btnBook;

    private TimePickerDialog timePickerDialog;
    private DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        e1 = findViewById(R.id.editFullName);
        e2 = findViewById(R.id.editContactNumber);
        e3 = findViewById(R.id.editFess);
        e4 = findViewById(R.id.editAddress);
        e5 = findViewById(R.id.editTextTime);
        e6 = findViewById(R.id.editTextDate);
        btnBack = findViewById(R.id.cancel_button);
        btnBook = findViewById(R.id.book);

        e1.setKeyListener(null);
        e2.setKeyListener(null);
        e3.setKeyListener(null);

        Intent it = getIntent();
        String name = it.getStringExtra("text1");
        String contact = it.getStringExtra("text2");
        String fees = it.getStringExtra("text3");

        e1.setText(name);
        e2.setText(contact);
        e3.setText("Fees: " + fees + "/-");

        initTimePicker();
        e5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog.show();
            }
        });

        initDatePicker();
        e6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BookActivity.this, HomeActivity.class));
            }
        });

        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (e4.getText().toString().isEmpty()) {
                    Toast.makeText(BookActivity.this, "Please enter your address.", Toast.LENGTH_SHORT).show();
                } else if (e5.getText().toString().isEmpty()) {
                    Toast.makeText(BookActivity.this, "Please select a time.", Toast.LENGTH_SHORT).show();
                } else if (e6.getText().toString().isEmpty()) {
                    Toast.makeText(BookActivity.this, "Please select a date.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(BookActivity.this, "Appointment Booked!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(BookActivity.this, HomeActivity.class));
                }
            }
        });
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                e6.setText(day + "/" + month + "/" + year);
            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        datePickerDialog = new DatePickerDialog(this, dateSetListener, year, month, day);
        datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis() + 86400000); // +1 day
    }

    private void initTimePicker() {
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                e5.setText(String.format("%02d:%02d", hourOfDay, minute));
            }
        };

        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);

        timePickerDialog = new TimePickerDialog(this, timeSetListener, hour, minute, true);
    }
}
