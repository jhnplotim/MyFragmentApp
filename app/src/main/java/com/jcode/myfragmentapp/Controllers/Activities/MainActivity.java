package com.jcode.myfragmentapp.Controllers.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.jcode.myfragmentapp.Controllers.Fragments.DetailFragment;
import com.jcode.myfragmentapp.Controllers.Fragments.MainFragment;
import com.jcode.myfragmentapp.R;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainFragment.OnButtonClickedListener {

	// 1 - Declare main fragment
	private MainFragment mMainFragment;

	// 1a - Declare detail fragment
	private DetailFragment mDetailFragment;

	@Override
	protected int getActivityLayout() {
		return R.layout.activity_main;
	}

	@Override
	protected void configureDesign() {

		// 2- Configure and show the home fragment
		this.configureAndShowMainFragment();

		//2b - Configure and show the detail fragment
		this.configureAndShowDetailFragment();

	}
	// --------------
	// FRAGMENTS
	// --------------


	private void configureAndShowMainFragment() {
		//we're using the SupportFragmentManager instead of the FragmentManager, in order to support Android versions below 3.0
		// A - Get FragmentManager (Support) and Try to find existing instance of fragment in FrameLayout container
		mMainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_main);

		if (mMainFragment == null) {
			// B - Create new main fragment
			mMainFragment = new MainFragment();
			// C - Add it to FrameLayout container
			getSupportFragmentManager().beginTransaction()
					.add(R.id.frame_layout_main, mMainFragment)
					.commit();

		}
	}

	private void configureAndShowDetailFragment() {

		//we're using the SupportFragmentManager instead of the FragmentManager, in order to support Android versions below 3.0
		// 2A - Get FragmentManager (Support) and Try to find existing instance of fragment in FrameLayout container
		mDetailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_detail);

		//2B - We only add DetailFragment in Tablet mode (If found frame_layout_detail)
		if (mDetailFragment == null && findViewById(R.id.frame_layout_detail) != null) {
			mDetailFragment = new DetailFragment();
			getSupportFragmentManager().beginTransaction()
					.add(R.id.frame_layout_detail, mDetailFragment)
					.commit();
		}

	}

	@Override
	public void onButtonClicked(View view) {
		Log.e(getClass().getSimpleName(),"Button clicked !");
		//startActivity(new Intent(this, DetailActivity.class));

		// 1 - Retrieve button tag
		int buttonTag = Integer.parseInt(view.getTag().toString());

		// 2 - Check if DetailFragment is visible (Tablet)
		if (mDetailFragment != null && mDetailFragment.isVisible()) {
			// 2.1 - TABLET : Update directly TextView
			mDetailFragment.updateTextView(buttonTag);
		} else {
			// 2.2 - SMARTPHONE : Pass tag to the new intent that will show DetailActivity (and so DetailFragment)
			Intent i = new Intent(this, DetailActivity.class);
			i.putExtra(DetailActivity.EXTRA_BUTTON_TAG, buttonTag);
			startActivity(i);
		}
	}

	// --------------
	// MENU
	// --------------
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		//2 - Inflate the menu and add it to the Toolbar
		getMenuInflater().inflate(R.menu.menu_activity_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item) {
		//3 - Handle actions on menu items
		switch (item.getItemId()){
			case R.id.menu_activity_main_settings:
				Toast.makeText(this,"Settings clicked!!!", Toast.LENGTH_SHORT).show();
				//Start ParamsActivity
				Intent paramsActivity = new Intent(this, ParamsActivity.class);
				startActivity(paramsActivity);
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}

	}
}
