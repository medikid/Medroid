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

/*
 * Handles MCQ TImer
 */
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
		viewContext = context; Logger.im(" Timer class is initialized ");
	}

	public Timer(Context context, AttributeSet attrs) {
		super(context, attrs);
		viewContext = context; Logger.im(" Timer class is initialized ");
	}

	public Timer(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		viewContext = context; Logger.im(" Timer class is initialized ");
	}

	public void start(long startTimeInSec) {
		startTimer(startTimeInSec);
	}

	public void start(String startTimeString) {
		// logger
		Logger.varm("startTimeString", startTimeString);

		long timeInSec = DateTimeHandler.stringToSeconds(startTimeString);
		startTimer(timeInSec);

		// logger
		Logger.varm("timeInSec", timeInSec);
	}

	public void setTime(long timeInMilliSec) {
		String time = DateTimeHandler.getTimeInHMSstring(timeInMilliSec);
		setText(time);
	}

	public void startTimer(long startTimeInSec) {
		startTimeInMilliSec = DateTimeHandler.secondsToMillis(startTimeInSec);

		// logger
		Logger.varm("startTimeInMilliSec", startTimeInMilliSec);

		counter = new CountDownTimer(startTimeInMilliSec, 1000) {

			public void onTick(long millisUntilFinished) {
				timerOnTick(millisUntilFinished);

				// logger
				Logger.varm("millisUntilFinished", millisUntilFinished);

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
		Logger.im(" Timer On Finish executed ");
		setText("Done!");
	}

	public String getTimeLeft() {
		Logger.im(" Get Time Left requested ");
		String timeLeft = (String) this.getText();
		return timeLeft;
	}

	public void stopTimer() {

	}

	protected void alertbox(String title, String mymessage) {
		Logger.im("Timer Alert box is displayed ");

		new AlertDialog.Builder(viewContext).setMessage(mymessage)
				.setTitle(title).setCancelable(true)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						// do things
					}
				}).show();
	}

	public void setAlarmTime(String reminderInterval, String finalRemainder, String blinkerStartTime) {
		Logger.im(" Alarm Time is set ");
		timerAlarm = new TimerAlarm(reminderInterval, finalRemainder,
				blinkerStartTime);
	}

	public void setToastRemainder(String str) {
		Logger.im(" Toast Reminder is displayed ");
		Toast.makeText(viewContext, str, Toast.LENGTH_LONG).show();
	}

	public void setBlinker() {
		Logger.im(" Set blinker on requested ");
		if (this.blinkerVar == 0) {
			this.setBackgroundColor(Color.RED);
			this.blinkerVar = 1;
		} else if (this.blinkerVar == 1) {
			this.setBackgroundColor(Color.YELLOW);
			this.blinkerVar = 0;
		}
	}
}
