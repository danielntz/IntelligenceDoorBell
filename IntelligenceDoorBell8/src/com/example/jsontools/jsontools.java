package com.example.jsontools;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.allinformation.Person;

/**
 * 封装json信息
 * @author lenovo
 *
 */
  
  

public class jsontools {
         //封装注册信息  
	     public static String createjsonzhuce(Person person) throws JSONException{
			
	    	 String fengzhuan;
	    	 JSONObject  jsonobject = new JSONObject();
	    	 JSONArray  jsonarray = new JSONArray();
	    	 JSONObject   fengzhuang = new JSONObject();
	    	 fengzhuang.put("userName", person.getUserName());
	    	 fengzhuang.put("deviceId", person.getDeviceId());
	    	 fengzhuang.put("userNick", person.getUserNick());
	    	 fengzhuang.put("userPass", person.getUserPass());
	    	 jsonarray.put(fengzhuang);
	    	  jsonobject.put("Data", jsonarray);
	    	  fengzhuan = jsonobject.toString();
	    	  return fengzhuan;
		   }
	     //封装登陆信息
	     public  static  String createjsondenglu(){
	    	 
	    	 return null;
	     }
	     //封装找回密码信息
	     public static String   createjsonfind(){
	    	 
	    	 return null;
	     }
}
