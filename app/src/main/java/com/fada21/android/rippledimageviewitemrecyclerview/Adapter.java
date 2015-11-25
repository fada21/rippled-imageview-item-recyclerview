package com.fada21.android.rippledimageviewitemrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == 0) {
            return new Holder(inflater.inflate(R.layout.item_with_image, parent, false), viewType);
        } else {
            return new Holder(inflater.inflate(R.layout.item_with_cardview, parent, false), viewType);
        }
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        final int viewType = getItemViewType(position);
        if (viewType == 0) {
            final String url = String.format("http://lorempixel.com/640/320/food/%d", position / 2 + 1);
            Glide.with(holder.imageView.getContext())
                    .load(url)
                    .fitCenter()
                    .placeholder(R.drawable.ic_android_24dp)
                    .crossFade()
                    .into(holder.imageView);
        }
        holder.text.setText(String.format("Position %d", position + 1));
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public static class Holder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView text;

        public Holder(View itemView, int type) {
            super(itemView);
            if (type == 0) {
                imageView = (ImageView) itemView.findViewById(R.id.img);
            }
            text = (TextView) itemView.findViewById(R.id.text);


        }
    }

}
