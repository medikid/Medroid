package com.meditrainer.medroid.activity;

import com.meditrainer.medroid.R;
import com.meditrainer.medroid.R.layout;
import com.meditrainer.medroid.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class UserRegister extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_reg);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_user_reg, menu);
        return true;
    }
}
