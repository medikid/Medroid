package com.meditrainer.medroid.util;

/*
 * Handles alarm settings for MCQ Timer
 */
public class TimerAlarm {

	long alarmDialogTimeInSec;
	long alarmToastIntervalInSec;
	long alarmBlinkerTimeInSec;
	public Boolean isSet;

	public TimerAlarm(String AlarmToastIntervalInSec, String AlarmDialogTimeInSec, String AlarmBlinkerTimeInSec) {
		Logger.im("Toast alarm class is initialized");
		alarmDialogTimeInSec = DateTimeHandler.stringToSeconds(AlarmToastIntervalInSec);
		alarmToastIntervalInSec = DateTimeHandler.stringToSeconds(AlarmDialogTimeInSec);
		alarmBlinkerTimeInSec = DateTimeHandler.stringToSeconds(AlarmBlinkerTimeInSec);
		this.isSet = true;
	}

	public Boolean validateForToast(long timeInSec) {
		Logger.im("Check if Toast alarm is set at " + String.valueOf(timeInSec));
		Boolean validateForToast = false;
		long mod = timeInSec % alarmToastIntervalInSec;
		if (mod == 0) {
			validateForToast = true;
			Logger.im("Toast alarm is set at " + String.valueOf(timeInSec));
		}
		return validateForToast;
	}

	public Boolean validateForDialog(long timeInSec) {
		Logger.im("Check if Dialog alarm is set at " + String.valueOf(timeInSec));
		Boolean validateForDialog = false;
		if (timeInSec == alarmDialogTimeInSec) {
			validateForDialog = true;
			Logger.i("Dialog alarm is set at " + String.valueOf(timeInSec));
		}
		return validateForDialog;
	}

	public Boolean validateForBlinker(long timeInSec) {
		Logger.im("Check if Blinker alarm is set at " + String.valueOf(timeInSec));
		Boolean validateForBlinker = false;
		if (timeInSec < alarmBlinkerTimeInSec) {
			validateForBlinker = true;
			Logger.im("Blinker alarm is set at " + String.valueOf(timeInSec));
		}
		return validateForBlinker;
	}
}
