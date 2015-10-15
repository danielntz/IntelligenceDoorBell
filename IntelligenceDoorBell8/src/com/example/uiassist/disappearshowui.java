package com.example.uiassist;

import android.view.View;
import android.widget.Button;

public class disappearshowui {
    
	   private  static Button button;
	
	   public static void show(Button button0){
		   
		   button0.setVisibility(View.VISIBLE);
		   
	   }
	   
	   public static void disappear(Button button1){
		   
		   button1.setVisibility(View.INVISIBLE);
	   }
	
}
