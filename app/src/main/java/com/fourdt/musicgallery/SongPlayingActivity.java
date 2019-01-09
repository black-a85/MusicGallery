package com.fourdt.musicgallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class SongPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_playing);
        Song song = getIntent().getParcelableExtra("now playing song");
        TextView nowPlayingSong = findViewById(R.id.now_playing_text_view);
        nowPlayingSong.setText(song.getName());
    }
}
