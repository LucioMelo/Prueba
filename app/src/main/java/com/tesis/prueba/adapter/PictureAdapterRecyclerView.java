package com.tesis.prueba.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tesis.prueba.R;

import java.util.ArrayList;

import com.tesis.prueba.model.Picture;
import com.tesis.prueba.view.PictureDetailActivity;

/**
 * Created by Lucio on 19/09/2017.
 */

public class PictureAdapterRecyclerView extends RecyclerView.Adapter<PictureAdapterRecyclerView.PictureViewHolder> {




    private ArrayList<Picture> pictures;
    private int resource;
    private Activity activity;

    public PictureAdapterRecyclerView(ArrayList<Picture> pictures, int resource, Activity activity) {
        this.pictures = pictures;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public PictureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);

        return new PictureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PictureViewHolder holder, int position) {
        Picture picture=pictures.get(position);
        holder.textUserNameCard.setText(picture.getUserName());
        holder.timeCard.setText(picture.getTime());
        holder.likeNumberCard.setText(picture.getLikeNumber());
        Picasso.with(activity).load(picture.getPicture()).into(holder.pictureCardImage);

        holder.pictureCardImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, PictureDetailActivity.class);

                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP)
                {
                    Explode explode=new Explode();
                    explode.setDuration(1000);
                    activity.getWindow().setExitTransition(explode);
                    activity.startActivity(intent, ActivityOptionsCompat
                            .makeSceneTransitionAnimation(activity,view,activity
                                    .getString(R.string.strTransitionNamePicture)).toBundle());


                }
                else {
                    activity.startActivity(intent);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }

    public class PictureViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView pictureCardImage;
        private TextView textUserNameCard;
        private TextView timeCard;
        private TextView likeNumberCard;



        public PictureViewHolder(View itemView) {
            super(itemView);

            pictureCardImage    =(ImageView) itemView.findViewById(R.id.pictureCardImage);
            textUserNameCard    =(TextView) itemView.findViewById(R.id.textUserNameCard);
            timeCard            =(TextView) itemView.findViewById(R.id.timeCard);
            likeNumberCard      =(TextView) itemView.findViewById(R.id.likeNumberCard);


        }
    }
}
