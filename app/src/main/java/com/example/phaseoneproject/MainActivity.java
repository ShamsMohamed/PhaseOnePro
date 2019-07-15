package com.example.phaseoneproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mButtonAboutAlc;
    private Button mButtonMyProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonAboutAlc = findViewById(R.id.btn_about_alc);
        mButtonMyProfile = findViewById(R.id.btn_my_profile);

        mButtonAboutAlc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AboutAlcActivity.class);
                startActivity(intent);
            }
        });

        mButtonMyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MyProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}
