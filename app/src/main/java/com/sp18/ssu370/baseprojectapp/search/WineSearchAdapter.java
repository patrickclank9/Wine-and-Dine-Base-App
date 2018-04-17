package com.sp18.ssu370.baseprojectapp.search;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sp18.ssu370.baseprojectapp.R;
import com.sp18.ssu370.baseprojectapp.model.Wine;
import com.sp18.ssu370.baseprojectapp.search.WineItemViewHolder;

import java.util.ArrayList;

public class WineSearchAdapter extends RecyclerView.Adapter<WineItemViewHolder>{

    private ArrayList<Wine> bindableCollection;
    private WineItemClickListener WineItemClickListener;

    public WineSearchAdapter(ArrayList<Wine> collection) {
        this.bindableCollection = collection;
    }

    @Override
    public WineItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.wine_search_item, parent, false);

        return new WineItemViewHolder(inflatedView);

    }

    @Override
    public void onBindViewHolder(WineItemViewHolder holder, int position) {
        Wine item = bindableCollection.get(position);
        holder.setListener(new WineItemViewHolder.OnItemClickedListener() {
            @Override
            public void onItemClicked(int position) {
                if(WineItemClickListener != null) {
                    WineItemClickListener.onWineItemClicked(bindableCollection.get(position));
                }
            }
        });

        holder.bindView(item);
    }

    @Override
    public int getItemCount() {
        return this.bindableCollection.size();
    }

    public void setWineItemClickListener(WineItemClickListener WineItemClickListener) {
        this.WineItemClickListener = WineItemClickListener;
    }

    public interface WineItemClickListener {
        void onWineItemClicked(Wine selectedItem);
    }
}
