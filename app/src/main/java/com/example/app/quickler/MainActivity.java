package com.example.app.quickler;

import android.os.Bundle;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    String[] typeOfOptions = {"Profile", "Explore", "Upload", "Notification", "Home", "Bookmark"};

    RecyclerView recyclerView;
    DatabaseReference mDatabase;

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

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Quickler");
        mDatabase.keepSynced(true);
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<CardData, RecyclerViewHolder> FBRA = new FirebaseRecyclerAdapter<CardData, RecyclerViewHolder>(
                CardData.class,
                R.layout.card_layout,
                RecyclerViewHolder.class,
                mDatabase)
        {
            @Override
            protected void populateViewHolder(final RecyclerViewHolder viewHolder, final CardData model, int position) {
                viewHolder.setTitle(model.getName());

                viewHolder.bulbbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        model.isbtn = !model.isbtn;

                        if(model.isbtn)
                        {
                            viewHolder.bulbbtn.setBackgroundResource(R.drawable.bulbstateon);
                        }
                        else
                            viewHolder.bulbbtn.setBackgroundResource(R.drawable.bulbstateoff);

                    }
                });

                viewHolder.markbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        model.ismark = !model.ismark;

                        if(model.ismark)
                        {
                            viewHolder.markbtn.setBackgroundResource(R.drawable.ic_bookmark_black_24dp);
                        }
                        else
                            viewHolder.markbtn.setBackgroundResource(R.drawable.ic_bookmark_border_black_24dp);
                    }
                });

            }
        };

        recyclerView.setAdapter(FBRA);
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{

        Button bulbbtn = itemView.findViewById(R.id.bulbbtn);
        Button markbtn = itemView.findViewById(R.id.btnmark);

        public RecyclerViewHolder(View itemView) {
            super(itemView);
        }

        public void setTitle(String text)
        {
            TextView postTitle = itemView.findViewById(R.id.postTitle);
            postTitle.setText(text);
        }
    }
}



    /*viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {

        }
        });*/