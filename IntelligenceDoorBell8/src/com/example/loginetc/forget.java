package com.example.loginetc;

import com.example.uiproject.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;


    

	       
public class forget  extends Activity implements OnClickListener{
    
	   private ImageButton fanhuijiemian; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.forget_layout);
		
		 fanhuijiemian = (ImageButton)findViewById(R.id.fanhui);
		 fanhuijiemian.setOnClickListener(this);
		 
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.fanhui:
			 finish();
			 break;

		default:
			break;
		}
	}
    
	       
	
	
	
}

	
	

