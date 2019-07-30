package com.example.bchen.billsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    final ItemClickListener listener;

    public class WordViewHolder extends RecyclerView.ViewHolder {
        public TextView simpleTextView;

        public WordViewHolder(final View itemView) {
            super(itemView);
            simpleTextView = (TextView) itemView.findViewById(R.id.textView);
            simpleTextView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    //handle click
                    listener.onItemClick(v, getAdapterPosition());
                }
            });
        }
    }
    public interface ItemClickListener{
        void onItemClick(View v, int index);
    }
    private final LayoutInflater mInflater;
    private List<Word> mWords; // Cached copy of words

    WordListAdapter(Context context, ArrayList wordList, ItemClickListener listener) {
        mWords = wordList;
        mInflater = LayoutInflater.from(context);
        this.listener = listener;
    }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        Word current = mWords.get(position);
        holder.simpleTextView.setText(current.name);
    }

    void setWords(List<Word> words) {
        mWords = words;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mWords.size();
    }
}
