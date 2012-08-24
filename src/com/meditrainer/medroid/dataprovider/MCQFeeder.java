package com.meditrainer.medroid.dataprovider;

import java.io.File;
import java.io.IOException;

import android.content.Context;
import android.util.Log;

import com.meditrainer.medroid.content.MCQ;
import com.meditrainer.medroid.storage.iStorage;
import com.meditrainer.medroid.storage.iStorageMCQs;
import com.meditrainer.medroid.userdata.UserSession;
import com.meditrainer.medroid.util.Logger;

/*
 * Provides MCQ data for QuestionSheet, loads from the Internal Storage or Loads from MCQ Repo
 */
public class MCQFeeder {

	static int loadedBundle;
	static Boolean loadingComplete;
	static MCQ[] MCQs;
	static File MCQsFolder;
	
	
	public static void loadMCQBundle(Context context, int bundleNo) throws IOException{
		loadingComplete = false;
		MCQs = iStorageMCQs.load(context, bundleNo);
		loadedBundle = bundleNo;
	}
	
	public static int QNoToBundleNo(int QNo){
		int diviser = QNo / 10;
		int bNo = diviser * 10;
		return bNo;
	}
	
	public static int QNoToMCQIndex(int QNo){
		int mod = QNo % 10;
		return mod;
	}
	
	public static MCQ[] loadMCQBundleByQNo(Context context, int QNo) throws IOException{
		int bundleNo = QNoToBundleNo(QNo);
		loadMCQBundle(context, bundleNo);
		return MCQs;
	}
	
	public static MCQ getMCQ(Context context, int QNo) throws IOException{
		MCQ MCQrequested = null;
		int bundleToLoad = QNoToBundleNo(QNo);
		if (bundleToLoad == loadedBundle){
			int MCQindex = QNoToMCQIndex(QNo);
			if (MCQs[MCQindex].qno == QNo){
				MCQrequested = MCQs[MCQindex];
			} else MCQrequested = searchBundleByQNo(QNo);
			
		} else {
			loadMCQBundle(context, bundleToLoad);
			getMCQ(context, QNo);
		}
		
		return MCQrequested;
	}
	
	public static MCQ searchBundleByQNo(int qNo) {
		MCQ requestedMCQ = null;
		int i = 0;
		for(i = 0; i < MCQs.length; i++){
			if (MCQs[i].qno == qNo){
				requestedMCQ = MCQs[i];
				break;
			}
		}
	
		return requestedMCQ;
	}

	public Boolean isCorrectMCQ(int QNo, MCQ mcq){
		Boolean isCorrect = false;
		if (QNo == mcq.qno){
			isCorrect = true;
		}
		return isCorrect;
	}
	
	public Boolean isCorrectBundle(int QNo){
		Boolean isCorrect = false;
		if (loadedBundle == QNoToBundleNo(QNo)){
			isCorrect = true;
		}
		return isCorrect;
	}
}
