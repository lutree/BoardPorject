package com.example.boardporject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.boardporject.common.CONST;
import com.example.boardporject.util.PreferenceManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PreferenceManager.setString(this, CONST.USER_ID, "lutree");
        PreferenceManager.setString(this, CONST.USER_NAME, "이수걸");

        Intent intent = new Intent(MainActivity.this, BoardListActivity.class);
        startActivity(intent);
        finish();
    }
}