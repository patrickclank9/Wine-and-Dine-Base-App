package com.sp18.ssu370.baseprojectapp.search;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sp18.ssu370.baseprojectapp.R;
import com.sp18.ssu370.baseprojectapp.model.Food;
import com.sp18.ssu370.baseprojectapp.search.FoodItemViewHolder;

import java.util.ArrayList;

import Database.FoodEntity;

public class FoodSearchAdapter extends RecyclerView.Adapter<FoodItemViewHolder>{

    private ArrayList<FoodEntity> bindableCollection;
    private FoodItemClickListener FoodItemClickListener;

    public FoodSearchAdapter(ArrayList<FoodEntity> collection) {
        this.bindableCollection = collection;
    }

    @Override
    public FoodItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.food_search_item, parent, false);

        return new FoodItemViewHolder(inflatedView);

    }

    @Override
    public void onBindViewHolder(FoodItemViewHolder holder, int position) {
        FoodEntity item = bindableCollection.get(position);
        holder.setListener(new FoodItemViewHolder.OnItemClickedListener() {
            @Override
            public void onItemClicked(int position) {
                if(FoodItemClickListener != null) {
                    FoodItemClickListener.onFoodItemClicked(bindableCollection.get(position));
                }
            }
        });

        holder.bindView(item);
    }

    @Override
    public int getItemCount() {
        if (this.bindableCollection == null)
            return 0;
        return this.bindableCollection.size();
    }

    public void setFoodItemClickListener(FoodItemClickListener FoodItemClickListener) {
        this.FoodItemClickListener = FoodItemClickListener;
    }

    public interface FoodItemClickListener {
        void onFoodItemClicked(FoodEntity selectedItem);
    }
}
