package com.wen;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();//不熟
        result = findViewById(R.id.result);
        result.setText("Welcome");
        new AlertDialog.Builder(ResultActivity.this)
                .setTitle("Success")
                .setMessage("Hello world!")
                .setPositiveButton("JOINUS",null)
                .show();
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();

            }
        });
    }
    public void reset() {
        Intent intent1 = new Intent(this,MainActivity.class);
        startActivity(intent1);
    }

}
