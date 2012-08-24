package com.meditrainer.medroid.util;

public class TimerAlarm {

	long alarmDialogTimeInSec;
	long alarmToastIntervalInSec;
	long alarmBlinkerTimeInSec;
	public Boolean isSet;

	public TimerAlarm(String AlarmToastIntervalInSec, String AlarmDialogTimeInSec, String AlarmBlinkerTimeInSec) {
		alarmDialogTimeInSec = DateTimeHandler.stringToSeconds(AlarmToastIntervalInSec);
		alarmToastIntervalInSec = DateTimeHandler.stringToSeconds(AlarmDialogTimeInSec);
		alarmBlinkerTimeInSec = DateTimeHandler.stringToSeconds(AlarmBlinkerTimeInSec);
		this.isSet = true;
	}

	public Boolean validateForToast(long timeInSec) {
		Boolean validateForToast = false;
		long mod = timeInSec % alarmToastIntervalInSec;
		if (mod == 0) {
			validateForToast = true;
		}
		return validateForToast;
	}

	public Boolean validateForDialog(long timeInSec) {
		Boolean validateForDialog = false;
		if (timeInSec == alarmDialogTimeInSec) {
			validateForDialog = true;
		}
		return validateForDialog;
	}

	public Boolean validateForBlinker(long timeInSec) {
		Boolean validateForBlinker = false;
		if (timeInSec < alarmBlinkerTimeInSec) {
			validateForBlinker = true;
		}
		return validateForBlinker;
	}
}
