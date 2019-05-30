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
 * {@link PantaiFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PantaiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PantaiFragment extends Fragment{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    View v;
    private RecyclerView myRecycleView;
    private List<pantaiModel> listPantai;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public PantaiFragment() {
        // Required empty public constructor
    }
    // TODO: Rename and change types and number of parameters
    public static PantaiFragment newInstance(String param1, String param2) {
        PantaiFragment fragment = new PantaiFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listPantai = new ArrayList<>();
        listPantai.add(new pantaiModel("Pantai Parangritis","Jogjakarta",1,"enak",R.drawable.jogjaholiday));
        listPantai.add(new pantaiModel("Pantai Depok","Jogjakarta",5,"biasa",R.drawable.pantaidepok));
        listPantai.add(new pantaiModel("Pantai Drini","Jogjakarta",5,"biasa",R.drawable.pantaidrini));
        listPantai.add(new pantaiModel("Pantai Glagah","Jogjakarta",5,"biasa",R.drawable.pantaiglagah));
        listPantai.add(new pantaiModel("Pantai Indrayanti","Jogjakarta",5,"biasa",R.drawable.pantaiindrayanti));
        listPantai.add(new pantaiModel("Pantai Jogan","Jogjakarta",5,"biasa",R.drawable.pantaijogan));
        listPantai.add(new pantaiModel("Pantai Krakal","Jogjakarta",5,"biasa",R.drawable.pantaikrakal));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_pantai,container,false);
        myRecycleView = (RecyclerView) v.findViewById(R.id.recycle_view);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),listPantai);
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
