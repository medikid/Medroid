package com.meditrainer.medroid.ui;

import com.meditrainer.medroid.R;
import com.meditrainer.medroid.R.layout;
import com.meditrainer.medroid.R.menu;
import com.meditrainer.medroid.test.TestActivity;
import com.meditrainer.medroid.util.Logger;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.view.Menu;

public class Medroid extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medroid);
        Logger.i("App Launched");
        
        Intent i = new Intent(getApplicationContext(), UserDashboardActivity.class );
        startActivity(i);
        Logger.i("Started new Activity inside Medroid file");
        

        
    };

}
