package com.evanemran.marvel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.evanemran.marvel.Adapters.ComicAdapter;
import com.evanemran.marvel.Adapters.EventsAdapter;
import com.evanemran.marvel.Adapters.SeriesAdapter;
import com.evanemran.marvel.Adapters.StoriesAdapter;
import com.evanemran.marvel.Listeners.AllCharactersResponseListener;
import com.evanemran.marvel.Listeners.ComicResponseListener;
import com.evanemran.marvel.Listeners.HomeMenuClickListener;
import com.evanemran.marvel.Listeners.SeriesResponseListener;
import com.evanemran.marvel.Listeners.StoriesResponseListener;
import com.evanemran.marvel.Model.AllCharacterAPIResponse;
import com.evanemran.marvel.Model.ComicResponse;
import com.evanemran.marvel.Model.SeriesResponse;
import com.evanemran.marvel.Model.StoriesResponse;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Wave;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CharacterDetailActivity extends AppCompatActivity {

    RequestManager manager;
    String character_id;
    ImageView imageView_character_banner;
    TextView textView_character_banner_name, textView_character_banner_desc, textView_character_name;
    RecyclerView recycler_comics, recycler_series, recycler_stories, recycler_events;
    ComicAdapter comicAdapter;
    SeriesAdapter seriesAdapter;
    StoriesAdapter storiesAdapter;
    EventsAdapter eventsAdapter;
    ScrollView character_detail_container;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_detail);

        imageView_character_banner = findViewById(R.id.imageView_character_banner);
        textView_character_banner_name = findViewById(R.id.textView_character_banner_name);
        textView_character_banner_desc = findViewById(R.id.textView_character_banner_desc);
        textView_character_name = findViewById(R.id.textView_character_name);
        recycler_comics = findViewById(R.id.recycler_comics);
        recycler_series = findViewById(R.id.recycler_series);
        recycler_stories = findViewById(R.id.recycler_stories);
        recycler_events = findViewById(R.id.recycler_events);
        character_detail_container = findViewById(R.id.character_detail_container);

        progressBar = (ProgressBar)findViewById(R.id.loader);
        Sprite anim = new Wave();
        progressBar.setIndeterminateDrawable(anim);

        character_id = getIntent().getExtras().getString("character_id");

        manager = new RequestManager(this);
        manager.getCharacter(listener, character_id);
        manager.getCharacterComic(comicResponseListener, character_id);
        manager.getCharacterSeries(seriesResponseListener, character_id);
        manager.getCharacterStories(storiesResponseListener, character_id);
    }

    private final AllCharactersResponseListener listener = new AllCharactersResponseListener() {
        @Override
        public void onFetch(AllCharacterAPIResponse response, String message) {
            progressBar.setVisibility(View.GONE);
            character_detail_container.setVisibility(View.VISIBLE);
            showData(response.getData().results);
        }

        @Override
        public void onError(String message) {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(CharacterDetailActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    private final ComicResponseListener comicResponseListener = new ComicResponseListener() {
        @Override
        public void onFetch(ComicResponse response, String message) {
            //comic data
            recycler_comics.setHasFixedSize(true);
            recycler_comics.setLayoutManager(new LinearLayoutManager(CharacterDetailActivity.this, LinearLayoutManager.HORIZONTAL, false));
            comicAdapter = new ComicAdapter(CharacterDetailActivity.this, response.data.results, clickListener);
            recycler_comics.setAdapter(comicAdapter);
        }

        @Override
        public void onError(String message) {
            Toast.makeText(CharacterDetailActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    private final SeriesResponseListener seriesResponseListener = new SeriesResponseListener() {
        @Override
        public void onFetch(SeriesResponse response, String message) {
            //series data
            recycler_series.setHasFixedSize(true);
            recycler_series.setLayoutManager(new LinearLayoutManager(CharacterDetailActivity.this, LinearLayoutManager.HORIZONTAL, false));
            seriesAdapter = new SeriesAdapter(CharacterDetailActivity.this, response.data.results, clickListener);
            recycler_series.setAdapter(seriesAdapter);
        }

        @Override
        public void onError(String message) {
            Toast.makeText(CharacterDetailActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    private final StoriesResponseListener storiesResponseListener = new StoriesResponseListener() {
        @Override
        public void onFetch(StoriesResponse response, String message) {
            //series data
            recycler_stories.setHasFixedSize(true);
            recycler_stories.setLayoutManager(new LinearLayoutManager(CharacterDetailActivity.this, LinearLayoutManager.HORIZONTAL, false));
            storiesAdapter = new StoriesAdapter(CharacterDetailActivity.this, response.data.results, clickListener);
            recycler_stories.setAdapter(storiesAdapter);
        }

        @Override
        public void onError(String message) {
            Toast.makeText(CharacterDetailActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    private void showData(List<AllCharacterAPIResponse.Result> results) {
        String url = results.get(0).thumbnail.path+"."+results.get(0).thumbnail.extension;
        Picasso.get().load(url).into(imageView_character_banner);
        textView_character_banner_name.setText(results.get(0).name);
        textView_character_banner_name.setSelected(true);
        textView_character_banner_desc.setText(results.get(0).description);
        textView_character_name.setText(results.get(0).name);

//        events_loader
        recycler_events.setHasFixedSize(true);
        recycler_events.setLayoutManager(new LinearLayoutManager(CharacterDetailActivity.this, LinearLayoutManager.HORIZONTAL, false));
        eventsAdapter = new EventsAdapter(CharacterDetailActivity.this, results, clickListener);
        recycler_events.setAdapter(eventsAdapter);
    }

    private HomeMenuClickListener clickListener = new HomeMenuClickListener() {
        @Override
        public void onClick(String menu) {
//            Toast.makeText(CharacterDetailActivity.this, menu, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(CharacterDetailActivity.this, ComicDetailsActivity.class)
            .putExtra("comic_id", menu));
        }
    };
}