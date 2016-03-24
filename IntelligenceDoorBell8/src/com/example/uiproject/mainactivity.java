package com.example.uiproject;

import com.example.allinformation.biaoshi;
import com.example.loginetc.MainActivity;
import com.example.segmentcontrolview.Onsegmentlistenerclicker;
import com.example.segmentcontrolview.SegmentView;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.SlidingDrawer;
import android.widget.TextView;
import android.widget.Toast;
// android-support-v4 只能有一个，两个不知道编译哪个
public class mainactivity extends  SlidingFragmentActivity    implements OnClickListener, Onsegmentlistenerclicker{
      /*----用于展示动态的fragment*/
	  private dateFragement showdate;
	  private findFragment  showfind;
	  private setupFragment showsetup;
	  private messageFragment showmessage;
	  
	  /*-------用于的界面布局  ---------*/
      private View  datelayout;
      private View  findlayout;
      private View setupolayout;
      private View messagelayout;
	  
      private ImageView  one1;
      private ImageView  two1;
      private ImageView  three1;
      private ImageView  four1;
      private TextView   one;
      private TextView   two;
      private TextView   three;
      private TextView   four;      
      
      private SegmentView  view1 = null;
      private  boolean   flag = true;
      private  int  count = 0 ;
      
      
      private FragmentManager frangementmanager; //用于对fragement处理
      
	  //获得侧滑菜单
      private SlidingMenu sm;
      
