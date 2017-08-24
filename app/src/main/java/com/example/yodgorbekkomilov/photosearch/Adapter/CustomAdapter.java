package com.example.yodgorbekkomilov.photosearch.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import com.example.yodgorbekkomilov.photosearch.Model.*;
import com.example.yodgorbekkomilov.photosearch.*;
/**
 * Created by yodgorbekkomilov on 8/24/17.
 */

public class CustomAdapter extends ArrayAdapter {
    Context context;
    List<Link> list;
    LayoutInflater inflater;
    public CustomAdapter(Context context, List<Link> list) {
        super(context,list.size());
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_gallery,null);
        final CircleImageView image = (CircleImageView) view.findViewById(R.id.image);
        TextView title = (TextView)view.findViewById(R.id.title);
        title.setText(list.get(position).getTite());
        Picasso.with(context).load(list.get(position).getUrl()).placeholder(R.drawable.placeholder).into(image);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, PhotosActivity.class);
                i.putExtra("item",list.get(position));
                context.startActivity(i);
            }
        });

        return view;
    }
}

