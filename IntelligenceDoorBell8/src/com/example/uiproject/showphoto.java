package com.example.uiproject;

import java.io.IOException;

import com.example.http.Asynhttp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;

public class showphoto   extends Activity{
          
	    private  ImageView    showphoto;
	    private  Bitmap     bitmap;
	
	
		    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	    	// TODO Auto-generated method stub
	    	super.onCreate(savedInstanceState);
	    	requestWindowFeature(Window.FEATURE_NO_TITLE);    //全屏
	    	setContentView(R.layout.photo);
	       showphoto  = (ImageView)findViewById(R.id.photo);
	    	
	    	 initfunction();                             //向服务器发送消息，并且显示在手机上
	    	
	    }
	//向服务器发送消息，并且获得门铃拍的照片
	 public   void    initfunction(){
		          
		    try {
				bitmap =      Asynhttp.transitphoto("219.201");
				showphoto.setImageBitmap(bitmap);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	 }
	
}
