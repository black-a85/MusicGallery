package com.fourdt.musicgallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;


public class SongPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_playing);
        Song song = getIntent().getParcelableExtra("now playing song");
        Album album = getIntent().getParcelableExtra("album name");
        TextView nowPlayingSong = findViewById(R.id.song_name_text_view);
        nowPlayingSong.setText(song.getName());
        TextView songDurationTextView = findViewById(R.id.song_duration_text_view);
        String duration = String.format(Locale.getDefault(), "%02d:%02d", song.getDuration() / 60, song.getDuration() % 60);
        songDurationTextView.setText(duration);
        TextView artistNameTextView = findViewById(R.id.artist_name_text_view);
        artistNameTextView.setText(album.getArtist());
        TextView albumNameTextView = findViewById(R.id.album_name_text_view);
        albumNameTextView.setText(album.getAlbumName());
        ImageView albumImageView = findViewById(R.id.album_art_image_view);
        albumImageView.setImageResource(album.getAlbumArt());
    }
}
