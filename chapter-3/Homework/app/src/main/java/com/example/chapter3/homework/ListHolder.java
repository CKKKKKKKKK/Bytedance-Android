package com.example.chapter3.homework;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
    private TextView mTextView;

    public ListHolder(@NonNull View itemView) {
        super(itemView);
        mTextView = itemView.findViewById(R.id.text);
        itemView.setOnClickListener(this);
    }

    public void bind(String text) {
        mTextView.setText(text);
    }
    @Override
    public void onClick(View v) {

    }
}
