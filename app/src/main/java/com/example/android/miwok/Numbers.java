package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowInsetsControllerCompat;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;

public class Numbers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        final   ArrayList<Word> word = new ArrayList<Word>();
        word.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
        word.add(new Word("two", "otiiko", R.drawable.number_two, R.raw.number_two));
        word.add(new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        word.add(new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        word.add(new Word("five", "massokka", R.drawable.number_five, R.raw.number_five));
        word.add(new Word("six", "temmokka", R.drawable.number_six, R.raw.number_six));
        word.add(new Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        word.add(new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        word.add(new Word("nine", "wo’e", R.drawable.number_nine, R.raw.number_nine));
        word.add(new Word("ten", "na’aacha", R.drawable.number_ten, R.raw.number_ten));
        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, word,R.color.category_numbers);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word words = word.get(position);//to add an audio to list


                    // Create and setup the {@link MediaPlayer} for the audio resource associated
                    // with the current word
                 MediaPlayer   mMediaPlayer = MediaPlayer.create(Numbers.this, words.getAudioResourceId());

                    // Start the audio file
                    mMediaPlayer.start();

                    // Setup a listener on the media player, so that we can stop and release the
                    // media player once the sound has finished playing.

                }
            });

    }



}