package com.meditrainer.medroid.ui;

import java.io.IOException;

import com.meditrainer.medroid.DummyData;
import com.meditrainer.medroid.R;
import com.meditrainer.medroid.R.layout;
import com.meditrainer.medroid.R.menu;
import com.meditrainer.medroid.content.CurrentQNo;
import com.meditrainer.medroid.content.CurrentQNo.CurrentQNoChangeListener;
import com.meditrainer.medroid.content.MCQ;
import com.meditrainer.medroid.content.Question;
import com.meditrainer.medroid.dataprovider.MCQFeeder;
import com.meditrainer.medroid.dataprovider.MCQLoader;
import com.meditrainer.medroid.ui.QSNavListFragment.OnQuestionSelectedListener;
import com.meditrainer.medroid.util.Timer;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.graphics.Color;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class QuestionViewerFragment extends Fragment implements OnCheckedChangeListener, OnClickListener, CurrentQNoChangeListener {

	TextView tvQuestionText;
	RadioGroup rdoGrpChoices;
	RadioButton rdoChoiceA, rdoChoiceB, rdoChoiceC, rdoChoiceD, rdoChoiceE, rdoBtnSelected;
	Button btnSubmitAnswer, btnNext, btnPrev, btnStartStop;
	int mcqQno, mcqQid, LoadedMCQRepoId;
	String mcqChoiceSelected = "";
	MCQ mMCQ;
	Timer MCQTimer;
	View v;
	OnQuestionSelectedListener mListener;
	CurrentQNo currentQNo = new CurrentQNo();
	MCQLoader loader;
	
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		v = inflater.inflate(R.layout.activity_mcq_viewer, container, false);
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_mcq_viewer);
        
        findAllViewsById(v);
        rdoChoiceA.setOnCheckedChangeListener(this);
        rdoChoiceB.setOnCheckedChangeListener(this);
        rdoChoiceC.setOnCheckedChangeListener(this);
        rdoChoiceD.setOnCheckedChangeListener(this);
        rdoChoiceE.setOnCheckedChangeListener(this);
        btnSubmitAnswer.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnPrev.setOnClickListener(this);
        btnStartStop.setOnClickListener(this);
        currentQNo.setCurrentQNoChangeListener(this);
        
      this.setContent(setDummyContent()) ;    
      MCQTimer.start("00:01:30");
      MCQTimer.setAlarmTime("00:00:30:", "00:01:00", "00:00:30");
      
      return v;
    }
    
    public MCQ setDummyContent(){
    	MCQ dummyMCQ = new MCQ(1);
    	dummyMCQ.question_text = "What is the name of Bhavana's daughter?";
    	dummyMCQ.choice_a = "Disha";
    	dummyMCQ.choice_b = "Nisha";
    	dummyMCQ.choice_c = "Monisha";
    	dummyMCQ.choice_d = "Kesha";
    	dummyMCQ.choice_e = "Pisha";
    	dummyMCQ.answer = "b";
    	return dummyMCQ;    	
    }
    
    public void findAllViewsById(View v){
    	tvQuestionText = (TextView) v.findViewById(R.id.tvQuestionText);
    	rdoGrpChoices= (RadioGroup) v.findViewById(R.id.rdoGrpChoices);
    	rdoChoiceA = (RadioButton) v.findViewById(R.id.rdoChoiceA);
    	rdoChoiceB = (RadioButton) v.findViewById(R.id.rdoChoiceB);
    	rdoChoiceC = (RadioButton) v.findViewById(R.id.rdoChoiceC);
    	rdoChoiceD = (RadioButton) v.findViewById(R.id.rdoChoiceD);
    	rdoChoiceE = (RadioButton) v.findViewById(R.id.rdoChoiceE);
    	btnSubmitAnswer= (Button) v.findViewById(R.id.btnSubmitAnswer);
    	btnNext= (Button) v.findViewById(R.id.btnNext);
    	btnPrev= (Button) v.findViewById(R.id.btnPrev);
    	btnStartStop= (Button) v.findViewById(R.id.btnStartStop);
    	MCQTimer = (Timer) v.findViewById(R.id.mcq_timer);
    }
    
    public RadioButton getRdoBtnSelected(){
    	int rdoSelectedInt = rdoGrpChoices.getCheckedRadioButtonId();
    	RadioButton rdoBtnSelected = (RadioButton) v.findViewById(rdoSelectedInt);
    	return rdoBtnSelected;
    }

    public void resetView(){
    	tvQuestionText.setText(null);
    	rdoGrpChoices.clearCheck();
    	rdoChoiceA.setText(null);
    	rdoChoiceB.setText(null);
    	rdoChoiceC.setText(null);
    	rdoChoiceD.setText(null);
    	rdoChoiceE.setText(null);
    }
   
    
    public void setContent(MCQ mcq){
    	resetView();
    	this.mMCQ = mcq;
    	tvQuestionText.setText(Html.fromHtml("<b>"+mcq.qno+". </b>"+this.mMCQ.question_text));
    	rdoChoiceA.setText(Html.fromHtml("<b>"+getString(R.string.prefix_choice_a)+" </b>"+this.mMCQ.choice_a));
    	rdoChoiceB.setText(Html.fromHtml("<b>"+getString(R.string.prefix_choice_b)+" </b>"+this.mMCQ.choice_b));
    	rdoChoiceC.setText(Html.fromHtml("<b>"+getString(R.string.prefix_choice_c)+" </b>"+this.mMCQ.choice_c));
    	rdoChoiceD.setText(Html.fromHtml("<b>"+getString(R.string.prefix_choice_d)+" </b>"+this.mMCQ.choice_d));
    	rdoChoiceE.setText(Html.fromHtml("<b>"+getString(R.string.prefix_choice_e)+" </b>"+this.mMCQ.choice_e));
    }
    
    

	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		if (isChecked){
			buttonView.setBackgroundColor(Color.YELLOW);
			rdoBtnSelected = (RadioButton) buttonView;
			setAnswerSelected();
			
			Log.i("AppActivity", "User selected answer "+ mcqChoiceSelected);
		} else buttonView.setBackgroundColor(Color.TRANSPARENT);		
		
	}

	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Button clickedButton = (Button) arg0;
		
		String $validation_feedback="";
		if (validateAnswerSubmitted() == true){
			$validation_feedback = "Yes, that's correct. Awesome response!";
		} else $validation_feedback = "Sorry, that's Not correct. Correct answer is Nisha";
		
		Toast.makeText(getActivity(), "You selected answer "+mcqChoiceSelected+". "+$validation_feedback, 6000).show();
		Log.i("AppActivity", $validation_feedback);
	}
	
	public void setAnswerSelected(){
		if(rdoBtnSelected.getId() == rdoChoiceA.getId()){
			this.mcqChoiceSelected = "a";
		} else if (rdoBtnSelected.getId() == rdoChoiceB.getId()){
			this.mcqChoiceSelected = "b";
		} else if (rdoBtnSelected.getId() == rdoChoiceC.getId()) {
			this.mcqChoiceSelected = "c";
		} else if (rdoBtnSelected.getId() == rdoChoiceD.getId()){
			this.mcqChoiceSelected = "d";
		} else if (rdoBtnSelected.getId() == rdoChoiceE.getId()){
			this.mcqChoiceSelected = "e";
		}
	}
	
	public Boolean validateAnswerSubmitted(){
		Boolean answer_validation = false;
		if (this.mcqChoiceSelected == this.mMCQ.answer){
			answer_validation = true;
		}
		return answer_validation;
	}
	
	public void getNextQ(){
		currentQNo.NextQ();
	}
	
	public void getPrevQ(){
		currentQNo.PrevQ();
	}

	public void onCurrentQNoChanged(int newQNo){
		// TODO Auto-generated method stub
		Toast.makeText(getActivity(), "CurrentQNOchange lisener working", Toast.LENGTH_LONG).show();
		MCQ m = null;
		try {
		MCQFeeder.loadMCQBundleByQNo(getActivity().getApplicationContext(), newQNo);
		m = MCQFeeder.getMCQ(getActivity().getApplicationContext(), newQNo);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setContent(m);
		
	}

}
