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
		Logger.i(" Launch request initiated for Button ID" + String.valueOf(clickedButtonID));
		
		Intent StartThisActivity = new Intent();
		StartThisActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		
		switch(clickedButtonID){
		case R.id.btn_dashboard_home:
			Logger.i(" Request to Open activity: Dashboard Home");
			StartThisActivity.setClass(appContext, UserDashboardActivity.class);
			break;
		case R.id.btn_start_test:
			Logger.i(" Request to Open activity: Start Test");
			StartThisActivity.setClass(appContext, StartTestActivity.class);
			break;
		case R.id.btn_test_profile:
			Logger.i(" Request to Open activity: Test Profile");
			StartThisActivity.setClass(appContext, TestProfileActivity.class);
			break;
		case R.id.btn_user_profile:
			Logger.i(" Request to Open activity: User Profile");
			StartThisActivity.setClass(appContext, UserProfileActivity.class);
			break;
		case R.id.btn_perf_analysis:
			Logger.i(" Request to Open activity: Perf Analysis");
			StartThisActivity.setClass(appContext,  PerfAnalysisActivity.class);
			break;
		case R.id.btn_buy_subscription:
			Logger.i(" Request to Open activity: Buy Subscription");
			StartThisActivity.setClass(appContext,  BuySubscriptionActivity.class);
			break;
		case R.id.btn_newsfeed:
			Logger.i(" Request to Open activity: Newsfeed");
			StartThisActivity.setClass(appContext, NewsfeedActivity.class);
			break;
		case R.id.btn_start_test_now:
			Logger.i(" Request to Open activity: Start Test Now");
			StartThisActivity.setClass(appContext, QuestionSheetActivity.class);
			break;
		case R.id.link_to_register:
			Logger.i(" Request to Open activity: User Registration");
			StartThisActivity.setClass(appContext, UserRegisterActivity.class);
			break;		
		}
		
		appContext.startActivity(StartThisActivity);
	}
	
	public static void LaunchByActivityName(Context appContext, ActivityName ActName) throws ClassNotFoundException{
			//Class myClass = Class.forName("com.meditrainer.medroid.ui." + ActName);
		Logger.i(" Request to Open activity by ActivityName enum");
		Intent StartThisActivity = new Intent();
		StartThisActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		StartThisActivity.setClassName(appContext, "com.meditrainer.medroid.ui." + ActName);
		appContext.startActivity(StartThisActivity);
		
	}
	
	
}