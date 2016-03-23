package com.example.loginetc;



import com.example.uiproject.R;
import com.example.uiproject.mainactivity;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity  implements OnClickListener{
    
	
	 private TextView  register;
	 private TextView  findpassword;
	 private Button    enter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		
		enter = (Button)findViewById(R.id.enter);
		register = (TextView)findViewById(R.id.register);
		findpassword = (TextView)findViewById(R.id.forgetmima);
	    enter.setOnClickListener(this);
		register.setOnClickListener(this);
		findpassword.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.register:
			 Intent intent0 = new Intent(MainActivity.this,register.class);
			 startActivity(intent0);
			 break;
		case R.id.forgetmima :
			 Intent intent1 = new Intent(MainActivity.this,forget.class);
			 startActivity(intent1);
			 break;
		case R.id.enter:
			 Intent intent2 = new Intent(MainActivity.this,mainactivity.class);
			 startActivity(intent2);
			 break;
		
		}
	}


}
