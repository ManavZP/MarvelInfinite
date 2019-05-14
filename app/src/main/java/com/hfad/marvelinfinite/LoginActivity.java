package com.hfad.marvelinfinite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEdit;
    private EditText passwordEdit;
    private Button loginButton;
    public static final String EXTRA_USERNAME = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        wireWidgets();
        setOnClickListeners();
        Backendless.initApp(this, Credentials.APP_ID, Credentials.API_KEY);
    }

    private void setOnClickListeners() {

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginToBackendless();
            }
        });

    }


    private void loginToBackendless() {
        String login = usernameEdit.getText().toString();
        String password = passwordEdit.getText().toString();
        Backendless.UserService.login(login, password,
                new AsyncCallback<BackendlessUser>() {
                    @Override
                    public void handleResponse(BackendlessUser response) {
                        // Start the new activity here because
                        // this method is called when the login is complete
                        // and successful


                        Intent intent = new Intent(LoginActivity.this,
                                HomeActivity.class);
                        startActivity(intent);

                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {
                        Toast.makeText(LoginActivity.this,
                                fault.getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                });


    }

    private void wireWidgets() {

        usernameEdit = findViewById(R.id.editText_login_username);
        passwordEdit = findViewById(R.id.editText_login_password);
        loginButton = findViewById(R.id.button_login_loginButton);

    }
}
