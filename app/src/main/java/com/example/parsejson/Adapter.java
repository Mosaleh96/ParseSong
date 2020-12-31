package com.example.parsejson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    LayoutInflater inflater;
    List<Song> songs;

    public Adapter(Context ctx, List<Song> songs) {
        this.inflater = LayoutInflater.from(ctx);
        this.songs = songs;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    private ViewGroup parent;
    View view = inflater.inflate(R.layout.custom_list_layout, parent, false);
  //  return new viewHolder(view);



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.songTitle.setText(songs.get(position).getTitle());
              holder.songArtists.setText(songs.get(position).getArtist());
        Picasso .get().load(songs.get(position).getCoverImage()).into(holder.songcoverImage);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView  songTitle ,songArtists;
        ImageView songcoverImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           // songTitle =itemView.findViewById(R.id.songTitle);
            songArtists =itemView.findViewById(R.id.songArtists);
            songcoverImage=itemView.findViewById(R.id.songcoverImage);

        }


    }
}
