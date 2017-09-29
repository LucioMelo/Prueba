package com.tesis.prueba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.tesis.prueba.R;
import com.tesis.prueba.view.ContainerActivity;
import com.tesis.prueba.view.CreateAccountActivity;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void goCreateAccount(View view)
    {
        Intent intent = new Intent(this,CreateAccountActivity.class);
        startActivity(intent);
    }

    public void goCreateContainer(View view)
    {
        Intent intentContainer = new Intent(this,ContainerActivity.class);
        startActivity(intentContainer);
    }

}
