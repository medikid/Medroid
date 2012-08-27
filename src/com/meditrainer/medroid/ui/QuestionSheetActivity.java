
package com.meditrainer.medroid.ui;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.widget.ListView;
import android.widget.Toast;

import com.meditrainer.medroid.DummyData;
import com.meditrainer.medroid.R;
import com.meditrainer.medroid.content.Question;
import com.meditrainer.medroid.ui.QSNavListFragment.OnQuestionSelectedListener;
import com.meditrainer.medroid.ui.QuestionViewerFragment.OnCurrentQNoChangeListener;
import com.meditrainer.medroid.util.Logger;

public class QuestionSheetActivity extends Activity implements  OnQuestionSelectedListener, OnCurrentQNoChangeListener {
	FragmentManager mFragmentManager;
	QSNavListFragment qnav_frag = null;
	QuestionViewerFragment qview_frag = null;
	

	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_question_sheet);
	        

	       qnav_frag = new QSNavListFragment();
	       addFragment(R.id.frag_list_view, qnav_frag);	       
	       
	       qview_frag = new QuestionViewerFragment();
	       addFragment(R.id.frag_list_detail, qview_frag);	
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
		Logger.i("QSActivity: OnQuestionSelected function called" );
		Logger.toast(getApplicationContext(), "Listener from QSActivity: List Item selected " + String.valueOf(q.qno));
		
		if (qnav_frag.lv == null){
			qnav_frag.setLView();
		}	
		qview_frag.setCurrentQNo(q.qno);
		
	}

	//things to do when MCQ is selected on Q is na
	public void onCurrentQNoChanged(int newQNo) {
		Logger.i("QSActivity: OnCurrentQNoChanged function called" );
		Logger.toast(getApplicationContext(), "Listener from QSActivity: New MCQ selected " + String.valueOf(newQNo));
		
		if (qnav_frag.lv == null){
			qnav_frag.setLView();
		}
		
		//qnav_frag.autoscrollToPosition(newQNo + qnav_frag.mcqOffset);
		qnav_frag.syncSelectionWithQuestionViewer(newQNo);
	}
	
		
}
