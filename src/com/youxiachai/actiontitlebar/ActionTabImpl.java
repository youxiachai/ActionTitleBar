package com.youxiachai.actiontitlebar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.v4.ActionBar.Tab;
import android.app.v4.ActionBar.TabListener;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class ActionTabImpl extends Tab {
	
	View mTabView;
	FragmentActivity mAct;
	LayoutInflater mInflater;
	
	public ActionTabImpl(FragmentActivity act){
		mAct = act;
		mInflater = act.getLayoutInflater();
	}
	
	@Override
	public int getPosition() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Drawable getIcon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CharSequence getText() {
		TextView tvTabText = (TextView) getCustomView().findViewById(R.id.tabText);
		return  tvTabText.getText();
	}

	@Override
	public Tab setIcon(Drawable icon) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tab setIcon(int resId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tab setText(CharSequence text) {
		TextView tvTabText = (TextView) getCustomView().findViewById(R.id.tabText);
		tvTabText.setText(text);
		return this;
	}

	@Override
	public Tab setText(int resId) {
		// TODO Auto-generated method stub
		TextView tvTabText = (TextView) getCustomView().findViewById(R.id.tabText);
		tvTabText.setText(resId);
		return this;
	}

	@Override
	public Tab setCustomView(View view) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tab setCustomView(int layoutResId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public View getCustomView() {
		if(mTabView != null){
			return mTabView;
		}else{
			mTabView = mInflater.inflate(R.layout.actiontitle_bar_tab, null);
			if(mAct.getResources().getBoolean(R.bool.isPhone)){
				LinearLayout.LayoutParams lp = new LayoutParams(0, LayoutParams.WRAP_CONTENT);
				lp.weight = 1;
				mTabView.setLayoutParams(lp);
			}
			
			
			return mTabView;
		}
		
	}

	@Override
	public Tab setTag(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getTag() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tab setTabListener(final TabListener listener) {
		// TODO Auto-generated method stub
		mTabView.setOnClickListener(new OnClickListener() {
			
			@SuppressLint("CommitTransaction")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				listener.onTabSelected(ActionTabImpl.this, mAct.getSupportFragmentManager().beginTransaction());
			}
		});
		return this;
	}

	@Override
	public void select() {
		// TODO Auto-generated method stub

	}

	@Override
	public Tab setContentDescription(int resId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tab setContentDescription(CharSequence contentDesc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CharSequence getContentDescription() {
		// TODO Auto-generated method stub
		return null;
	}

}
