package com.meditrainer.medroid.content;

import org.json.JSONObject;

import android.app.Activity;

public class MCQ implements iMCQ{

	
	public int qid, qno, LoadedMCQRepoId;	
	public String question_text, choice_a, choice_b, choice_c, choice_d, choice_e, answer;
	
	public MCQ(int qNO){
		this.qno = qNO;
	}
	

}
