package com.meditrainer.medroid.ui;

import java.util.ArrayList;
import java.util.List;

import com.meditrainer.medroid.DummyData;
import com.meditrainer.medroid.R;
import com.meditrainer.medroid.adapter.QSArrayAdapter;
import com.meditrainer.medroid.content.Question;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
public class QSNavListActivity extends ListActivity{

	

@Override
public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);

	//setListAdapter(new ArrayAdapter<String>(this, R.layout.list_mobile,
	//		R.id.label, MOBILE_OS));
	ArrayList<Question> QuestionSheetArray = DummyData.QuestionSheetArray;
	setListAdapter(new QSArrayAdapter(this, QuestionSheetArray));
	

}

@Override
protected void onListItemClick(ListView l, View v, int position, long id) {

	//get selected items
	//String selectedValue = (String) getListAdapter().getItem(position);
	
	Question selectedValue = (Question) l.getItemAtPosition(position);
	
	Toast.makeText(this, "Question " + String.valueOf(selectedValue.qno) + "was answerd as "+ selectedValue.answer, Toast.LENGTH_SHORT).show();

}

}