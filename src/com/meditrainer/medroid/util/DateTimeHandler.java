package com.meditrainer.medroid.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import android.text.format.Time;

public abstract class DateTimeHandler {

	
	public static Date stringToDate(String timeString) throws ParseException {
		Logger.varm(" String to Date conversion ", timeString);
		Date dateObj = null;
		TimeZone tz = TimeZone.getTimeZone("UTC");
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		sdf.setTimeZone(tz);
		dateObj = sdf.parse(timeString);
		return dateObj;
	}

	public static Time stringToTime(String timeHMSstr) {
		Logger.varm(" String to Time conversion", timeHMSstr);

		String[] timeStr = timeHMSstr.split(":");

		Time tm = new Time();
		tm.hour = Integer.parseInt(timeStr[0]);
		tm.minute = Integer.parseInt(timeStr[1]);
		tm.second = Integer.parseInt(timeStr[2]);

		return tm;
	}

	public static long stringToSeconds(String timeHMSstr) {
		Logger.varm(" String to Seconds conversion", timeHMSstr);
		Time tm = stringToTime(timeHMSstr);
		long timeInSeconds = tm.toMillis(false) / 1000;
		return timeInSeconds;
	}
	
	public static long secondsToMillis(long timeInSec){
		Logger.varm(" Seconds to Milliseconds conversion ", timeInSec);
		long timeInMillis = timeInSec * 1000;
		return timeInMillis;
	}
	
	public static long millisToSec(long timeInMillis){
		Logger.varm(" millisToSec ", timeInMillis);
		long timeInSec = timeInMillis / 1000;
		return timeInSec;
	}
	
	public static String getTimeInHMSstring(long timeInMillis){
		Logger.varm(" Get time in HMS String ", timeInMillis);
		TimeZone tz = TimeZone.getTimeZone("UTC");
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		sdf.setTimeZone(tz);
		String HMStime = sdf.format(new Date(timeInMillis));
		return HMStime;
	}
}
