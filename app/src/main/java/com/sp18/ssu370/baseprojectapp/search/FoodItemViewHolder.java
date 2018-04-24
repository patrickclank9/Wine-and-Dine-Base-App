package com.sp18.ssu370.baseprojectapp.search;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sp18.ssu370.baseprojectapp.R;

import com.sp18.ssu370.baseprojectapp.model.Food;

public class FoodItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView FoodName;
    private ImageView FoodThumbnail;
    private OnItemClickedListener listener;



    public FoodItemViewHolder(View itemView) {
        super(itemView);

        FoodName = (TextView)itemView.findViewById(R.id.food_name);
        FoodThumbnail = (ImageView)itemView.findViewById(R.id.food_thumbnail);
        FoodName.setOnClickListener(this);
        FoodThumbnail.setOnClickListener(this);
    }

    public void bindView(Food item) {
        FoodName.setText(item.getName());

        Glide.with(this.itemView)
                .load(item.getThumbnailSources().get(0))
                .into(FoodThumbnail);
    }

    public void setListener(OnItemClickedListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        listener.onItemClicked(FoodItemViewHolder.this.getLayoutPosition());
    }

    public interface OnItemClickedListener {
        void onItemClicked(int position);
    }
}
