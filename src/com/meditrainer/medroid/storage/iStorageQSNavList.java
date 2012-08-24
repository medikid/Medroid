package com.meditrainer.medroid.storage;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.meditrainer.medroid.content.Question;
import com.meditrainer.medroid.userdata.UserSession;
import com.meditrainer.medroid.util.JSONHandler;

import android.content.Context;

public class iStorageQSNavList extends iStorage {

	static File folderSessionData;
	static File fileNavList;
	static ArrayList<Question> QSNavList;
		
	public static String read(Context context) throws IOException{
		String fileContents = null;
		fileNavList = UserSession.getNavListFile(context);
		fileContents = getFileContent(context, fileNavList);
		
		return fileContents;
	}
	
	public static void write(Context context, String contents) throws IOException{
		fileNavList = UserSession.getNavListFile(context);
		if (!fileNavList.exists()){
			fileNavList.createNewFile();
		}
		addFileContent(context, fileNavList, contents);
	}
	
	public static void edit(){
		
	}
	
	public static void delete(){
		
	}
	
	public static ArrayList<Question> load(Context context) throws IOException{
		String jsonString = read(context);		
		Type collectionType =  new TypeToken<List<Question>>(){}.getType();
		QSNavList = (ArrayList<Question>)JSONHandler.jsonToObject(jsonString, collectionType);		
		
		return QSNavList;
	}
	
	public static void save(Context context, ArrayList<Question> navList) throws IOException{
		QSNavList = navList;
		String jsonString = JSONHandler.jsonFromObject(QSNavList);
		write(context, jsonString);
	}
}
