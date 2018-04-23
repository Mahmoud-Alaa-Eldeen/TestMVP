package com.innovdroid.testmvp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.innovdroid.testmvp.model.PresenterImpl;
import com.innovdroid.testmvp.presenter.LoginPresenter;
import com.innovdroid.testmvp.view.LoginView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginView {
    EditText emailEdText, passwordEdText;
    TextView loginTextView;
    LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEdText = findViewById(R.id.emailEditText);
        passwordEdText = findViewById(R.id.passwordEditText);
        loginTextView = findViewById(R.id.login_textview);

        loginTextView.setOnClickListener(this);
        mLoginPresenter=new PresenterImpl(LoginActivity.this);
    }

    @Override
    public void onClick(View view) {

        String email = emailEdText.getText().toString();
        String password = passwordEdText.getText().toString();
        mLoginPresenter.performLogin(email,password);

    }

    @Override
    public void loginValidations() {

        Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "loginSuccess", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void loginError() {
        Toast.makeText(this, "login failure", Toast.LENGTH_SHORT).show();

    }
}
