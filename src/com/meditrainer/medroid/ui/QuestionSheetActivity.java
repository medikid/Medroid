
package com.meditrainer.medroid.ui;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.widget.Toast;

import com.meditrainer.medroid.DummyData;
import com.meditrainer.medroid.R;
import com.meditrainer.medroid.content.Question;
import com.meditrainer.medroid.ui.QSNavListFragment.OnQuestionSelectedListener;

public class QuestionSheetActivity extends Activity implements  OnQuestionSelectedListener {
	OnQuestionSelectedListener mListener;
	FragmentManager mFragmentManager;

	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_question_sheet);
	        

	       QSNavListFragment qn_frag = new QSNavListFragment();
	       addFragment(R.id.frag_list_view, qn_frag);
	       
	       QuestionViewerFragment qv_frag = new QuestionViewerFragment();
	       addFragment(R.id.frag_list_detail, qv_frag);	        
	    }
	 
	 public void addFragment(int containerViewID, Fragment fragmentName){
		 mFragmentManager = getFragmentManager();
		 
		 //check if fragment is added, add only if not initiated, this prevents duplication
		 if (mFragmentManager.findFragmentById(containerViewID) == null){
			 FragmentTransaction transaction = mFragmentManager.beginTransaction();
			 
			 transaction.add(containerViewID, fragmentName);
			 
			 transaction.commit();
		 }
	 }
	
	 
	 
	 //things to do when question selected on the questoin Nav list
	public void onQuestionSelected(Question q) {
		// TODO Auto-generated method stub
		Toast.makeText(getApplicationContext(), "Answer " + q.answer + "was given to question" + String.valueOf(q.qno),
				Toast.LENGTH_SHORT).show();
		
		FragmentManager frgmMgr = getFragmentManager();
		QuestionViewerFragment qv_frag = (QuestionViewerFragment) frgmMgr.findFragmentById(R.id.frag_list_detail);
			
		qv_frag.currentQNo.set(q.qno);
		
	}
	
}
