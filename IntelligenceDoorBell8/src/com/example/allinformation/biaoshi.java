package com.example.allinformation;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * 是否监听的标志
 * @author jsjxy
 *
 */
public class biaoshi {
                  
	       private static   SlidingMenu    sm;
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
