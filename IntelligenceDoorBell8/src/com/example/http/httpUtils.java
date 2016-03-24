package com.example.http;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.loopj.android.http.HttpGet;

/**
 *  连接web服务器，并且获得json内容
 * @author lenovo
 *
 */
public class httpUtils {
    
	  public   httpUtils(){
		  
	  }
	    
	  //连接服务器，获得服务器返回的流，对流进行处理，获得json字符串
	 //采用HttpClient方法，另外还有URLConnection的方法
	  public  static  String httpgetjsonContent(String path) throws ClientProtocolException, IOException{
		  
		      HttpClient  client = new DefaultHttpClient();
		      HttpGet  httpget = new HttpGet(path);
		      HttpResponse response = client.execute(httpget);  //获得服务器的响应
		      int code;
		      code = response.getStatusLine().getStatusCode();
		      if(code == 200){
		    	   InputStream is = response.getEntity().getContent() ; //获得服务器反回过来的流
		    	   String text;
		    	   text = streamtools.readInputStream(is);
	               return text;	 
		      }
		      else{
		    	  return null;
		      }
	  }
	  
	  //连接服务器，获得服务器返回的流，对流进行处理，获得图片
	  public  static Bitmap httpgetphoto(String path) throws  IOException
	   {
		   HttpClient client = new DefaultHttpClient();
		   HttpGet httpget = new HttpGet(path);
		   @SuppressWarnings("deprecation")
		HttpResponse response = client.execute(httpget);
		   int code;
		   code = response.getStatusLine().getStatusCode();
		   if(code == 200)
		   {
			   InputStream is = response.getEntity().getContent();
			   Bitmap bitmap = BitmapFactory.decodeStream(is);
			   return bitmap;
		   }
		   else
		   {
			   return null;
		   }
		   
	   }
}
