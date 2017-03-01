package com.geniusnine.android.recyclerviewexample;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;

import com.clockbyte.admobadapter.AdmobRecyclerAdapterWrapper;
import com.clockbyte.admobadapter.expressads.AdmobExpressAdapterWrapper;
import com.clockbyte.admobadapter.expressads.NativeExpressAdViewHolder;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.NativeExpressAdView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

RecyclerView recyclerViewContents;
    AdmobRecyclerAdapterWrapper adapterWrapper;
    Timer updateAdsTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MobileAds.initialize(getApplicationContext(), getString(R.string.test_admob_app_id));
        initRecyclerViewItems();
        initUpdateAdsTimer();
    }

    private void initRecyclerViewItems() {

        recyclerViewContents = (RecyclerView)findViewById(R.id.recyclerViewContent);
        recyclerViewContents.setLayoutManager(new LinearLayoutManager((this)));

        ContentAdapter recyclerViewContentsAdapter = new ContentAdapter(this);

        adapterWrapper =  new AdmobRecyclerAdapterWrapper(this, getString(R.string.test_admob_app_id) );

        adapterWrapper.setAdapter(recyclerViewContentsAdapter);


        adapterWrapper.setLimitOfAds(3);

        adapterWrapper.setNoOfDataBetweenAds(10);
        adapterWrapper.setFirstAdIndex(2);


        recyclerViewContents.setAdapter(adapterWrapper);





    }
    private void initUpdateAdsTimer() {
        updateAdsTimer = new Timer();
        updateAdsTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapterWrapper.requestUpdateAd();
                    }
                });
            }
        }, 60*1000, 60*1000);
    }




}
