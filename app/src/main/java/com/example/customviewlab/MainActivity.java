package com.example.customviewlab;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.customviewlab.custom.MyCustomView;

public class MainActivity extends AppCompatActivity {
    private MyCustomView myCustomView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myCustomView = findViewById(R.id.myCustom);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCustomView.startAnimating(230);
            }
        });

        getLifecycle().addObserver(new MyLifeCycleClass());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Claudio - ", "on resume terminou");
        //myCustomView.startAnimating(360);
        //Log.d("Claudio - ", getLifecycle().getCurrentState().toString());
    }

    private class MyLifeCycleClass implements LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        public void resume() {
            Log.d("Claudio - ", getLifecycle().getCurrentState().toString());
            //myCustomView.startAnimating(275);
        }
    }
}
