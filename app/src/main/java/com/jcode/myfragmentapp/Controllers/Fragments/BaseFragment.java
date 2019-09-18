package com.jcode.myfragmentapp.Controllers.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import icepick.Icepick;

/**
 * Created by otimj on 9/17/2019.
 */
public abstract class BaseFragment extends Fragment {

	// Force developer to implement these methods below
	protected abstract BaseFragment newInstance();
	protected abstract int getFragmentLayout();
	protected abstract void configureDesign();
	protected abstract void updateDesign();

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// Get layout identifier from abstract method
		View view = inflater.inflate(getFragmentLayout(),container,false);
		// Binding views
		ButterKnife.bind(this, view);
		// Configure Design (Developer will call this method instead of override onCreateView())
		this.configureDesign();
		return (view);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		// Handling Bundle Restoration
		Icepick.restoreInstanceState(this, savedInstanceState);
		// Update Design (Developer will call this method instead of override onActivityCreated())
		this.updateDesign();
	}

	@Override
	public void onSaveInstanceState(@NonNull Bundle outState) {
		super.onSaveInstanceState(outState);
		// Handling Bundle save
		Icepick.saveInstanceState(this, outState);
	}
}
