package com.example.yodgorbekkomilov.photosearch;

import android.app.ProgressDialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.example.yodgorbekkomilov.photosearch.Adapter.*;
import com.example.yodgorbekkomilov.photosearch.Api.*;
import com.example.yodgorbekkomilov.photosearch.Model.Link;
import com.example.yodgorbekkomilov.photosearch.Model.Photos;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    Button send;
    CustomAdapter adapter;
    ListView listView;
    EditText query;
    List<Link> list = new ArrayList<>();
    private int page = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        query = (EditText)findViewById(R.id.query);
        send = (Button)findViewById(R.id.send);
        listView = (ListView) findViewById(R.id.grid_view);
        send.setOnClickListener(this);
        adapter = new CustomAdapter(this,list);
        listView.setAdapter(adapter);
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE
                        && (listView.getLastVisiblePosition() - listView.getHeaderViewsCount() -
                        listView.getFooterViewsCount()) >= (adapter.getCount() - 1)) {
                    download(list.size()/100+1);
                }
            }


            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
        download(page);
    }

    @Override
    public void onClick(View v) {
        page = 1;
        list.clear();
        download(page);
    }
    public void download(int page){
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setCancelable(false);
        pd.setTitle("Downloading");
        pd.setMessage("wait ...");
        pd.show();

        String queryText = query.getText().toString();
        if (queryText.equals("")){
            queryText = "New_York";
            Toast.makeText(this, "Default searching New York", Toast.LENGTH_SHORT).show();
        }
        ApiClient apiClient = ApiClientGenerator.createService(ApiClient.class);
        Call<Photos> call = apiClient.getPhotos(String.valueOf(page),queryText);

        call.enqueue(new Callback<Photos>() {
            @Override
            public void onResponse(Call<Photos> call, Response<Photos> response) {
                pd.dismiss();
                List<Link> currentList = new ArrayList<>();
                if (response.isSuccessful()){Photos mPhotos = response.body();
                    Toast.makeText(MainActivity.this, String.valueOf(mPhotos.photos.photo.length), Toast.LENGTH_SHORT).show();
                    for (int i=0;i<mPhotos.photos.photo.length; i++){
                        Link link = new Link(mPhotos.photos.photo[i].getId(),
                                mPhotos.photos.photo[i].getSecret(),
                                mPhotos.photos.photo[i].getServer(),
                                ""+mPhotos.photos.photo[i].getFarm(),
                                mPhotos.photos.photo[i].getTitle());
                        currentList.add(link);
                    }
                    list.addAll(currentList);
                    adapter.notifyDataSetChanged();
                    adapter = new CustomAdapter(MainActivity.this,list);
                    //gridView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<Photos> call, Throwable t) {
                Toast.makeText(MainActivity.this, "network error", Toast.LENGTH_SHORT).show();
                pd.dismiss();
            }
        });
    }
}
