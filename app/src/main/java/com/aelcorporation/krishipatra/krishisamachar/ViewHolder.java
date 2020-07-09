package com.aelcorporation.krishipatra.krishisamachar;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aelcorporation.krishipatra.R;
import com.squareup.picasso.Picasso;




public class ViewHolder extends RecyclerView.ViewHolder {

    public static String detailofnews;

    View mView;
    public ViewHolder (View itemView) {
        super (itemView);

        mView = itemView;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    mClickListener.onItemClick(view, getAdapterPosition());
                }

        });

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                mClickListener.onItemLongClick(view, getAdapterPosition());

                return true;
            }
        });




    }


    public void setDetails (Context ctx, String title, String description, String image, String detail ) {

        TextView mTitleTv = mView.findViewById(R.id.rTitleTv);
        TextView mDetailTv = mView.findViewById(R.id.rDescriptionTv);
        ImageView mImageIv = mView.findViewById(R.id.rImageView);

        mTitleTv.setText(title);
        mDetailTv.setText(description);
        Picasso.with(ctx).load(image).into(mImageIv);
        detailofnews = detail;

    }


    private ViewHolder.ClickListener mClickListener;




    public interface ClickListener {

        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);


    }

    public void setOnClickListener (ViewHolder.ClickListener clickListener) {

        mClickListener = clickListener;


    }




}
