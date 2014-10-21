package com.kalisandroid.expandablelistview;

import info.androidhive.expandablelistview.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.kalisandroid.adapter.ExpandableListAdapter;

import com.kalisandroid.adapter.MyListAdapter;
import com.kalisandroid.adapter.MyListExpandAdapter;
import com.kalisandroid.listview.LinearLayoutForListView;

public class MainActivity extends Activity {

	ExpandableListAdapter listAdapter;
	ExpandableListView expListView;
	List<String> listDataHeader;
	HashMap<String, List<String>> listDataChild;
	boolean ischecked;

	// ListView
	MyListAdapter mMyListAdapter;
	List<String> mList = new ArrayList<String>();
	ListView mListView;

	//
	ListView mListViewForScrollView;

	LinearLayoutForListView mLayoutForListView;

	Handler mHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {

			super.handleMessage(msg);

			switch (msg.what) {
			case 1:

			
				break;

			default:
				break;
			}

		}

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// initexpandbleList();

		intData();

		mMyListAdapter = new MyListAdapter(mList, this);

		mListView = (ListView) findViewById(R.id.listView);

		ScrollView scrollView3 = (ScrollView) findViewById(R.id.scrollView3);
		mListViewForScrollView = (ListView) findViewById(R.id.listView2);

		MyListExpandAdapter myListExpandAdapter = new MyListExpandAdapter(
				mList, this, mHandler);

		mLayoutForListView = (LinearLayoutForListView) findViewById(R.id.listView3);

		// mLayoutForListView.setAdapter(mMyListAdapter);

		// mListViewForScrollView.setAdapter(mMyListAdapter);

		mListViewForScrollView.setAdapter(myListExpandAdapter);

		scrollView3.smoothScrollTo(0, 0);
		// mListView.setAdapter(mMyListAdapter);

	 ListView	listView6 =(ListView) findViewById(R.id.listView6);
		
		listView6.setAdapter(myListExpandAdapter);
		// mListView.setSelection(1);

	}

	private void intData() {
		for (int i = 0; i < 5; i++) {

			mList.add("Item" + i);

		}

	}

	private void initexpandbleList() {
		expListView = (ExpandableListView) findViewById(R.id.lvExp);

		prepareListData();

		listAdapter = new ExpandableListAdapter(this, listDataHeader,
				listDataChild);

		// setting list adapter
		expListView.setAdapter(listAdapter);

		expListView.setOnGroupExpandListener(new OnGroupExpandListener() {
			int previousGroup = -1;

			@Override
			public void onGroupExpand(int groupPosition) {
				if (groupPosition != previousGroup)
					expListView.collapseGroup(previousGroup);
				previousGroup = groupPosition;
			}
		});

		/*
		 * // Listview Group click listener
		 * expListView.setOnGroupClickListener(new OnGroupClickListener() {
		 * 
		 * @Override public boolean onGroupClick(ExpandableListView parent, View
		 * v, int groupPosition, long id) { //
		 * Toast.makeText(getApplicationContext(), // "Group Clicked " +
		 * listDataHeader.get(groupPosition), // Toast.LENGTH_SHORT).show();
		 * return false; } });
		 */

		// Listview Group expanded listener
		/*
		 * expListView.setOnGroupExpandListener(new OnGroupExpandListener() {
		 * 
		 * @Override public void onGroupExpand(int groupPosition) {
		 * Toast.makeText(getApplicationContext(),
		 * listDataHeader.get(groupPosition) + " Expanded",
		 * Toast.LENGTH_SHORT).show(); } });
		 */

		// Listview Group collasped listener
		/*
		 * expListView.setOnGroupCollapseListener(new OnGroupCollapseListener()
		 * {
		 * 
		 * @Override public void onGroupCollapse(int groupPosition) {
		 * Toast.makeText(getApplicationContext(),
		 * listDataHeader.get(groupPosition) + " Collapsed",
		 * Toast.LENGTH_SHORT).show();
		 * 
		 * } });
		 */

		// Listview on child click listener
		expListView.setOnChildClickListener(new OnChildClickListener() {
			TextView a;

			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				// TODO Auto-generated method stub

				/*
				 * if(ischecked){ a=(TextView)v.findViewWithTag(v);
				 * a.setTextColor(0xFF000000); }else{ //
				 * a.setTextColor(0xFFFFFFFF); ischecked=true; }
				 */

				Toast.makeText(
						getApplicationContext(),
						listDataHeader.get(groupPosition)
								+ " : "
								+ listDataChild.get(
										listDataHeader.get(groupPosition)).get(
										childPosition), Toast.LENGTH_SHORT)
						.show();
				return false;
			}
		});
	}

	/*
	 * Preparing the list data
	 */
	private void prepareListData() {
		listDataHeader = new ArrayList<String>();
		listDataChild = new HashMap<String, List<String>>();

		// Adding child data
		listDataHeader.add("India");
		listDataHeader.add("Pakistan");
		listDataHeader.add("Srilanka");
		listDataHeader.add("Chinna");

		listDataHeader.add("India");
		listDataHeader.add("Pakistan");
		listDataHeader.add("Srilanka");
		listDataHeader.add("Chinna");

		listDataHeader.add("India");
		listDataHeader.add("Pakistan");
		listDataHeader.add("Srilanka");
		listDataHeader.add("Chinna");

		listDataHeader.add("India");
		listDataHeader.add("Pakistan");
		listDataHeader.add("Srilanka");
		listDataHeader.add("Chinna");

		// Adding child data
		List<String> India = new ArrayList<String>();
		India.add("Chennai");
		India.add("New Delhi");
		India.add("Mumbai");
		India.add("Kolkata");
		India.add("Bangalore");
		India.add("Hyderabad");

		List<String> Pakistan = new ArrayList<String>();
		Pakistan.add("Karachi");
		Pakistan.add("Lahore");
		Pakistan.add("Faisalabad");
		Pakistan.add("Rawalpindi");

		List<String> Srilanka = new ArrayList<String>();
		Srilanka.add("Colombo");
		Srilanka.add("Jaffna");
		Srilanka.add("Kandy");
		Srilanka.add("Negombo");
		Srilanka.add("Talawakele");

		List<String> Chinna = new ArrayList<String>();
		Chinna.add("Beijing");
		Chinna.add("Shanghai");
		Chinna.add("Chongqing");
		Chinna.add("Hong Kong");
		Chinna.add("Guangzhou");

		listDataChild.put(listDataHeader.get(0), India); // Header, Child data
		listDataChild.put(listDataHeader.get(1), Pakistan);
		listDataChild.put(listDataHeader.get(2), Srilanka);
		listDataChild.put(listDataHeader.get(3), Chinna);
	}
}
