package com.aelcorporation.krishipatra;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.aelcorporation.krishipatra.forumsection.ForumActivity;
import com.aelcorporation.krishipatra.krishisamachar.newshome;
import com.aelcorporation.krishipatra.view.activities.ECartHomeActivity;


public class HomeActivity extends AppCompatActivity {

    LinearLayout samachar, sodhpuch, video, market, chat, profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        samachar = findViewById(R.id.samachar);
        sodhpuch = findViewById(R.id.sodhpuch);
        video = findViewById(R.id.video);
        market = findViewById(R.id.market);
        chat = findViewById(R.id.chat);
        profile = findViewById(R.id.profile);

        market.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, ECartHomeActivity.class);
                startActivity(i);
            }
        });

      samachar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openNews = new Intent(HomeActivity.this, newshome.class );
                startActivity(openNews);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openProfile = new Intent(HomeActivity.this, ProfileSection.class );
                startActivity(openProfile);
            }
        });

        sodhpuch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openForum = new Intent(HomeActivity.this, ForumActivity.class );
                startActivity(openForum);
            }
        });

        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openChat = new Intent(HomeActivity.this, FarmersNearby.class );
                startActivity(openChat);
            }
        });


        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openVideo = new Intent(HomeActivity.this, com.aelcorporation.krishipatra.activity.HomeActivity.class );
                startActivity(openVideo);
            }
        });


        /*








*/
    }





}





