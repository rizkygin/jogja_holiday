package com.example.rizky.jogjaholiday;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class spesific extends AppCompatActivity {

    String darialamat,darnama;
    TextView mNama;
    TextView address,rating;
    DatabaseReference reff;
    String posP,posG,posB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spesific);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        address = findViewById(R.id.alamat);
        rating = findViewById(R.id.tvRating);
        mNama = findViewById(R.id.nama);

        Intent intent = getIntent();

        posG = intent.getStringExtra("positionGoa");
        posP = intent.getStringExtra("positionPantai");
        posB = intent.getStringExtra("positionBukit");


        if(posP!=null){
            reff = FirebaseDatabase.getInstance().getReference().child("Pantai").child(String.valueOf(posP));
        } else if(posG!=null){
            reff = FirebaseDatabase.getInstance().getReference().child("Goa").child(String.valueOf(posG));
        }else if(posB!=null){
            reff = FirebaseDatabase.getInstance().getReference().child("Bukit").child(String.valueOf(posB));
        }
                reff.addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child("nama").getValue() == null){
                            mNama.setText("Tidak ditemukan");
                        }
                        String nama = dataSnapshot.child("nama").getValue().toString();
                        String al = dataSnapshot.child("al").getValue().toString();
                        String des = dataSnapshot.child("des").getValue().toString();

                        address.setText(al);
                        mNama.setText(nama);
                        posP = null;
                        posG = null;
                        posB = null;
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"value " + String.valueOf(posG),Toast.LENGTH_SHORT).show();
    }
}


