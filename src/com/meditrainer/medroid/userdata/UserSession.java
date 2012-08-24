package com.meditrainer.medroid.userdata;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import android.content.Context;
import com.meditrainer.medroid.Globals.*;
import com.meditrainer.medroid.content.Question;
import com.meditrainer.medroid.util.Logger;

/*
 * Handles UserSession data
 */
public class UserSession {

	public static void setUID(int uid){		
		AppUser.UID = String.valueOf(uid); Logger.i(" Set UserSession UID ");
	}
	
	public static int getUID(){
		Logger.i(" Get UserSession UID ");
		return Integer.parseInt(AppUser.UID);
	}
	
	public static void setQSID(int qsid){
		
		AppUser.QSID = String.valueOf(qsid); Logger.i(" Set UserSession QSID ");
	}
	
	public static int getQSID(){
		Logger.i(" Set UserSession UID ");
		return Integer.parseInt(AppUser.QSID);
	}
	
	public static File getUsersFolder(Context context){
		File userFolder = new File(context.getFilesDir(), App.USERS_FOLDERNAME + "/" + AppUser.UID);
		if (!userFolder.exists()){
			userFolder.mkdirs(); Logger.i(" Created UserFolder Directory ");
		}
		return userFolder;
	}
	
	public static File getSessionDataFolder(Context context){
		Logger.i(" Request to get Session Data Folder");
		String pathSessionDataFolder = App.USERS_FOLDERNAME + "/" + AppUser.UID + "/" + App.USER_SESSION_DATA_FOLDERNAME + "/" + AppUser.QSID;
		File sessionDataFolder = new File(context.getFilesDir(), pathSessionDataFolder);
		if (!sessionDataFolder.exists()){
			sessionDataFolder.mkdirs(); Logger.i(" Created Session Data Folder ");
		}
		return sessionDataFolder;
	}
	
	public static File getNavListFile(Context context) throws IOException{
		Logger.i(" Request to get NavListFile ");
		File userSessionDataFolder = getSessionDataFolder(context);
		File navListFile = new File(userSessionDataFolder, App.TEST_NAVLIST_FILENAME); 
		
		return navListFile;
	}
	
	public static File getMCQsFolder(Context context){	
		Logger.i(" Request to get MCQs folder ");
		String pathMCQsFolder = App.USERS_FOLDERNAME + "/" + AppUser.UID + "/" + App.USER_SESSION_DATA_FOLDERNAME + "/" + AppUser.QSID + "/" + App.TEST_MCQS_FOLDERNAME;
		File MCQsFolder = new File(context.getFilesDir(), pathMCQsFolder);
		if (!MCQsFolder.exists()){
			MCQsFolder.mkdirs(); Logger.i(" Created MCQs Folder ");
		}
		
		return MCQsFolder;
	}	
	
}
