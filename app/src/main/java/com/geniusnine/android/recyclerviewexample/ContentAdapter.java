package com.geniusnine.android.recyclerviewexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.clockbyte.admobadapter.ViewWrapper;

import java.util.ArrayList;

/**
 * Created by AndriodDev8 on 01-03-2017.
 */

public class ContentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private ArrayList<String> items = new ArrayList<>();
    private Context mContext;

    public ContentAdapter(Context context){
        mContext = context;
        contentGenerator();
    }

    @Override
    public ViewWrapper<RecyclerViewItem> onCreateViewHolder(ViewGroup parent, int viewType ){
        return new ViewWrapper<RecyclerViewItem>(new RecyclerViewItem(mContext));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        RecyclerViewItem item = (RecyclerViewItem) viewHolder.itemView;
        String str = getItem(position);
        item.bind(str);
    }

    public String getItem(int position) {
        return items.get(position);
    }


    private void contentGenerator() {

        String alpha = "This is \n Awesome \n working\nGreat\n..........# ";
        for (int i = 0; i < 101; i++) {
            items.add(alpha + Integer.toString(i));

        }

    }
    @Override
    public int getItemCount() {
        return items.size();
    }
}
