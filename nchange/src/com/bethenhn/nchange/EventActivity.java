package com.bethenhn.nchange;

import com.bethenhn.nchange.debug.DebugSetting;
import com.bethenhn.nchange.model.EventItem;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

public class EventActivity extends Fragment {
	static final String DEBUG_TAG = "EVENT_FRAGMENT";
	EventListView listView;
	EventListAdapter listAdapter;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		//final Context context = inflater.getContext();
		if ( DebugSetting.IS_DEBUG == true) {
			Log.d(DEBUG_TAG, "on create view started");
			
		}
		
		View view = inflater.inflate(R.layout.event, container,false);
		if ( null == view ) {
			return null;
		}
		
		final Context context = view.getContext();
		
		if ( DebugSetting.IS_DEBUG == true) {
			Log.d(DEBUG_TAG, "get context");
			
		}
		
		listView = new EventListView(context);
		listAdapter = new EventListAdapter(context);
		
		Resources res = this.getResources();
		
		//test cases
		listAdapter.addItem(new EventItem(res.getDrawable(R.drawable.sewoo), "2013.03.02 ~ 2013.04.02", "스타벅스 1+1 이벤트", "으아호로로로로 롤로" ));
		listAdapter.addItem(new EventItem(res.getDrawable(R.drawable.sewoo), "2013.02.11 ~ 2013.01.03", "바나나맛 우유가 4만원", "세븐일레븐트웰브" ));
		//
		
		if ( DebugSetting.IS_DEBUG == true) {
			Log.d(DEBUG_TAG, "items are added.");
			
		}		
		listView.setAdapter(listAdapter);
		listView.setOnDataSelectionListener( new OnDataSelectionListener() {

			@Override
			public void onDataSelected(AdapterView parent, View v,
					int position, long id) {
				// TODO Auto-generated method stub
				EventItem currentItem = (EventItem) listAdapter.getItem(position);
				
				Toast.makeText(context.getApplicationContext(), currentItem.getEventTitle(), 2000).show();
			}
			
			
		});
		
		if ( DebugSetting.IS_DEBUG == true) {
			Log.d(DEBUG_TAG, "all settings has be done. ");
			
		}		
		//view.set
		container.addView(listView);
		return view;
		
		//return container;
		
		//return inflater.inflate(R.layout.home, container, false);
	}
}
