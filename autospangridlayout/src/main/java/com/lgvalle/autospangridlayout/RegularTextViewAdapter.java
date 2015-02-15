package com.lgvalle.autospangridlayout;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by lgvalle on 31/01/15.
 */
public class RegularTextViewAdapter extends RecyclerView.Adapter<RegularTextViewAdapter.TextViewHolder> {
    private static final String TAG = RegularTextViewAdapter.class.getSimpleName();
    private List<String> nodes;

    public RegularTextViewAdapter() {
        this.nodes = new ArrayList<>();
    }

    @Override
    public TextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_row, parent, false);
        return new TextViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TextViewHolder holder, int position) {
        String node = nodes.get(position);
        holder.bind(node);
    }

    @Override
    public int getItemCount() {
        return nodes.size();
    }

    public void addItem(String s) {
        nodes.add(s);
        notifyItemInserted(nodes.size() - 1);
    }

    class TextViewHolder extends RecyclerView.ViewHolder {
        public TextViewHolder(View itemView) {
            super(itemView);
        }

        public void bind(String node) {
            ((TextView) itemView).setText(node);
        }
    }

}