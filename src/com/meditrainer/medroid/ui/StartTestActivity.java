package com.meditrainer.medroid.ui;

import java.io.IOException;

import com.meditrainer.medroid.DummyData;
import com.meditrainer.medroid.R;
import com.meditrainer.medroid.R.layout;
import com.meditrainer.medroid.R.menu;
import com.meditrainer.medroid.userdata.UserSession;
import com.meditrainer.medroid.util.ActivityLauncher;
import com.meditrainer.medroid.util.Logger;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class StartTestActivity extends Activity implements OnClickListener {
	
	Button btnStartTestNow, btnDashboardHome;
	EditText et_UID, et_QSID, et_qTot; 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_test); 
        setupButtons();
        
        Logger.i("Start Test Activity started");
    }
    
    public void setupButtons(){
    	 btnStartTestNow = (Button) findViewById(R.id.btn_start_test_now);
         btnStartTestNow.setOnClickListener(this);
         Logger.i("Set On Click Listener for Start Test Now Button");
         
         btnDashboardHome =(Button) findViewById(R.id.btn_dashboard_home);
         btnDashboardHome.setOnClickListener(this);
         Logger.i("Set On Click Listener for Dashboard Home Button");
         
         et_UID = (EditText) findViewById(R.id.et_UID);
         et_QSID = (EditText) findViewById(R.id.et_QSID);
         et_qTot = (EditText) findViewById(R.id.et_qtot);
         
    }
    
    public void createDummyTest(){
    	Logger.i("Request for Creating Dummy Test");
    	   	
    	String sUID = et_UID.getText().toString();
    	String sQSID = et_QSID.getText().toString();
    	String sQTot = et_qTot.getText().toString();
    	
    	
    	int UID = Integer.parseInt(sUID);
		int QSID = Integer.parseInt(sQSID);
		int qTot = Integer.parseInt(sQTot);		
		
		UserSession.setUID(UID);
		UserSession.setQSID(QSID);
		
		try {
			DummyData.createDummyQSNavList(this, UID, QSID, qTot);
			DummyData.createDummmyMCQBundles(this, UID, QSID, qTot);
			Logger.i(" Successfully created Dummy QSNavList AND mcq BUNDLES ");
		} catch (IOException e) {
			e.printStackTrace();
			Logger.i(" CreateDummyTest exited with errors ");
		}
		
    }


    //onClick listenerL
	public void onClick(View v) {
		
		switch(v.getId()){
		case R.id.btn_start_test_now:
			Logger.i("Start Test Now button Clicked ");
			createDummyTest();
			break;
		case R.id.btn_dashboard_home:
			Logger.i("Dashboard Home button Clicked ");
			break;
		}
	
		ActivityLauncher.Launch(getApplicationContext(), v.getId());
	
	}
}
