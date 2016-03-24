package com.example.uiproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.Inflater;

import com.example.uiassist.myadapter;
import com.loopj.android.http.MySSLSocketFactory;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class messageFragment  extends ListFragment implements OnClickListener, OnItemClickListener{
      
	
	  private ListView    infolistview;
	  private myadapter   adapter = null;
	
	  public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
	}


	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//获得当前的fragment
		View messagefragment = inflater.inflate(R.layout.message_layout,container, false);
		 adapter = new myadapter (getActivity());  
	     setListAdapter(adapter);    
		//myadapter adapter = new myadapter(getActivity());
	    // 	setListAdapter(adapter);
		//infolistview =  (ListView)messagefragment.findViewById(android.R.id.list);
		//chakanliuyan = (TextView)messagefragment.findViewById(R.id.checkinfo);
		//chakanshipin = (TextView)messagefragment.findViewById(R.id.checkvideo);
		//myadapter adapter = new myadapter();
		//myadapter adapter = new myadapter();li
		//SimpleAdapter   listadapter = new SimpleAdapter(getActivity(), listviewinfo, R.layout.pauseinfo,  new String[]{"pitcure","name","introduce","time","liuyan","liuyancheck","video","videocheck"}, new int[]{R.id.xianshiphoto,R.id.name,R.id.content,R.id.time,R.id.showphoto,R.id.checkinfo,R.id.videophoto,R.id.checkvideo});
		//infolistview.setAdapter(listadapter);
		//infolistview.setAdapter(adapter);
		//infolistview.setOnItemClickListener(this);
		//chakanliuyan.setOnClickListener(this);
		//chakanshipin.setOnClickListener(this);
		return  messagefragment;
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.checkinfo:
			
			 break;

		case R.id.checkvideo:
			break;
		}
	}

    //点击listview中的一条显示内容
	

    public static List<HashMap<String,Object>> getdate(){
		
    	List<HashMap<String,Object>>  listviewinfo = new ArrayList<HashMap<String,Object>>();
		for(int i = 0; i < 7;i++){
			HashMap<String , Object> data = new HashMap<String, Object>();
			data.put("pitcure", R.drawable.find);
			data.put("name", "门铃NJ");
		    data.put("introduce", "有人长时间逗留");
			data.put("time", "2015-9-15 10:11:40");
			data.put("liuyan", R.drawable.info);
			data.put("liuyancheck","查看留言");
			data.put("video", R.drawable.video);
			data.put("videocheck", "查看视频");
			listviewinfo.add(data);
		}
    	
    	return listviewinfo;
    	
    }


	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		
	}
	

	
	
	
	
	
	
}
