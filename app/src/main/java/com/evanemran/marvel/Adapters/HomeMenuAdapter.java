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
import com.evanemran.marvel.Model.MainMenu;
import com.evanemran.marvel.R;

import java.util.List;

public class HomeMenuAdapter extends RecyclerView.Adapter<HomeMenuViewHolder>{

    Context context;
    List<MainMenu> list;
    HomeMenuClickListener listener;

    public HomeMenuAdapter(Context context, List<MainMenu> list, HomeMenuClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public HomeMenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeMenuViewHolder(LayoutInflater.from(context).inflate(R.layout.list_home, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeMenuViewHolder holder, int position) {
        holder.imageView_home_list.setImageResource(list.get(position).getIconId());
        holder.textView_home_list.setText(list.get(position).getName());

        holder.home_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(list.get(holder.getAdapterPosition()).getName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class HomeMenuViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView_home_list;
    TextView textView_home_list;
    CardView home_container;
    public HomeMenuViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView_home_list = itemView.findViewById(R.id.imageView_home_list);
        textView_home_list = itemView.findViewById(R.id.textView_home_list);
        home_container = itemView.findViewById(R.id.home_container);
    }
}
