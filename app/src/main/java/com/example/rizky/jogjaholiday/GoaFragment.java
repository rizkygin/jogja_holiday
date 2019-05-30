package com.example.rizky.jogjaholiday;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rizky.jogjaholiday.Adapter.goaModel;

import java.util.ArrayList;
import java.util.List;

public class GoaFragment extends Fragment {
    
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    
    
    private String mParam1;
    private String mParam2;


    View v;
    private RecyclerView myRecycleView;
    private List<goaModel> listgoa;
    
    private OnFragmentInteractionListener mListener;

    public GoaFragment() {
        // Required empty public constructor
    }
    public static GoaFragment newInstance(String param1, String param2) {
        GoaFragment fragment = new GoaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        listgoa= new ArrayList<>();
        listgoa.add(new goaModel("Goa Pindul","Jalan Raya Pindul Banyubening II, RT.06/RW.11, Gelaran II, Bejiharjo, Karangmojo, Kabupaten Gunung Kidul, Daerah Istimewa Yogyakarta 55891","keren",1,R.drawable.goapindul));
        listgoa.add(new goaModel("Goa Cerme","Jl. Srunggo, Selopamioro, Imogiri, Srunggo 2, Selopamioro, Imogiri, Bantul, Daerah Istimewa Yogyakarta 55782","keren",1,R.drawable.goacerme));
        listgoa.add(new goaModel("Goa Jomblang","Jetis Wetan, Pacarejo, Semanu, Gunung Kidul Regency, Special Region of Yogyakarta 55893","keren",1,R.drawable.goajomblang));
        listgoa.add(new goaModel("Goa Kali Suci","Jetis, Jonge, Pacarejo, Kec. Semanu, Kabupaten Gunung Kidul, Daerah Istimewa Yogyakarta 55893","keren",1,R.drawable.goakalisuci));
        listgoa.add(new goaModel("Goa Rancang Kencono","Mungguran II, Bleberan, Playen, Gunung Kidul Regency, Special Region of Yogyakarta 558611","keren",1,R.drawable.goarancangkencono));
        listgoa.add(new goaModel("Goa Selarong","Waktu Gedug, Guwosari, Pajangan, Bantul Regency, Special Region of Yogyakarta 55751","keren",1,R.drawable.goaselarong));
        listgoa.add(new goaModel("Goa Seplawan","Katerban, Donorejo, Kaligesing, Purworejo Regency, Central Java 54175","keren",1,R.drawable.goaseplawan));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_goa,container,false);
        myRecycleView = (RecyclerView) v.findViewById(R.id.recycle_view);
        RecyclerViewAdaptergoa recyclerViewAdapter = new RecyclerViewAdaptergoa(getContext(),listgoa);
        myRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecycleView.setAdapter(recyclerViewAdapter);
        return v;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
