package com.kalisandroid.adapter;

import info.androidhive.expandablelistview.R;

import java.util.List;

import android.R.integer;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MyListExpandAdapter extends BaseAdapter implements OnClickListener {
	
	List<String >mList;
	Context mContext;

	Handler mHandler;

	private int count;
	
	
	
	Boolean flag=false;
	public MyListExpandAdapter(List<String> mList, Context mContext ,Handler mHandler) {
		super();
		this.mList = mList;
		this.mContext = mContext;
		this.mHandler=mHandler;
		
		
		count	=mList.size()>2?2:0;
		
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public Object getItem(int position) {
		
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		if (convertView == null) {
		
			
			LayoutInflater infalInflater = (LayoutInflater) mContext
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = infalInflater.inflate(R.layout.list_item_expand, null);
			 
			
		}

		
		
		TextView txtListChild		 = (TextView) convertView
					.findViewById(R.id.textView122);
		txtListChild.setText(mList.get(position));
		ToggleButton toggleButton1	 =(ToggleButton) convertView.findViewById(R.id.toggleButton1);
	
		
		
		
		toggleButton1.setOnClickListener(this);
		
		
		return convertView;
		
		
		
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.toggleButton1:
			
			if (!flag) {
				count=mList.size();
				
				flag=true;
				
			}else {
				count=2;
				flag=false;			}
		
			
			
			
			
			MyListExpandAdapter.this.notifyDataSetChanged();
			
			
			break;

		default:
			break;
		}
		
	}

}
