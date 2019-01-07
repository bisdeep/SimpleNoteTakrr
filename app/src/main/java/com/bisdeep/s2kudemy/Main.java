package com.bisdeep.s2kudemy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main extends AppCompatActivity {
    final Data data = new Data(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//obtain view from xml file "activity_main"
    makeViews();
    }

private void makeViews(){
        final EditText listbox = (EditText) findViewById(R.id.listbox);
        String oldList = data.retrieveList();

        listbox.setText(oldList);
        Button saveBtn = (Button) findViewById(R.id.save);
        saveBtn.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            String listString = listbox.getText().toString();

            data.writeList(listString);

            Intent intent = new Intent(Main.this, Main2Activity.class);
            if (listString.contains("Slashtag 2k")){
              //  intent.putExtra("listSaved", true);
            } else {
                //intent.putExtra("listSaved", false);
            }
            startActivity(intent);
        }
    });
}
}
