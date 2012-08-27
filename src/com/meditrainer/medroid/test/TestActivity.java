package com.meditrainer.medroid.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.meditrainer.medroid.DummyData;
import com.meditrainer.medroid.Globals;
import com.meditrainer.medroid.Globals.AppUser;
import com.meditrainer.medroid.R;
import com.meditrainer.medroid.R.layout;
import com.meditrainer.medroid.R.menu;
import com.meditrainer.medroid.content.MCQ;
import com.meditrainer.medroid.content.Question;
import com.meditrainer.medroid.dataprovider.MCQFeeder;
import com.meditrainer.medroid.dataprovider.QSDataProvider;
import com.meditrainer.medroid.storage.iStorage;
import com.meditrainer.medroid.storage.iStorageQSNavList;
import com.meditrainer.medroid.storage.iStorageMCQs;
import com.meditrainer.medroid.ui.StartTestActivity;
import com.meditrainer.medroid.userdata.UserSession;
import com.meditrainer.medroid.util.Logger;
import com.meditrainer.medroid.util.JSONHandler;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TestActivity extends Activity implements OnClickListener {

	EditText et_test;
	TextView tv_test;
	Button btn_test;
	
	String	et_text;
	String tv_text;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        setupControls();
    }
    
    public void setupControls(){
    	et_test = (EditText) findViewById(R.id.et_test);
    	tv_test = (TextView) findViewById(R.id.tv_test);
    	btn_test = (Button) findViewById(R.id.btn_test);
    	btn_test.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_test, menu);
        return true;
    }

     
    
	public void onClick(View v){
	
		UserSession.setUID(123);
		UserSession.setQSID(123456);
		try {
			DummyData.createDummyQSNavList(this, 123, 123456, 200);
			DummyData.createDummmyMCQBundles(this, 123, 123456, 200);
			Logger.i(" Successfully created Dummy QSNavList AND mcq BUNDLES ");
		} catch (IOException e) {
			e.printStackTrace();
			Logger.i(" CreateDummyTest exited with errors ");
		}
		Logger.toast(this, "Dummy data created");
	 
	}
}
