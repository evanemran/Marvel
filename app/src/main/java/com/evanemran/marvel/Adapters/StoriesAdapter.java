package com.evanemran.marvel.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.evanemran.marvel.Listeners.HomeMenuClickListener;
import com.evanemran.marvel.Model.StoriesResponse;
import com.evanemran.marvel.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class StoriesAdapter extends RecyclerView.Adapter<StoriesViewHolder>{

    Context context;
    List<StoriesResponse.Result> list;
    HomeMenuClickListener listener;

    public StoriesAdapter(Context context, List<StoriesResponse.Result> list, HomeMenuClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public StoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StoriesViewHolder(LayoutInflater.from(context).inflate(R.layout.stories_list, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull StoriesViewHolder holder, int position) {
        Picasso.get().load(R.drawable.story_placeholder)
        .placeholder(R.drawable.story_placeholder).into(holder.imageView_stories);

        holder.textView_stories_name.setText(list.get(position).title);
        holder.textView_stories_name.setSelected(true);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class StoriesViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView_stories;
    TextView textView_stories_name;
    CardView stories_container;
    public StoriesViewHolder(@NonNull View itemView) {
        super(itemView);
        stories_container = itemView.findViewById(R.id.stories_container);
        imageView_stories = itemView.findViewById(R.id.imageView_stories);
        textView_stories_name = itemView.findViewById(R.id.textView_stories_name);
    }
}
