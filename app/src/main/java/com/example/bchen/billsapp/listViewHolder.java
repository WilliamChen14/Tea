package com.example.bchen.billsapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class listViewHolder extends RecyclerView.ViewHolder {
    private TextView simpleTextView;

    public listViewHolder(final View itemView) {
        super(itemView);
        simpleTextView = (TextView) itemView.findViewById(R.id.tvAnimalName);
    }

    public void bindData(final listitem viewModel) {
        simpleTextView.setText(viewModel.getListItem());
    }
}
