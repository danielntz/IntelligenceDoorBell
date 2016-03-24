package com.example.uiproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		 View setupfragement = inflater.inflate(R.layout.setup_layout, container, false);
		
		   userinfo =   (Button)setupfragement.findViewById(R.id.username);
		    changemima = (Button)setupfragement.findViewById(R.id.changeword);
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
				      smm.toggle(true);
			      	break;

			
			}
		}
	
}
