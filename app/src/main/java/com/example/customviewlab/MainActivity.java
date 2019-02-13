package com.example.customviewlab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.customviewlab.custom.MultipleGoalsView;

public class MainActivity extends AppCompatActivity {
    private MultipleGoalsView myCustomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myCustomView = findViewById(R.id.myCustom);
    }
}
