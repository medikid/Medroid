package com.meditrainer.medroid.util;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.TimeZone;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.nfc.Tag;
import android.os.CountDownTimer;
import android.text.format.Time;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.meditrainer.medroid.*;

public class Timer extends TextView {

	CountDownTimer counter;
	long startTimeInMilliSec;
	long alarmTimeInSec;
	Context viewContext;
	long alarmToastIntervalInSec;
	TimerAlarm timerAlarm;
	int blinkerVar = 0;

	public Timer(Context context) {
		super(context);
		viewContext = context;
	}

	public Timer(Context context, AttributeSet attrs) {
		super(context, attrs);
		viewContext = context;
	}

	public Timer(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		viewContext = context;
	}

	public void start(long startTimeInSec) {
		startTimer(startTimeInSec);
	}

	public void start(String startTimeString) {
		// logger
		Logger.variable("startTimeString", startTimeString);

		long timeInSec = DateTimeHandler.stringToSeconds(startTimeString);
		startTimer(timeInSec);

		// logger
		Logger.variable("timeInSec", timeInSec);
	}

	public void setTime(long timeInMilliSec) {
		String time = DateTimeHandler.getTimeInHMSstring(timeInMilliSec);
		setText(time);
	}

	public void startTimer(long startTimeInSec) {
		startTimeInMilliSec = DateTimeHandler.secondsToMillis(startTimeInSec);

		// logger
		Logger.variable("startTimeInMilliSec", startTimeInMilliSec);

		counter = new CountDownTimer(startTimeInMilliSec, 1000) {

			public void onTick(long millisUntilFinished) {
				timerOnTick(millisUntilFinished);

				// logger
				Logger.variable("millisUntilFinished", millisUntilFinished);

			}

			public void onFinish() {
				timerOnFinish();
			}

		}.start();
	}

	public void timerOnTick(long MillisUntilFinished) {
		setTime(MillisUntilFinished);

		if (timerAlarm.isSet) {

			if (timerAlarm.validateForBlinker(DateTimeHandler
					.millisToSec(MillisUntilFinished))) {
				setBlinker();
			}

			if (timerAlarm.validateForDialog(DateTimeHandler
					.millisToSec(MillisUntilFinished))) {
				alertbox("Time Left", "Time left : " + getTimeLeft());
			}

			if (timerAlarm.validateForToast(DateTimeHandler
					.millisToSec(MillisUntilFinished))) {
				setToastRemainder("Time Left" + getTimeLeft());
			}
		}
	}

	public void timerOnFinish() {
		setText("Done!");
	}

	public String getTimeLeft() {
		String timeLeft = (String) this.getText();
		return timeLeft;
	}

	public void stopTimer() {

	}

	protected void alertbox(String title, String mymessage) {

		new AlertDialog.Builder(viewContext).setMessage(mymessage)
				.setTitle(title).setCancelable(true)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						// do things
					}
				}).show();
	}

	public void setAlarmTime(String reminderInterval, String finalRemainder,
			String blinkerStartTime) {
		timerAlarm = new TimerAlarm(reminderInterval, finalRemainder,
				blinkerStartTime);
	}

	public void setToastRemainder(String str) {
		Toast.makeText(viewContext, str, Toast.LENGTH_LONG).show();
	}

	public void setBlinker() {
		if (this.blinkerVar == 0) {
			this.setBackgroundColor(Color.RED);
			this.blinkerVar = 1;
		} else if (this.blinkerVar == 1) {
			this.setBackgroundColor(Color.YELLOW);
			this.blinkerVar = 0;
		}
	}
}
