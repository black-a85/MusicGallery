package com.fourdt.musicgallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;


public class SongDetailsActivity extends AppCompatActivity {
    private int trackNumber;
    private Button playStopButton;
    private boolean isPlaying;
    private ArrayList<Song> playlist;
    private TextView nowPlayingTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_details);


        nowPlayingTextView = findViewById(R.id.now_playing_text_view);

        trackNumber = getIntent().getIntExtra("now playing track", 0);
        Album album = getIntent().getParcelableExtra("album name");
        playlist = getIntent().getParcelableArrayListExtra("playlist");
        Song nowPlayingSong = playlist.get(trackNumber);
        TextView songDurationTextView = findViewById(R.id.song_duration_text_view);
        String duration = String.format(Locale.getDefault(), "%02d:%02d", nowPlayingSong.getDuration() / 60, nowPlayingSong.getDuration() % 60);
        songDurationTextView.setText(duration);
        TextView artistNameTextView = findViewById(R.id.artist_name_text_view);
        artistNameTextView.setText(album.getArtist());
        TextView albumNameTextView = findViewById(R.id.album_name_text_view);
        albumNameTextView.setText(album.getAlbumName());
        ImageView albumImageView = findViewById(R.id.album_art_image_view);
        albumImageView.setImageResource(album.getAlbumArt());
        playStopButton = findViewById(R.id.song_play_stop_button);
        playStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPlaying) {
                    playStopButton.setBackgroundResource(R.mipmap.play);
                    isPlaying = false;
                    Toast.makeText(SongDetailsActivity.this, "playlist paused", Toast.LENGTH_SHORT).show();
                } else {
                    playStopButton.setBackgroundResource(R.mipmap.pause);
                    isPlaying = true;
                    Toast.makeText(SongDetailsActivity.this, "playlist playing", Toast.LENGTH_SHORT).show();
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
                } else if (trackNumber == 0) {
                    Toast.makeText(SongDetailsActivity.this, "this is the first track in playlist",
                            Toast.LENGTH_SHORT).show();
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
                } else if (trackNumber == playlist.size() - 1) {
                    Toast.makeText(SongDetailsActivity.this, "this is the last track in playlist",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void updateNowPlaying() {
        if (playlist != null) {
            nowPlayingTextView.setText(playlist.get(trackNumber).getName());

        } else {
            nowPlayingTextView.setText(R.string.no_track_playing);
        }
    }
}
