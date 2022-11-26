package com.denich.nextgenmessenger;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Collections;


public class ChatActivity extends AppCompatActivity {
    private String login;
    private String profile;
    private String mes;
    private EditText mEditText;
    private View box;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent loginint = getIntent();
        login = loginint.getStringExtra("login");
        Intent mesinint = getIntent();
        mes = mesinint.getStringExtra("message");
        if (login.equals("Даня")) profile = "Лушников Д.В";
        if (login.equals("Егор")) profile = "Бесхлебнов Е.А";
        if (login.equals("Надя")) profile = "Рябинина Н.В";
        if (login.equals("Гриша")) profile = "Чеботаев Г.И";
        mEditText=(EditText) findViewById(R.id.editTextChatLine);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    public void onClickOpenProfile(View view) {
        Intent intentProfile = new Intent(this, ProfileActivity.class);
        intentProfile.putExtra("login", profile);
        startActivity(intentProfile);
    }

    public void onClickSend(View view) {
        Toast.makeText(getApplicationContext(), "Немного не успели!", Toast.LENGTH_SHORT).show();
    }
    public void onClickNextGen(View view) {
        Toast.makeText(getApplicationContext(), "Мы очень старались, и наш back-end сильно страдал", Toast.LENGTH_SHORT).show();
    }
}