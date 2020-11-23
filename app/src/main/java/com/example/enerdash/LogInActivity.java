package com.example.enerdash;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.enerdash.Data.UserConfig;
import com.example.enerdash.Modelos.UserModel;
import com.google.android.material.textfield.TextInputLayout;

import java.security.InvalidParameterException;

public class LogInActivity extends AppCompatActivity {
    TextInputLayout tilEmail, tilPw;
    EditText etEmail, etPw;

    UserModel userModel;

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
                signIn();
            }
        });
    }

    private void signIn() {
        if(!validateFields()) {
            return;
        }
        userModel = new UserModel(etEmail.getText().toString(), etPw.getText().toString());
        saveUser(userModel);
        navigateToMain(userModel);
    }

    private void saveUser(UserModel user) {
        UserConfig userConfig = new UserConfig(getApplicationContext());
        userConfig.setUser(user);
    }

    private void navigateToMain(UserModel user) {
        Intent intent = new Intent(this, MainActivity.class);
        //la proxima activity ahora será la primera en el back stack
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(MainActivity.EMAIL_KEY, user.getEmail());
        intent.putExtra(MainActivity.PASSWORD_KEY, user.getPassword());
        startActivity(intent);
    }

    private boolean validateFields() {
        if(etEmail.getText() == null || TextUtils.isEmpty(etEmail.getText().toString())) {
            showMessage("Favor ingresa tu email.");
            return false;
        }
        if(etPw.getText() == null || TextUtils.isEmpty(etPw.getText().toString())) {
            showMessage("Favor ingresa tu contraseña.");
            return false;
        }
        showMessage("¡Bienvenido!");
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
