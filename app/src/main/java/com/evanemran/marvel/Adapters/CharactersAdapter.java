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

public class CharactersAdapter extends RecyclerView.Adapter<CharacterViewHolder>{
    Context context;
    List<AllCharacterAPIResponse.Result> list;
    HomeMenuClickListener listener;

    public CharactersAdapter(Context context, List<AllCharacterAPIResponse.Result> list, HomeMenuClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CharacterViewHolder(LayoutInflater.from(context).inflate(R.layout.characters_list, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        String url = list.get(position).thumbnail.path+"."+list.get(position).thumbnail.extension;
        try{
            Picasso.get().load(url).placeholder(R.drawable.characters).into(holder.imageView_character_item);
        }catch (Exception e){
            e.printStackTrace();
        }
        holder.textView_character_item.setText(list.get(position).name);
        holder.textView_character_item.setSelected(true);

        holder.cardView_character.setOnClickListener(new View.OnClickListener() {
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

class CharacterViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView_character_item;
    TextView textView_character_item;
    CardView cardView_character;
    public CharacterViewHolder(@NonNull View itemView) {
        super(itemView);
        cardView_character = itemView.findViewById(R.id.cardView_character);
        imageView_character_item = itemView.findViewById(R.id.imageView_character_item);
        textView_character_item = itemView.findViewById(R.id.textView_character_item);
    }
}
