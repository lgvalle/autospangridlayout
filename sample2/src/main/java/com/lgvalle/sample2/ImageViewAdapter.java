package com.lgvalle.sample2;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lgvalle.autospangridlayout.AutoSpanAdapter;
import com.lgvalle.autospangridlayout.AutoSpannable;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lgvalle on 09/07/15.
 */
public class ImageViewAdapter extends RecyclerView.Adapter<ImageViewAdapter.ImageViewHolder> implements AutoSpanAdapter {

    private static final String TAG = ImageViewHolder.class.getSimpleName();
    List<SpannableImage> nodes;

    public ImageViewAdapter(ArrayList<SpannableImage> nodes) {
        this.nodes = nodes;
        setHasStableIds(true);
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        holder.bind(position);
    }


    @Override
    public long getItemId(int position) {
        return nodes.get(position).getUrl().hashCode();
    }

    @Override
    public int getItemCount() {
        return nodes.size();
    }

    public void addItem(SpannableImage obj) {
        nodes.add(obj);
        notifyItemInserted(nodes.size() - 1);
        //notifyDataSetChanged();
    }

    @Override
    public List<? extends AutoSpannable> getItems() {
        return nodes;
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {

        public ImageViewHolder(View itemView) {
            super(itemView);
        }

        public void bind(final int position) {
            final ImageView imageView = (ImageView) this.itemView;
            final SpannableImage item = nodes.get(position);

            Log.d(TAG, "Loading: " + item.getUrl());
            Picasso.with(imageView.getContext())
                    .load(item.getUrl())
                    .placeholder(R.drawable.ic_launcher)
                    .into(new Target() {
                        @Override
                        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                            if (from == Picasso.LoadedFrom.NETWORK) {
                                imageView.setImageBitmap(bitmap);
                                Log.d(TAG, "-- Setting bitmap:" + bitmap.getWidth());
                                item.setBitmapWidth(bitmap.getWidth());
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        notifyDataSetChanged();
                                    }
                                }, 200);
                            }
                        }

                        @Override
                        public void onBitmapFailed(Drawable errorDrawable) {
                            Log.e(TAG, "Error loading");
                        }

                        @Override
                        public void onPrepareLoad(Drawable placeHolderDrawable) {

                        }
                    });
        }
    }

}
