package com.example.app.quickler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    String[] typeOfOptions = {"Profile", "Explore", "Upload", "Notification", "Home", "Bookmark"};

    @Override

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.item1) {
            Toast.makeText(getApplicationContext(), "Profile", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.item2) {
            Toast.makeText(getApplicationContext(), "Explore", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.item3) {
            Toast.makeText(getApplicationContext(), "Upload", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.item4) {
            Toast.makeText(getApplicationContext(), "Notification", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.item5) {
            Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.item6) {
            Toast.makeText(getApplicationContext(), "Bookmark", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
}

