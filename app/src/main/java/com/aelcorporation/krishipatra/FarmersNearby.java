package com.aelcorporation.krishipatra;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import Model.User;

public class FarmersNearby extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DatabaseReference table_user;
    private DatabaseReference mRef;
    public static String post_key;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmers_nearby);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerViewnearby);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        table_user =FirebaseDatabase.getInstance().getReference("User");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("नजिकी किसानहरु");


        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             finish();
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<User, FarmersNearby.BlogzoneViewHolder> FBRA = new FirebaseRecyclerAdapter<User, FarmersNearby.BlogzoneViewHolder>(
                User.class,
                R.layout.farmersrow,
                FarmersNearby.BlogzoneViewHolder.class,
                table_user
        ) {
            @Override
            protected void populateViewHolder(final FarmersNearby.BlogzoneViewHolder viewHolder, User model, int position) {
                final String post_key = getRef(position).getKey();

                viewHolder.setName(model.getName());
                viewHolder.setNumber(post_key);
                ImageButton call = (ImageButton)viewHolder.mView.findViewById(R.id.btnCall);

                call.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        TextView post_number = findViewById(R.id.numberContactTxt);
                        final String numbertocall = post_number.getText().toString();
                        Intent callphone = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + numbertocall));
                        startActivity(callphone);


                    }
                });

                        ImageButton sendMessageBtn = (ImageButton)viewHolder.mView.findViewById(R.id.btnMessage);

                        sendMessageBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                TextView post_number = findViewById(R.id.numberContactTxt);
                                final String numbertocall = post_number.getText().toString();

                                 startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("sms:" + numbertocall)));

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
        public void setName(String name){
            TextView post_title = mView.findViewById(R.id.nameContactTxt);
            post_title.setText(name);
        }

        public void setNumber(String post_key){
            TextView post_number = mView.findViewById(R.id.numberContactTxt);
            post_number.setText(post_key);
        }


    }

}