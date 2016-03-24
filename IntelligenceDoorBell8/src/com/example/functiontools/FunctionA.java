package com.example.functiontools;

import java.io.IOException;

import android.media.MediaPlayer;

/**
 * 播放服务器的音频文件
 * @author jsjxy
 *
 */
public class FunctionA {
  
	   private     MediaPlayer      player  ;
	
	   public   FunctionA(){
		   
	   }
	
	   public  FunctionA(MediaPlayer   player){
		   this. player = player;
	   }
	   //播放
	   public  void  start(String path) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException{
		        if(this.player == null ){
		        	    this.player = new MediaPlayer();
		        	    this.player.setDataSource(path);
		        	    this.player.prepare();
		        }
		        this.player.start();
		    	   
	   }
	   
	   //暂停
	   public  void   pause(){
		      if(this.player.isPlaying() || this.player != null){     
		    	  this.player.pause();
		      }
		    
		   
	   }
	   
}
