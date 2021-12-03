package com.evanemran.marvel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.evanemran.marvel.Adapters.HomeMenuAdapter;
import com.evanemran.marvel.Listeners.AllCharactersResponseListener;
import com.evanemran.marvel.Listeners.HomeMenuClickListener;
import com.evanemran.marvel.Listeners.UpcomingApiResponseListener;
import com.evanemran.marvel.Model.AllCharacterAPIResponse;
import com.evanemran.marvel.Model.MainMenu;
import com.evanemran.marvel.Model.UpcomingResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RequestManager manager;
    List<MainMenu> menuList = new ArrayList<>();
    HomeMenuAdapter homeMenuAdapter;
    RecyclerView recyclerView_home;
    ImageView imageView_upcoming;
    TextView banner_movie_name, banner_movie_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.red));

        recyclerView_home = findViewById(R.id.recycler_home_menu);
        imageView_upcoming = findViewById(R.id.imageView_upcoming);
        banner_movie_name = findViewById(R.id.banner_movie_name);
        banner_movie_time = findViewById(R.id.banner_movie_time);

        manager = new RequestManager(this);
//        manager.getAllCharacters(listener);

        loadUpcomingBanner();

        initMainMenu();
    }

    private void loadUpcomingBanner() {
        manager.getUpcomingMovie(upcomingApiResponseListener);

    }

    private final UpcomingApiResponseListener upcomingApiResponseListener = new UpcomingApiResponseListener() {
        @Override
        public void onFetch(UpcomingResponse response, String message) {
            Picasso.get().load(response.poster_url).into(imageView_upcoming);
            banner_movie_name.setText(response.title);
            banner_movie_name.setSelected(true);
            banner_movie_time.setText(response.days_until + " days to go!");
        }

        @Override
        public void onError(String message) {
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    private void initMainMenu() {
        menuList.add(new MainMenu("Characters", R.drawable.characters));
        menuList.add(new MainMenu("Comics", R.drawable.marvel_comics));
        menuList.add(new MainMenu("Creators", R.drawable.characters));
        menuList.add(new MainMenu("Events", R.drawable.characters));
        menuList.add(new MainMenu("Series", R.drawable.characters));
        menuList.add(new MainMenu("Stories", R.drawable.characters));

        recyclerView_home.setHasFixedSize(true);
        recyclerView_home.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        homeMenuAdapter = new HomeMenuAdapter(this, menuList, homeMenuClickListener);
        recyclerView_home.setAdapter(homeMenuAdapter);
    }

    private final HomeMenuClickListener homeMenuClickListener = new HomeMenuClickListener() {
        @Override
        public void onClick(String menu) {
            switch (menu){
                case "Characters":
                    startActivity(new Intent(MainActivity.this, CharactersActivity.class));
                    break;
                default:
                    Toast.makeText(MainActivity.this, menu, Toast.LENGTH_SHORT).show();
            }
        }
    };
}