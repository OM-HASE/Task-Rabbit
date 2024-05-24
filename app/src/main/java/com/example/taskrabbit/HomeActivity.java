package com.example.taskrabbit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homeactivity);

        CardView electrician = findViewById(R.id.electrician);
        electrician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ElectricianActivity.class));
            }
        });

        CardView plumber = findViewById(R.id.plumber);
        plumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, PlumberActivity.class));
            }
        });

        CardView carpenter = findViewById(R.id.carpenter);
        carpenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, CarpenterActivity.class));
            }
        });

        CardView home_cleaning = findViewById(R.id.home_cleaning);
        home_cleaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, HomeCleaningActivity.class));
            }
        });

        CardView pest_control = findViewById(R.id.pest_control);
        pest_control.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, PestControlActivity.class));
            }
        });

        CardView gardener = findViewById(R.id.gardener);
        gardener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, GardenerActivity.class));
            }
        });

        Button logOutButton = findViewById(R.id.log_out);
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logOut();
            }
        });
    }

    private void logOut() {
        Toast.makeText(HomeActivity.this, "Logged Out Successfully", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
