package com.example.bchen.billsapp;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class WordViewHolder extends RecyclerView.ViewHolder {
    private TextView simpleTextView;

    public WordViewHolder(final View itemView, final ItemClickListener listener) {
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
