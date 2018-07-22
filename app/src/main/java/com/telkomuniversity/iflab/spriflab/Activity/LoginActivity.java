package com.telkomuniversity.iflab.spriflab.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.telkomuniversity.iflab.spriflab.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    // item dari layout
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);

        setTitle("Log In");
    }

    @Override
    public void onClick(View view) {
        if(view == btnLogin){
            try{
                // belom harus pake username sama password
                Intent adminIntent = new Intent(LoginActivity.this, AdminActivity.class);
                startActivity(adminIntent);
            }catch(Exception e){
                Toast.makeText(this, "Exception detected", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onBackPressed() {
        Intent MainIntent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(MainIntent);
        finish();
    }
}
