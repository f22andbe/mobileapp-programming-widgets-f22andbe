package com.example.widgets;

import androidx.appcompat.app.AppCompatActivity;

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
        bgColors = (RadioGroup) findViewById(R.id.rgrp);
        bgColorWhite = (RadioButton) findViewById(R.id.white);
        bgColorPurple = (RadioButton) findViewById(R.id.purple);
        textEditButton = (Button) findViewById(R.id.textbutton);
        confirmTextButton = (Button) findViewById(R.id.confirmbutton);




        /* Setup event handlers */

        /* click handler for textEditButton
         * make textEditButton invisible and textEditView and confirmTextButton visible
         */
        textEditButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("editButton", "button was clicked");
                textEditView.setVisibility(View.VISIBLE);
                confirmTextButton.setVisibility(View.VISIBLE);
                textEditButton.setVisibility(View.INVISIBLE);
            }
        });

        /* click listener for confirmTextButton
         * check if a message has been input into textEditView and update message if it has
         * restore the original visibility of textEditView, confirmTextButton and textEditButton
         */
        confirmTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newMessage = textEditView.getText().toString();
                Log.i("confirmTextButton_value", newMessage);
                if(!newMessage.isEmpty()){
                    tw.setText(textEditView.getText());
                }

                textEditView.setVisibility(View.GONE);
                confirmTextButton.setVisibility(View.GONE);
                textEditButton.setVisibility(View.VISIBLE);
            }
        });



        /* click handler for the RadioGroup
         * anytime button that has focus is changed this is run
         */
        bgColors.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup arg0, int id) {

                if(id == R.id.white){
                    root.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                    Log.i("@string/TAG", "Chose white");
                }else if(id == R.id.purple){
                    root.setBackgroundColor(getResources().getColor(R.color.colorPurple));
                    Log.i("@string/TAG", "Chose purple");
                }else {
                    Log.i("@string/TAG", "Huh?");
                }

            }
        });


    }

/* click handler for the LinearLayout
 * if any button in the RadioGroup has focus, it clears it
 */
    public void onClickLayout(View v) {

        bgColors.clearCheck();

    }

}
