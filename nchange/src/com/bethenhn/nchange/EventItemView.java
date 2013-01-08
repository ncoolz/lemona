package com.bethenhn.nchange;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bethenhn.nchange.model.EventItem;

public class EventItemView extends LinearLayout {

	private ImageView eventIcon;
	public EventItemView(Context context) {
		super(context);
		LayoutInflater inflater = (LayoutInflater)
				context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		inflater.inflate(R.layout.eventlistitem, this, true);		
		setArrow();
	}
	
	
	private void setArrow() {
		
		// TODO Auto-generated method stub
		ImageView arrowView = (ImageView) findViewById(R.id.iconArrow);
		//Drawable iconArrow = (Drawable) findViewById(R.drawable.arrow_small);
		arrowView.setImageDrawable(this.getResources().getDrawable(R.drawable.arrow_small));
	}


	public EventItemView(Context context, EventItem eventItem) {
		super(context);
		// TODO Auto-generated constructor stu
		LayoutInflater inflater = (LayoutInflater)
									context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				
		inflater.inflate(R.layout.eventlistitem, this, true);
		
		setIcon(eventItem.getEventIcon());
		setDuration(eventItem.getDuration());
		setEventTitle(eventItem.getEventTitle());
		setParticipant(eventItem.getEventParticipant());
		setArrow();
		
		
	}
	
	public void setIcon(Drawable icon) {
		eventIcon = (ImageView) findViewById(R.id.iconItem);
		eventIcon.setImageDrawable(icon);
	
	}
	
	
	public void setDuration(String duration) {
		TextView durationView = (TextView) findViewById(R.id.itemDuration);		
		durationView.setText(duration);		
	}
	
	public void setEventTitle(String eventTitle) {
		TextView eventTitleView = (TextView) findViewById(R.id.itemEventTitle);	
		eventTitleView.setText(eventTitle);
		
	}
	
	public void setParticipant(String eventParticipant) {
		TextView participantView = (TextView) findViewById(R.id.itemParticipant);

		participantView.setText(eventParticipant);
	}

}
