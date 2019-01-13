package com.fourdt.musicgallery;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class SongAdapter extends ArrayAdapter<Song> {
    private Context mContext;

    public SongAdapter(Context context, ArrayList<Song> songs){
        super(context,0,songs);
        this.mContext = context;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        final Song song = getItem(position);
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_list_layout,parent,false);
        }

        if (song != null){
            TextView songNameView = listItemView.findViewById(R.id.song_name_text_view);
            songNameView.setText(song.getName());
            TextView songDurationView = listItemView.findViewById(R.id.song_duration_text_view);
            String songDuration = String.format(Locale.getDefault(), "%02d:%02d", song.getDuration() / 60, song.getDuration() % 60);
            songDurationView.setText(songDuration);
            Button playButton = listItemView.findViewById(R.id.song_play_button);
            playButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mContext instanceof AlbumDetailsActivity){
                        ((AlbumDetailsActivity)mContext).playSong(song);
                    } else {
                        Toast.makeText(mContext, "Error, can't Play Song " + song.getName(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
            Button addSongToPlayList = listItemView.findViewById(R.id.add_song_to_play_list_button);
            addSongToPlayList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mContext instanceof AlbumDetailsActivity) {
                        ((AlbumDetailsActivity) mContext).addSongToPlaylist(song);
                    }
                }
            });
        }
        return listItemView;
    }
}
