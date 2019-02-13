package com.example.customviewlab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnSimpleGraph;
    private Button btnMultipleGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSimpleGraph = findViewById(R.id.single_graph);
        btnMultipleGraph = findViewById(R.id.multiple_graph);

        btnSimpleGraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSimpleGraph();
            }
        });

        btnMultipleGraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMultipleGraph();
            }
        });
    }

    private void openSimpleGraph() {
        Intent intent = new Intent(this, SimpleGraphActivity.class);
        startActivity(intent);
    }

    private void openMultipleGraph() {
        Intent intent = new Intent(this, MultipleGoalsActivity.class);
        startActivity(intent);
    }
}
