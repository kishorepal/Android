package com.google.external.assignment.movie.common.utilities;

import android.content.Context;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.PicassoProvider;

public class PicassoUtility {

    private static PicassoUtility mInstance;
    private Context mContext;

    private PicassoUtility(Context aContext) {
        mContext = aContext;
    }

    public static PicassoUtility getInstance(Context aContext) {
        if(mInstance == null) {
            mInstance = new PicassoUtility(aContext);
        }

        return mInstance;
    }

    public void loadImage(String imageUrl, ImageView imageButton) {
        Picasso.get().load(String.format("http://image.tmdb.org/t/p/w500%s",imageUrl )).into(imageButton);
    }


}
