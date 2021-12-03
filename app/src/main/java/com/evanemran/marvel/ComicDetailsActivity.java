package com.evanemran.marvel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.evanemran.marvel.Listeners.ComicResponseListener;
import com.evanemran.marvel.Model.ComicResponse;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Wave;
import com.squareup.picasso.Picasso;

public class ComicDetailsActivity extends AppCompatActivity {
    CardView container_comics;
    ImageView imageView_comic_details;
    TextView textView_comic_details_name, textView_comic_issue, textView_comic_pages, textView_comic_details, textView_comic_price;
    Button button_comic_buy;
    RequestManager manager;
    String comic_id;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_details);

        button_comic_buy = findViewById(R.id.button_comic_buy);
        container_comics = findViewById(R.id.container_comics);
        imageView_comic_details = findViewById(R.id.imageView_comic_details);
        textView_comic_details_name = findViewById(R.id.textView_comic_details_name);
        textView_comic_issue = findViewById(R.id.textView_comic_issue);
        textView_comic_pages = findViewById(R.id.textView_comic_pages);
        textView_comic_details = findViewById(R.id.textView_comic_details);
        textView_comic_price = findViewById(R.id.textView_comic_price);

        progressBar = (ProgressBar)findViewById(R.id.loader);
        Sprite anim = new Wave();
        progressBar.setIndeterminateDrawable(anim);

        comic_id = getIntent().getStringExtra("comic_id");

        manager = new RequestManager(this);
        manager.getComicDetails(comicResponseListener, comic_id);


    }

    private final ComicResponseListener comicResponseListener = new ComicResponseListener() {
        @Override
        public void onFetch(ComicResponse response, String message) {
            Picasso.get().load(response.data.results.get(0).thumbnail.path+"."+response.data.results.get(0).thumbnail.extension)
                    .placeholder(R.drawable.story_placeholder).into(imageView_comic_details);
            textView_comic_details_name.setText(response.data.results.get(0).title);
            textView_comic_issue.setText("Issue No: " + response.data.results.get(0).issueNumber);
            textView_comic_pages.setText("Pages: " + response.data.results.get(0).pageCount);
            textView_comic_details.setText(response.data.results.get(0).description);
            textView_comic_price.setText("Price: " + response.data.results.get(0).prices.get(0).price+" $");
            progressBar.setVisibility(View.GONE);
            container_comics.setVisibility(View.VISIBLE);
        }

        @Override
        public void onError(String message) {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(ComicDetailsActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };
}