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
public class AutoSpanTextViewAdapter extends RecyclerView.Adapter<AutoSpanTextViewAdapter.TextViewHolder> implements AutoSpanGridLayoutManager.AutoSpanAdapter {
    private static final String TAG = AutoSpanTextViewAdapter.class.getSimpleName();

    private List<AutoSpannableText> nodes;

    public AutoSpanTextViewAdapter() {
        this.nodes = new ArrayList<>();
    }

    public AutoSpanTextViewAdapter(ArrayList<AutoSpannableText> nodes) {
        this.nodes = nodes;
    }

    @Override
    public TextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_row, parent, false);
        return new TextViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TextViewHolder holder, int position) {
        AutoSpannableText node = nodes.get(position);
        holder.bind(position, node.getValue());
    }

    @Override
    public int getItemCount() {
        return nodes.size();
    }

    public void addItem(AutoSpannableText obj) {
        nodes.add(obj);
        notifyItemInserted(nodes.size() - 1);
    }

    @Override
    public List<? extends AutoSpannable> getItems() {
        return nodes;
    }

    class TextViewHolder extends RecyclerView.ViewHolder {
        public TextViewHolder(View itemView) {
            super(itemView);
        }

        public void bind(final int position, final String node) {
            ((TextView) itemView).setText(node);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*
                    * Modify
                    *
                    AutoSpannableText item = nodes.get(position);
                    item.setValue(item.getValue()+node);
                    notifyItemChanged(position);
                    */
                    //nodes.remove(position);
                    nodes.remove(position);
                    notifyItemRemoved(position);
                }
            });
        }
    }

}