package com.meditrainer.medroid.ui;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.meditrainer.medroid.DummyData;
import com.meditrainer.medroid.Globals;
import com.meditrainer.medroid.R;
import com.meditrainer.medroid.adapter.QSArrayAdapter;
import com.meditrainer.medroid.content.Question;
import com.meditrainer.medroid.dataprovider.QSDataProvider;
import com.meditrainer.medroid.storage.iStorageQSNavList;
import com.meditrainer.medroid.userdata.UserSession;
import com.meditrainer.medroid.util.JSONHandler;
import com.meditrainer.medroid.util.Logger;

import android.app.Activity;
import android.app.FragmentManager;
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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class QSNavListFragment extends ListFragment  {
	OnQuestionSelectedListener qListener;
	
	public ListView lv =null;
	private int lastSelectedPosition = 0;
	private int currentlySelectedPosition = 0;
	public int mcqOffset ;
	private int listItemColor = Color.GRAY;
	private int highlightedListItemColor = Color.YELLOW;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// setListAdapter(new ArrayAdapter<String>(this, R.layout.list_mobile,		// R.id.label, MOBILE_OS));
		//ArrayList<Question> QuestionSheetArray = DummyData.QuestionSheetArray;
		
		ArrayList<Question> QuestionSheetArray = new ArrayList<Question>();
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
	            qListener = (OnQuestionSelectedListener) activity;
	        } catch (ClassCastException e) {
	            throw new ClassCastException(activity.toString() + " must implement OnQuestionSelectedListener");
	        }   
	    }
	
	 @Override
    public void onListItemClick(ListView lv, View v, int position, long id) {
    	setCurrentlySelectedPosition(position);
		highlightItemSelected();
        
		// Append the clicked item's row ID with the content provider Uri
    	Question selectedValue = (Question) lv.getItemAtPosition(currentlySelectedPosition);
        // Send the event and Uri to the host activity
        
    	qListener.onQuestionSelected(selectedValue);
    }
    
	 public void setMCQOffset(){
		int checkPosition = lv.getFirstVisiblePosition();
		Question q = (Question) lv.getItemAtPosition(checkPosition);
		mcqOffset = checkPosition - q.qno;
		Logger.i("MCQ Offset setup : "+String.valueOf(mcqOffset));
	 }	 
	 
	 
	 public void setLView(){		
		 if (lv == null){
		 lv = getListView();
		 setMCQOffset();
		 Logger.i("List View is setup");
		 }
	 }	
	 
	 public int getPositionByMCQNo(int mcqNo){
		 return mcqNo + mcqOffset;
	 }
	 
	 public View getViewByMCQNo(int mcqNo){
		 int mcqPosition = getPositionByMCQNo(mcqNo);
		 View v = getViewByPosition(mcqPosition);
		 return v;
	 }
	 
	 public View getViewByPosition(int position){
		setViewInFocus(position);
		int firstPosition = lv.getFirstVisiblePosition();
		int positonIndex = position - firstPosition;
		
		View v = lv.getChildAt(positonIndex);
		return v;		
	 }
	 
	 public void setViewInFocus(int position){
		 if (position < lv.getFirstVisiblePosition() || position > lv.getLastVisiblePosition()){
			 autoscrollToPosition(position - 3);
		 }
	 }
	 
    public void setCurrentlySelectedPosition(int position){
    	lastSelectedPosition = currentlySelectedPosition;
    	currentlySelectedPosition = (position < 0) ? 0 : position;
    }
    
    
    public void highlightItemSelected(){ 
    	try{
		    View lstView =	getViewByPosition(lastSelectedPosition);
		    lstView.setBackgroundColor(listItemColor);
		    	
		    View crtView =	getViewByPosition(currentlySelectedPosition);
		    crtView.setBackgroundColor(highlightedListItemColor);
    	} catch (NullPointerException e){
    		e.printStackTrace();
    	}

    }
    
    public void autoscrollToPosition(int newPosition){
    	Logger.i("List Autoscrolled to new position:" + String.valueOf(newPosition));
    	
    	QSArrayAdapter lvAdapter = (QSArrayAdapter) lv.getAdapter();
    	View v = lvAdapter.getView(newPosition, null, null);
    	int top = (v == null) ? 0 : v.getTop();
    	
    	lv.setSelectionFromTop(newPosition, top);
    }
    
    public Boolean isListItemVisible(View v){
    	Boolean isVisible = false;
    	if (v.getVisibility() == View.VISIBLE){
    		isVisible = true;
    	}
    	return isVisible;
    }
    
    
    
    /*
     * sync nav list with mcq selection on the Question viewer
     * use GetAdapter and then item/view instead of accessing item directly from the listview
     * the reason being not all the views/items are visible/active at a given time
     */
    public void syncSelectionWithQuestionViewer(int mcqQNo){
    	Logger.i("List View sync request with new MCQ selection: " + String.valueOf(mcqQNo) + " Current Q Position: "  + String.valueOf(currentlySelectedPosition) );
    	
        int mcqPosition = getPositionByMCQNo(mcqQNo);
        setCurrentlySelectedPosition(mcqPosition);
        setViewInFocus(mcqPosition);        
        highlightItemSelected();
    	
    } 
    /*********************************** Interface for Q Selection Listener*********************************/
	 // Container Activity must implement this interface
    public interface OnQuestionSelectedListener {
        public void onQuestionSelected(Question q);
    }
    

}