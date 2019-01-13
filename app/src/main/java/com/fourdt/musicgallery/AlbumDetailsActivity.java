package com.fourdt.musicgallery;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AlbumDetailsActivity extends AppCompatActivity {
    Song nowPlayingSong;
    ArrayList<Song> playlist;
    int trackNumber;
    boolean isPlaying = false;
    TextView nowPlayingTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_details);

        nowPlayingTextView = findViewById(R.id.now_playing_text_view);

        final Album album = getIntent().getParcelableExtra("album name");
        nowPlayingSong = getIntent().getParcelableExtra("now playing song");
        playlist = getIntent().getParcelableExtra("play list");
        updateNowPlaying();
        TextView albumName = findViewById(R.id.album_name_text_view);
        albumName.setText(album.getAlbumName());
        ListView albumSongs = findViewById(R.id.album_songs_list);
        albumSongs.setAdapter(new SongAdapter(this,album.getSongs()));
        ImageView albumBackground = findViewById(R.id.album_art_image_view);
        albumBackground.setImageResource(album.getAlbumArt());
        nowPlayingTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent songPlaying = new Intent(AlbumDetailsActivity.this, SongDetailsActivity.class);
                songPlaying.putExtra("now playing song", nowPlayingSong);
                songPlaying.putExtra("album name", album);
                songPlaying.putExtra("play list", playlist);
                startActivity(songPlaying);
            }
        });

        Button addAlbumToPlayList = findViewById(R.id.add_album_to_playlist);
        addAlbumToPlayList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (playlist != null) {
                    playlist.addAll(album.getSongs());
                } else {
                    playlist = new ArrayList<>();
                    playlist.addAll(album.getSongs());
                }
                Toast.makeText(AlbumDetailsActivity.this, album.getSongs().size() + " songs added to playlist", Toast.LENGTH_SHORT).show();
                checkPlaylist();
            }
        });

        final Button playStopButton = findViewById(R.id.song_play_stop_button);
        playStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPlaying) {
                    playStopButton.setBackgroundResource(R.mipmap.play);
                    isPlaying = false;
                    Toast.makeText(AlbumDetailsActivity.this, "playlist paused", Toast.LENGTH_SHORT).show();
                } else {
                    playStopButton.setBackgroundResource(R.mipmap.pause);
                    isPlaying = true;
                    Toast.makeText(AlbumDetailsActivity.this, "playlist playing", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button previousButton = findViewById(R.id.previous_track_button);
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (trackNumber > 0) {
                    trackNumber--;
                    updateNowPlaying();
                }
            }
        });


        Button nextButton = findViewById(R.id.next_track_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (trackNumber < playlist.size() - 1) {
                    trackNumber++;
                    updateNowPlaying();
                }
            }
        });
        checkPlaylist();
    }

    public void playSong (Song song){
        playlist = new ArrayList<>();
        playlist.add(song);
        trackNumber = 0;
        updateNowPlaying();
        checkPlaylist();
    }

    public void addSongToPlaylist(Song song) {
        if (playlist != null) {
            playlist.add(song);
        } else {
            playlist = new ArrayList<>();
            playlist.add(song);
        }
        Toast.makeText(AlbumDetailsActivity.this, song.getName() + " added to playlist", Toast.LENGTH_SHORT).show();
        checkPlaylist();
    }

    private void updateNowPlaying (){
        if (playlist != null) {
            nowPlayingTextView.setText(playlist.get(trackNumber).getName());
        } else {
            nowPlayingTextView.setText(R.string.no_track_playing);
        }
    }

    private void checkPlaylist() {
        Button previousButton = findViewById(R.id.previous_track_button);
        Button playStopButton = findViewById(R.id.song_play_stop_button);
        Button nextButton = findViewById(R.id.next_track_button);
        if (playlist == null) {
            previousButton.setClickable(false);
            previousButton.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
            playStopButton.setClickable(false);
            playStopButton.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
            nextButton.setClickable(false);
            nextButton.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
        } else {
            previousButton.setClickable(true);
            previousButton.getBackground().setColorFilter(null);
            playStopButton.setClickable(true);
            playStopButton.getBackground().setColorFilter(null);
            nextButton.setClickable(true);
            nextButton.getBackground().setColorFilter(null);
        }
    }
}
