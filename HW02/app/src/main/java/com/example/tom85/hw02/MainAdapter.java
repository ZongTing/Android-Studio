package com.example.tom85.hw02;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private List<Food> mFoodList;

    private OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener li) {
        mListener = li;
    }

    interface OnItemClickListener {
        void onItemClick(int position);
    }

    public MainAdapter(List<Food> foodList) {
        this.mFoodList = foodList;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_main, viewGroup, false);

        return new MainViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, final int position) {
        Food food = getItem(position);

        holder.mNameTextView.setText(food.name);
        holder.mAddressTextView.setText(food.address);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mFoodList.size();
    }

    public Food getItem(int position) {
        return mFoodList.get(position);
    }

    public static class MainViewHolder extends RecyclerView.ViewHolder {

        private TextView mNameTextView;
        private TextView mAddressTextView;

        public MainViewHolder(View itemView) {
            super(itemView);

            mNameTextView = itemView.findViewById(R.id.nameTextView);
            mAddressTextView = itemView.findViewById(R.id.addressTextView);
        }

    }

}
