package com.evanemran.marvel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.evanemran.marvel.Adapters.CharactersAdapter;
import com.evanemran.marvel.Listeners.AllCharactersResponseListener;
import com.evanemran.marvel.Listeners.HomeMenuClickListener;
import com.evanemran.marvel.Model.AllCharacterAPIResponse;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Wave;

import java.util.List;

public class CharactersActivity extends AppCompatActivity {

    RecyclerView recyclerView_character;
    CharactersAdapter charactersAdapter;
    RequestManager manager;
    SearchView searchView_characters;
    RelativeLayout activity_character_container;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characters);

        recyclerView_character = findViewById(R.id.recycler_character_items);
        searchView_characters = findViewById(R.id.searchView_characters);
        activity_character_container = findViewById(R.id.activity_character_container);

        progressBar = (ProgressBar)findViewById(R.id.loader);
        Sprite anim = new Wave();
        progressBar.setIndeterminateDrawable(anim);

        manager = new RequestManager(this);
        manager.getAllCharacters(listener);
        searchView_characters.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                manager.searchCharacters(listener, query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }

    private final AllCharactersResponseListener listener = new AllCharactersResponseListener() {
        @Override
        public void onFetch(AllCharacterAPIResponse response, String message) {
//            Toast.makeText(CharactersActivity.this, "Got data!", Toast.LENGTH_SHORT).show();
            showData(response.getData().results);
            progressBar.setVisibility(View.GONE);
            activity_character_container.setVisibility(View.VISIBLE);
        }

        @Override
        public void onError(String message) {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(CharactersActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    private void showData(List<AllCharacterAPIResponse.Result> results) {
        recyclerView_character.setHasFixedSize(true);
        recyclerView_character.setLayoutManager(new GridLayoutManager(this, 3));
        charactersAdapter = new CharactersAdapter(this, results, homeMenuClickListener);
        recyclerView_character.setAdapter(charactersAdapter);
    }

    private final HomeMenuClickListener homeMenuClickListener = new HomeMenuClickListener() {
        @Override
        public void onClick(String menu) {
//            Toast.makeText(CharactersActivity.this, menu, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(CharactersActivity.this, CharacterDetailActivity.class)
            .putExtra("character_id", menu));
        }
    };
}