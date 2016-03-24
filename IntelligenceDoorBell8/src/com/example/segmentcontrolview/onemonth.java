package com.example.segmentcontrolview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.uiproject.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.SimpleAdapter;

public class onemonth  extends Fragment{
	
	 private GridView  gridview;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View onemonthfragment = inflater.inflate(R.layout.onemonth, container, false);
		gridview = (GridView)onemonthfragment.findViewById(R.id.showthing);
		 
		 //Ìí¼ÓGridView 
		 List<HashMap<String, Object>> things = new ArrayList<HashMap<String,Object>>();
		
		for(int i =0 ;i < 7 ; i++){
			
			HashMap<String,Object> basic = new HashMap<String,Object>();
			basic.put("photo", R.drawable.set1);
			basic.put("time", "2014-13-12");
			things.add(basic);
		}
		
		 
		 SimpleAdapter  simple = new SimpleAdapter(getActivity(), things, R.layout.info, new String[]{"photo","time"}, new int[]{R.id.showinfo,R.id.showtime});
		 gridview.setAdapter(simple);
		 
		return onemonthfragment;
	}
         
}
