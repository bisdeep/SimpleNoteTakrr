package com.bisdeep.s2kudemy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        displayContent();
    }
    public void displayContent() {
        Intent intent = getIntent();

        boolean listSaved = intent.getBooleanExtra("listSaved", true);
        TextView saved = (TextView) findViewById(R.id.savedView);

        if(listSaved){
            saved.setText("List was able to save!");
        } else {
            saved.setText("Something isn't working right.");
        }
    }
}
