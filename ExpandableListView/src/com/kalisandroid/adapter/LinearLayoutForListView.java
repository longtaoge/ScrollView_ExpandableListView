package com.kalisandroid.adapter;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

/**
 * 
 * @author Jordan
 *
 */
public class LinearLayoutForListView extends LinearLayout {

    private BaseAdapter adapter;
    private OnClickListener onClickListener = null;

    
    /**
     *  缁戝畾鏁版嵁
     */
    public void bindLinearLayout() {
    	int count = adapter.getCount();
    	 if(count==-1){
    		 return;
    	 }
        
        for (int i = 0; i < count; i++) {
            View v = adapter.getView(i, null, null);
            v.setOnClickListener(this.onClickListener);
 
            addView(v, i);
        }
        Log.v("countTAG", "" + count);
    }

    public LinearLayoutForListView(Context context) {
        super(context);

    }

    public LinearLayoutForListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub

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
