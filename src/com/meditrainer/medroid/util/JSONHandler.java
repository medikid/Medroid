package com.meditrainer.medroid.util;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.meditrainer.medroid.content.Question;

public class JSONHandler {
	static Gson g = new Gson();
	
	public void toJson(){
		
	}
	
	public void fromJson(){
		
	}
	
	public static String jsonFromObject(Object object){
	 String	jsonStr = g.toJson(object);
	 return jsonStr;
	}
	
	public static Object jsonToObject(String jsonStr, Class Class) {
		Object obj = g.fromJson(jsonStr, Class);		
		return obj;
	}
	
	public static Object jsonToObject(String jsonStr, Type T) {
		Object obj = g.fromJson(jsonStr, T);		
		return obj;
	}
	
	public static <T, cls> Type getCollectionType(Class cls){
		Type collectionType = new TypeToken<List<cls>>(){}.getType();		
		return collectionType;
	}
	
	public static <T> ArrayList jsonToArrayList(String jsonString, Class cls){
		Type collectionType = getCollectionType(cls);
		ArrayList<T> jsonArrayList = (ArrayList<T>) g.fromJson(jsonString, collectionType);		
		return jsonArrayList;
	}
}
