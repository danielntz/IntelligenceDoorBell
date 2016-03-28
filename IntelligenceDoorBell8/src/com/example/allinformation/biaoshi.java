package com.example.allinformation;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * 是否监听的标志
 * @author jsjxy
 *
 */
public class biaoshi {
                  
           private   static   String  deviceId;    //设备编号
	       private static   SlidingMenu    sm;
	       private    static    String urlphoto;    //图片的信息
	       
	       
	       public static String getUrlphoto() {
			return urlphoto;
		}
		public static void setUrlphoto(String urlphoto) {
			biaoshi.urlphoto = urlphoto;
		}
		public static String getDeviceId() {
			return deviceId;
		}
		public static void setDeviceId(String deviceId) {
			biaoshi.deviceId = deviceId;
		}
		private  static   int   i;
	    public static  SlidingMenu getSm() {
			return sm;
		}
		public  static void setSm(SlidingMenu sm) {
	          	sm = sm;
		}
		public   static   boolean   flag = true ;
	    
	    public     boolean   getbiaoshi()
	    {
	    	    return  flag ;
	    }
	   public    void  setbiaoshi(boolean   flag){
		     this. flag = flag;
	   }
	public static int getI() {
		return i;
	}
	public static void setI(int i) {
		biaoshi.i = i;
	}
	  
	   
	
}
