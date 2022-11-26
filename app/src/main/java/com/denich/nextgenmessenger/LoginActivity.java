package com.denich.nextgenmessenger;

import static com.denich.nextgenmessenger.coding.*;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class LoginActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button login;
    public static final String DB_URL = "jdbc:h2:/c:/JavaPrj/SQLDemo/db/stockExchange";
    public static final String DB_Driver = "org.h2.Driver";

    int numberOfRemainingLoginAttempts = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }
        username = (EditText) findViewById(R.id.editTextLogIn);
        password = (EditText) findViewById(R.id.editTextPassword);
        login = (Button) findViewById(R.id.buttonLogIn);


    }

    public void onClickLogin(View view) throws IOException {
        List<String> pASSword = new ArrayList<>();
        boolean flag=true;
        pASSword.add("Даня12345");
        pASSword.add("ЕгорQwerty");
        pASSword.add("НадяTRSG23");
        pASSword.add("ГришаGnom");
        for(int i=0; i<pASSword.toArray().length; i++){
        if ((username.getText().toString()+password.getText().toString()).equals(pASSword.get(i))){
            Toast.makeText(getApplicationContext(), "Вход выполнен!", Toast.LENGTH_SHORT).show();
            Intent intentLogin = new Intent(this, ChatActivity.class);
            intentLogin.putExtra("login",username.getText().toString());
            intentLogin.putExtra("message","");
            startActivity(intentLogin);
            flag=false;
        }}
        if (flag) {
            Toast.makeText(getApplicationContext(), "Неправильные данные!", Toast.LENGTH_SHORT).show();
            numberOfRemainingLoginAttempts--;
        }
        if (numberOfRemainingLoginAttempts == 0) {
            login.setEnabled(false);
            Toast.makeText(getApplicationContext(), "Вход заблокирован!", Toast.LENGTH_SHORT).show();
        }
    }
}