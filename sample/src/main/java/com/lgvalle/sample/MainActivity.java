package com.lgvalle.sample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.lgvalle.autospangridlayout.AutoSpanGridLayoutManager;
import com.lgvalle.sample.sample.R;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    private String[] nodesSrc = {"Lorem", "ipsum", "dolor", "sit", "amet consectetur adipiscing elit", "sed", "do", "eiusmod", "tempor incididunt", "ut", "labore et", "dolore magna", "aliqua"};
    private ArrayList<AutoSpannableText> nodes = new ArrayList<>();
    private static final String TAG = MainActivity.class.getSimpleName();
    private AutoSpanTextViewAdapter adapter;
    private int index;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        fetchFakeData();
        setupAutoLayout();
    }

    private void fetchFakeData() {
        for (String s : nodesSrc) {
            AutoSpannableText autoMeasurableText = new AutoSpannableTextImpl(this, s);
            nodes.add(autoMeasurableText);
        }
    }

    private void setupAutoLayout() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.autofitView);
        AutoSpanGridLayoutManager layoutManager = new AutoSpanGridLayoutManager(this, getResources().getInteger(R.integer.columns));
        recyclerView.setLayoutManager(layoutManager);
        adapter = new AutoSpanTextViewAdapter(nodes);
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
        adapter.addItem(nodes.get(index++));
        if (index >= nodes.size()) {
            index = 0;
        }
        return true;
    }
}
