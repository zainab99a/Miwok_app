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

public class Phrases extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> word = new ArrayList<Word>();
        word.add(new Word("Where are you going?", "minto wuksus",
                R.raw.phrase_where_are_you_going));
        word.add(new Word("What is your name?", "tinnә oyaase'nә",
                R.raw.phrase_what_is_your_name));
        word.add(new Word("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
        word.add(new Word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
        word.add(new Word("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
        word.add(new Word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
        word.add(new Word("Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
        word.add(new Word("I’m coming.", "әәnәm", R.raw.phrase_im_coming));
        word.add(new Word("Let’s go.", "yoowutis", R.raw.phrase_lets_go));
        word.add(new Word("Come here.", "әnni'nem", R.raw.phrase_come_here));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, word,R.color.category_phrases);

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
                   MediaPlayer mMediaPlayer = MediaPlayer.create(Phrases.this, words.getAudioResourceId());

                    // Start the audio file
                    mMediaPlayer.start();

                }

});}}
