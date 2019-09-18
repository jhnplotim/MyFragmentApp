package com.jcode.myfragmentapp.Controllers.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jcode.myfragmentapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import icepick.Icepick;
import icepick.State;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends BaseFragment {

	// 1 - Declare TextView
	// Adding @BindView in order to indicate to ButterKnife to get & serialise it
	@BindView(R.id.fragment_detail_txt_view) TextView mTextView;

	// 1 - Declare a mButtonTag tracking. Using IcePick, remove modifier Private, ....
	@State int mButtonTag;
	// 2 - Create static variable to identify key in Bundle
	private static final String KEY_BUTTONTAG = "com.jcode.myfragmentapp.Controllers.Fragments.DetailFragment.KEY_BUTTONTAG";

	public DetailFragment() {
		// Required empty public constructor
	}


	@Override
	protected BaseFragment newInstance() {
		return new DetailFragment();
	}

	@Override
	protected int getFragmentLayout() {
		return R.layout.fragment_detail;
	}

	@Override
	protected void configureDesign() {

	}

	@Override
	protected void updateDesign() {
		this.updateTextView(this.mButtonTag);
	}

	//------------
	// UPDATE UI
	//------------

	//Update TextView depending on TAG's button
	public void updateTextView(int tag) {
		// Save tag in ButtonTag variable
		this.mButtonTag = tag;

		switch (tag){
			case 10:
				this.mTextView.setText("You're a very good programmer !");
				break;
			case 20:
				this.mTextView.setText("I do believe that Jon Snow is going to die in next season...");
				break;
			case 30:
				this.mTextView.setText("Maybe Game of Thrones next season will get back in 2040 ?");
				break;
			default:
				break;
		}
	}
}
