package com.example.rizky.jogjaholiday;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

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

    int pos;
    View v;
    private RecyclerView myRecycleView;
    private List<pantaiModel> listPantai;
    private ListView mlistview;

    String [] nama = new String[7];
    String [] alamat = new String[7];
    int[] bintang = new int[7];
    String [] Deskripsi = new String[7];
    int[] gambar = new int[7];

    public void setNama(String nama,int i) {
        this.nama[i] = nama;
    }

    public void setAlamat(String[] alamat) {
        this.alamat = alamat;
    }

    public void setBintang(int[] bintang) {
        this.bintang = bintang;
    }

    public void setDeskripsi(String[] deskripsi) {
        Deskripsi = deskripsi;
    }

    public void setGambar(int[] gambar) {
        this.gambar = gambar;
    }

    public String getNama(int i) {
        return nama[i];
    }

    public String getAlamat(int i) {
        return alamat[i];
    }

    public int getBintang(int i) {
        return bintang[i];
    }

    public String getDeskripsi(int i) {
        return Deskripsi[i];
    }

    public int getGambar(int i) {
        return gambar[i];
    }

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

        listPantai.add(new pantaiModel("Pantai Depok","Parangtritis, Pantai, Parangtritis, Kec. Kretek, Bantul, Daerah Istimewa Yogyakarta",5,"biasa",R.drawable.pantaidepok));
        listPantai.add(new pantaiModel("Pantai Parangritis","Jl. Pantai Parangkusumo, Pantai, Parangtritis, Kec. Kretek, Bantul, Daerah Istimewa Yogyakarta 55772",1,"enak",R.drawable.jogjaholiday));
        listPantai.add(new pantaiModel("Pantai Drini","Banjarejo, Tanjungsari, Gunung Kidul Regency, Special Region of Yogyakarta 55881",5,"biasa",R.drawable.pantaidrini));
        listPantai.add(new pantaiModel("Pantai Glagah","Glagah, Temon, Kulon Progo Regency, Special Region of Yogyakarta 55654",5,"biasa",R.drawable.pantaiglagah));
        listPantai.add(new pantaiModel("Pantai Indrayanti","Pantai, Tepus, Gunung Kidul Regency, Special Region of Yogyakarta 55881",5,"biasa",R.drawable.pantaiindrayanti));
        listPantai.add(new pantaiModel("Pantai Jogan","Jalan Pantai Siung, Purwodadi, Tepus, Pantai, Purwodadi, Tepus, Kabupaten Gunung Kidul",5,"biasa",R.drawable.pantaijogan));
        listPantai.add(new pantaiModel("Pantai Krakal","Ngestirejo, Tanjungsari, Gunung Kidul Regency, Special Region of Yogyakarta 55000",5,"biasa",R.drawable.pantaikrakal));




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
//        Intent intent = getActivity().getIntent();
//        pos = intent.getExtras().getInt("Position");
//        Bundle bundleterima = getActivity().getIntent().getExtras();
//        if (bundleterima != null)
//        {
//            final int pose = bundleterima.getInt("position");
//            pos = pose;
//        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
//
//        Bundle bundle = new Bundle();
//        bundle.putString("nama",nama[pos]);
//
//        Intent kirim = new Intent(getActivity(),spesific.class);
//        kirim.putExtras(bundle);
//        startActivityForResult(kirim, 0);
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
