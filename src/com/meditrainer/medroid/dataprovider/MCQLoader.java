package com.meditrainer.medroid.dataprovider;

import java.io.IOException;

import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;

import com.meditrainer.medroid.content.*;

public class MCQLoader {
	MCQFeeder feeder = new MCQFeeder();
	int QSID;
	MCQ mMCQ;
	public static final int LOAD_TYPE_NONE = 0;
	public static final int LOAD_TYPE_MIN = 1; 
	public static final int LOAD_TYPE_BASIC = 2; 
	public static final int LOAD_TYPE_NORMAL = 3; 
	public static final int LOAD_TYPE_MED = 4; 
	public static final int LOAD_TYPE_MAX = 5;
	public static Boolean mLoadModeOffline = true;;
	public static int mLoadType = 3;

	public void getQid() {
		// TODO Auto-generated method stub
		
	}
	
	public static MCQ Load(Context context, int qNO) throws IOException {
		MCQFeeder.loadMCQBundleByQNo(context, qNO);
		MCQ RequestedMCQ = MCQFeeder.getMCQ(context, qNO);
		return RequestedMCQ;		
	}

	public void Load(int qNO, Boolean LoadModeOffline) {
		mLoadModeOffline = LoadModeOffline;
		
	}
	public void Load(int qNO, Boolean LoadModeOffline, int LoadType) {
		mLoadModeOffline = LoadModeOffline;
		mLoadType = LoadType;
		
	}
	
	public void LoadByQID(int QID){
		
	}

	
	public void create() {
		// TODO Auto-generated method stub
		
	}

	public void createFromJason(JSONObject mcqJason) {
		// TODO Auto-generated method stub
		
	}

	public void displayPrepare(Activity nameActivity) {
		// TODO Auto-generated method stub
		
	}

	public void displayOnScreen(Activity nameActivity) {
		// TODO Auto-generated method stub
		
	}

	public void choiceSelected() {
		// TODO Auto-generated method stub
		
	}

	public void submitAnswer() {
		// TODO Auto-generated method stub
		
	}

	public void getNext() {
		// TODO Auto-generated method stub
		
	}

	public void getPrev() {
		// TODO Auto-generated method stub
		
	}

}
