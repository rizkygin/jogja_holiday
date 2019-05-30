package com.example.rizky.jogjaholiday;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;
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
    public MyViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.view_layout_item,viewGroup,false);
        final MyViewHolder vHolder = new MyViewHolder(v);

        vHolder.spesific_wisata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                String kirim  = String.valueOf(v.findViewById(R.id.alamat)[pos]);

                int posP  = vHolder.getAdapterPosition() + 1 ;
//                Intent intent = new Intent(viewGroup.getContext(),PantaiFragment.class);
//                intent.putExtra("Position",pos);
//                (intent);

                Bundle bundle = new Bundle();
                bundle.putString("positionPantai",String.valueOf(posP));

                Intent newIntent = new Intent(mContext, spesific.class);
                newIntent.putExtras(bundle);
                mContext.startActivity(newIntent);


            }
        });


        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.tv_name.setText(mData.get(i).getNama());
        myViewHolder.tv_location.setText(mData.get(i).getAlamat());
        myViewHolder.img.setImageResource(mData.get(i).getGambar());
        myViewHolder.bintang.setText(String.valueOf(mData.get(i).getBintang()));

    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout spesific_wisata;
        private TextView tv_name;
        private TextView tv_location;
        private ImageView img;
        private TextView bintang;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            bintang = (TextView) itemView.findViewById(R.id.bintang);
            spesific_wisata = (LinearLayout) itemView.findViewById(R.id.wisata);
            tv_name =(TextView) itemView.findViewById(R.id.name);
            tv_location=(TextView) itemView.findViewById(R.id.location);
            img = (ImageView) itemView.findViewById(R.id.image);
        }
    }

    @Override
    public int getItemViewType(int position) {


        return super.getItemViewType(position);
    }
}
