package com.example.icloudmusic.ui;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.icloudmusic.MainActivity;
import com.example.icloudmusic.R;

public class Index extends AppCompatActivity {

    private Handler handler =new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(Index.this, MainActivity.class));
                finish();
            }
        },2*1000);
    }
}
