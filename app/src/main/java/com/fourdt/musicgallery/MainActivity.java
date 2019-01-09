package com.fourdt.musicgallery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Song nowPlayingSong;
    ArrayList<Album> albums = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        albums.add(new Album("album 1", "artist 1", R.drawable.ic_launcher_foreground));
        albums.add(new Album("album 2", "artist 2", R.drawable.ic_launcher_foreground));
        albums.add(new Album("album 3", "artist 3", R.drawable.ic_launcher_foreground));
        albums.add(new Album("album 4", "artist 2", R.drawable.ic_launcher_foreground));
        albums.add(new Album("album 5", "artist 1", R.drawable.ic_launcher_foreground));
        albums.add(new Album("album 6", "artist 3", R.drawable.ic_launcher_foreground));
        albums.get(1).addSong("song 1", 200);
        albums.get(1).addSong("song 2", 250);
        GridView albumGridView = findViewById(R.id.albums_grid);
        albumGridView.setAdapter(new AlbumAdapter(this,albums));
        albumGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent albumDetails = new Intent(MainActivity.this, AlbumDetailsActivity.class);
                albumDetails.putExtra("album name", albums.get(i));
                albumDetails.putExtra("now playing song", nowPlayingSong);
                startActivity(albumDetails);
            }
        });
        TextView nowPlayingTextView = findViewById(R.id.now_playing_text_view);
        if (nowPlayingSong != null){
            nowPlayingTextView.setText(nowPlayingSong.getName());
        } else {
            nowPlayingTextView.setText(R.string.no_track_playing);
        }
    }

}