package com.example.bchen.billsapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements WordListAdapter.ItemClickListener {

    public WordViewModel mWordViewModel;

    private ArrayList<Word> wordList= new ArrayList();

    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 52;

    public static final int PERSONS_NAME_ACTIVITY_REQUEST_CODE = 15;

    public static String nameOfPerson;

    public static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //creates adapter
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.my_list_view);
        final WordListAdapter adapter = new WordListAdapter(this, wordList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        mWordViewModel = ViewModelProviders.of(this).get(WordViewModel.class);

        mWordViewModel.getAllWords().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                wordList.clear();
                wordList.addAll(words);
                adapter.notifyDataSetChanged();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, Persons_Name_Activity.class);
                startActivityForResult(myIntent , PERSONS_NAME_ACTIVITY_REQUEST_CODE);

            }
        });
       //mWordViewModel.insert(new Word("Bollllll chin", "", "", 69, "", ""));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private List<Contact> generateSimpleList() {
        List<Contact> simpleViewModelList = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            simpleViewModelList.add(new Contact(String.format("This is item %d", i)));
        }

        return simpleViewModelList;
    }

    @Override
    public void onItemClick(View v, int index){
        //when item is clicked do this
        Intent intent = new Intent(MainActivity.this, NewWordActivity.class);
        intent.putExtra("word", wordList.get(index));

        startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == PERSONS_NAME_ACTIVITY_REQUEST_CODE  && resultCode  == RESULT_OK) {
                Log.d(TAG, "onActivityResult: =====================================");
                String requiredName = data.getStringExtra("word");
                nameOfPerson = requiredName;
                mWordViewModel.insert(new Word(requiredName, "", "", 0, "", ""));            }
            else if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK){
                Log.d(TAG, "onActivityResult: iuwaefouabsvbewaluva");
                Word w = data.getParcelableExtra("word");
                Log.d(TAG, "onActivityResult:   " + w.number);
                mWordViewModel.update(w);
            }
        } catch (Exception ex) {
            Toast.makeText(MainActivity.this, ex.toString(),
                    Toast.LENGTH_SHORT).show();
        }

    }


}
