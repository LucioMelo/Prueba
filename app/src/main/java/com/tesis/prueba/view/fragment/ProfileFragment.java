package com.tesis.prueba.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tesis.prueba.R;
import com.tesis.prueba.adapter.PictureAdapterRecyclerView;
import com.tesis.prueba.model.Picture;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view =inflater.inflate(R.layout.fragment_profile,container,false);

        showToolbar("",false,view);

        RecyclerView picturesRecycler = (RecyclerView) view.findViewById(R.id.pictureProfileRecycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        picturesRecycler.setLayoutManager(linearLayoutManager);

        PictureAdapterRecyclerView pictureAdapterRecyclerView = new PictureAdapterRecyclerView
                (buidPictures(), R.layout.cardview_captura, getActivity());

        picturesRecycler.setAdapter(pictureAdapterRecyclerView);


        return view;

    }


    public ArrayList<Picture> buidPictures()
    {
        ArrayList<Picture> pictures=new ArrayList<>();
        pictures.add(new Picture("https://la-motorbit-media.s3.amazonaws.com/2016/09/autos-mexicanos-inferno-exotic-car-1024x768.jpg","Lucio Melo","4 días","3 Me gusta"));
        pictures.add(new Picture("https://la-motorbit-media.s3.amazonaws.com/2016/09/autos-mexicanos-inferno-exotic-car-p-1000x750.jpg","Juan Pablo","2 días","7 Me gusta"));
        pictures.add(new Picture("http://cdn.gq.com.mx/uploads/images/thumbs/201312/los_autos_de_ferrari_63856622_900x556.jpg","Pedro Melo","4 días","9 Me gusta"));
        pictures.add(new Picture("https://la-motorbit-media.s3.amazonaws.com/2016/09/autos-mexicanos-inferno-exotic-car-1024x768.jpg","Lucio Melo","4 días","3 Me gusta"));
        pictures.add(new Picture("https://la-motorbit-media.s3.amazonaws.com/2016/09/autos-mexicanos-inferno-exotic-car-p-1000x750.jpg","Juan Pablo","2 días","7 Me gusta"));
        return pictures;
    }

    public void showToolbar(String tittle, boolean upButton,View view)
    {
        Toolbar toolbar =(Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(tittle);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }


}
