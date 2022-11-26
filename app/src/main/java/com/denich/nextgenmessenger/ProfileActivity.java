package com.denich.nextgenmessenger;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {
    private TextView profilename;
    private String login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent loginint = getIntent();
        String login = loginint.getStringExtra("login");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profilename = findViewById(R.id.textViewProfileName);
        profilename.setText(login);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }
    }

    public void onClickLogOut(View view) {
        Intent intentLogOut = new Intent(this, LoginActivity.class);
        startActivity(intentLogOut);
    }

    public void onClickBackToChat(View view) {
        Intent intentBackToChat = new Intent(this, ChatActivity.class);
        startActivity(intentBackToChat);
    }
}