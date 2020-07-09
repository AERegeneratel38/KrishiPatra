package com.aelcorporation.krishipatra.krishisamachar;

import android.content.Intent;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aelcorporation.krishipatra.HomeActivity;
import com.aelcorporation.krishipatra.R;
import com.aelcorporation.krishipatra.forumsection.ForumActivity;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class newshome extends AppCompatActivity {


    public static Drawable ImageDrawable;



    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newshome);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("समाचार");
        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              finish();

            }
        });
        mRecyclerView = findViewById(R.id.recyclerViewnews);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("Data");

    }


    @Override
    protected void onStart() {

        super.onStart();
        FirebaseRecyclerAdapter<Model,ViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Model, ViewHolder>(
                    Model.class,
                        R.layout.row,
                        ViewHolder.class,
                        mRef

                ) {
            @Override
                    protected void populateViewHolder(ViewHolder viewHolder,Model model, int position) {

                viewHolder.setDetails(getApplicationContext(), model.getTitle(), model.getDescription(), model.getImage(), model.getDetail() );
            }


                    @Override
                    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                        ViewHolder viewHolder = super.onCreateViewHolder(parent, viewType);

                        viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {

                                TextView mTitleTv = view.findViewById(R.id.rTitleTv);
                                TextView mDetailTv = view.findViewById(R.id.rDescriptionTv);
                                ImageView mImageView = view.findViewById(R.id.rImageView);


                                String mTitle = mTitleTv.getText().toString();
                                String mDetail = mDetailTv.getText().toString();


                                newshome.ImageDrawable = mImageView.getDrawable();


                                Intent intent = new Intent(view.getContext(), newsdetail.class);


                                intent.putExtra("title", mTitle);
                                intent.putExtra("description", mDetail);


                                view.getContext().startActivity(intent);

                            }

                            @Override
                            public void onItemLongClick(View view, int position) {
                               /* TextView mTitleTv = view.findViewById(R.id.rTitleTv);
                                ImageView mImageView = view.findViewById(R.id.rImageView);
                                TextView mDetailTv = view.findViewById(R.id.rDescriptionTv);

                                String mTitle = mTitleTv.getText().toString();
                                String mDetail = mDetailTv.getText().toString();


                                Intent intent = new Intent(view.getContext(), newsdetail.class);



                                intent.putExtra("Title", mTitle);
                                intent.putExtra("Description", mDetail);

                                startActivity(intent); */
                            }
                        });

                        return viewHolder;
                    }
                };


        mRecyclerView.setAdapter(firebaseRecyclerAdapter);










    }


}
