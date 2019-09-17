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
public class DetailFragment extends Fragment {

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
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_detail, container, false);
		// 2 - Get mTextView from layout (don't forget to create ID in fragment_detail.xml)
		//this.mTextView = view.findViewById(R.id.fragment_detail_txt_view);

		// Telling ButterKnife to bind all views in layout
		ButterKnife.bind(this,view);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		// 5 - Restore last mButtonTag if possible
//		if (savedInstanceState != null) {
//			int buttonTagRestored = savedInstanceState.getInt(KEY_BUTTONTAG, 0);
//			// 6 - Update TextView
//			this.updateTextView(buttonTagRestored);
//		}
		//ICE PICK IMPLEMENTATION
		// Restore all @State annotation variables in Bundle
		Icepick.restoreInstanceState(this, savedInstanceState);
		this.updateTextView(this.mButtonTag);
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		// 4 - Save mButtonTag in Bundle when fragment is destroyed
//		outState.putInt(KEY_BUTTONTAG, mButtonTag);
		// ICE PICK IMPLEMENTATION
		// Save all @State annotation variables in Bundle
		Icepick.saveInstanceState(this, outState);
	}


	//------------
	// UPDATE UI
	//------------
	public void updateTextView(int tag) {
		// 3 - Save tag in ButtonTag variable
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
