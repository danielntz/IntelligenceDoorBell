package com.example.jsontools;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.allinformation.Audioinfo;
import com.example.allinformation.Person;
import com.example.allinformation.enter;
import com.example.allinformation.forgetinfo;
import com.example.allinformation.getJsonResult;

/**
 * 封装json信息
 * @author lenovo
 *
 */
  
  

public class jsontools {
         //封装注册信息，封装json  
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
	     //封装登陆信息，封装json  
	     public  static  String createjsondenglu(enter    enter1) throws JSONException{
	    	    String     denglu  ;
	    	    JSONObject   jsonobject  = new JSONObject();
	    	    JSONArray   jsonarray = new JSONArray();
	    	    JSONObject    dengluinfo= new JSONObject();
	    	    dengluinfo.put("userName",enter1.getUserName());
	    	    dengluinfo.put("userPass", enter1.getUserPass());
	    	    jsonarray.put(dengluinfo);
	    	    jsonobject.put("Data", jsonarray);
	    	    denglu = jsonobject.toString();
	    	    return denglu;
	    	 
	     }
	     //封装找回密码信息，封装json  
	     public static String   createjsonfind(forgetinfo info) throws JSONException{
	    	      
	    	   String findmima;
	    	   JSONObject  jsonobject =new JSONObject();
	    	   JSONArray  array  = new JSONArray();
	    	   JSONObject   findinfo = new JSONObject();
	    	   findinfo.put("phone", info.getPhone());
	    	   findinfo.put("checkma", info.getCheckma());
	    	   array.put(findinfo);
	    	   jsonobject.put("Data", array);
	    	   findmima = jsonobject.toString();
	    	   return    findmima;
	    }
	     //使用JSON包解析json
	       public  static  getJsonResult  jiexienter(String jsonstring) throws JSONException{
	    	    
	    	            getJsonResult   getreslut = new getJsonResult();
	    	            JSONObject  jsonobject = new JSONObject(jsonstring); //获得已经封装好的一整串字符串
	    	           //返回关键字key所对应的json字符串
	    	            JSONObject   jsonresult = jsonobject.getJSONObject("msg");  //得到关键字所对应的value
	    	            getreslut.setUserNick(jsonresult.getString("userNick"));
	    	            return  getreslut;
	    	    	
	       }
	     
	       //解析json数组
	   	public  static  List<Audioinfo> getListperson(String key,String jsonstring) throws Exception{
	   		          
	   		     List<Audioinfo> list = new ArrayList<Audioinfo>();
	   		     JSONObject jsonobject = new JSONObject(jsonstring);
	   		     //返回关键字key所对应的json数组
	   		     JSONArray jsonarrty = jsonobject.getJSONArray(key);  
	   		     for(int i = 0;i < jsonarrty.length(); i++){
	   		    	 JSONObject   jsonobject2 =  jsonarrty.getJSONObject(i);      //json数组中有多个json对象
	   		    	Audioinfo person1 = new Audioinfo();
	   		    //	 person1.setId(jsonobject2.getInt("id"));
	   		 //   	 person1.setName(jsonobject2.getString("name"));
	   			//	 person1.setAddress(jsonobject2.getString("address"));
	   				 list.add(person1);
	   		     }
	   		return list;
	   	}
	     
	     
	     
	     
	     
	     
	     
}
