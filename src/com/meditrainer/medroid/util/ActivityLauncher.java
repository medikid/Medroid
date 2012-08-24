package com.meditrainer.medroid.util;

import com.meditrainer.medroid.R;
import com.meditrainer.medroid.ui.BuySubscriptionActivity;
import com.meditrainer.medroid.ui.MCQViewerActivity;
import com.meditrainer.medroid.ui.NewsfeedActivity;
import com.meditrainer.medroid.ui.PerfAnalysisActivity;
import com.meditrainer.medroid.ui.QuestionSheetActivity;
import com.meditrainer.medroid.ui.StartTestActivity;
import com.meditrainer.medroid.ui.TestProfileActivity;
import com.meditrainer.medroid.ui.UserDashboardActivity;
import com.meditrainer.medroid.ui.UserProfileActivity;
import com.meditrainer.medroid.ui.UserRegisterActivity;

import android.content.Context;
import android.content.Intent;

public class ActivityLauncher {
	
	
	
	public static void Launch(Context appContext, int clickedButtonID){
		Logger.i(" Launch request initiated ");
		
		Intent StartThisActivity = new Intent();
		StartThisActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		
		switch(clickedButtonID){
		case R.id.btn_dashboard_home:
			StartThisActivity.setClass(appContext, UserDashboardActivity.class);
			break;
		case R.id.btn_start_test:
			StartThisActivity.setClass(appContext, StartTestActivity.class);
			break;
		case R.id.btn_test_profile:
			StartThisActivity.setClass(appContext, TestProfileActivity.class);
			break;
		case R.id.btn_user_profile:
			StartThisActivity.setClass(appContext, UserProfileActivity.class);
			break;
		case R.id.btn_perf_analysis:
			StartThisActivity.setClass(appContext,  PerfAnalysisActivity.class);
			break;
		case R.id.btn_buy_subscription:
			StartThisActivity.setClass(appContext,  BuySubscriptionActivity.class);
			break;
		case R.id.btn_newsfeed:
			StartThisActivity.setClass(appContext, NewsfeedActivity.class);
			break;
		case R.id.btn_start_test_now:
			StartThisActivity.setClass(appContext, QuestionSheetActivity.class);
			break;
		case R.id.link_to_register:
			StartThisActivity.setClass(appContext, UserRegisterActivity.class);
			break;		
		}
		
		appContext.startActivity(StartThisActivity);
	}
	
	public static void LaunchByActivityName(Context appContext, ActivityName ActName) throws ClassNotFoundException{
			//Class myClass = Class.forName("com.meditrainer.medroid.ui." + ActName);
		Intent StartThisActivity = new Intent();
		StartThisActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		StartThisActivity.setClassName(appContext, "com.meditrainer.medroid.ui." + ActName);
		appContext.startActivity(StartThisActivity);
		
	}
	
	
}