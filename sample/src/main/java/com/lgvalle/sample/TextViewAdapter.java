package com.lgvalle.sample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lgvalle.autospangridlayout.AutoSpanAdapter;
import com.lgvalle.autospangridlayout.AutoSpannable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lgvalle on 31/01/15.
 */
public class TextViewAdapter extends RecyclerView.Adapter<TextViewAdapter.TextViewHolder> implements AutoSpanAdapter {
    private static final String TAG = TextViewAdapter.class.getSimpleName();

    private List<SpannableText> nodes;

    public TextViewAdapter(ArrayList<SpannableText> nodes) {
        this.nodes = nodes;
    }

    @Override
    public TextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(com.lgvalle.sample.sample.R.layout.text_row, parent, false);
        return new TextViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TextViewHolder holder, int position) {
        SpannableText node = nodes.get(position);
        holder.bind(position, node.getValue());
    }

    @Override
    public int getItemCount() {
        return nodes.size();
    }

    public void addItem(SpannableText obj) {
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
                    duplicateNodeValue(position);
                }
            });
        }

        private void duplicateNodeValue(int position) {
            SpannableText item = nodes.get(position);
            item.setValue(item.getValue()+" "+item.getValue());
            notifyItemChanged(position);
        }
    }

}