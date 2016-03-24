package com.example.functiontools;

import java.io.File;



import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Environment;
import android.util.Log;
import android.widget.VideoView;

/**
 * 播放服务器的视频文件
 * @author jsjxy
 *
 */
public class FunctionV implements OnPreparedListener {

	       private   int  bofang = 0;   //播放标志
	       private  VideoView   show;
	       
	       public    FunctionV(){
	    	   
	       }
	       
	       public  void start(VideoView showmv ,String path){
			    if(this.bofang == 0){
			    
			    //    /showmv.setVideoPath("/sdcard/Wiz Khalifa-See you again.mp4");
			      showmv.setVideoPath(path); //设置本地资源路径
				  showmv.requestFocus();    //设置焦点
				   this.bofang = 1 ;
			    }
			     showmv.setOnPreparedListener(this);
			     showmv.start();
			     
		  }
			   
		 
		  public   void pause(VideoView showmv){
			
			  if(showmv != null && showmv.isPlaying()){
				showmv.pause();
				this.bofang = 2;
			 }
		  }
		@Override
		public void onPrepared(MediaPlayer mp) {
			// TODO Auto-generated method stub
			  
		}
	
	
	
}
