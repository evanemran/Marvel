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
import com.evanemran.marvel.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class EventsAdapter extends RecyclerView.Adapter<EventsViewHolder>{

    Context context;
    List<AllCharacterAPIResponse.Result> list;
    HomeMenuClickListener listener;

    public EventsAdapter(Context context, List<AllCharacterAPIResponse.Result> list, HomeMenuClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public EventsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EventsViewHolder(LayoutInflater.from(context).inflate(R.layout.events_list, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull EventsViewHolder holder, int position) {
        Picasso.get().load(R.drawable.events_placeholder).into(holder.imageView_events);
        holder.textView_events_name.setText(list.get(position).getEvents().items.get(position).name);
        holder.textView_events_name.setSelected(true);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
class EventsViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView_events;
    TextView textView_events_name;
    CardView events_container;
    public EventsViewHolder(@NonNull View itemView) {
        super(itemView);
        events_container = itemView.findViewById(R.id.events_container);
        imageView_events = itemView.findViewById(R.id.imageView_events);
        textView_events_name = itemView.findViewById(R.id.textView_events_name);
    }
}
