package com.bethenhn.nchange.model;

import android.graphics.drawable.Drawable;

public class EventItem {
	
		private Drawable eventIcon;
		private String duration;
		private String eventTitle;
		private String eventParticipant;
		
		public EventItem() {}
		public EventItem(Drawable eventIcon, String duration, String eventTitle, String eventParticipant ) {
			
			this.setEventIcon(eventIcon);
			this.setDuration(duration);
			this.setEventTitle(eventTitle);
			this.setEventParticipant(eventParticipant);
			
		}
		public Drawable getEventIcon() {
			return eventIcon;
		}
		public void setEventIcon(Drawable eventIcon) {
			this.eventIcon = eventIcon;
		}
		public String getDuration() {
			return duration;
		}
		public void setDuration(String duration) {
			this.duration = duration;
		}
		public String getEventTitle() {
			return eventTitle;
		}
		public void setEventTitle(String eventTitle) {
			this.eventTitle = eventTitle;
		}
		public String getEventParticipant() {
			return eventParticipant;
		}
		public void setEventParticipant(String eventParticipant) {
			this.eventParticipant = eventParticipant;
		}
	
}