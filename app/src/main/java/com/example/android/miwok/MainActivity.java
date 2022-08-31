/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
// import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
TextView textNumber,textFamily,textColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);
        textNumber=findViewById(R.id.numbers);
        textFamily=findViewById(R.id.family);
        textColor=findViewById(R.id.colors);
        textNumber.setOnClickListener(new View.OnClickListener() {
            //in this method we add onClick to do some code in side it like to show toast message and move to another activity
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this,Numbers.class);
                startActivity(i);
            }
        });
        textFamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,FamilyMembers.class);
                startActivity(i);
            }
        });

        textColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this,Colors.class);
                startActivity(i);
            }
        });
    }//end of onCreate()


    public void openPhrases(View view) {
        Intent i = new Intent(this, Phrases.class);
        startActivity(i);
    }
}//class end
