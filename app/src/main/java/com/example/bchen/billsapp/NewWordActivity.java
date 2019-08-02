package com.example.bchen.billsapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NewWordActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";
    private static final int CAMERA_PIC_REQUEST = 1337;
    private static final int MAIN_ACTIVITY_REQUEST = 1338;


    private EditText mEditWordView;
    private  EditText mFavColorView;
    private TextView mNameView;

    private Bitmap imageData;

    private String favColorText = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        setContentView(R.layout.activity_new_word);
        mEditWordView = findViewById(R.id.edit_word);
        mFavColorView = findViewById(R.id.favColorText);
        mNameView = findViewById(R.id.nameText);
        if(bundle.getString("color")!=null){
            mFavColorView.setText(bundle.getString("color"));
        }


        mNameView.setText(bundle.getString("name"));

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(NewWordActivity.this, MainActivity.class);
                favColorText = findViewById(R.id.favColorText).toString();
                intent.putExtra("color", favColorText);
                startActivityForResult(intent, MAIN_ACTIVITY_REQUEST);


                    //replyIntent.putExtra(EXTRA_REPLY, word);
                    //setResult(RESULT_OK, replyIntent);
                    //startActivityForResult(replyIntent, TEXT_REQUEST_CODE);
                }
                //finish();
            }
        );

        final ImageView profilePic =  findViewById(R.id.profilePicture);
        profilePic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(takePictureIntent, CAMERA_PIC_REQUEST);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_PIC_REQUEST) {
            if (resultCode == RESULT_OK) {
                imageData = (Bitmap) data.getExtras().get("data");
                ImageView image = (ImageView) findViewById(R.id.profilePicture);
                image.setImageBitmap(imageData);
            }
        }
        /*else if(requestCode == TEXT_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                favColorText = data.getStringExtra(EXTRA_REPLY);
                EditText text = (EditText)findViewById(R.id.favColorText);
                text.setText(favColorText);
            }
        }*/
    }

    protected void onResult(){

    }
}