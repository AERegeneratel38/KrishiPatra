package com.aelcorporation.krishipatra.krishisamachar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aelcorporation.krishipatra.R;

public class newsdetail extends AppCompatActivity {


    TextView mTitleTv, mDetailTv, mDetailNewsTv;
    ImageView mImageIv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsdetail);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("समाचार");
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setDisplayShowHomeEnabled(true);




        mTitleTv = findViewById(R.id.titleTv);
        mDetailTv = findViewById(R.id.descriptionTv);
        mImageIv = findViewById(R.id.imageView);
        mDetailNewsTv = findViewById(R.id.detailnewsTv);

        Intent i = getIntent();



        String title = i.getStringExtra("title");
        String description = i.getStringExtra("description");




        mTitleTv.setText(title);
        mDetailTv.setText(description);
        mDetailNewsTv.setText(ViewHolder.detailofnews);

        mImageIv.setImageDrawable(newshome.ImageDrawable);





    }


    @Override
    public boolean onSupportNavigateUp() {

        onBackPressed();
        return true;


    }
}
