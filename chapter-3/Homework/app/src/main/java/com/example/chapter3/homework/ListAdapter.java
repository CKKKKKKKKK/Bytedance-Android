package com.example.chapter3.homework;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListHolder>  {
    @NonNull
    private List<String> mItems = new ArrayList<>();

    @NonNull
    @Override
    public ListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_text, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListHolder holder, int position) {
        holder.bind(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void notifyItems(@NonNull List<String> items) {
        mItems.clear();
        mItems.addAll(items);
        notifyDataSetChanged();
    }
}
