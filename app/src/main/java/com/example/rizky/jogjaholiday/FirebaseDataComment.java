package com.example.rizky.jogjaholiday;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDataComment {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mCommentReff;
    private List<Comment> Comments = new ArrayList<>();
    String p;
    String jenis;


    public interface DataStaus{
        void DataisLoaded(List<Comment> comments,List<String> keys);
        void DataisInserted();
        void DataisUpdated();
        void DataisDeleted();

    }
    public FirebaseDataComment() {
        mDatabase = FirebaseDatabase.getInstance();
        mCommentReff = mDatabase.getReference("Comment");

        spesific position = new spesific();

        p = position.getPos();
        jenis = position.getJenis();
    }
    public void readComment(final DataStaus dataStaus){
        mCommentReff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Comments.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
//                    String id = dataSnapshot.child("id_wisata").toString();
//                    String macam = dataSnapshot.child("jenis_wisata").toString();
                        Comment comment = keyNode.getValue(Comment.class);
                        Comments.add(comment);

                }
                dataStaus.DataisLoaded(Comments,keys);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
