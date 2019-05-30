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

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BukitFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BukitFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BukitFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    View v;
    private RecyclerView myRecycleView;
    private List<bukitModel> listBukit;

    private OnFragmentInteractionListener mListener;

    public BukitFragment() {
        // Required empty public constructor
    }
    // TODO: Rename and change types and number of parameters
    public static BukitFragment newInstance(String param1, String param2) {
        BukitFragment fragment = new BukitFragment();
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
        listBukit= new ArrayList<>();
        listBukit.add(new bukitModel("Bukit Becici","Gunungcilik, RT.07/RW.02, Gn. Cilik, Muntuk, Dlingo, Bantul, Daerah Istimewa Yogyakarta 55783","keren",4,R.drawable.becici));
        listBukit.add(new bukitModel("Bukit Panguk Kediwung","Kediwung, Mangunan, Dlingo, Bantul Regency, Special Region of Yogyakarta 55783","keren",5,R.drawable.pangukkediwung));
        listBukit.add(new bukitModel("Bukit Setumbu","Jl.Borobudur Ngadiharjo KM 4 km, Kurahan, Karangrejo, Kec. Borobudur, Magelang, Jawa Tengah 56553","keren",2,R.drawable.setumbu));
        listBukit.add(new bukitModel("Bukit Tembelan","Mangunan, Dlingo, Bantul Regency, Special Region of Yogyakarta 55783","keren",3,R.drawable.tembelan));
        listBukit.add(new bukitModel("Bukit Ketep Pass","Jl. Blabak - Boyolali No.KM. 16, Ketep Pas, Ketep, Sawangan, Magelang, Jawa Tengah 56481","keren",2,R.drawable.keteppass));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_bukit,container,false);
        myRecycleView = (RecyclerView) v.findViewById(R.id.recycle_view);
        RecyclerViewAdapterbukit recyclerViewAdapter = new RecyclerViewAdapterbukit(getContext(),listBukit);
        myRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecycleView.setAdapter(recyclerViewAdapter);
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
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
