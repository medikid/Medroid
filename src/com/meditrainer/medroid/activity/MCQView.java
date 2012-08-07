package com.meditrainer.medroid.activity;

import com.meditrainer.medroid.R;
import com.meditrainer.medroid.R.layout;
import com.meditrainer.medroid.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MCQView extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_mcq_view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
     //   getMenuInflater().inflate(R.menu.activity_mcq_view, menu);
        return true;
    }
}
