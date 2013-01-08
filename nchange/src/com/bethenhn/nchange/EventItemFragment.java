package com.bethenhn.nchange;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class EventItemFragment extends Fragment {
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View eventItemView = inflater.inflate(R.layout.fragment_item, container, false);
		
		return eventItemView;
	}
}
