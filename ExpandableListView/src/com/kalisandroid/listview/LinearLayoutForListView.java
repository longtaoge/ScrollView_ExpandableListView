package com.kalisandroid.listview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

public class LinearLayoutForListView extends LinearLayout {

	private BaseAdapter adapter;
	private OnClickListener onClickListener = null;

	public LinearLayoutForListView(Context context) {
		super(context);
		// 
	}

	

	    public LinearLayoutForListView(Context context, AttributeSet attrs) {
	        super(context, attrs);
	        // TODO Auto-generated constructor stub

	    }
	
	
	/**
	 * �󶨲���
	 */
	public void bindLinearLayout() {
		int count = adapter.getCount();
		this.removeAllViews();
		for (int i = 0; i < count; i++) {
			View v = adapter.getView(i, null, null);

			v.setOnClickListener(this.onClickListener);
			addView(v, i);
		}
		Log.v("countTAG", "" + count);
	}

	
	 /**
     * 锟斤拷取Adapter
     * 
     * @return adapter
     */
    public BaseAdapter getAdpater() {
        return adapter;
    }

    /**
     * 锟斤拷锟斤拷锟斤拷锟�
     * 
     * @param adpater
     */
    public void setAdapter(BaseAdapter adpater) {
        this.adapter = adpater;
        bindLinearLayout();
    }
    
    public void changeAdapter(BaseAdapter adpater){
    	removeAllViewsInLayout();
        this.adapter = adpater;
        bindLinearLayout();
    }

    /**
     * 鐩戝惉
     * 
     * @return
     */
    public OnClickListener getOnclickListner() {
        return onClickListener;
    }

    /**
     * 璁剧疆鐩戝惉
     * 
     * @param onClickListener
     */
    public void setOnclickLinstener(OnClickListener onClickListener) {
    	
        this.onClickListener = onClickListener;
        
    }

	
	
	
}
