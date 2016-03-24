package com.example.http;

import java.io.IOException;

import org.apache.http.Header;

import android.graphics.Bitmap;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/*
 * 用来连接服务器，并且向服务器发送数据
 */
public class Asynhttp {
   
	   
	       public   Asynhttp(){
	    	   
	       }
	
	     //向服务器发送消息，告知服务器我要拍照
	
	    public   static     Bitmap     transitphoto(String path) throws IOException{
	    	   //获取图片在服务器上的地址
	    	    Bitmap    bitmap ;
	    	   AsyncHttpClient   client = new AsyncHttpClient();
	    	   RequestParams  params = new RequestParams();
	    	   params.add("photo", "give me photo");
	    	   client.post(path, params , new AsyncHttpResponseHandler() {
				@Override
				public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
					// TODO Auto-generated method stub
					        //返回的是图片的地址
				}
				@Override
				public void onFailure(int statusCode, Header[] headers,
						byte[] responseBody, Throwable error) {
					// TODO Auto-generated method stub
					
				}
			});
	    	   //拿到图片的地址后，现在在移动端显示出
	    	   bitmap  = httpUtils.httpgetphoto(path);
	    	   return bitmap;
	    }
	       
	    //向服务器发送消息，告知服务器我要查看语音
	    public   static   void     transitaudio(String path) throws IOException{
	    	   //获取音频文件在服务器上的地址
	    	   AsyncHttpClient   client = new AsyncHttpClient();
	    	   RequestParams  params = new RequestParams();
	    	   params.add("audio", "give me audio");
	    	   client.post(path, params , new AsyncHttpResponseHandler() {
				@Override
				public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
					// TODO Auto-generated method stub
					        //返回的是音频的地址
				}
				@Override
				public void onFailure(int statusCode, Header[] headers,
						byte[] responseBody, Throwable error) {
					// TODO Auto-generated method stub
					
				}
			});
	    	   //拿到音频的地址后，在移动端播放
	    	   
	       }
	   
	   //向服务器发送消息，告知服务器我要查看视频
	    public  static   void    transitvideo(String path){
	    	   //获取视频文件在服务器上的位置
	    	AsyncHttpClient   client  = new AsyncHttpClient();
	    	RequestParams params = new RequestParams();
	    	params.add("video", "give me video");
	    	client.post(path, params, new AsyncHttpResponseHandler() {
				
				@Override
				public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onFailure(int statusCode, Header[] headers,
						byte[] responseBody, Throwable error) {
					// TODO Auto-generated method stub
					
				}
			});
	    	//拿到视频地址后，在移动端进行播放
	    }
}