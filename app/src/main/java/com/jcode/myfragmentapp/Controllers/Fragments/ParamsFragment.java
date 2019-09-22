package com.jcode.myfragmentapp.Controllers.Fragments;


import androidx.fragment.app.Fragment;

import com.jcode.myfragmentapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ParamsFragment extends BaseFragment {


	public ParamsFragment() {
		// Required empty public constructor
	}


	@Override
	protected BaseFragment newInstance() {
		return new ParamsFragment();
	}

	@Override
	protected int getFragmentLayout() {
		return R.layout.fragment_params;
	}

	@Override
	protected void configureDesign() {

	}

	@Override
	protected void updateDesign() {

	}

}
