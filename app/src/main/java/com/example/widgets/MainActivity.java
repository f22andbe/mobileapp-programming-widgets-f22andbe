package com.example.widgets;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.*;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    ImageView iw;
    TextView tw;
    EditText textEditView;
    Button songButton;
    Button textEditButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Setup all the views */
        iw = (ImageView) findViewById(R.id.flag);
        tw = (TextView) findViewById(R.id.textview1);
        textEditView = (EditText) findViewById(R.id.edittext);
        songButton = (Button) findViewById(R.id.songbutton);
        textEditButton = (Button) findViewById(R.id.textbutton);
    }
}
