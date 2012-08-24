package com.meditrainer.medroid.storage;

import java.io.File;
import java.io.IOException;

import android.content.Context;

import com.meditrainer.medroid.content.MCQ;
import com.meditrainer.medroid.userdata.UserSession;
import com.meditrainer.medroid.util.JSONHandler;
import com.meditrainer.medroid.util.Logger;


public class iStorageMCQs extends iStorage {

	static File folderMCQs;
	static File fileMCQs;
	static int mBundleNo;
	static MCQ[] mcqBundle;
	
	
	public static String read(Context context, int bundleNo) throws IOException{
		mBundleNo = bundleNo;
		String fileContents = null;
		folderMCQs = UserSession.getMCQsFolder(context);
		fileMCQs = new File(folderMCQs, String.valueOf(mBundleNo));
		fileContents = getFileContent(context, fileMCQs);
		
		return fileContents;
	}
	
	public static void write(Context context, int bundleNo, String contents) throws IOException{
		mBundleNo = bundleNo;
		String fileContents = null;
		folderMCQs = UserSession.getMCQsFolder(context);
		fileMCQs = new File(folderMCQs, String.valueOf(mBundleNo));
		if (!fileMCQs.exists()){
		fileMCQs.createNewFile();
		}
		addFileContent(context, fileMCQs, contents);
		
		Logger.i("Bundle No:" + String.valueOf(bundleNo) + "Completed writing MCQs at " + fileMCQs.getAbsolutePath().toString() );
	}
	
	public static MCQ[] load(Context context, int bundleNo) throws IOException{
		mBundleNo = bundleNo;
		String jsonStr = read(context, mBundleNo);
		mcqBundle = (MCQ[]) JSONHandler.jsonToObject(jsonStr, MCQ[].class);
		return mcqBundle;
	}
	
	public static void save(Context context, int bundleNo, MCQ[] MCQs) throws IOException{
		String jsonStr =  JSONHandler.jsonFromObject(MCQs);
		write(context, bundleNo, jsonStr);
		
	}

	
}
