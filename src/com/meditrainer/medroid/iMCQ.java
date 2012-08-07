package com.meditrainer.medroid;

import org.json.JSONObject;

import android.app.Activity;

public interface iMCQ {
	
	public void getQid();
	public void Load(int qid);
	public void create();
	public void createFromJason(JSONObject mcqJason);	
	public void displayPrepare(Activity nameActivity);
	public void displayOnScreen(Activity nameActivity);
	public void choiceSelected();
	public void submitAnswer();
	public void getNext();
	public void getPrev();


}
