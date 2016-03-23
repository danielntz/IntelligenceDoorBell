package com.example.loginetc;




import org.apache.http.Header;
import org.json.JSONException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.allinformation.enter;
import com.example.allinformation.getJsonResult;
import com.example.functiontools.registerfunction;
import com.example.jsontools.jsonservice;
import com.example.jsontools.jsontools;
import com.example.uiproject.R;
import com.example.uiproject.mainactivity;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class MainActivity extends Activity  implements OnClickListener{
    
	
	 protected static final String TAG = null;
	private TextView  register;
	 private TextView  findpassword;
	 private Button    enter;
	 private Button zhendong;
	 private   EditText  zhanghao;
	 private  EditText  mima;
	 private    enter    huodeinfo;
	 private  String msg;
	 private  ImageView  view; 
	 private  String  result = new String("v");     //不能为空字符
	 private    boolean   judge   = true;      //判断是有空项还是用户名或密码错误
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		zhanghao =  (EditText)findViewById(R.id.zhanghao);
		mima =(EditText)  findViewById(R.id.mima);
		enter = (Button)findViewById(R.id.enter);
		register = (TextView)findViewById(R.id.register);
		findpassword = (TextView)findViewById(R.id.forgetmima);
//		view  =(ImageView) findViewById(R.id.show);
	//	danrudanchu(view);
	//	zhendong = (Button)findViewById(R.id.zhendong);
	    enter.setOnClickListener(this);
		register.setOnClickListener(this);
	//	zhendong.setOnClickListener(this);
		findpassword.setOnClickListener(this);
		
	}
	
	public   void   danrudanchu (ImageView  view){
		 AlphaAnimation   alpha = new AlphaAnimation(1f, 0.0f);
		  alpha.setDuration(3000);
	         alpha.setFillAfter(true);
	         view.setAnimation(alpha);
	}
	
	 public   void   huoqu() throws JSONException{
		     
	//	  huodeinfo = new enter(zhanghao.getText().toString(), mima.getText().toString());
		  if(TextUtils.isEmpty(zhanghao.getText()) || TextUtils.isEmpty(mima.getText())){
			  
			   judge = false;
			  Toast.makeText(getApplicationContext(), "有空项,请填写完整", 0).show();
			    
		  }
		  else{
			   judge = true;
			  huodeinfo =  jsonservice.getenterinfo(registerfunction.geteditinformation(zhanghao), registerfunction.geteditinformation(mima));
				msg = jsontools.createjsondenglu(huodeinfo);
				 //传输json字符串采用AsyncHttpClient异步框架
				 AsyncHttpClient client1  = new AsyncHttpClient();
		//		 String path1 = "http://192.168.1.111:8080/IntelligenceDoorBellWeb/chuanshu"; 
				 String path1 = "http://219.244.48.159:8080/WeChat/loginSmartDogAction.action";
				 RequestParams params  = new RequestParams();
				 params.add("enter", msg);
				 client1.post(path1, params,  new AsyncHttpResponseHandler(){

					@Override
					public void onSuccess(int statusCode, Header[] headers,
							byte[] responseBody) {
				  String data = new String(responseBody);
				  result =  data;
					Toast.makeText(MainActivity.this, data.substring(data.indexOf(":") + 2 , data.indexOf("}") -1) ,0).show();
				  //  Toast.makeText(getApplicationContext(), content.getUserNick(), 0).show();
					   
				
						
					}
	              //responsBody 是服务器返回的内容
					@Override
					public void onFailure(int statusCode, Header[] headers,
							byte[] responseBody, Throwable error) {
						// TODO Auto-generated method stub
						result = new String(responseBody);
					//	Toast.makeText(MainActivity.this, new String(responseBody), 0).show();
					}
					}) ; 
			
				
		  }
		 	 
	 }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.register:
			 Intent intent0 = new Intent(MainActivity.this,register.class);
			  startActivity(intent0);
			 break;
		case R.id.forgetmima :
			 Intent intent1 = new Intent(MainActivity.this,forget.class);
			 startActivity(intent1);
			 break;
	     	case R.id.enter:
		
			 //向服务器发送数据，采用AsynHttpClient
			 try {
				      huoqu();
				    if(judge){
				        if(result.equals("fail") || result.equals("v") ){
				    	     Toast.makeText(getApplicationContext(), "用户名或密码错误,请重新输入", 0).show();
				    }
				    else{   //用户密码正确，进入程序
					   Intent intent2 = new Intent(MainActivity.this,mainactivity.class);
				    	 startActivity(intent2);
					 	 finish();
				    }
		     }
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		  break;
		
		
		}
	}


}
