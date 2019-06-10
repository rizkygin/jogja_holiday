package com.example.rizky.jogjaholiday;

import android.app.LauncherActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class spesific extends AppCompatActivity implements CommentDialog.ExampleDialogListener{

    private RecyclerView mRecyclerView;
    private String namatempat;

    private DatabaseReference mDatabase;

    TextView mNama;
    TextView address,rating;
    DatabaseReference reff;
    String posP,posG,posB;
    String lat;
    ImageView mImageView;


    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private String  pos;
    private String  jenis;

    public spesific() {
    }

    public String getPos() {
        return pos;
    }

    public String getJenis() {
        return jenis;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spesific);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        address = findViewById(R.id.alamat);
        rating = findViewById(R.id.tvRating);
        mNama = findViewById(R.id.nama);


        mDatabase = FirebaseDatabase.getInstance().getReference("Comment");

        // Nampilin Comment
        mRecyclerView = (RecyclerView) findViewById(R.id.listComment);
        new FirebaseDataComment().readComment(new FirebaseDataComment.DataStaus() {
            @Override
            public void DataisLoaded(List<Comment> comments, List<String> keys) {
                new RecylerViewComment().setConfig(mRecyclerView,spesific.this,comments,keys);

            }

            @Override
            public void DataisInserted() {

            }

            @Override
            public void DataisUpdated() {

            }

            @Override
            public void DataisDeleted() {

            }
        });

        mImageView = findViewById(R.id.imageView2);


        // nampilin data dari image storage


//        String url = "https://firebasestorage.googleapis.com/v0/b/jogjaholiday-635f3.appspot.com/o/Pantai%20Depok.jpg?alt=media&token=69083be9-95cd-4e78-96c0-5cf8d8f20dbe";
//
//        Glide.with(getApplicationContext()).load(url).into(mImageView);



        if(user.getEmail()!=null){

//            username.setText(user.getEmail());
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
            pos = posP;
            this.jenis = "Pantai";
        } else if(posG!=null){
            reff = FirebaseDatabase.getInstance().getReference().child("Goa").child(String.valueOf(posG));
            pos = posG;
            this.jenis = "Goa";
        }else if(posB!=null){
            reff = FirebaseDatabase.getInstance().getReference().child("Bukit").child(String.valueOf(posB));
            pos = posB;
            this.jenis = "Bukit";
        }
                reff.addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child("nama").getValue() == null){
                            mNama.setText("Tidak ditemukan");
                        }
                        String nama = dataSnapshot.child("nama").getValue().toString();
                        namatempat = nama;
                        String al = dataSnapshot.child("al").getValue().toString();
                        String latlo = dataSnapshot.child("lat").getValue().toString();
                        String drating = dataSnapshot.child("rating").getValue().toString();
                        String gambar = dataSnapshot.child("pic").getValue().toString();

                        lat = latlo;

                        rating.setText(drating);
                        address.setText(al);
                        mNama.setText(nama);
                        posP = null;
                        posG = null;
                        posB = null;

                        Glide.with(getApplicationContext()).load(gambar).into(mImageView);
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
        FloatingActionButton cek = findViewById(R.id.checkcauca);
        cek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),cuaca.class);
                startActivity(i);

            }
        });
        FloatingActionButton comment  = findViewById(R.id.comment);
        comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommentDialog exampleDialog = new CommentDialog();
                exampleDialog.show(getSupportFragmentManager(), "example dialog");


            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
//        Toast.makeText(this,"value " + String.valueOf(user.getEmail()),Toast.LENGTH_SHORT).show();
    }

    public void pushComment(){

    }
    @Override
    public void applyTexts(String Comment) {
        String komen = Comment.trim();
        String email = user.getEmail();
        String id_wisata = pos;
        String jenis_wisata = namatempat;
        List<Comment> Comments = new ArrayList<>();
        Comment push = new Comment( email,  komen,  id_wisata,  jenis_wisata);
        Comments.add(push);
//        mNama.setText(komen);
        mDatabase.push().setValue(push);
    }
}


