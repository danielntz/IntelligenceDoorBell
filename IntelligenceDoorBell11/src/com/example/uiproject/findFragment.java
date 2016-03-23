package com.example.uiproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.segmentcontrolview.Onsegmentlistenerclicker;
import com.example.segmentcontrolview.SegmentView;
import com.example.segmentcontrolview.onemonth;
import com.example.segmentcontrolview.oneweek;
import com.example.segmentcontrolview.threemonth;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class findFragment  extends Fragment {
      
	 /*----用于展示动态的fragment*/
	  private oneweek   showweek;
	  private onemonth  showmonth;
	  private threemonth showthreemonth;
	
	  private SegmentView text;
	//private GridView   grid_view;
	  private  FragmentManager  fragmentmanger;   //用于对fragement处理，在findfragment之下在再产生一个fragment 
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		 super.onCreate(savedInstanceState);
		 View findfragement = inflater.inflate(R.layout.find_layout, container, false);
		 text = (SegmentView)findfragement.findViewById(R.id.segment);   //获得segmentcontrol控件
         fragmentmanger =  getChildFragmentManager();    //嵌套在fragment中的fragment
	     setTabSelection(0);    //设定界面
	     text.setOnsegmentlistenerclicker(new Onsegmentlistenerclicker() {
		@Override
			public void setOnsegment(View v, int position) {
				// TODO Auto-generated method stub
				//按下segmentcontrol的功能
				
				setTabSelection(position);
			}  
		});
		 return findfragement;
       }

	public  void setTabSelection(int i) {
		// TODO Auto-generated method stub
		 FragmentTransaction trans =fragmentmanger.beginTransaction();
		//clearselection();
		//  hideFragements(trans);
		  //显示动态内容
		 hidefragment(trans);
		  switch (i) {
		   case  0:
			
			if(showweek == null){
				showweek = new oneweek();
				trans.add(R.id.contentsegment,showweek);
			}
			else
			{
				trans.show(showweek);
			}
			trans.commit();
			break;
	    
		   case 1:
			   
			   if(showmonth == null){
					showmonth = new onemonth();
					trans.add(R.id.contentsegment, showmonth);
				}
				else
				{
					trans.show(showmonth);
				}
			   trans.commit();
				break;
		   case  2:
			   
				if(showthreemonth == null){
					showthreemonth = new threemonth();
					trans.add(R.id.contentsegment, showthreemonth);
				}
				else
				{
					trans.show(showthreemonth);
				}
				trans.commit();
				break;
		  }
		      
	}

	public void hidefragment(FragmentTransaction transaction){
		  if(showweek !=null){
			  transaction.hide(showweek);
		  }
		 if(showmonth != null){
			 transaction.hide(showmonth);
		 }
		 if(showthreemonth != null){
			 transaction.hide(showthreemonth);
		 }
	}
	
	
	
	
	
}
