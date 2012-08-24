package com.meditrainer.medroid.dataprovider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import android.content.Context;

import com.meditrainer.medroid.content.Question;
import com.meditrainer.medroid.storage.iStorage;
import com.meditrainer.medroid.storage.iStorageQSNavList;
import com.meditrainer.medroid.userdata.UserSession;
import com.meditrainer.medroid.util.JSONHandler;
import com.meditrainer.medroid.util.Logger;

/*
 * get and set data for QuestionSheet
 */
public class QSDataProvider {	
	/*
	 * load QNavList from internal storage
	 */
	public static ArrayList<Question> iLoadQNavList(Context context) throws IOException{
		String navListfileContent = iLoadJsonQNavList(context);
		ArrayList<Question> QNavList = JSONHandler.jsonToArrayList(navListfileContent, Question.class);
		
		return QNavList;
	}
	
	public static String iLoadJsonQNavList(Context context) throws IOException{
		String navListfileContent = iStorageQSNavList.read(context);
		return navListfileContent;
	}
	
	public static void iSaveQNavList(Context context, ArrayList<Question> alq) throws IOException{		
		String jsonQnavList = JSONHandler.jsonFromObject(alq);
		iSaveJsonQNavList(context, jsonQnavList);		
	}
	
	public static void iSaveQNavList(Context context, String jsonQNavList) throws IOException{
		iSaveJsonQNavList(context, jsonQNavList);
	}
	
	private static void iSaveJsonQNavList(Context context, String jsonQNavList) throws IOException{
		File navListFile = UserSession.getNavListFile(context);
	 	 
		try {
			iStorageQSNavList.write(context, jsonQNavList);
			Logger.i("Added following contents to navlistfile: " + jsonQNavList.toString());
		} catch (IOException e) {
			e.printStackTrace();
			Logger.i("Logged error adding contents"); 
		}
	}

}
