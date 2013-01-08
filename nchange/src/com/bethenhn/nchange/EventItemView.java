package com.bethenhn.nchange;
import com.bethenhn.nchange.model.EventItem;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

public class EventItemView extends LinearLayout {

	private Drawable eventIcon;
	
	public EventItemView(Context context, EventItem eventItem) {
		super(context);
		// TODO Auto-generated constructor stu
		LayoutInflater inflater = (LayoutInflater)
									context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				
		inflater.inflate(R.layout.eventlistitem, this, true);
		//eventIcon = (ImageView) findViewById(R.id.iconItem);
		
	}

}
