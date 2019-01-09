package com.fourdt.musicgallery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class AlbumDetailsActivity extends AppCompatActivity {
    Song nowPlayingSong;
    TextView nowPlayingTextView = findViewById(R.id.now_playing_text_view);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_details);

        final Album album = getIntent().getParcelableExtra("album name");
        nowPlayingSong = getIntent().getParcelableExtra("now playing song");
        updateNowPlaying();
        ListView albumSongs = findViewById(R.id.album_songs_list);
        albumSongs.setAdapter(new SongAdapter(this,album.getSongs()));
        nowPlayingTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent songPlaying = new Intent(AlbumDetailsActivity.this, SongPlayingActivity.class);
                songPlaying.putExtra("now playing song", nowPlayingSong);
                songPlaying.putExtra("album name", album);
                startActivity(songPlaying);
            }
        });
    }

    public void playSong (Song song){
        nowPlayingSong = song;
        updateNowPlaying();
    }

    private void updateNowPlaying (){

        if (nowPlayingSong != null){
            nowPlayingTextView.setText(nowPlayingSong.getName());
        } else {
            nowPlayingTextView.setText(R.string.no_track_playing);
        }
    }
}
