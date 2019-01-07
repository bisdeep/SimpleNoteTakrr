package com.bisdeep.s2kudemy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        startActivity(new Intent(Splash.this, Main.class));
    }
    private void redirect(){
        boolean isFirstRun = getSharedPreferences("PREFERENCES", MODE_PRIVATE).getBoolean("isFirstRun", true);
        Intent intent;
        // =new Intent(this, Main.class);
        if(isFirstRun){
            intent = new Intent(Splash.this, Main.class);
            getSharedPreferences("PREFERENCES", MODE_PRIVATE).edit().putBoolean("isFirstRun", false).commit();
        } else {
            int goToActivity = getSharedPreferences("PREFERENCES", MODE_PRIVATE).getInt("whereToNext", 0);
            if(goToActivity==0){
                intent = new Intent(Splash.this, Main2Activity.class);
            }
            else if (goToActivity == 1){
                intent = new Intent(Splash.this, Main.class);
            }
            else {
                intent = new Intent(Splash.this, Main2Activity.class);
            }
        }

        startActivity(intent);
    }
}
