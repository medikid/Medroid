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
/***********************************App Activity logi*********************************/
	public static void i(String str){
		if (isEnabled){
		Log.i(Globals.System.iTAG, str);
		}
	}		
	
	
	public static void im(String str){
		if (isEnabled){
		Log.i(Globals.System.imTAG, str);
		}
	}
	
/***********************App Misc Var Activity***********************************************/
	public static void varm(String str, String strVar){
		if (isEnabled){
		Log.i(Globals.System.imTAG, "Value of "+ str +" : "+strVar);
		}
	}
	
	public static void varm(String str, int intVar){
		if (isEnabled){
		Log.i(Globals.System.imTAG, "Value of "+ str +" : " + String.valueOf(intVar) );
		}
	}
	
	public static void varm(String str, long longVar){
		if (isEnabled){
		Log.i(Globals.System.imTAG, "Value of "+ str +" : " + String.valueOf(longVar) );
		}
	}
	
	public static void varm(String str, double doubleVar){
		if (isEnabled){
		Log.i(Globals.System.imTAG, "Value of "+ str +" : " + String.valueOf(doubleVar) );
		}
	}
	
	public static void varm(String str, float floatVar){
		if (isEnabled){
		Log.i(Globals.System.imTAG, "Value of "+ str +" : " + String.valueOf(floatVar) );
		}
	}
	
	public static void varm(String str, Boolean boolVar){
		if (isEnabled){
		Log.i(Globals.System.imTAG, "Value of "+ str +" : " + String.valueOf(boolVar) );
		}
	}

/******************************App Misc Var Activity******************************************/
	public static void var(String str, String strVar){
		if (isEnabled){
		Log.i(Globals.System.iTAG, "Value of "+ str +" : "+strVar);
		}
	}
	
	public static void var(String str, int intVar){
		if (isEnabled){
		Log.i(Globals.System.iTAG, "Value of "+ str +" : " + String.valueOf(intVar) );
		}
	}
	
	public static void var(String str, long longVar){
		if (isEnabled){
		Log.i(Globals.System.iTAG, "Value of "+ str +" : " + String.valueOf(longVar) );
		}
	}
	
	public static void var(String str, double doubleVar){
		if (isEnabled){
		Log.i(Globals.System.iTAG, "Value of "+ str +" : " + String.valueOf(doubleVar) );
		}
	}
	
	public static void var(String str, float floatVar){
		if (isEnabled){
		Log.i(Globals.System.iTAG, "Value of "+ str +" : " + String.valueOf(floatVar) );
		}
	}
	
	public static void var(String str, Boolean boolVar){
		if (isEnabled){
		Log.i(Globals.System.iTAG, "Value of "+ str +" : " + String.valueOf(boolVar) );
		}
	}
/*********************************App Toast Reminder ************************************/	
	public static void toast(Context context, String str){
		Toast.makeText(context, str, Toast.LENGTH_LONG).show();
	}
}
