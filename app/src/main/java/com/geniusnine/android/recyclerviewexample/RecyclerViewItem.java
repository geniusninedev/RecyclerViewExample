package com.geniusnine.android.recyclerviewexample;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by AndriodDev8 on 01-03-2017.
 */

public class RecyclerViewItem extends FrameLayout {

    TextView textViewContent;

    public  RecyclerViewItem(Context context){
        super(context);

        inflate(context, R.layout.row_view, this);
        textViewContent = (TextView)findViewById(R.id.textViewContent);


    }

    public void bind(String str){
        textViewContent.setText(str);
    }
}
