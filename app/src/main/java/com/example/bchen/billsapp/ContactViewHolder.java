package com.example.bchen.billsapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ContactViewHolder extends RecyclerView.ViewHolder {
    private TextView simpleTextView;

    public ContactViewHolder(final View itemView, final ItemClickListener listener) {
        super(itemView);
        simpleTextView = (TextView) itemView.findViewById(R.id.tvAnimalName);
        simpleTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //handle click
                listener.onItemClick(v);
            }
        });
    }

    public void bindData(final Contact viewModel) {
        simpleTextView.setText(viewModel.getListItem());
    }

    public interface ItemClickListener{
        void onItemClick(View v);
    }
}