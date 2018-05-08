package com.sp18.ssu370.baseprojectapp.search;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sp18.ssu370.baseprojectapp.R;

import com.sp18.ssu370.baseprojectapp.model.Food;

import Database.FoodEntity;

public class FoodItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView FoodName;
    private OnItemClickedListener listener;



    public FoodItemViewHolder(View itemView) {
        super(itemView);

        FoodName = (TextView)itemView.findViewById(R.id.food_name);
        FoodName.setOnClickListener(this);
    }

    public void bindView(FoodEntity item) {
        FoodName.setText(item.getFoodname());
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
