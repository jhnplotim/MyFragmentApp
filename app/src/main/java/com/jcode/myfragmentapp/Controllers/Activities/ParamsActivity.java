package com.jcode.myfragmentapp.Controllers.Activities;

import androidx.appcompat.app.ActionBar;

import com.jcode.myfragmentapp.Controllers.Fragments.ParamsFragment;
import com.jcode.myfragmentapp.R;

public class ParamsActivity extends BaseActivity {

	private ParamsFragment mParamsFragment;

	@Override
	protected int getActivityLayout() {
		return R.layout.activity_params;
	}

	@Override
	protected void configureDesign() {

		//Configure and show params fragment
		this.configureAndShowParamsFragment();

	}

	private void configureAndShowParamsFragment() {

	}

	@Override
	public void configureToolbar() {
		super.configureToolbar();
		//Display home up for Detail Activity
		//Check mToolbar is not null before setting up to avoid run time errors.
		if(mToolbar != null){
			//Get a support ActionBar corresponding to this toolbar
			ActionBar ab = getSupportActionBar();
			//Enable the Up Button
			ab.setDisplayHomeAsUpEnabled(true);
		}
	}
}
