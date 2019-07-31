package com.example.bchen.billsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Persons_Name_Activity extends AppCompatActivity {

    public String personsName;

    private Word word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persons__name_);

        final EditText theirName = (EditText)findViewById(R.id.newPersonsName);


        Button sub = (Button) findViewById(R.id.submitButtonForName);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                personsName = theirName.getText().toString();
                Intent myIntent = new Intent(Persons_Name_Activity.this, MainActivity.class);
                myIntent.putExtra("word", personsName);
                setResult(RESULT_OK, myIntent);
                finish();

            }
        });
    }
}
