package com.example.segmentcontrolview;

import org.xmlpull.v1.XmlPullParser;

import com.example.uiproject.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class SegmentView  extends LinearLayout {

     private TextView lateone = null;      //最近一周
     private TextView latetwo = null;      //最近一月
     private TextView latethree = null;    //最近三月
     private  View     line = null;        //竖线
     private  View     line1 = null;       //竖线
     private Onsegmentlistenerclicker  listener;
     private   SegmentView view1 = null;
     public SegmentView(Context context) {
		super(context);
		init();
		// TODO Auto-generated constructor stub
	}
     
     public SegmentView(Context context, AttributeSet attrs) {
  		super(context, attrs);
  		init();
  	}
  	
  	@SuppressLint("NewApi")
 	public SegmentView(Context context, AttributeSet attrs, int defStyleAttr) {
  		super(context, attrs, defStyleAttr);
  		init();
  	}
     //初始化
      public void init(){
      lateone = new TextView(getContext());
      latetwo = new TextView(getContext());
      latethree =   new TextView(getContext());
      line     =  new TextView(getContext());
      line1   =  new TextView(getContext());
      
      //用來描述控件的大小
      lateone.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT,1));
      line.setLayoutParams(new LayoutParams(1,LayoutParams.MATCH_PARENT));
      latetwo.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT,1));
      line1.setLayoutParams(new LayoutParams(1,LayoutParams.MATCH_PARENT));
      latethree.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT,1));
      
      //添加控件文字及大小
      lateone.setText("最近一周");
      latetwo.setText("最近一月");
      latethree.setText("最近三月");
      lateone.setTextSize(16);
      latetwo.setTextSize(16);
      latethree.setTextSize(16);
      //设置文字的颜色
		XmlPullParser xrp = getResources().getXml(R.drawable.changewenzi); 
	    try {  
	        ColorStateList csl = ColorStateList.createFromXml(getResources(), xrp);  
	        lateone.setTextColor(csl);
	        latetwo.setTextColor(csl);
	        latethree.setTextColor(csl);
	      } catch (Exception e) {  
	    } 
      
      //控件在布局中的位置
      lateone.setGravity(Gravity.CENTER);
      latetwo.setGravity(Gravity.CENTER);
      latethree.setGravity(Gravity.CENTER);
      lateone.setPadding(3, 6, 3, 6);
      latetwo.setPadding(3, 6, 3, 6);
      latethree.setPadding(3, 6, 3, 6);
      lateone.setBackgroundResource(R.drawable.left);
      latetwo.setBackgroundResource(R.drawable.middle);
      latethree.setBackgroundResource(R.drawable.right);
      line.setBackgroundColor(getResources().getColor(R.color.blue));
      line1.setBackgroundColor(getResources().getColor(R.color.blue));
      
      //在此布局上添加组件
      this.removeAllViews();
      this.addView(lateone);
      this.addView(line);
      this.addView(latetwo);
      this.addView(line1);
      this.addView(latethree);
      this.invalidate();
      lateone.setSelected(true);
      
      
      //添加监听事件
      lateone.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(lateone.isSelected()){
				return ;
			}
			lateone.setSelected(true);
            latetwo.setSelected(false);	
            latethree.setSelected(false);
            if(listener !=null){
            	 listener.setOnsegment(lateone, 0);
            }
		}
	});
      
      latetwo.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(latetwo.isSelected()){
				return ;
			}
			lateone.setSelected(false);
            latetwo.setSelected(true);	
            latethree.setSelected(false);
            if(listener !=null){
                listener.setOnsegment(latetwo, 1);
            }
		}
		
	});
      
      latethree.setOnClickListener(new OnClickListener() {
  		
  		@Override
  		public void onClick(View v) {
  			// TODO Auto-generated method stub
  			if(latethree.isSelected()){
  				return ;
  			}
  			lateone.setSelected(false);
              latetwo.setSelected(false);	
              latethree.setSelected(true);
              if(listener !=null){
              	  listener.setOnsegment(latethree, 2);
              }
  		}
  		
  	});
		
	
    }
     
      
      public void setOnsegmentlistenerclicker( Onsegmentlistenerclicker listener){
    	          
    	     this.listener = listener;
      }   
	  
     
}
