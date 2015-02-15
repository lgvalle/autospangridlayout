package com.lgvalle.autospangridlayout;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import java.util.ArrayList;

/**
 * Created by lgvalle on 31/01/15.
 */
public class MainActivity extends Activity {
    private String[] nodesSrc = {"I need a", "at", "Flat 5 58 Cleveland Way E14UF, London", "handyman", "to", "fix my toilet"};
    private ArrayList<AutoSpannableText> nodes = new ArrayList<>();
    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private AutoSpanTextViewAdapter adapter;
    private int index;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        fetchFakeData();
        setupAutoLayout();
        index = 0;
    }

    private void fetchFakeData() {
        for (String s : nodesSrc) {
            AutoSpannableText autoMeasurableText = new AutoSpannableTextImpl(this, s);
            nodes.add(autoMeasurableText);
        }
    }

    private void setupAutoLayout() {
        recyclerView = (RecyclerView) findViewById(R.id.autofitView);
        AutoSpanGridLayoutManager layoutManager = new AutoSpanGridLayoutManager(this, getResources().getInteger(R.integer.columns));
        recyclerView.setLayoutManager(layoutManager);
        adapter = new AutoSpanTextViewAdapter(nodes);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }


    private void setupLayout() {
        recyclerView = (RecyclerView) findViewById(R.id.autofitView);
        GridLayoutManager layoutManager = new RegularGridLayoutManager(this, getResources().getInteger(R.integer.columns));

        recyclerView.setLayoutManager(layoutManager);
        //adapter = new RegularTextViewAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (index < nodes.size()) {
            adapter.addItem(nodes.get(index++));
            return true;
        }
        return false;
    }
}

