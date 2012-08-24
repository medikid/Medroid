package com.meditrainer.medroid.ui;

import com.meditrainer.medroid.Globals;
import com.meditrainer.medroid.R;
import com.meditrainer.medroid.R.layout;
import com.meditrainer.medroid.R.menu;
import com.meditrainer.medroid.util.ActivityLauncher;
import com.meditrainer.medroid.util.ActivityName;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class UserDashboardActivity extends Activity implements OnClickListener {

	private static final int LENGTH_LONG = 10000;
	Button btn_start_test, btn_test_profile, btn_user_profile, btn_perf_analysis, btn_buy_subscription, btn_newsfeed;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);
        
        setupButtons(); 
          
    }
	
	//initiate and set button click listners
	private void setupButtons(){
		/**
         * Creating all buttons instances
         * */
        // Dashboard Start Test button
       btn_start_test = (Button) findViewById(R.id.btn_start_test);
       btn_start_test.setOnClickListener(this);
       Log.i(Globals.System.iTAG, "Start Test Button set");
 
        // Dashboard Test profile button
        btn_test_profile = (Button) findViewById(R.id.btn_test_profile);
        btn_test_profile.setOnClickListener(this);
 
        // Dashboard User Profile button
       btn_user_profile = (Button) findViewById(R.id.btn_user_profile);
       btn_user_profile.setOnClickListener(this);
 
        // Dashboard Performance Analysis button
       btn_perf_analysis = (Button) findViewById(R.id.btn_perf_analysis);
       btn_perf_analysis.setOnClickListener(this);
 
        // Dashboard Buy Subscription button
      btn_buy_subscription = (Button) findViewById(R.id.btn_buy_subscription);
      btn_buy_subscription.setOnClickListener(this);
 
        // Dashboard Newsfeeds button
      btn_newsfeed = (Button) findViewById(R.id.btn_newsfeed);
      btn_buy_subscription.setOnClickListener(this); 
     
	}

	//button click handler
	public void onClick(View v) {		
		ActivityLauncher.Launch(this, v.getId());
	}

}