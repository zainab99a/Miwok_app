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

public class FamilyMembers extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        final   ArrayList<Word> word = new ArrayList<Word>();
        word.add(new Word("father", "әpә", R.drawable.family_father, R.raw.family_father));
        word.add(new Word("mother", "әṭa", R.drawable.family_mother, R.raw.family_mother));
        word.add(new Word("son", "angsi", R.drawable.family_son, R.raw.family_son));
        word.add(new Word("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter));
        word.add(new Word("older brother", "taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        word.add(new Word("younger brother", "chalitti", R.drawable.family_younger_brother,
                R.raw.family_younger_brother));
        word.add(new Word("older sister", "teṭe", R.drawable.family_older_sister,
                R.raw.family_older_sister));
        word.add(new Word("younger sister", "kolliti", R.drawable.family_younger_sister,
                R.raw.family_younger_sister));
        word.add(new Word("grandmother ", "ama", R.drawable.family_grandmother,
                R.raw.family_grandmother));
        word.add(new Word("grandfather", "paapa", R.drawable.family_grandfather,
                R.raw.family_grandfather));
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
                MediaPlayer   mMediaPlayer = MediaPlayer.create(FamilyMembers.this, words.getAudioResourceId());

                // Start the audio file
                mMediaPlayer.start();

                // Setup a listener on the media player, so that we can stop and release the
                // media player once the sound has finished playing.

            }
        });

    }



}
