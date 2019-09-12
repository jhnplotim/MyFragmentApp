package com.jcode.myfragmentapp.Controllers.Fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcode.myfragmentapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements View.OnClickListener {


	public MainFragment() {
		// Required empty public constructor
	}

	//2 - Declare callback
	private OnButtonClickedListener mCallback;

	// 1 - Declare our interface that will be implemented by any container activity
	public interface OnButtonClickedListener {
		public void onButtonClicked(View view);
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View result = inflater.inflate(R.layout.fragment_main, container, false);

		//Set OnClickListener for buttons
		result.findViewById(R.id.fragment_main_button_happy).setOnClickListener(this);
		result.findViewById(R.id.fragment_main_button_sad).setOnClickListener(this);
		result.findViewById(R.id.fragment_main_button_horrible).setOnClickListener(this);

		return  result;
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);

		// 4 - Call the method that creating callback after being attached to parent activity
		this.createCallbackToParentActivity();
	}

	// --------------
	// ACTIONS
	// --------------

	@Override
	public void onClick(View view) {
		// 5 - Spread the click to the parent activity
		mCallback.onButtonClicked(view);

	}

	// --------------
	// FRAGMENT SUPPORT
	// --------------

	// 3 - Create callback to parent activity
	private void createCallbackToParentActivity(){
		try {
			//Parent activity will automatically subscribe to callback
			mCallback = (OnButtonClickedListener) getActivity();
		} catch (ClassCastException e) {
			throw new ClassCastException(e.toString()+ " must implement OnButtonClickedListener");
		}
	}
}
