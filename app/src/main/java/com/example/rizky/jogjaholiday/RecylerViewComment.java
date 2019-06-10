package com.example.rizky.jogjaholiday;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.ls.LSException;

import java.util.List;

public class RecylerViewComment {
    private Context mContext;
    private CommentAdapter mCommentsAdapter;


    public void setConfig(RecyclerView recyclerView, Context context, List<Comment> comments , List<String> keys){
        mContext = context;
        mCommentsAdapter = new CommentAdapter(comments,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mCommentsAdapter);
    }



    class CommentView extends RecyclerView.ViewHolder{

        private TextView mEmail;
        private TextView mComment;
        private TextView id_wisata;
        private TextView jenis_wisata;

        private String Key;
        public CommentView(@NonNull ViewGroup parent) {
            super(LayoutInflater.from(mContext).inflate(R.layout.commentlistspesific,parent,false));

            mEmail = itemView.findViewById(R.id.iniemailreview);
            mComment = itemView.findViewById(R.id.comment);
            jenis_wisata = itemView.findViewById(R.id.jenis);
        }

        public void bind(Comment comment, String Key) {
            mEmail.setText(comment.getEmail());
            mComment.setText(comment.getComment());
            jenis_wisata.setText(comment.getJenis_wisata());

            this.Key = Key;
        }
    }

    class CommentAdapter extends RecyclerView.Adapter<CommentView>{
        private List<Comment> mListComment;
        private List<String> mKeys;

        public CommentAdapter(List<Comment> mListComment, List<String> mKeys) {
            this.mListComment = mListComment;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public CommentView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new CommentView(viewGroup);
        }

        @Override
        public void onBindViewHolder(@NonNull CommentView commentView, int i) {
            commentView.bind(mListComment.get(i),mKeys.get(i));
        }

        @Override
        public int getItemCount() {
            return mListComment.size();
        }
    }
}
