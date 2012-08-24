package com.meditrainer.medroid.adapter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.meditrainer.medroid.DummyData;
import com.meditrainer.medroid.R;
import com.meditrainer.medroid.content.Question;
import com.meditrainer.medroid.storage.iStorage;
import com.meditrainer.medroid.ui.QSNavListFragment;
import com.meditrainer.medroid.userdata.UserSession;
import com.meditrainer.medroid.util.JSONHandler;


public class QSArrayAdapter extends ArrayAdapter<Question> {
	private final Context context;
	private final LayoutInflater mInflater;
	private QSListViewHolder mListViewHolder;
	private final ArrayList<Question> questions;

		
	public QSArrayAdapter(Context context, ArrayList<Question> questionArray) {
		super(context, R.layout.fragment_qs_nav_list, questionArray);
		this.context = context;
		this.questions = questionArray;
		this.mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	/*
	@Override //dumb method of getview, creating new view for every row of a list
	public View getView(int position, View convertView, ViewGroup parent) {		
		
		View rowView = mInflater.inflate(R.layout.list_qs_nav, parent, false);
				
		Question q = questions.get(position);
		
		bindQuestion(rowView, q);
	

		return rowView;
	}
	
	@Override //good method of getview, recycling convertView(previously displayed view)
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null){				
		convertView = mInflater.inflate(R.layout.list_qs_nav, parent, false);
		}
		
		Question q = questions.get(position);
		
		bindQuestion(convertView, q);	

		return convertView;
	}
	*/
	
	
	@Override //best method of getview, recycling convertView and viewholder(so no need to findviewbyid every time)
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null){
			convertView = mInflater.inflate(R.layout.fragment_qs_nav_list, parent, false);
			mListViewHolder = new QSListViewHolder();
			
			mListViewHolder.iv_qFlag = (ImageView) convertView.findViewById(R.id.q_flag);
			mListViewHolder.iv_qView_status = (ImageView) convertView.findViewById(R.id.q_view_status);
			mListViewHolder.tv_qNo = (TextView) convertView.findViewById(R.id.qno);
			mListViewHolder.tv_qAnswer = (TextView) convertView.findViewById(R.id.answer);
			mListViewHolder.iv_qVal = (ImageView) convertView.findViewById(R.id.q_val);
			
			convertView.setTag(mListViewHolder);
		} else mListViewHolder = (QSListViewHolder) convertView.getTag();
		
		Question q = questions.get(position);
		
		viewHolderBindQuestion(mListViewHolder, q);
	
		return convertView;
	}
	
	public QSListViewHolder viewHolderBindQuestion(QSListViewHolder vh, Question q){
		vh.setupQuestion(q);		
		return vh;
	}	
		

	
	
	
}
