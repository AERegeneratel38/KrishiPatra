package com.aelcorporation.krishipatra.forumsection;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aelcorporation.krishipatra.HomeActivity;
import com.aelcorporation.krishipatra.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;
import android.view.View;
import android.support.design.widget.FloatingActionButton;


public class ForumActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DatabaseReference mReference;
    public static String postkey,  userid, userIid, numberaa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);


        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           finish();

            }
        });


        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("सोधपुछ");

        //initialize recyclerview and FIrebase objects
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        mReference = FirebaseDatabase.getInstance().getReference("Forum");


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newpost = new Intent(ForumActivity.this, ForumPostActivity.class);
                startActivity(newpost);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<ForumModel, BlogzoneViewHolder> FBRA = new FirebaseRecyclerAdapter<ForumModel, BlogzoneViewHolder>(
                ForumModel.class,
                R.layout.card_items,
                BlogzoneViewHolder.class,
                mReference
        ) {
            @Override
            protected void populateViewHolder(BlogzoneViewHolder viewHolder, ForumModel model, int position) {
                final String post_key = getRef(position).getKey();
                  final  String userid = model.getUid();
                viewHolder.setTitle(model.getTitle());
                viewHolder.setDesc(model.getDesc());
                viewHolder.setImageUrl(getApplicationContext(), model.getImageUrl());
                viewHolder.setUserName(model.getUid());
                viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent singleActivity = new Intent(ForumActivity.this, ForumDetailActivity.class);
                        postkey = post_key;
                        userIid = userid;
                        numberaa = postkey;
                        startActivity(singleActivity);


                    }
                });
            }
        };
        recyclerView.setAdapter(FBRA);
    }
    public static class BlogzoneViewHolder extends RecyclerView.ViewHolder{
        View mView;
        public BlogzoneViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }
        public void setTitle(String title){
            TextView post_title = mView.findViewById(R.id.post_title_txtview);
            post_title.setText(title);
        }
        public void setDesc(String desc){
            TextView post_desc = mView.findViewById(R.id.post_desc_txtview);
            post_desc.setText(desc);
        }
        public void setImageUrl(Context ctx, String imageUrl){
            ImageView post_image = mView.findViewById(R.id.post_image);
            Picasso.with(ctx).load(imageUrl).into(post_image);
        }
        public void setUserName(String userName){
            TextView postUserName = mView.findViewById(R.id.post_user);
            postUserName.setText(userName);
        }
    }

}
