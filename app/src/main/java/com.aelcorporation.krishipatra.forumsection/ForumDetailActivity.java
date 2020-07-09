package com.aelcorporation.krishipatra.forumsection;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.aelcorporation.krishipatra.FarmersNearby;
import com.aelcorporation.krishipatra.HomeActivity;
import com.aelcorporation.krishipatra.ProfileSection;
import com.aelcorporation.krishipatra.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;


import com.aelcorporation.krishipatra.forumsection.CommentModel;

import static com.aelcorporation.krishipatra.LoginActivity.UserId;
import static com.aelcorporation.krishipatra.forumsection.ForumActivity.numberaa;
import static com.aelcorporation.krishipatra.forumsection.ForumActivity.postkey;
import static com.aelcorporation.krishipatra.forumsection.ForumActivity.userid;

public class ForumDetailActivity extends AppCompatActivity {

    private ImageView singelImage;
    private TextView singleTitle, singleDesc, postuser, commentdetail, commentuser;
    String post_key = null;
    private DatabaseReference mReference;
    private RecyclerView recyclerView;
    private DatabaseReference commenttable;
    private DatabaseReference mRef;
    public static String text1, user1, commenttext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum_detail);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("सोधपुछ");


        singelImage = (ImageView) findViewById(R.id.singleImageview);
        singleTitle = (TextView) findViewById(R.id.singleTitle);
        singleDesc = (TextView) findViewById(R.id.singleDesc);
        postuser = (TextView) findViewById(R.id.post_user);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerviewcomment);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        mReference = FirebaseDatabase.getInstance().getReference("Forum");
        commenttable =mReference.child(postkey);
        mRef = commenttable.child("comment");






        mReference.child(ForumActivity.postkey).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String post_title = (String) dataSnapshot.child("title").getValue();
                String post_desc = (String) dataSnapshot.child("desc").getValue();
                String post_image = (String) dataSnapshot.child("imageUrl").getValue();
                String post_uid = (String) dataSnapshot.child("uid").getValue();

                singleTitle.setText(post_title);
                singleDesc.setText(post_desc);
                Picasso.with(ForumDetailActivity.this).load(post_image).into(singelImage);
                //postuser.setText(userId);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        final Context context = this;

        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fabcomment);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get prompts.xml view
                LayoutInflater li = LayoutInflater.from(context);
                View promptsView = li.inflate(R.layout.newcomment, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(promptsView);


                final EditText userInput = (EditText) promptsView
                        .findViewById(R.id.entercommentbox);
                 commenttext = userInput.getText().toString();

                // set dialog message
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int id) {

                                        commenttext = userInput.getText().toString();


                                   CommentModel commentModel = new CommentModel();
                                   commentModel.setText(commenttext);
                                   commentModel.setUser(UserId);
                                   mRef.push().setValue(commentModel);
                                   //DatabaseReference newcmt = mRef.push();
                                   //newcmt.setValue(commentModel);



                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int id) {
                                        dialog.cancel();
                                    }
                                });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();

            }

        });




    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<CommentModel, BlogzoneViewHolder> FBRA = new FirebaseRecyclerAdapter<CommentModel, BlogzoneViewHolder>(
               CommentModel.class,
                R.layout.comment_items,
                BlogzoneViewHolder.class,
                mRef
        ) {
            @Override
            protected void populateViewHolder(BlogzoneViewHolder viewHolder, CommentModel model, int position) {
                final String post_key = getRef(position).getKey();

                viewHolder.setText(model.getText());
                 text1 = model.getText();
                viewHolder.setUser(model.getUser());
                 user1 = model.getUser();







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
        public void setText(String text){
            TextView post_title = mView.findViewById(R.id.comment_txtView);
            post_title.setText(text);
        }

        public void setUser(String user){
            TextView post_number = mView.findViewById(R.id.post_user1);
            post_number.setText(user);
        }


    }



}
