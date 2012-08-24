package com.meditrainer.medroid.content;

public class Question implements iQuestion {

	public int qsid, qno, qid, q_flag, q_val, q_view_status;
	public String answer;
	public MCQ mcq;
	
	public Question(int QNO){
		qno = QNO;	
		setDefaults();
	}
	
	public Question(int QNO, int QSID){
		qsid =	QSID;
		qno = QNO;
		setDefaults();
	}
	public Question(int QNO, int QSID, int QID){
		qsid =	QSID;
		qid = QID;
		qno = QNO;
		setDefaults();
	}
	
	public void setDefaults(){
		
		answer ="";
		q_flag = 0;
		q_val = 0;
		q_view_status = 0;
	}
	
	public void setFlag(){
		q_flag = 1;
	}
	
	public void removeFlag(){
		q_flag = 0;
	}
}
