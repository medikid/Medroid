package com.meditrainer.medroid.ui;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.meditrainer.medroid.DummyData;
import com.meditrainer.medroid.R;
import com.meditrainer.medroid.adapter.QSArrayAdapter;
import com.meditrainer.medroid.content.Question;
import com.meditrainer.medroid.dataprovider.QSDataProvider;
import com.meditrainer.medroid.storage.iStorageQSNavList;
import com.meditrainer.medroid.userdata.UserSession;
import com.meditrainer.medroid.util.JSONHandler;
import com.meditrainer.medroid.util.Logger;

import android.app.Activity;
import android.app.ListActivity;
import android.app.ListFragment;
import android.content.ContentUris;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class QSNavListFragment extends ListFragment  {
	OnQuestionSelectedListener mListener;
	private int currentlySelectedPosition = 1;
	private int listItemColor = Color.GRAY;
	private int highlightedListItemColor = Color.YELLOW;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// setListAdapter(new ArrayAdapter<String>(this, R.layout.list_mobile,		// R.id.label, MOBILE_OS));
		//ArrayList<Question> QuestionSheetArray = DummyData.QuestionSheetArray;
		
		ArrayList<Question> QuestionSheetArray = new ArrayList<Question>();
		UserSession.setUID(123);
		UserSession.setQSID(123456);
		try {		
			QuestionSheetArray = iStorageQSNavList.load(getActivity());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Logger.i("Logged error, couldnot load QuestionSheetArray");
		}
		
		setListAdapter(new QSArrayAdapter(getActivity(), QuestionSheetArray));
	
	}
 

	@Override
	 public void onAttach(Activity activity) {
	        super.onAttach(activity);
	        try {
	            mListener = (OnQuestionSelectedListener) activity;
	        } catch (ClassCastException e) {
	            throw new ClassCastException(activity.toString() + " must implement OnArticleSelectedListener");
	        }
	    }
	
	
	 // Container Activity must implement this interface
    public interface OnQuestionSelectedListener {
        public void onQuestionSelected(Question q);
    }
    
    @Override
    public void onListItemClick(ListView lv, View v, int position, long id) {
    	int previouslySelectedItem =  currentlySelectedPosition;
		currentlySelectedPosition = position;
		highlightItemSelected(lv, v, previouslySelectedItem);
        
		// Append the clicked item's row ID with the content provider Uri
    	Question selectedValue = (Question) lv.getItemAtPosition(position);
        // Send the event and Uri to the host activity
        
    	mListener.onQuestionSelected(selectedValue);
    }
    
    
    public void highlightItemSelected(ListView lv, View currentlySelectedView, int previouslySelectedPosition){
    	/*
    	for(int a = 0; a < lv.getChildCount(); a++)
        {
    		//if previously selected, unselect it
    		if (a == currentSelectedPosition){
    			
    		} else lv.getChildAt(a).setBackgroundColor(Color.BLACK);
        } */
    	lv.getChildAt(previouslySelectedPosition).setBackgroundColor(listItemColor);
    	currentlySelectedView.setBackgroundColor(highlightedListItemColor);

    }
    

}