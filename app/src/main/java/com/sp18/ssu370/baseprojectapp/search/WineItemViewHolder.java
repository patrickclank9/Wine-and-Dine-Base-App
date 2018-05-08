package com.sp18.ssu370.baseprojectapp.search;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sp18.ssu370.baseprojectapp.R;

import com.sp18.ssu370.baseprojectapp.model.Wine;

public class WineItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView WineName;
    private OnItemClickedListener listener;



    public WineItemViewHolder(View itemView) {
        super(itemView);

        WineName = (TextView)itemView.findViewById(R.id.wine_name);
        WineName.setOnClickListener(this);
    }

    public void bindView(Wine item) {
        WineName.setText(item.getName());
    }

    public void setListener(OnItemClickedListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        listener.onItemClicked(WineItemViewHolder.this.getLayoutPosition());
    }

    public interface OnItemClickedListener {
        void onItemClicked(int position);
    }
}
