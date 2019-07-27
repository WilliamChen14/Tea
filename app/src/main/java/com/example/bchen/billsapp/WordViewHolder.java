package com.example.bchen.billsapp;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class WordViewHolder extends RecyclerView.ViewHolder {
    private TextView simpleTextView;

    public WordViewHolder(final View itemView, final ItemClickListener listener) {
        super(itemView);
        simpleTextView = (TextView) itemView.findViewById(R.id.my_list_view);
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
