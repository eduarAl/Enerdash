package com.example.enerdash;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.security.InvalidParameterException;

public class LogInActivity extends AppCompatActivity {
    TextInputLayout tilEmail, tilPw;
    EditText etEmail, etPw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setup();
    }

    private void setup() {
        tilEmail = findViewById(R.id.til_user);
        tilPw = findViewById(R.id.til_pw);

        etEmail = tilEmail.getEditText();
        etPw = tilPw.getEditText();

        Button btnAcceder = findViewById(R.id.btn_acces);
        btnAcceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToMain();
            }
        });
    }

    private void navigateToMain() {
        if(!validateFields()) {
            return;
        }

        if(etEmail.getText() == null || etPw.getText() == null)
            throw new InvalidParameterException();

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(MainActivity.EMAIL_KEY, etEmail.getText().toString());
        intent.putExtra(MainActivity.PASSWORD_KEY, etPw.getText().toString());
        startActivity(intent);
    }

    private boolean validateFields() {
        if(etEmail.getText() == null || TextUtils.isEmpty(etEmail.getText().toString())) {
            showMessage("Favor ingresa tu email.)");
            return false;
        }
        if(etPw.getText() == null || TextUtils.isEmpty(etPw.getText().toString())) {
            showMessage("Favor ingresa tu contraseña.)");
            return false;
        }

        showMessage("Todo correcto, ¡gracias!");
        return true;
    }

    private void showMessage(String message) {
        Toast.makeText(
                this,
                message,
                Toast.LENGTH_LONG
        ).show();
    }
}
