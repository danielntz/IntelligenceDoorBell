package com.example.uiproject;

import java.io.IOException;

import org.apache.http.Header;

import com.example.allinformation.biaoshi;
import com.example.http.Asynhttp;
import com.example.http.httpUtils;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.image.SmartImageView;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.ImageView;

public class showphoto   extends Activity{
          
	    private static final String TAG = null;
		private  SmartImageView    showphoto;
	    private  Bitmap     bitmap;
	    private   String    photopath;
	
		    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	    	// TODO Auto-generated method stub
	    	super.onCreate(savedInstanceState);
	    	requestWindowFeature(Window.FEATURE_NO_TITLE);    //全屏
	    	setContentView(R.layout.photo);
	       showphoto  = (SmartImageView)findViewById(R.id.photo);
	
	     	 initfunction();                             //向服务器发送消息，并且显示在手机上
	       
		    }
	    
   	//向服务器发送消息，获得图片的位置，得到图片的位图，显示在移动端
	 public   void    initfunction(){
		          
		 try {
		   	String path = "http://219.244.48.159:8080/WeChat/sendPhotoSmartDogAction.action";
			//	bitmap =      Asynhttp.transitphoto(path);
		    transitphoto(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		 
	 }
	  
	 
	 public     void     transitphoto(String path) throws IOException{
  	   //获取图片在服务器上的地址
  	   AsyncHttpClient   client = new AsyncHttpClient();
  	   RequestParams  params = new RequestParams();
 	 //  params.add("fileType", "photo_" +biaoshi.getDeviceId());
  	   params.add("fileType", "photo_" + "201508");      //测试当前绑定的设备
  	//   Log.i(TAG, params.toString());
	   client.post(path, params , new AsyncHttpResponseHandler() {
			@Override
			public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
				// TODO Auto-generated method stub
				        //返回的是图片的地址
			        String  photo = new String(responseBody);
			        photopath =  photo.substring(photo.indexOf(":") + 2 , photo.indexOf("}") -1);
			      //  Log.i(TAG, photopath);
			        photopath =photopath.replace("\\", "");     //把斜杠取消掉，java中斜杠不能单一写
			        Log.i(TAG, photopath);
			        showphoto.setImageUrl(photopath, R.drawable.abc_ab_share_pack_mtrl_alpha, R.drawable.abc_action_bar_item_background_material);
			        
			}
			@Override
			public void onFailure(int statusCode, Header[] headers,
					byte[] responseBody, Throwable error) {
				// TODO Auto-generated method stub
			       String  photo = new String(responseBody);
			       photopath = "获取失败";         
			}
		});    
  }
	 
	
		 
	 }
	 
	


  
