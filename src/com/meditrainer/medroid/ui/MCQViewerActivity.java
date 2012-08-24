package com.meditrainer.medroid.ui;

import com.meditrainer.medroid.R;
import com.meditrainer.medroid.R.layout;
import com.meditrainer.medroid.R.menu;
import com.meditrainer.medroid.content.MCQ;
import com.meditrainer.medroid.util.Timer;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class MCQViewerActivity extends Activity implements OnCheckedChangeListener, OnClickListener {

	TextView tvQuestionText;
	RadioGroup rdoGrpChoices;
	RadioButton rdoChoiceA, rdoChoiceB, rdoChoiceC, rdoChoiceD, rdoChoiceE, rdoBtnSelected;
	Button btnSubmitAnswer, btnNext, btnPrev, btnStartStop;
	int mcqQno, mcqQid, LoadedMCQRepoId;
	String mcqChoiceSelected = "";
	MCQ mcq_current;
	Timer MCQTimer;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcq_viewer);
        
        findAllViewsById();
        rdoChoiceA.setOnCheckedChangeListener(this);
        rdoChoiceB.setOnCheckedChangeListener(this);
        rdoChoiceC.setOnCheckedChangeListener(this);
        rdoChoiceD.setOnCheckedChangeListener(this);
        rdoChoiceE.setOnCheckedChangeListener(this);
        btnSubmitAnswer.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnPrev.setOnClickListener(this);
        btnStartStop.setOnClickListener(this);
        
      this.setContent(setDummyContent()) ;    
      MCQTimer.start("00:01:30");
      MCQTimer.setAlarmTime("00:00:30:", "00:01:00", "00:00:30");
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
    
    public void findAllViewsById(){
    	tvQuestionText = (TextView) findViewById(R.id.tvQuestionText);
    	rdoGrpChoices= (RadioGroup) findViewById(R.id.rdoGrpChoices);
    	rdoChoiceA = (RadioButton) findViewById(R.id.rdoChoiceA);
    	rdoChoiceB = (RadioButton) findViewById(R.id.rdoChoiceB);
    	rdoChoiceC = (RadioButton) findViewById(R.id.rdoChoiceC);
    	rdoChoiceD = (RadioButton) findViewById(R.id.rdoChoiceD);
    	rdoChoiceE = (RadioButton) findViewById(R.id.rdoChoiceE);
    	btnSubmitAnswer= (Button) findViewById(R.id.btnSubmitAnswer);
    	btnNext= (Button) findViewById(R.id.btnNext);
    	btnPrev= (Button) findViewById(R.id.btnPrev);
    	btnStartStop= (Button) findViewById(R.id.btnStartStop);
    	MCQTimer = (Timer) findViewById(R.id.mcq_timer);
    }
    
    public RadioButton getRdoBtnSelected(){
    	int rdoSelectedInt = rdoGrpChoices.getCheckedRadioButtonId();
    	RadioButton rdoBtnSelected = (RadioButton) findViewById(rdoSelectedInt);
    	return rdoBtnSelected;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_mcq_view, menu);
        return true;
    }
    
    public void setContent(MCQ mcq){
    	this.mcq_current = mcq;
    	tvQuestionText.setText(Html.fromHtml("<b>"+mcq.qno+". </b>"+this.mcq_current.question_text));
    	rdoChoiceA.setText(Html.fromHtml("<b>"+getString(R.string.prefix_choice_a)+" </b>"+this.mcq_current.choice_a));
    	rdoChoiceB.setText(Html.fromHtml("<b>"+getString(R.string.prefix_choice_b)+" </b>"+this.mcq_current.choice_b));
    	rdoChoiceC.setText(Html.fromHtml("<b>"+getString(R.string.prefix_choice_c)+" </b>"+this.mcq_current.choice_c));
    	rdoChoiceD.setText(Html.fromHtml("<b>"+getString(R.string.prefix_choice_d)+" </b>"+this.mcq_current.choice_d));
    	rdoChoiceE.setText(Html.fromHtml("<b>"+getString(R.string.prefix_choice_e)+" </b>"+this.mcq_current.choice_e));
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
		
		Toast.makeText(this, "You selected answer "+mcqChoiceSelected+". "+$validation_feedback, 6000).show();
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
		if (this.mcqChoiceSelected == this.mcq_current.answer){
			answer_validation = true;
		}
		return answer_validation;
	}
}
