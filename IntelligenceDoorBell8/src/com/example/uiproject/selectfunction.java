package com.example.uiproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.example.allinformation.biaoshi;
/**
 * 當客人按下門鈴之後，登陆进App之后，移动端震动弹出选择功能界面
 * @author jsjxy
 *
 */
public class selectfunction  extends Activity implements OnClickListener{ 
      
	         private  Button   take_photo;
	         private  Button  real_talk;
	         private  Button  real_video;
	       private   int  count = 0;   
	
	
	
	       @Override
	    protected void onCreate(Bundle savedInstanceState) {
	    	// TODO Auto-generated method stub
	    	super.onCreate(savedInstanceState);
	       setContentView(R.layout.select_function);
	       take_photo = (Button)findViewById(R.id.take_photo);
	    	real_talk = (Button)findViewById(R.id.real_talk);
	    	real_video = (Button)findViewById(R.id.real_video);
	    	take_photo.setOnClickListener(this);
	    	real_talk.setOnClickListener(this);
	    	real_video.setOnClickListener(this);
	    }




		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			  switch (v.getId()) {
			case R.id.take_photo:
				      biaoshi.flag = true;
				      finish();
				      //用户给服务器发送拍照的消息，然后从服务器上获得门铃所拍的照片
				      Intent  intent  = new Intent (selectfunction.this,showphoto.class);
				      startActivity(intent);
		
				break;
			case    R.id.real_talk:
				biaoshi.flag = true;
				 finish();
				break;
			case R.id.real_video:
				biaoshi.flag = true;
				 finish();
				  break;
			}
		}
		//监听一下手机上的按键，以防退出程序
	 	@Override
	 	public boolean onKeyUp(int keyCode, KeyEvent event) {
	 		// TODO Auto-generated method stub
	 	
	 		  if(count == 1 ){
	 			   biaoshi.flag = true;
	 			  finish();
	 		  }
	 		if(event.KEYCODE_BACK  == keyCode){    //如果你点击的是返回键
	 			         //提示你在点一下，才退出程序
	 			  Toast.makeText(getApplicationContext(), "确定不做接听吗", 0).show();
	 			  count ++ ;
	 			  return false;
	 			  }
	        return super.onKeyUp(keyCode, event);
	 	}
	
	
}
