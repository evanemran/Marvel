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
import com.evanemran.marvel.Model.SeriesResponse;
import com.evanemran.marvel.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SeriesAdapter extends RecyclerView.Adapter<SeriesViewHolder>{

    Context context;
    List<SeriesResponse.Result> list;
    HomeMenuClickListener listener;

    public SeriesAdapter(Context context, List<SeriesResponse.Result> list, HomeMenuClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public SeriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SeriesViewHolder(LayoutInflater.from(context).inflate(R.layout.series_list, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull SeriesViewHolder holder, int position) {
        String url = list.get(position).thumbnail.path+"."+list.get(position).thumbnail.extension;
        Picasso.get().load(url).into(holder.imageView_series);
        holder.textView_series_name.setText(list.get(position).title);
        holder.textView_series_name.setSelected(true);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
class SeriesViewHolder extends RecyclerView.ViewHolder {

    CardView series_container;
    ImageView imageView_series;
    TextView textView_series_name;
    public SeriesViewHolder(@NonNull View itemView) {
        super(itemView);
        textView_series_name = itemView.findViewById(R.id.textView_series_name);
        series_container = itemView.findViewById(R.id.series_container);
        imageView_series = itemView.findViewById(R.id.imageView_series);
    }
}
