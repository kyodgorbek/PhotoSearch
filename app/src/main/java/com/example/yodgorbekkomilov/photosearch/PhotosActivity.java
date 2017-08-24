package com.example.yodgorbekkomilov.photosearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.yodgorbekkomilov.photosearch.Model.Link;
import com.squareup.picasso.Picasso;

public class PhotosActivity extends AppCompatActivity {
    ImageView imageView;
    Link link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        link = (Link)getIntent().getSerializableExtra("item");
        imageView = (ImageView)findViewById(R.id.image);
        Picasso.with(this).load(link.getUrl()).placeholder(R.drawable.placeholder).into(imageView);
        getSupportActionBar().setTitle(link.getTite());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
