package com.meditrainer.medroid.adapter;

import com.meditrainer.medroid.R;
import com.meditrainer.medroid.content.Question;

import android.widget.ImageView;
import android.widget.TextView;

public class QSListViewHolder {

	ImageView iv_qFlag ;
	ImageView iv_qView_status ;
	TextView tv_qNo ;
	TextView tv_qAnswer;
	ImageView iv_qVal ;
	
	public void setupQuestion(Question q){		
		setQFlag(q.q_flag);
		setQViewStatus(q.q_view_status);
		setQNo(q.qno);
		setQAnswer(q.answer);
		setQVal(q.q_val);
	}
	
	public void setQFlag(int q_flag){
		if (q_flag == 1){
		iv_qFlag.setImageResource(R.drawable.q_flag);
		}		
	}
	
	public void setQViewStatus(int q_viewed){
		if (q_viewed == 1){
		iv_qView_status.setImageResource(R.drawable.q_viewed);
		} else if (q_viewed == 2){
			iv_qView_status.setImageResource(R.drawable.q_viewed_past);
		} else if (q_viewed == 3){
			iv_qView_status.setImageResource(R.drawable.q_skipped);
		}
	}
	
	public void setQNo(int q_qno){
		tv_qNo.setText(String.valueOf(q_qno));
	}
	
	public void setQAnswer(String q_answer){
		tv_qAnswer.setText(q_answer);
	}
	
	public void setQVal(int q_val){
		if (q_val == 2){
		iv_qVal.setImageResource(R.drawable.q_correct);
		} else if (q_val == 1){
		iv_qVal.setImageResource(R.drawable.q_incorrect);
		}
	}
}
