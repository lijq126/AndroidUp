package com.smartdot.androidup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CustomViewActivity extends AppCompatActivity {
    private CustomView customView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        customView = findViewById(R.id.cus);
        customView.smootheScrollTo(-400, 0);
    }
}
