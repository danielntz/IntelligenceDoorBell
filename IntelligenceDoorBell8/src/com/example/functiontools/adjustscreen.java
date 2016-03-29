package com.example.functiontools;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

public class adjustscreen  extends  VideoView{

	@SuppressLint("NewApi")
	public adjustscreen(Context context, AttributeSet attrs, int defStyleAttr,
			int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		// TODO Auto-generated constructor stub
	}

	public adjustscreen(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}

	public adjustscreen(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public adjustscreen(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	     @Override
	    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
	    	// TODO Auto-generated method stub
	    	    int width = getDefaultSize(0, widthMeasureSpec);  
		        int height = getDefaultSize(0, heightMeasureSpec);  
		        setMeasuredDimension(width, height);  
	    	
	    	
	    }

}
