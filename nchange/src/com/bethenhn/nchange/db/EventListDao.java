package com.bethenhn.nchange.db;

import java.util.ArrayList;
import java.util.List;

import com.bethenhn.nchange.model.EventItem;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.util.Log;

public class EventListDao {
	private static final String DEBUG_TAG = "EVENTLISTDAO";
	
	public static final int NO_LIMIT = -1;
	private Context context;
	private SqliteDbAdapter adapter;
	public EventListDao(Context context) {
		this.context = context;
		adapter = new SqliteDbAdapter(context);
		
	}
	
	public void open(){ adapter.open();}
	public void close(){ adapter.close(); }
	
	public List<EventItem> getEventList( int index, int limit){
		List<EventItem> listOfItems = new ArrayList<EventItem>();
		
		String query = "SELECT ev.event_no, ev.title, ev.image_id, ev.duration_start, ev.duration_end, ev.participant_no, pa.name, pa.logo_id ";
			   query += "FROM event ev ,participant pa WHERE pa.participant_no = ev.participant_no ORDER BY ev.event_no DESC ";
		
		if ( limit != NO_LIMIT ) {
			query += " LIMIT "+index+", "+ " "+limit;
		}
		
		Log.d(DEBUG_TAG,query);
		Cursor cur = adapter.GetDB().rawQuery(query, null);
		Log.d(DEBUG_TAG,"queried.");
		
		if(cur.moveToFirst()) {
			do {
				
				Log.d(DEBUG_TAG,"cursoring"+cur.getInt(0));
				EventItem item = new EventItem();
				Resources res = context.getResources();
				String eventTitle = cur.getString(1);
				
				int imageId = cur.getInt(2);
				Drawable icon = res.getDrawable(imageId);
				
				String durationStart = cur.getString(3);
				String durationEnd = cur.getString(4);
				
				
				String duration = durationStart+"~"+durationEnd;
				
				
				item.setEventTitle( eventTitle );
				item.setEventIcon(icon);
				item.setDuration(duration);
				
				listOfItems.add(item);
			} while(cur.moveToNext());
			
		}
		return listOfItems;
		
	}
	
}
