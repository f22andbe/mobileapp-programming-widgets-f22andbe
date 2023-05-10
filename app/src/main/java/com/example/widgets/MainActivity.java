package com.example.widgets;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;
import android.widget.*;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


   LinearLayout root;
    ImageView iw;
    TextView tw;
    EditText textEditView;
    RadioGroup bgColors;
    RadioButton bgColorWhite;
    RadioButton bgColorPurple;
    Button textEditButton;
    Button confirmTextButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Setup all the views */
        root = (LinearLayout) findViewById(R.id.root);
        iw = (ImageView) findViewById(R.id.flag);
        tw = (TextView) findViewById(R.id.textview1);
        textEditView = (EditText) findViewById(R.id.edittext);
        // make texteditview invisible until textbutton has been pressed
        textEditView.setVisibility(View.INVISIBLE);
        bgColors = (RadioGroup) findViewById(R.id.rgrp);
        bgColorWhite = (RadioButton) findViewById(R.id.white);
        bgColorPurple = (RadioButton) findViewById(R.id.purple);
        textEditButton = (Button) findViewById(R.id.textbutton);
        confirmTextButton = (Button) findViewById(R.id.confirmbutton);




        /* Setup event handlers */
        textEditButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("editbutton", "button was clicked");
                textEditView.setVisibility(View.VISIBLE);
                confirmTextButton.setVisibility(View.VISIBLE);
                textEditButton.setVisibility(View.INVISIBLE);
               /* Button confirmText = new Button(MainActivity.this);
                confirmText.setText(R.string.button_set_new_text);
                root.addView(confirmText);*/

            }
        });


        confirmTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newMessage = textEditView.getText().toString();
                Log.i("confirmtextbutton_value", newMessage);
                if(!newMessage.isEmpty()){
                    tw.setText(textEditView.getText());
                }

                textEditView.setVisibility(View.GONE);
                confirmTextButton.setVisibility(View.GONE);
                textEditButton.setVisibility(View.VISIBLE);
            }
        });



        bgColors.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup arg0, int id) {
                switch (id) {
                    case -1:
                        Log.i("@string/TAG", "Choices cleared!");
                        break;
                    case R.id.white:
                        root.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                        Log.i("@string/TAG", "Chose white");
                        break;

                    case R.id.purple:
                        root.setBackgroundColor(getResources().getColor(R.color.colorPurple));
                        Log.i("@string/TAG", "Chose purple");
                        break;
                    default:
                        Log.i("@string/TAG", "Huh?");
                        break;
                }
            }
        });


    }
}
