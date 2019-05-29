package com.example.rizky.jogjaholiday;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends  RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<pantaiModel> mData;

    public RecyclerViewAdapter(Context mContext, List<pantaiModel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.view_layout_item,viewGroup,false);
        MyViewHolder vHolder = new MyViewHolder(v);


        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.tv_name.setText(mData.get(i).getNama());
        myViewHolder.tv_location.setText(mData.get(i).getAlamat());
        myViewHolder.img.setImageResource(mData.get(i).getGambar());
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_name;
        private TextView tv_location;
        private ImageView img;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name =(TextView) itemView.findViewById(R.id.name);
            tv_location=(TextView) itemView.findViewById(R.id.location);
            img = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
