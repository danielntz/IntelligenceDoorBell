package com.example.uiassist;


import com.example.uiproject.R;
import com.example.uiproject.messageFragment;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class myadapter  extends BaseAdapter implements OnClickListener{
    
	private static final String TAG = null;
	private LayoutInflater inflater = null ;
    private TextView  view1;
    private TextView view2;
    private TextView view3;
    private TextView view4;
    private TextView view5;
	private ImageView  imageview1;
	private ImageView  imageview2;
	private ImageView imageview3;
    
    public myadapter(Context context)
	{    
    	super();
		this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	

	public myadapter() {
		// TODO Auto-generated constructor stub
	}



	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return messageFragment.getdate().size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView == null){
		     convertView = inflater.inflate(R.layout.pauseinfo, null);
	       view4 = (TextView)convertView.findViewById(R.id.checkinfo);
		   view5 = (TextView)convertView.findViewById(R.id.checkvideo);
		   view1 = (TextView)convertView.findViewById(R.id.name);
		   view2 = (TextView)convertView.findViewById(R.id.content);
		   view3 = (TextView)convertView.findViewById(R.id.time);
		    
	   }
		else{
			
		}
		
		view1.setText(messageFragment.getdate().get(position).get("name").toString());
		view2.setText(messageFragment.getdate().get(position).get("introduce").toString());
		view3.setText(messageFragment.getdate().get(position).get("time").toString());
		view4.setText(messageFragment.getdate().get(position).get("liuyancheck").toString());
		view5.setText(messageFragment.getdate().get(position).get("videocheck").toString());
		view4.setOnClickListener(this);
		view5.setOnClickListener(this);
		return  convertView;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.checkinfo:
			 
			Log.i(TAG, "sdfds");
			 break;

		case R.id.checkvideo:
			Log.i(TAG, "yrytry");
			
			break;
		}
	}

}
