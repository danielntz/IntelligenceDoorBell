package com.example.functiontools;

import java.io.File;
import java.io.IOException;
import android.annotation.SuppressLint;
import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;
import android.view.SurfaceView;

public class datefragmentfunction {
   
   private static MediaRecorder  recorder;
   private static Boolean   isrecording;
    //开始录视频
   @SuppressLint("NewApi")
public  static  void   startluxiang(SurfaceView  ss) throws IllegalStateException, IOException{
	    
	    File file = new File("/sdcard/aaa.mp4");
	    if(file.exists() && file.length() > 0){
	    	file.delete();
	    }
	    recorder = new MediaRecorder();
	    recorder.setOrientationHint(90);
	   	recorder.reset();
	   	recorder.setAudioSource(MediaRecorder.AudioSource.MIC);   //设置音频录入源
	   	recorder.setVideoSource(MediaRecorder.VideoSource.CAMERA); //设置视频录入源
	   	recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4); //设置录入媒体的输出格式
	   	recorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT); //设置音频的编码格式
	   	recorder.setVideoEncoder(MediaRecorder.VideoEncoder.MPEG_4_SP); //设置视频的编码格式
	   	recorder.setVideoFrameRate(6);                 //设置视频的采样率，每秒5帧
	   	recorder.setOutputFile(file.getAbsolutePath());  //输出视频文件的路径
	   	recorder.setPreviewDisplay(ss.getHolder().getSurface());                  //设置捕获视频图像的预览界面
	   	recorder.prepare();
	   	recorder.start();
	  }
   //停止录视频
   public static void stopluxiang(){
	    recorder.stop();
     	recorder.release();
     	recorder = null;
   }
  // 开始录音
  public  static void startluyin() throws IllegalStateException, IOException 
  {
	  File file = new File("/sdcard/luyin1.amr");
	    if(file.exists() && file.length() > 0){
	    	file.delete();   //保证内存中只有一个此文件
	    }
	     recorder = new MediaRecorder();
	     recorder.setAudioSource(MediaRecorder.AudioSource.MIC); //设置音频录入源
	     recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);  //设置音频输出格式
	     recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);    //设置音频的编码格式
	     recorder.setOutputFile(file.getAbsolutePath());              //设置音频文件输出文件路径
         recorder.setOnErrorListener(new OnErrorListener(){

			@Override
			public void onError(MediaRecorder mr, int what, int extra) {
				// TODO Auto-egenerated method stub
				 //发生错误，停止录制
				recorder.stop();
				recorder.release();
				recorder = null;
				isrecording = false;
				return;
				
		    }
  	 
       });
       //准备，开始
       recorder.prepare();
       recorder.start();
       isrecording = true;
  }
  //停止录音
    public static  void  stopluyin(){
	  //如果正在录音，停止并释放资源
      recorder.stop();
  	  recorder.release();	
  	  recorder = null;
  //	isrecording = false;
   }
    
    
    

}
   
	
	
	
	
	

