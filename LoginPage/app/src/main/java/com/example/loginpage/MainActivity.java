package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etUserName,etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUserName=findViewById(R.id.username);
        etPassword=findViewById(R.id.password);

        btnLogin=findViewById(R.id.login);

        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String user = etUserName.getText().toString();
        String pass = etPassword.getText().toString();

        if(user.equals("admin") && pass.equals("password"))
        {
            Intent act = new Intent(getApplicationContext(),Main2Activity.class);
            startActivity(act);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Invalid User Name and Password",Toast.LENGTH_SHORT).show();
        }

    }
}
