package com.bethenhn.nchange;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class EventListView extends ListView {

	private OnDataSelectionListener selectionListener;
	
	public EventListView(Context context) {
		super(context);
		init();
		
	}

	public EventListView(Context context , AttributeSet attrs) {
		super(context, attrs);
		
		init();
		
	}
	
	private void init() {
		// TODO Auto-generated method stub
		setOnItemClickListener(new OnItemClickAdapter());
		
	}

	public void setOnDataSelectionListener(OnDataSelectionListener listener) {
		this.selectionListener = listener;
		
	}

	public OnDataSelectionListener getOnDataSelectionListener() {
		
		return selectionListener;
	}
	
	class OnItemClickAdapter implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView parent, View v, int position,
				long id) {
			// TODO Auto-generated method stub
			if (selectionListener == null) {
				
				return ;
			}
			
			selectionListener.onDataSelected(parent, v, position, id);
			
		}
		
		
	}
}
