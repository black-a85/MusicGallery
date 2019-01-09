package com.fourdt.musicgallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AlbumAdapter extends ArrayAdapter<Album> {

    public AlbumAdapter(Context context, ArrayList<Album> albums){
        super(context,0,albums);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Album album = getItem(position);
        View gridItemView = convertView;
        if (gridItemView == null){
            gridItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.album_grid_layout,parent,false);
        }

        if (album != null){
            ImageView albumArt = gridItemView.findViewById(R.id.album_art_image_view);
            albumArt.setImageResource(album.getAlbumArt());
            TextView albumName = gridItemView.findViewById(R.id.album_name_text_view);
            albumName.setText(album.getAlbumName());
        }
        return gridItemView;
    }
}
