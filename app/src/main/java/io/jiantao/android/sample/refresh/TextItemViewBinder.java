package io.jiantao.android.sample.refresh;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.jiantao.android.sample.R;
import me.drakeet.multitype.ItemViewBinder;

public class TextItemViewBinder extends ItemViewBinder<TextItem, TextItemViewBinder.TextHolder> {


    static class TextHolder extends RecyclerView.ViewHolder {

        private
        @NonNull
        final TextView text;

        TextHolder(@NonNull View itemView) {
            super(itemView);
            this.text = (TextView) itemView.findViewById(R.id.text);
        }
    }

    @NonNull
    @Override
    protected TextHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.item_text, parent, false);
        return new TextHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull TextHolder holder, @NonNull TextItem textItem) {
        int position = getPosition(holder);
        Log.d("demo", "position: " + position);
        boolean b = (position & 1) == 0;
        int height = b ? 200 : 300;
        height = (int) (Math.random() * 200 + height);
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        layoutParams.height = height;
        holder.itemView.setLayoutParams(layoutParams);
        holder.text.setText("hello: " + textItem.text+"height: "+height);
//        Log.d("demo", "adapter: " + getAdapter());
    }
}