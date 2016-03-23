package com.example.loginetc;



import java.io.IOException;

import org.apache.http.Header;
import org.json.JSONException;

import com.example.allinformation.Person;
import com.example.functiontools.registerfunction;
import com.example.http.httpservice;
import com.example.http.streamtools;
import com.example.jsontools.jsonservice;
import com.example.jsontools.jsontools;
import com.example.uiproject.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.zxing.activity.CaptureActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class register  extends Activity implements OnClickListener{
   
	  private static final String TAG = null;
	private Button switchphoto;
	  private ImageButton fanhuijiemian;
	  private EditText   tel0;
	  private EditText   yanzheng0;
	  private EditText  nickname0;
	  private EditText  password0;
	  private EditText confirmword0;
	  private TextView    ok;
	  private Person    changeperson;   //获得数值的person
	  private String   msg;             //json结构的字符串
	  private  Button   sao ;         //二维码扫描按钮
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register_layout);
		//switchphoto = (Button)findViewById(R.id.switchphoto);
		fanhuijiemian = (ImageButton)findViewById(R.id.fanhui);
       tel0 = (EditText)findViewById(R.id.tel);
		yanzheng0 = (EditText)findViewById(R.id.yanzheng);
		nickname0 = (EditText)findViewById(R.id.nickname);
		password0  = (EditText)findViewById(R.id.newpass);
		confirmword0 = (EditText)findViewById(R.id.confimpass);
		sao =(Button) findViewById(R.id.saoyisao);
        ok = (TextView)findViewById(R.id.ok);
	//	switchphoto.setOnClickListener(this);
		fanhuijiemian.setOnClickListener(this);
		ok.setOnClickListener(this);
		sao.setOnClickListener(this);
		
	}

        

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
	/*	case R.id.switchphoto:
			 switchphoto.setBackgroundResource(R.drawable.yanzhengma);
			 break;*/
		case R.id.saoyisao:
		     	Toast.makeText(getApplicationContext(), "开始扫描", 0).show();
			   Intent  intent = new Intent(getApplicationContext(),CaptureActivity.class);
		     	//	 startActivity(intent);	
		    	startActivityForResult(intent	, 0);
		    	break;  
		case R.id.fanhui :
			 //结束当前的activity
			 finish();
	         break;
		case R.id.ok :
			
			 if(TextUtils.isEmpty(tel0.getText()) || TextUtils.isEmpty(yanzheng0.getText()) ||TextUtils.isEmpty(nickname0.getText())
					  ||TextUtils.isEmpty(password0.getText()) ||TextUtils.isEmpty(confirmword0.getText()))
			 {
				 Toast.makeText(register.this, "有空项，请填写", 0).show();;
				 
			 }
			
			 else{
			// new Thread(new network()).start();
			changeperson= jsonservice.getperson(registerfunction.geteditinformation(tel0), 
				       registerfunction.geteditinformation(yanzheng0),
				       registerfunction.geteditinformation(nickname0), 
				       registerfunction.geteditinformation(password0), 
				       registerfunction.geteditinformation(confirmword0));
		  // Log.i(TAG, changeperson.getDeviceId());
		   
		//构造json字符串
			 try {
				msg = jsontools.createjsonzhuce(changeperson);
				Log.i(TAG, msg);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		
			 //传输json字符串采用AsyncHttpClient异步框架
			 AsyncHttpClient client1  = new AsyncHttpClient();
			 String path1 = "http://219.244.48.159:8080/WeChat/registerSmartDogAction.action";
			 RequestParams params  = new RequestParams();
			 params.add("register", msg);
			 client1.post(path1, params,  new AsyncHttpResponseHandler(){

				@Override
				public void onSuccess(int statusCode, Header[] headers,
						byte[] responseBody) {
					// TODO Auto-generated method stub
					//String returninfo = responseBody.toString();
				//	String  jiequinfo = returninfo.substring(0,3);
					
					Toast.makeText(register.this,new String(responseBody).substring(8, 12) , 0).show();
					
				}
              //responsBody 是服务器返回的内容
				@Override
				public void onFailure(int statusCode, Header[] headers,
						byte[] responseBody, Throwable error) {
					// TODO Auto-generated method stub
					Toast.makeText(register.this, new String(responseBody), 0).show();
				}
				}) ; 
		     break;
		/**
		 * 其它
		 */
		} 
		}
	
		
	}
      
	  @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == RESULT_OK){
			String result = data.getExtras().getString("result");
			yanzheng0.setText(result);
		}
		
	}
	
}
