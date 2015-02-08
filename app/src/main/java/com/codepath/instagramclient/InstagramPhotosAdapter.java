package com.codepath.instagramclient;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class InstagramPhotosAdapter extends ArrayAdapter<InstagramPhoto> {


    // what data do we need from the activity
    // context, datasource
    public InstagramPhotosAdapter(Context context, List<InstagramPhoto> objects) {
        super(context, android.R.layout.simple_list_item_1, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // get the data item for this position
        // check if we are using a recycled view
        // if not we need to inflate
        // lookup the views for populate the data
        // insert item model data into each of the view items
        // return the created item as a view.

        InstagramPhoto photo = getItem(position);

        if(convertView == null)
        {
            // no recycled view, create a new view
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_photo, parent, false);
        }

        TextView tvCaption = (TextView) convertView.findViewById(R.id.tvCaption);
        ImageView ivPhoto = (ImageView) convertView.findViewById(R.id.ivPhoto);

        tvCaption.setText(photo.caption);
        // use picasso to get download the image from url, make sure view is clean.
        ivPhoto.setImageResource(0);
        // Picasso.with(getContext()).load(photo.imageUrl).into(ivPhoto);

        Picasso.with(getContext()).load(photo.imageUrl).fit().centerCrop().placeholder(R.drawable.ic_launcher).into(ivPhoto);

        return convertView;
    }
}
