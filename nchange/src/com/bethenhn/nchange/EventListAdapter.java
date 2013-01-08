package com.bethenhn.nchange;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.bethenhn.nchange.model.EventItem;

public class EventListAdapter extends BaseAdapter {

	private Context mContext;
	private List<EventItem> eventItems = new ArrayList<EventItem>();
	public EventListAdapter (Context context) {
	
		mContext = context;
	}
	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return eventItems.size();
	}

	@Override
	public EventItem getItem(int index) {
		// TODO Auto-generated method stub
		return eventItems.get(index);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		EventItemView itemView;
		if ( convertView == null ) {
			
			itemView = new EventItemView(mContext);
			
		} else {
			itemView = (EventItemView) convertView;
			
		}
		EventItem item = eventItems.get(position);
		if ( null != item ) {
			
			itemView.setIcon(item.getEventIcon());
			itemView.setDuration(item.getDuration());
			itemView.setEventTitle(item.getEventTitle());
			itemView.setParticipant(item.getEventParticipant());
			
		}

		return itemView;
	}


	public void addItem(EventItem eventItem) {
		// TODO Auto-generated method stub
		eventItems.add(eventItem);
	}

}
