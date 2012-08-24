package com.meditrainer.medroid.ui;

import com.meditrainer.medroid.R;
import com.meditrainer.medroid.R.layout;
import com.meditrainer.medroid.R.menu;
import com.meditrainer.medroid.util.ActivityLauncher;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NewsfeedActivity extends Activity implements OnClickListener{
	Button btnDashboardHome;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsfeed);
        setupButtons();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_newsfeed, menu);
        return true;
    }
    
    public void setupButtons(){
    btnDashboardHome =(Button) findViewById(R.id.btn_dashboard_home);
    btnDashboardHome.setOnClickListener(this);
    }

	public void onClick(View  v) {
		// TODO Auto-generated method stub
		ActivityLauncher.Launch(getApplicationContext(), v.getId());
	}
    
}
