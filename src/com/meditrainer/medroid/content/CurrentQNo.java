package com.meditrainer.medroid.content;

public class CurrentQNo {
	
	int mQNo;
	private CurrentQNoChangeListener mListener;
	
	public CurrentQNo(){
		mQNo = 1;
	}
	
	public void set(int QNo){
		mQNo = QNo;
		if (mListener != null){
			mListener.onCurrentQNoChanged(mQNo);
		}
	}
	
	public int get(){
		return mQNo;
	}
	
	public void NextQ(){
		set(mQNo + 1);
	}
	
	public void PrevQ(){
		set(mQNo - 1);
	}
	
	public void setCurrentQNoChangeListener(CurrentQNoChangeListener listener){
		mListener = listener;
	}
	
	
	
	public static interface CurrentQNoChangeListener{
		
		void onCurrentQNoChanged(int newQNo);
	}

}

