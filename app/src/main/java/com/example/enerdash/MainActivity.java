package com.example.enerdash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.security.InvalidParameterException;

public class MainActivity extends AppCompatActivity {
    //Constantes
    private static final String TAG = MainActivity.class.getName();
    public static final String EMAIL_KEY = "EMAIL";
    public static final String PASSWORD_KEY = "PASSWORD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setup();
    }

    private void setup() {
        Button btn = findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToMain();
            }
        });
    }

    private void navigateToMain() {

        Intent intent = new Intent(this, CatalogoActivity.class);
        startActivity(intent);
    }
}