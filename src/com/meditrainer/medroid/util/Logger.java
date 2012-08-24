package com.meditrainer.medroid.util;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.meditrainer.medroid.Globals;

public abstract class Logger {	
	static Boolean isEnabled = true;
	
	
	public static void enable(Boolean en_dis ){
		isEnabled = en_dis;
	}
	
	public static void i(String str){
		if (isEnabled){
		Log.i(Globals.System.iTAG, str);
		}
	}		
	
	public static void variable(String str, String strVar){
		if (isEnabled){
		Log.i(Globals.System.iTAG, "Value of "+ str +" : "+strVar);
		}
	}
	
	public static void variable(String str, int intVar){
		if (isEnabled){
		Log.i(Globals.System.iTAG, "Value of "+ str +" : " + String.valueOf(intVar) );
		}
	}
	
	public static void variable(String str, long longVar){
		if (isEnabled){
		Log.i(Globals.System.iTAG, "Value of "+ str +" : " + String.valueOf(longVar) );
		}
	}
	
	public static void variable(String str, double doubleVar){
		if (isEnabled){
		Log.i(Globals.System.iTAG, "Value of "+ str +" : " + String.valueOf(doubleVar) );
		}
	}
	
	public static void variable(String str, float floatVar){
		if (isEnabled){
		Log.i(Globals.System.iTAG, "Value of "+ str +" : " + String.valueOf(floatVar) );
		}
	}
	
	public static void variable(String str, Boolean boolVar){
		if (isEnabled){
		Log.i(Globals.System.iTAG, "Value of "+ str +" : " + String.valueOf(boolVar) );
		}
	}
	
	public static void toast(Context context, String str){
		Toast.makeText(context, str, Toast.LENGTH_LONG).show();
	}
}
