package com.example.moviecatalogue;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MovieDetail extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_moview";
    TextView tvName, tvScore, tvDate, tvOverview;
    ImageView imgPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        tvName = findViewById(R.id.txt_name);
        tvDate = findViewById(R.id.txt_date);
        tvScore = findViewById(R.id.txt_score);
        tvOverview = findViewById(R.id.txt_overview);
        imgPhoto = findViewById(R.id.img_photo);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        tvName.setText(movie.getName());
        tvDate.setText(movie.getDate());
        tvScore.setText(movie.getScore());
        tvOverview.setText(movie.getOverview());
        Glide.with(this)
                .load(movie.getPhoto())
                .into(imgPhoto);

    }

    public boolean onOptionsItemSelected(MenuItem item){
        onBackPressed();
        return true;
    }
}
