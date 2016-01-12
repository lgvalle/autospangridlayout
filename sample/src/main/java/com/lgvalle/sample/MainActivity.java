package com.lgvalle.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.lgvalle.autospangridlayout.AutoSpanGridLayoutManager;
import com.lgvalle.sample.sample.R;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private String[] nodesSrc = {"Lorem", "ipsum", "dolor", "sit", "amet consectetur adipiscing elit", "sed", "do", "eiusmod", "tempor incididunt", "ut", "labore et", "dolore magna", "aliqua"};
    private ArrayList<SpannableText> nodes = new ArrayList<>();
    private static final String TAG = MainActivity.class.getSimpleName();
    private TextViewAdapter adapter;
    private int index;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        initData();
        setupAutoLayout();
    }

    private void initData() {
        for (String s : nodesSrc) {
            SpannableText autoMeasurableText = new SpannableTextImpl(this, s);
            nodes.add(autoMeasurableText);
        }
    }

    private void setupAutoLayout() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.autofitView);
        AutoSpanGridLayoutManager layoutManager = new AutoSpanGridLayoutManager(this, getResources().getInteger(R.integer.columns), 5);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new TextViewAdapter(nodes);
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
