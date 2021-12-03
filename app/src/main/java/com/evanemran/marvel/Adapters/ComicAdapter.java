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
import com.evanemran.marvel.Model.AllCharacterAPIResponse;
import com.evanemran.marvel.Model.ComicResponse;
import com.evanemran.marvel.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ComicAdapter extends RecyclerView.Adapter<ComicViewHolder>{
    Context context;
    List<ComicResponse.Result> list;
    HomeMenuClickListener listener;

    public ComicAdapter(Context context, List<ComicResponse.Result> list, HomeMenuClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ComicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ComicViewHolder(LayoutInflater.from(context).inflate(R.layout.comic_list, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ComicViewHolder holder, int position) {
        holder.textView_comic_name.setText(list.get(position).title);
        holder.textView_comic_name.setSelected(true);

        String url = list.get(position).thumbnail.path+"."+list.get(position).thumbnail.extension;

        Picasso.get().load(url).into(holder.imageView_comic);

        holder.comic_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(String.valueOf(list.get(holder.getAdapterPosition()).id));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class ComicViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView_comic;
    TextView textView_comic_name;
    CardView comic_container;

    public ComicViewHolder(@NonNull View itemView) {
        super(itemView);
        textView_comic_name = itemView.findViewById(R.id.textView_comic_name);
        imageView_comic = itemView.findViewById(R.id.imageView_comic);
        comic_container = itemView.findViewById(R.id.comic_container);
    }
}
