package com.wen;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView username;
    private TextView email;
    private TextView password;
    private ImageView image_errorname;
    private ImageView image_errorpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        username = findViewById(R.id.ed_name);
        email = findViewById(R.id.ed_mail);
        password = findViewById(R.id.ed_password);
        image_errorname = findViewById(R.id.image_errorname);
        image_errorpassword = findViewById(R.id.image_errorpassword);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });
    }
    public void reset() {
        Intent intent2 = new Intent(this,MainActivity.class);
        startActivity(intent2);
    }
    public void button(View view) {
        username.getText();
        email.getText();//想不到輸入搜尋是否有＠的方法
        password.getText();
        if (username.length() >= 3 && email.length() != 0 && password.length() >= 6) {
            Intent intent = new Intent(this,ResultActivity.class); //不熟
            startActivity(intent);
        } else if (username.length() < 3) {
            image_errorname.setVisibility(View.VISIBLE);
        } else if (email.length() == 0) {
            new AlertDialog.Builder(MainActivity.this)//不熟
                    .setTitle("Error")
                    .setMessage("Email can not be empty.")
                    .setPositiveButton("OK",null)
                    .show();
        } else if (password.length() < 6) {
            image_errorpassword.setVisibility(View.VISIBLE);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
