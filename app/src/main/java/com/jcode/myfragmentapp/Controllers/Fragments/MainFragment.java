package com.jcode.myfragmentapp.Controllers.Fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jcode.myfragmentapp.R;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends BaseFragment implements View.OnClickListener {

	@BindView(R.id.fragment_main_button_happy) Button mHappyButton;
	@BindView(R.id.fragment_main_button_sad) Button mSadButton;
	@BindView(R.id.fragment_main_button_horrible) Button mHorribleButton;

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
	protected BaseFragment newInstance() {
		return new MainFragment();
	}

	@Override
	protected int getFragmentLayout() {
		return R.layout.fragment_main;
	}

	@Override
	protected void configureDesign() {

		//Set OnClickListener for buttons
		mHappyButton.setOnClickListener(this);
		mHorribleButton.setOnClickListener(this);
		mSadButton.setOnClickListener(this);
	}

	@Override
	protected void updateDesign() {

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
