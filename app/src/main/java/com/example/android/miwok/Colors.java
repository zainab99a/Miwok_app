package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Colors extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> word = new ArrayList<Word>();
        word.add(new Word("red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
        word.add(new Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow,
                R.raw.color_mustard_yellow));
        word.add(new Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow,
                R.raw.color_dusty_yellow));
        word.add(new Word("green", "chokokki", R.drawable.color_green, R.raw.color_green));
        word.add(new Word("brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
        word.add(new Word("gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
        word.add(new Word("black", "kululli", R.drawable.color_black, R.raw.color_black));
        word.add(new Word("white", "kelelli", R.drawable.color_white, R.raw.color_white));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, word,R.color.category_colors);

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
                  MediaPlayer  mMediaPlayer = MediaPlayer.create(Colors.this, words.getAudioResourceId());

                    // Start the audio file
                    mMediaPlayer.start();


                }
        });
    }


}