	   //进入此界面后，需要每隔几秒钟捕获服务器发来的信息，获得相应信息后
      // 手机震动，弹出选择功能界面
	  
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setBehindContentView(R.layout.cehua);
		setContentView(R.layout.activity_main);
      	frangementmanager =   getSupportFragmentManager() ;
        new  Thread(new zhendong()).start();
      	initcehua();
      	init();
		setTabSelection(0);
		
   
	
		
	}
	public void initcehua(){
		
		sm = getSlidingMenu();  //获取侧滑菜单
		sm.setMode(SlidingMenu.LEFT);  //设置左滑菜单
		//sm.setAboveOffsetRes(R.dimen.shdow_width);   
		sm.setBehindOffsetRes(R.dimen.sliding_menuoffset);     //内容页剩余的宽度
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		biaoshi.setSm(sm);    //保存侧滑菜单
		biaoshi.setI(3);
	//	sm.setShadowWidthRes(R.dimen.shadow_width);
		//设置阴影
	   //	sm.setShadowWidth(R.dimen.shadow_width	);
		
		
		
	}
	public void init(){
		datelayout = findViewById(R.id.date);
		findlayout = findViewById(R.id.find);
		setupolayout = findViewById(R.id.set);
		messagelayout = findViewById(R.id.message);
		one = (TextView)findViewById(R.id.datezi);
		two = (TextView)findViewById(R.id.findzi);
		three = (TextView)findViewById(R.id.setzi);
		four = (TextView)findViewById(R.id.messagezi);
		one1 =(ImageView)findViewById(R.id.datephoto);
		two1 =(ImageView)findViewById(R.id.findphoto);
		three1 = (ImageView)findViewById(R.id.setphoto);
		four1 = (ImageView)findViewById(R.id.messagephoto);
		
		datelayout.setOnClickListener(this);
		findlayout.setOnClickListener(this);
		setupolayout.setOnClickListener(this);
		messagelayout.setOnClickListener(this);
		
	}
	
	
	public void  setTabSelection(int index){
		
	  FragmentTransaction trans = frangementmanager.beginTransaction();
	  clearselection();
	  hideFragements(trans);
	  //显示动态内容
	  switch (index) {
	   case  0:
		   one.setTextColor(Color.GREEN);
		   one1.setImageResource(R.drawable.date1);;
		if(showdate == null){
			showdate = new dateFragement();
			trans.add(R.id.content, showdate);
		}
		else
		{
			trans.show(showdate);
		}
		trans.commit();
		break;
    
	   case 1:
		   two.setTextColor(Color.GREEN);
		   two1.setImageResource(R.drawable.find1);
		   if(showfind == null){
				showfind = new findFragment();
				trans.add(R.id.content, showfind);
			}
			else
			{
				trans.show(showfind);
			}
		   trans.commit();
			break;
	   case  2:
		   three.setTextColor(Color.GREEN);
		   three1.setImageResource(R.drawable.set1);
			if(showsetup == null){
				showsetup = new setupFragment();
				trans.add(R.id.content, showsetup);
			}
			else
			{
				trans.show(showsetup);
			}
			trans.commit();
			break;
	   case 3 :
		   four.setTextColor(Color.GREEN);
		   four1.setImageResource(R.drawable.message);
		   if(showmessage == null){
			   showmessage = new messageFragment();
			   trans.add(R.id.content, showmessage);
		   }
		   else{
			 trans.show(showmessage);
		   }
	       trans.commit();
	       break;
		   
	}
		
		
		
		
		
	}
	//清除掉所有的选中状态
	public void clearselection(){
		one.setTextColor(Color.WHITE);
		two.setTextColor(Color.WHITE);
		three.setTextColor(Color.WHITE);
		four.setTextColor(Color.WHITE);
		one1.setImageResource(R.drawable.date);
		two1.setImageResource(R.drawable.find);
		three1.setImageResource(R.drawable.set);
		four1.setImageResource(R.drawable.message1);
		
	}
	//将所有fragement 置于隐藏状态
	
	public void hideFragements(FragmentTransaction transaction){
		if (showdate != null) {  
            transaction.hide(showdate);  
        }  
        if (showfind != null) {  
            transaction.hide(showfind);  
        }  
        if (showsetup != null) {  
            transaction.hide(showsetup);  
        }  
        if(showmessage != null){
        	transaction.hide(showmessage);  
        }
       
	}
	@Override
	public void onClick(View  v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.date:
			 setTabSelection(0);
			 break;
		case R.id.find:
			 setTabSelection(1);
			 break;
		case R.id.set:
			 setTabSelection(2);
			 break;
		case R.id.message:
			setTabSelection(3);
			break;
	    }
		
	}
	@Override
	public void setOnsegment(View v, int position) {
		// TODO Auto-generated method stub
		  switch (position) {
		case 0:
			Toast.makeText(this, "dsfsdf", 0).show();;
			break;
		case 1: 
			Toast.makeText(this, "sdfsdfdf", 0).show();;
		case 2:
			 Toast.makeText(this, "sdfdfdsfsdf", 0).show();
			 break;
		default:
			break;
		}
	}
	
	public  class    zhendong  implements Runnable  {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			            Vibrator   vibrator = (Vibrator)getSystemService(Service.VIBRATOR_SERVICE);  //获得震动服务
	                 
	                    	//用来监听从服务器发过来的信息数据
	                     //获得对应的数据后，震动且弹出选择功能界面
	                    	//是否获得了相应的提示信息
	                    	if(biaoshi.flag){
	                    	vibrator.vibrate(600);
	                    	Intent intent = new Intent();
	                    	intent.setClass(getApplication(), selectfunction.class);
	                    	startActivity(intent);
	                    	Log.i("TAG", "sdfsdf");
	                        new biaoshi().setbiaoshi(false);  	
	                    	}
	                  try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                }
	                    
	}
	
   
   //监听一下手机上的按键，以防退出程序
 	@Override
 	public boolean onKeyUp(int keyCode, KeyEvent event) {
 		// TODO Auto-generated method stub
 	
 		  if(count == 1 ){
 			  System.exit(0);
 		  }
 		if(event.KEYCODE_BACK  == keyCode){    //如果你点击的是返回键
 			         //提示你在点一下，才退出程序
 			  Toast.makeText(getApplicationContext(), "确定退出吗", 0).show();
 			  count ++ ;
 			  return false;
 			  }
        return super.onKeyUp(keyCode, event);
 	}
	
}
