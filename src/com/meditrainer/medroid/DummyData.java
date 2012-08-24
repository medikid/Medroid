package com.meditrainer.medroid;

import java.io.IOException;
import java.util.ArrayList;

import android.content.Context;

import com.meditrainer.medroid.content.MCQ;
import com.meditrainer.medroid.content.Question;
import com.meditrainer.medroid.storage.iStorageMCQs;
import com.meditrainer.medroid.storage.iStorageQSNavList;
import com.meditrainer.medroid.userdata.UserSession;
import com.meditrainer.medroid.util.Logger;

public class DummyData {

	public static final String[] QSNumbers = new String[] { "1", "2", "3", "4"};
	public static final String[] QSFruits = new String[] { "Avacado", "Apple", "Orange", "Pineapple"};
	public static final ArrayList<Question> QuestionSheetArray = getDummyQuestionSheetArray();
	
		
	static ArrayList<Question> getDummyQuestionSheetArray() {
		Logger.i("DummyQuestionSheet Array Created");
		ArrayList<Question> QuestionSheetArray = new ArrayList<Question>();
		
		Question q1 = new Question(1, 123);
		Question q2 = new Question(2, 123);
		Question q3 = new Question(3, 123);
		Question q4 = new Question(4, 123);
		Question q5 = new Question(105, 123);
		Question q6 = new Question(106, 123);
		
		q1.answer = "d";
		q1.q_view_status = 1;

		q2.answer = "c";
		q2.q_view_status = 2;
		q2.q_flag = 1;

		q3.answer = "b";
		q3.q_val = 1;

		q4.answer = "a";
		q4.q_val = 2;
		
		q5.answer="e";
		q5.q_val=1;
		
		q6.answer="a";
		q6.q_val=0;

		QuestionSheetArray.add(q1);
		QuestionSheetArray.add(q2);
		QuestionSheetArray.add(q3);
		QuestionSheetArray.add(q4);
		QuestionSheetArray.add(q5);
		QuestionSheetArray.add(q6);

		return QuestionSheetArray;
	}
	
	public static void createDummyQSNavList(Context context, int UID, int QSID, int MaxQuestions) throws IOException{
		Logger.i("Dummy QSNavList created");
		UserSession.setUID(UID);
		UserSession.setQSID(QSID);
		ArrayList<Question> dummyNavList = new ArrayList<Question>();
		for(int i = 0; i < MaxQuestions; i++){
			Question Q = new Question(i + 1, QSID);
				Q.q_flag = i % 2;
				Q.q_val = i % 2;
				Q.q_view_status = i % 2;
			dummyNavList.add(Q);
		}
		
		iStorageQSNavList.save(context, dummyNavList);	
	}
   
	public static void createDummmyMCQBundles(Context context, int UID, int QSID, int MaxQuestions) throws IOException{
		
		Logger.i("Dummy MCQ Bundle created ");
		UserSession.setUID(UID);
		UserSession.setQSID(QSID);
		int i;
		int x;
		int mod;
		int bNo;
		MCQ[] mcqs = new MCQ[10];
		for (i=0; i<MaxQuestions; i++){
			mod = i % 10;
			bNo = (i / 10) * 10;
			
			MCQ m = new MCQ(i);
			String s = "This is Question No #"+ i +"loaded from Bundle "+ bNo;
			m.qid = bNo*100;
			m.question_text = s;
			m.choice_a = "a" + s;
			m.choice_b = "b" + s;
			m.choice_c = "c" + s;
			m.choice_d = "d" + s;
			m.choice_e = "e" + s;
			m.answer = "d";
			mcqs[mod] = m;
			
			if (mod == 9){
				iStorageMCQs.save(context, bNo, mcqs);
				mcqs = null;
				mcqs = new MCQ[10];				
			}
			
		}
		
	}
	
}
