package com.bethenhn.nchange;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.bethenhn.nchange.debug.DebugSetting;
import com.bethenhn.nchange.model.EventItem;

public class EventListFragment extends Fragment {
	static final String DEBUG_TAG = "EVENT_FRAGMENT";
	EventListView listView;
	EventListAdapter listAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// final Context context = inflater.getContext();

		if (DebugSetting.IS_DEBUG == true) {
			Log.d(DEBUG_TAG, "on create view started");

		}

		final View view = inflater.inflate(R.layout.fragment_event, container,
				false);
		if (null == view) {
			return null;
		}

		final Context context = view.getContext();

		if (DebugSetting.IS_DEBUG == true) {
			Log.d(DEBUG_TAG, "get context");

		}

		// listView = new EventListView(context);
		listAdapter = new EventListAdapter(context);

		Resources res = this.getResources();

		// test cases
		listAdapter.addItem(new EventItem(res.getDrawable(R.drawable.sewoo),
				"2013.03.02 ~ 2013.04.02", "스타벅스 1+1 이벤트", "으아호로로로로 롤로"));
		listAdapter.addItem(new EventItem(res.getDrawable(R.drawable.sewoo),
				"2013.02.11 ~ 2013.01.03", "바나나맛 우유가 4만원", "세븐일레븐트웰브"));
		//

		if (DebugSetting.IS_DEBUG == true) {
			Log.d(DEBUG_TAG, "items are added.");

		}

		listView = (EventListView) view.findViewById(R.id.eventItemListView);

		listView.setAdapter(listAdapter);
		listView.setOnDataSelectionListener(new OnDataSelectionListener() {

			@Override
			public void onDataSelected(AdapterView parent, View v,
					int position, long id) {
				// TODO Auto-generated method stub
				EventItem currentItem = (EventItem) listAdapter
						.getItem(position);

				Toast.makeText(context.getApplicationContext(),
						currentItem.getEventTitle(), 2000).show();

				
				//listView.setDivider(null);
				listView.setVisibility(View.GONE);
				
				FragmentManager fragmentManager = getFragmentManager();
				FragmentTransaction fragmentTransaction = fragmentManager
						.beginTransaction();

				EventItemFragment fragment = new EventItemFragment();
				fragmentTransaction.replace(R.id.frag_content, fragment);
				fragmentTransaction.commit();
			}

		});

		if (DebugSetting.IS_DEBUG == true) {
			Log.d(DEBUG_TAG, "all settings has be done. ");

		}
		// view.set
		// container.addView(listView);

		return view;

		// return container;

		// return inflater.inflate(R.layout.home, container, false);
	}
}
