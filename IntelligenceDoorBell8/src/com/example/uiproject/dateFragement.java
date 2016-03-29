package com.example.uiproject;

import java.io.IOException;
import java.util.zip.DataFormatException;

import com.example.functiontools.adjustscreen;
import com.example.functiontools.datefragmentfunction;
import com.example.uiassist.disappearshowui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class dateFragement   extends Fragment implements OnClickListener{
     
	    private Button takephoto;
	    private Button luzhivideo;
	    private Button talk;
	    private Button stopvedio;
	    private Button stopsound;
	 //   private SurfaceView surfaceview;
	    private  adjustscreen   videoview;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//获得当前的fragment
		View datefragement = inflater.inflate(R.layout.date_layout, container, false);
		//获得当前fragment中的控件
		luzhivideo = (Button) datefragement.findViewById(R.id.luxiang);
		takephoto = (Button) datefragement.findViewById(R.id.paizhao);
		talk = (Button)datefragement.findViewById(R.id.luyin);
		videoview = (adjustscreen)datefragement.findViewById(R.id.monitor);
		stopvedio = (Button)datefragement.findViewById(R.id.stopvedio);
		stopsound = (Button)datefragement.findViewById(R.id.stopsound);
		takephoto.setOnClickListener(this);
	    luzhivideo.setOnClickListener(this); 
	    talk.setOnClickListener(this);
	    stopvedio.setOnClickListener(this);
	    stopsound.setOnClickListener(this);
		return   datefragement;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		
		case R.id.luxiang:
		     disappearshowui.disappear(luzhivideo);
			 disappearshowui.disappear(takephoto);
			 disappearshowui.disappear(talk);
			 disappearshowui.show(stopvedio);
			 try {
				    
				    datefragmentfunction.startluxiang(videoview);
				    Toast.makeText(getActivity(), "开始录制视频", 0).show();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 break;
		
		
		case R.id.paizhao:
			 
			 break;
		
		
		
		case R.id.luyin:
			 disappearshowui.disappear(luzhivideo);
			 disappearshowui.disappear(takephoto);
			 disappearshowui.disappear(talk);
			 disappearshowui.show(stopsound);
			 try {
				   datefragmentfunction.startluyin();
				   Toast.makeText(getActivity(), "开始录制音频", 0).show();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 break;
			
		case R.id.stopvedio:
			 disappearshowui.show(luzhivideo);
			 disappearshowui.show(takephoto);
			 disappearshowui.show(talk);
			 disappearshowui.disappear(stopvedio);
			 datefragmentfunction.stopluxiang();
			 Toast.makeText(getActivity(), "录像结束，保存录像", 0).show();
			 break;
			 
			 
		case R.id.stopsound:
			 disappearshowui.show(luzhivideo);
			 disappearshowui.show(takephoto);
			 disappearshowui.show(talk);
			 disappearshowui.disappear(stopsound);
			 datefragmentfunction.stopluyin();
			 Toast.makeText(getActivity(), "录音结束,保存录音", 0).show();;
			 break;
		}
	}
  
	  
	
	
}
