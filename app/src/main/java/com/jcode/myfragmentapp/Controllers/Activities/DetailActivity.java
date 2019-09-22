package com.jcode.myfragmentapp.Controllers.Activities;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;

import com.jcode.myfragmentapp.Controllers.Fragments.DetailFragment;
import com.jcode.myfragmentapp.R;


public class DetailActivity extends BaseActivity {

	// 1 - Create static variable to identify Intent
	public static final String EXTRA_BUTTON_TAG = "com.jcode.myfragmentapp.Controllers.Activities.DetailActivity.EXTRA_BUTTON_TAG";
	DetailFragment mDetailFragment;

	@Override
	protected int getActivityLayout() {
		return R.layout.activity_detail;
	}

	@Override
	protected void configureDesign() {

		//Configure and show detail fragment
		this.configureAndShowDetailFragment();
	}

	private void configureAndShowDetailFragment() {
		//we're using the SupportFragmentManager instead of the FragmentManager, in order to support Android versions below 3.0
		// A - Get FragmentManager (Support) and Try to find existing instance of fragment in FrameLayout container
		mDetailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_detail);

		//B - If DetailFragment doesn't exist yet, go ahead and create it then add it to the framelayout using a fragment transaction
		if(mDetailFragment == null){
			//C - Create new instance
			mDetailFragment = new DetailFragment();

			//D - Add fragment to frame layout
			getSupportFragmentManager().beginTransaction()
					                   .add(R.id.frame_layout_detail, mDetailFragment)
								       .commit();


		}
	}

	@Override
	public void onResume() {
		super.onResume();
		// 3 - Call update method here because we are sure that DetailFragment is visible
		this.updateDetailFragmentTextViewWithIntentTag();
	}


	// --------------
	// UPDATE UI
	// --------------

	// 2 - Update DetailFragment with tag passed from Intent
	private void updateDetailFragmentTextViewWithIntentTag(){
		// Get button's tag from intent
		int buttonTag = getIntent().getIntExtra(EXTRA_BUTTON_TAG, 0);
		// Update DetailFragment's TextView
		mDetailFragment.updateTextView(buttonTag);
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
