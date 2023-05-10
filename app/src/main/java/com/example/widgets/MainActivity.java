package com.example.widgets;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;
import android.widget.*;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    MediaPlayer mp;
    ImageView iw;
    TextView tw;
    EditText textEditView;
    Button songButton;
    Button textEditButton;
    Button confirmTextButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Setup all the views */
        //root = (LinearLayout) findViewById(R.id.root);
        iw = (ImageView) findViewById(R.id.flag);
        tw = (TextView) findViewById(R.id.textview1);
        textEditView = (EditText) findViewById(R.id.edittext);
        // make texteditview invisible until textbutton has been pressed
        textEditView.setVisibility(View.INVISIBLE);
        songButton = (Button) findViewById(R.id.songbutton);
        textEditButton = (Button) findViewById(R.id.textbutton);
        confirmTextButton = (Button) findViewById(R.id.confirmbutton);
        mp = MediaPlayer.create(this,R.raw.shortck);



        /* Setup event handlers */
        textEditButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("editbutton", "button was clicked");
                textEditView.setVisibility(View.VISIBLE);
                confirmTextButton.setVisibility(View.VISIBLE);
               /* Button confirmText = new Button(MainActivity.this);
                confirmText.setText(R.string.button_set_new_text);
                root.addView(confirmText);*/

            }
        });


        confirmTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tw.setText(textEditView.getText());
                textEditView.setVisibility(View.INVISIBLE);
                confirmTextButton.setVisibility(View.INVISIBLE);
            }
        });

        songButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("songButton", "button pressed");
                mp.setVolume(100,100);
                mp.start();
            }
        });


    }
}
