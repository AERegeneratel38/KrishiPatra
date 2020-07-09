package com.aelcorporation.krishipatra;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MyHolder extends RecyclerView.ViewHolder {

    View mView;
    public MyHolder (View itemView) {
        super (itemView);

        mView = itemView;





    }

    public void setDetails (Context ctx, String Name) {

        TextView mTitleTv = mView.findViewById(R.id.nameContactTxt);

        mTitleTv.setText(Name);


    }

}
