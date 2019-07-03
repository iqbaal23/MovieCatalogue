package com.example.moviecatalogue;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String [] dataName;
    private String [] dataScore;
    private String [] dataDate;
    private String [] dataOverview;
    private TypedArray dataPhoto;
    private MovieAdapter adapter;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.lv_movie);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movie movie = new Movie();
                movie.setName(movies.get(position).getName());
                movie.setScore(movies.get(position).getScore());
                movie.setDate(movies.get(position).getDate());
                movie.setOverview(movies.get(position).getOverview());
                movie.setPhoto(movies.get(position).getPhoto());

                Intent intent = new Intent(MainActivity.this, MovieDetail.class);
                intent.putExtra(MovieDetail.EXTRA_MOVIE, movie);
                startActivity(intent);
            }
        });
    }

    private void addItem(){
        movies = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++){
            Movie movie = new Movie();
            movie.setPhoto(dataPhoto.getResourceId(i,-1));
            movie.setName(dataName[i]);
            movie.setDate(dataDate[i]);
            movie.setOverview(dataOverview[i]);
            movie.setScore(dataScore[i]);
            movies.add(movie);
        }
        adapter.setMovies(movies);
    }

    private void prepare(){
        dataName = getResources().getStringArray(R.array.data_name);
        dataScore = getResources().getStringArray(R.array.data_score);
        dataDate = getResources().getStringArray(R.array.data_date);
        dataOverview = getResources().getStringArray(R.array.data_overview);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }

}
