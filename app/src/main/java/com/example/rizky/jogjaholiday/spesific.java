package com.example.rizky.jogjaholiday;

import android.content.Intent;
import android.net.Uri;
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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class spesific extends AppCompatActivity {

    String darialamat,darnama;
    TextView mNama;
    TextView username;
    Button check;
    TextView address,rating;
    DatabaseReference reff;
    String posP,posG,posB;
    String lat;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spesific);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        address = findViewById(R.id.alamat);
        rating = findViewById(R.id.tvRating);
        mNama = findViewById(R.id.nama);
        username = findViewById(R.id.username);
        check = findViewById(R.id.btncuaca);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),cuaca.class);
                startActivity(i);
            }
        });

        if(user.getEmail()!=null){

            username.setText(user.getEmail());
        }else {
            Toast.makeText(this,"Sure to Login First",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
        }

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
                        String latlo = dataSnapshot.child("lat").getValue().toString();
                        String drating = dataSnapshot.child("rating").getValue().toString();

                        lat = latlo;

                        rating.setText(drating);
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
                if(lat != null) {
                    Uri gmmIntentUri = Uri.parse("https://www.google.com/maps/search/?api=1" + "&query=" + lat);
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    mapIntent.setPackage("com.google.android.apps.maps");
                    startActivity(mapIntent);
                    }
                }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
//        Toast.makeText(this,"value " + String.valueOf(user.getEmail()),Toast.LENGTH_SHORT).show();
    }
}


