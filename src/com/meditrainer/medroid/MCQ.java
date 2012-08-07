package com.meditrainer.medroid;

import org.json.JSONObject;

import android.app.Activity;

public class MCQ implements iMCQ{

	public int qid, qno;
	public static final int LOAD_TYPE_NONE = 0;
	public static final int LOAD_TYPE_MIN = 1; 
	public static final int LOAD_TYPE_BASIC = 2; 
	public static final int LOAD_TYPE_NORMAL = 3; 
	public static final int LOAD_TYPE_MED = 4; 
	public static final int LOAD_TYPE_MAX = 5; 
	public String question_text, choice_a, choice_b, choice_c, choice_d, choice_e, answer;
	
	public MCQ(int qNO){
		this.qno = qNO;
	}
	
	public void getQid() {
		// TODO Auto-generated method stub
		
	}

	public void Load(int qid, Boolean LoadModeOffline, int LoadType) {
		// TODO Auto-generated method stub
		
	}

	public void create() {
		// TODO Auto-generated method stub
		
	}

	public void createFromJason(JSONObject mcqJason) {
		// TODO Auto-generated method stub
		
	}

	public void displayPrepare(Activity nameActivity) {
		// TODO Auto-generated method stub
		
	}

	public void displayOnScreen(Activity nameActivity) {
		// TODO Auto-generated method stub
		
	}

	public void choiceSelected() {
		// TODO Auto-generated method stub
		
	}

	public void submitAnswer() {
		// TODO Auto-generated method stub
		
	}

	public void getNext() {
		// TODO Auto-generated method stub
		
	}

	public void getPrev() {
		// TODO Auto-generated method stub
		
	}

	public void Load(int qid) {
		// TODO Auto-generated method stub
		
	}

}
