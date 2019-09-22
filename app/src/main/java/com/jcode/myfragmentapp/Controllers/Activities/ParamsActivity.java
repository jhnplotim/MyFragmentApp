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

		//we're using the SupportFragmentManager instead of the FragmentManager, in order to support Android versions below 3.0
		// A - Get FragmentManager (Support) and Try to find existing instance of fragment in FrameLayout container
		mParamsFragment = (ParamsFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_settings);

		//B - If ParamsFragment doesn't exist yet, go ahead and create it then add it to the framelayout using a fragment transaction
		if(mParamsFragment == null){
			//C - Create new instance
			mParamsFragment = new ParamsFragment();

			//D - Add fragment to frame layout
			getSupportFragmentManager().beginTransaction()
					.add(R.id.frame_layout_settings, mParamsFragment)
					.commit();


		}
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
