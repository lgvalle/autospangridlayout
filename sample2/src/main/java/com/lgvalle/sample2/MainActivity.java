package com.lgvalle.sample2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private final static int MIN_WIDTH = 100;
    private final static int RANDOM_WIDTH = 500;
    Random random = new Random();
    private ArrayList<SpannableImage> nodes = new ArrayList<>();
    private ImageViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupAutoLayout();
    }

    private void setupAutoLayout() {
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.autofitView);

        recyclerView.setLayoutManager(getLayoutManager());
        adapter = new ImageViewAdapter(nodes);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                recyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                for (int i = 0; i < 10; i++) {
                    addRandomItem();
                }
            }
        });
    }

    private RecyclerView.LayoutManager getLayoutManager() {
        //return new AutoSpanGridLayoutManager(this, getResources().getInteger(R.integer.columns));
        return new LinearLayoutManager(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    private int nextWidth() {
        return MIN_WIDTH + random.nextInt(RANDOM_WIDTH);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            addRandomItem();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void addRandomItem() {
        adapter.addItem(createRandomSpannableImage());
    }

    private SpannableImageImpl createRandomSpannableImage() {
        String imageUrl = getString(R.string.url_template, nextWidth());
        ImageView itemImage = (ImageView) getLayoutInflater().inflate(R.layout.item_image, null);

        return new SpannableImageImpl(itemImage, imageUrl);
    }
}
