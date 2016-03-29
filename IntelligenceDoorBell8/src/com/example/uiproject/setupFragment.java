package com.example.uiproject;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.allinformation.biaoshi;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class setupFragment  extends Fragment implements OnClickListener{
         
	 
	 private static final String TAG = null;
	private  Button       userinfo;
	 private  Button      changemima;
	 private   SlidingMenu   smm;
	 private  int  m;
	 private  LayoutInflater  inflater;
	 private   View   userview;    //用户信息的对话框自定义控件
	 private  View    userpass;     // 修改密码的对话框自定义控件
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		 View setupfragement = inflater.inflate(R.layout.setup_layout, container, false);
		   userview = inflater.inflate(R.layout.user_info, (ViewGroup) setupfragement.findViewById(R.id.show_user));
		   userinfo =   (Button)setupfragement.findViewById(R.id.username);
		    changemima = (Button)setupfragement.findViewById(R.id.changeword);
		    inflater = getLayoutInflater(null);
		     m = biaoshi.getI();
		     Log.i(TAG, m +"");
		     smm = biaoshi.getSm();
		     
		    userinfo.setOnClickListener(this);
	     return setupfragement;
	}
 
    	

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.username:
				   //弹出对话框的形式,来显示用户信息
				   ViewGroup  viewgroup =   (ViewGroup) userview.getParent();
				   if(viewgroup != null){
					        viewgroup.removeAllViewsInLayout();
				   }
			 final Dialog  dialog =   new AlertDialog.Builder(getContext()).setTitle("用户信息").setView(viewgroup).setPositiveButton("确定	", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
				                  
				}
			}).create();
					   dialog.show();  
				
				
				
			}
		}
}
