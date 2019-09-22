package com.jcode.myfragmentapp.Controllers.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.jcode.myfragmentapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import icepick.Icepick;

public abstract class BaseActivity extends AppCompatActivity {



	protected abstract int getActivityLayout();
	protected abstract void configureDesign();

	@BindView(R.id.toolbar)	Toolbar mToolbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		// Get layout identifier from abstract method
		setContentView(this.getActivityLayout());

		ButterKnife.bind(this);


		//All activities that inherit BaseActivity must include toolbar.xml in their layout and will have the toolbar automatically configured through this method.
		this.configureToolbar();

		// Configure Design (Developer will call this method instead of override onCreateView())
		this.configureDesign();
	}

	@Override
	protected void onSaveInstanceState(@NonNull Bundle outState) {
		super.onSaveInstanceState(outState);
		// Handling Bundle save
		Icepick.saveInstanceState(this, outState);
	}

	@Override
	protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		// Handling Bundle Restoration
		Icepick.restoreInstanceState(this, savedInstanceState);
	}

	//This method configures the tool bar for the activity. If the child activity would like to show the Back button in the Action bar, it should override this method and add the implementation
	//for enabling the button up. See Detail & Param Activity. Remember to modify the AndroidManifest.xml accordingly
	public void configureToolbar(){
		//Check it is not null before setting up to avoid run time errors.
		if(mToolbar != null){
			setSupportActionBar(mToolbar);
		}


	}
}
