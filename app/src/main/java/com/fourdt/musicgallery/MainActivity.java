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
    ArrayList<Song> playList;
    ArrayList<Album> albums = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        albums.add(new Album("Thriller", "Michael Jackson", R.drawable.thriller_album_art));
        albums.get(0).addSong("Wanna Be Startin' Somethin'", 363);
        albums.get(0).addSong("Baby Be Mine", 260);
        albums.get(0).addSong("The Girl Is Mine", 222);
        albums.get(0).addSong("Thriller", 5, 58);
        albums.get(0).addSong("Beat It", 4, 18);
        albums.get(0).addSong("Billie Jean", 4, 54);
        albums.get(0).addSong("Human Nature", 4, 6);
        albums.get(0).addSong("P.Y.T. (Pretty Young Thing)", 3, 59);
        albums.get(0).addSong("The Lady In My Life", 4, 59);

        albums.add(new Album("Their Greatest Hits", "Eagles", R.drawable.their_greatest_hits_album_art));
        albums.get(1).addSong("Take It Easy", 2, 29);
        albums.get(1).addSong("Witchy Woman", 4, 10);
        albums.get(1).addSong("Lyin' Eyes", 6, 21);
        albums.get(1).addSong("Already Gone", 4, 13);
        albums.get(1).addSong("Desperado", 3, 33);
        albums.get(1).addSong("One Of These Nights", 4, 51);
        albums.get(1).addSong("Tequila Sunrise", 2, 52);
        albums.get(1).addSong("Take It To The Limit", 4, 48);
        albums.get(1).addSong("Peaceful, Easy Feeling", 4, 16);
        albums.get(1).addSong("Best Of My Love", 4, 35);

        albums.add(new Album("Hotel California", "Eagles", R.drawable.hotel_california_album_art));
        albums.get(2).addSong("Hotel California", 6, 30);
        albums.get(2).addSong("New Kid In Town", 5, 40);
        albums.get(2).addSong("Life In The Fast Lane", 4, 46);
        albums.get(2).addSong("Wasted Time", 4, 55);
        albums.get(2).addSong("Wasted Time (Reprise)", 1, 22);
        albums.get(2).addSong("Victim Of Love", 4, 11);
        albums.get(2).addSong("Pretty Maids All In A Row", 4, 05);
        albums.get(2).addSong("Try And Love Again", 5, 10);
        albums.get(2).addSong("The Last Resort", 7, 25);

        albums.add(new Album("Come On Over", "Shania Twain", R.drawable.come_on_over_album_art));
        albums.get(3).addSong("You're Still The One", 3, 33);
        albums.get(3).addSong("When", 3, 38);
        albums.get(3).addSong("From This Moment On", 4, 52);
        albums.get(3).addSong("Black Eyes, Blue Tears", 3, 37);
        albums.get(3).addSong("I Won't Leave You Lonely", 4, 7);
        albums.get(3).addSong("I'm Holdin' On To Love (To Save My Life)", 3, 27);
        albums.get(3).addSong("Come On Over", 2, 54);
        albums.get(3).addSong("You've Got A Way", 3, 25);
        albums.get(3).addSong("Whatever You Do! Don't!", 3, 49);
        albums.get(3).addSong("Man! I Feel Like A Woman!", 3, 54);
        albums.get(3).addSong("Love Gets Me Every Time", 3, 33);
        albums.get(3).addSong("Don't Be Stupid (You Know I Love You)", 3, 34);
        albums.get(3).addSong("That Don't Impress Me Much", 3, 59);
        albums.get(3).addSong("Honey, I'm Home", 3, 34);
        albums.get(3).addSong("If You Wanna Touch Her, Ask!", 4, 14);
        albums.get(3).addSong("Rock This Country!", 4, 26);

        albums.add(new Album("Led Zeppelin IV", "Led Zeppelin", R.drawable.led_zepplin_iv_album_art));
        albums.get(4).addSong("Black Dog", 4, 55);
        albums.get(4).addSong("Rock And Roll", 3, 40);
        albums.get(4).addSong("The Battle Of Evermore", 5, 38);
        albums.get(4).addSong("Stairway To Heaven", 7, 55);
        albums.get(4).addSong("Misty Mountain Hop", 4, 39);
        albums.get(4).addSong("Four Sticks", 4, 49);
        albums.get(4).addSong("Going To California", 3, 36);
        albums.get(4).addSong("When The Levee Breaks", 7, 8);

        albums.add(new Album("The Bodyguard", "Whitney Houston & others", R.drawable.the_bodyguard_album_art));
        albums.get(5).addSong("I Will Always Love You", 4, 31);
        albums.get(5).addSong("I Have Nothing", 4, 50);
        albums.get(5).addSong("I'm Every Woman", 4, 47);
        albums.get(5).addSong("Run To You", 4, 25);
        albums.get(5).addSong("Queen Of The Night", 3, 9);
        albums.get(5).addSong("Jesus Loves Me", 5, 12);
        albums.get(5).addSong("Even If My Heart Would Break", 4, 58);
        albums.get(5).addSong("Someday (I'm Coming Back)", 4, 58);
        albums.get(5).addSong("It's Gonna Be A Lovely Day", 4, 51);
        albums.get(5).addSong("(What's So Funny 'Bout) Peace, Love And Understanding", 4, 5);
        albums.get(5).addSong("Theme From The Bodyguard", 2, 44);
        albums.get(5).addSong("Trust In Me", 4, 14);

        albums.add(new Album("Rumours", "Fleetwood Mac", R.drawable.rumours_album_art));
        albums.get(6).addSong("Second Hand News", 2, 43);
        albums.get(6).addSong("Dreams", 4, 14);
        albums.get(6).addSong("Never Going Back Again", 2, 2);
        albums.get(6).addSong("Don't Stop", 3, 11);
        albums.get(6).addSong("Go Your Own Way", 3, 38);
        albums.get(6).addSong("Songbird", 3, 20);
        albums.get(6).addSong("The Chain", 4, 28);
        albums.get(6).addSong("You Make Loving Fun", 3, 31);
        albums.get(6).addSong("I Don't Want To Know", 3, 11);
        albums.get(6).addSong("Oh Daddy", 3, 54);
        albums.get(6).addSong("Gold Dust Woman", 4, 51);

        albums.add(new Album("Back In Black", "AC/DC", R.drawable.back_in_black_album_art));
        albums.get(7).addSong("Hells Bells", 5, 9);
        albums.get(7).addSong("Shoot To Thrill", 5, 14);
        albums.get(7).addSong("What Do You Do For Money Honey", 3, 33);
        albums.get(7).addSong("Given The Dog A Bone", 3, 30);
        albums.get(7).addSong("Let Me Put My Love Into You", 4, 12);
        albums.get(7).addSong("Back In Black", 4, 13);
        albums.get(7).addSong("You Shook Me All Night Long", 3, 28);
        albums.get(7).addSong("Have A Drink On Me", 3, 57);
        albums.get(7).addSong("Shake A Leg", 4, 3);
        albums.get(7).addSong("Rock And Roll Ain't Noise Pollution", 4, 12);

        albums.add(new Album("21", "Adele", R.drawable.a21__album_art));
        albums.get(8).addSong("Rolling In The Deep", 3, 48);
        albums.get(8).addSong("Rumour Has It", 3, 43);
        albums.get(8).addSong("Turning Tables", 4, 10);
        albums.get(8).addSong("Don't You Remember", 4, 3);
        albums.get(8).addSong("Set Fire To The Rain", 4, 1);
        albums.get(8).addSong("He Won't Go", 4, 38);
        albums.get(8).addSong("Take It All", 3, 48);
        albums.get(8).addSong("I'll Be Waiting", 4, 2);
        albums.get(8).addSong("One And Only", 5, 48);
        albums.get(8).addSong("Love song", 11, 11);
        albums.get(8).addSong("Someone Like You", 5, 16);
        albums.get(8).addSong("I Found A Boy", 4, 45);

        albums.add(new Album("Jagged Little Pill", "Alanis Morissette", R.drawable.jagged_lettle_pill_album_art));
        albums.get(9).addSong("All I Really Want", 4, 45);
        albums.get(9).addSong("You Oughta Know", 4, 9);
        albums.get(9).addSong("Perfect", 3, 8);
        albums.get(9).addSong("Hand In My Pocket", 3, 41);
        albums.get(9).addSong("Right Through You", 2, 55);
        albums.get(9).addSong("Forgiven", 5, 0);
        albums.get(9).addSong("You Learn", 3, 59);
        albums.get(9).addSong("Head Over Feet", 4, 27);
        albums.get(9).addSong("Mary Jane", 4, 40);
        albums.get(9).addSong("Ironic", 3, 49);
        albums.get(9).addSong("Not The Doctor", 3, 47);
        albums.get(9).addSong("Wake Up", 4, 53);
        albums.get(9).addSong("You Oughta Know / Your House", 8, 11);

        albums.add(new Album("The Dark Side Of The Moon", "Pink Floyd ", R.drawable.dark_side_of_the_moon_album_art));
        albums.get(10).addSong("Breathe In The Air", 3, 57);
        albums.get(10).addSong("On The Run", 3, 31);
        albums.get(10).addSong("Time", 7, 5);
        albums.get(10).addSong("The Great Gig In The Sky", 4, 47);
        albums.get(10).addSong("Money", 6, 23);
        albums.get(10).addSong("Us And Them", 7, 48);
        albums.get(10).addSong("Any Colour You Like", 3, 25);
        albums.get(10).addSong("Brain Damage", 3, 50);
        albums.get(10).addSong("Eclipse", 2, 6);

        albums.add(new Album("1", "The Beatles", R.drawable.b1__album_art));
        albums.get(11).addSong("Love Me Do", 2, 20);
        albums.get(11).addSong("From Me To You", 1, 56);
        albums.get(11).addSong("She Loves You", 2, 21);
        albums.get(11).addSong("I Want To Hold Your Hand", 2, 25);
        albums.get(11).addSong("Can't Buy Me Love", 2, 11);
        albums.get(11).addSong("A Hard Day's Night", 2, 33);
        albums.get(11).addSong("I Feel Fine", 2, 18);
        albums.get(11).addSong("Eight Days A Week", 2, 44);
        albums.get(11).addSong("Ticket To Ride", 3, 10);
        albums.get(11).addSong("Help!", 2, 18);
        albums.get(11).addSong("Yesterday", 2, 5);
        albums.get(11).addSong("Day Tripper", 2, 48);
        albums.get(11).addSong("We Can Work It Out", 2, 15);
        albums.get(11).addSong("Paperback Writer", 2, 18);
        albums.get(11).addSong("Yellow Submarine", 2, 38);
        albums.get(11).addSong("Eleanor Rigby", 2, 6);
        albums.get(11).addSong("Penny Lane", 2, 59);
        albums.get(11).addSong("All You Need Is Love", 3, 47);
        albums.get(11).addSong("Hello, Goodbye", 3, 27);
        albums.get(11).addSong("Lady Madonna", 2, 16);
        albums.get(11).addSong("Hey Jude", 7, 4);
        albums.get(11).addSong("Get Back", 3, 12);
        albums.get(11).addSong("The Ballad Of John And Yoko", 2, 59);
        albums.get(11).addSong("Something", 3, 1);
        albums.get(11).addSong("Come Together", 4, 18);
        albums.get(11).addSong("Let It Be", 3, 50);
        albums.get(11).addSong("The Long And Winding Road", 3, 37);

        albums.add(new Album("Gold (Greatest Hits)", "Abba", R.drawable.gold_album_art));
        albums.get(12).addSong("Dancing Queen", 3, 49);
        albums.get(12).addSong("Knowing Me, Knowing You", 4, 1);
        albums.get(12).addSong("Take A Chance On Me", 4, 1);
        albums.get(12).addSong("Mamma Mia", 3, 32);
        albums.get(12).addSong("Lay All Your Love On Me", 4, 32);
        albums.get(12).addSong("Super Trouper", 4, 10);
        albums.get(12).addSong("I Have A Dream", 4, 43);
        albums.get(12).addSong("The Winner Takes It All", 4, 54);
        albums.get(12).addSong("Money, Money, Money", 3, 5);
        albums.get(12).addSong("S.O.S.", 3, 19);
        albums.get(12).addSong("Chiquitita", 5, 26);
        albums.get(12).addSong("Fernando", 4, 10);
        albums.get(12).addSong("Voulez Vous", 4, 21);
        albums.get(12).addSong("Gimme! Gimme! Gimme! (A Man After Midnight)", 4, 46);
        albums.get(12).addSong("Does Your Mother Know", 3, 14);
        albums.get(12).addSong("One Of Us", 3, 53);
        albums.get(12).addSong("The Name Of The Game", 3, 56);
        albums.get(12).addSong("Thank You For The Music", 3, 51);
        albums.get(12).addSong("Waterloo", 2, 42);

        albums.add(new Album("Legend ", "Bob Marley & The Wailers", R.drawable.legend_album_art));
        albums.get(13).addSong("Is This Love", 3, 52);
        albums.get(13).addSong("No Woman No Cry", 4, 5);
        albums.get(13).addSong("Could You Be Loved", 3, 33);
        albums.get(13).addSong("Three Little Birds", 2, 56);
        albums.get(13).addSong("Buffalo Soldier", 5, 24);
        albums.get(13).addSong("Get Up Stand Up", 3, 17);
        albums.get(13).addSong("Stir It Up", 3, 38);
        albums.get(13).addSong("One Love / People Get Ready", 2, 52);
        albums.get(13).addSong("I Shot The Sheriff", 3, 46);
        albums.get(13).addSong("Waiting In Vain", 4, 10);
        albums.get(13).addSong("Redemption Song", 3, 48);
        albums.get(13).addSong("Satisfy My Soul", 3, 45);
        albums.get(13).addSong("Exodus", 5, 24);
        albums.get(13).addSong("Jamming", 3, 17);

        albums.add(new Album("Appetite For Destruction", "Guns N' Roses", R.drawable.appetit_for_destruction_album_art));
        albums.get(14).addSong("Welcome To The Jungle", 4, 31);
        albums.get(14).addSong("It's So Easy", 3, 21);
        albums.get(14).addSong("Nightrain", 4, 26);
        albums.get(14).addSong("Out Ta Get Me", 4, 26);
        albums.get(14).addSong("Mr. Brownstone", 3, 46);
        albums.get(14).addSong("Paradise City", 6, 46);
        albums.get(14).addSong("My Michelle", 3, 39);
        albums.get(14).addSong("Think About You", 3, 50);
        albums.get(14).addSong("Sweet Child O' Mine", 5, 55);
        albums.get(14).addSong("You're Crazy", 3, 25);
        albums.get(14).addSong("Anything Goes", 3, 25);
        albums.get(14).addSong("Rocket Queen", 6, 13);

        GridView albumGridView = findViewById(R.id.albums_grid);
        albumGridView.setAdapter(new AlbumAdapter(this,albums));
        albumGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent albumDetails = new Intent(MainActivity.this, AlbumDetailsActivity.class);
                albumDetails.putExtra("album name", albums.get(i));
                albumDetails.putExtra("now playing song", nowPlayingSong);
                albumDetails.putExtra("play list", playList);
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