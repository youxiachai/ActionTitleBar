package com.youxiachai.actiontitlebar;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.SpinnerAdapter;

/**
 * @author youxiachai
 *
 */
public abstract class AbsActionTitleBar extends ActionBar{
	protected final static int WINDOWNTOP = 0;
	protected Activity mContext;
	protected PackageManager mPkgManager;
	protected ActionTitleBarOption mActionBarOption;
	protected int navigationMode = -1;
	public AbsActionTitleBar(Activity context, ActionTitleBarOption ao) {
		this.mContext = context;
		this.mPkgManager = context.getPackageManager();
		this.mActionBarOption = ao;
	}
	
	

	@Override
	public void setCustomView(View view) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCustomView(View view, LayoutParams layoutParams) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCustomView(int resId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIcon(int resId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIcon(Drawable icon) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLogo(int resId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLogo(Drawable logo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setListNavigationCallbacks(SpinnerAdapter adapter,
			OnNavigationListener callback) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSelectedNavigationItem(int position) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getSelectedNavigationIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNavigationItemCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setTitle(CharSequence title) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTitle(int resId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSubtitle(CharSequence subtitle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSubtitle(int resId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDisplayOptions(int options) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDisplayOptions(int options, int mask) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDisplayUseLogoEnabled(boolean useLogo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDisplayShowHomeEnabled(boolean showHome) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDisplayHomeAsUpEnabled(boolean showHomeAsUp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDisplayShowTitleEnabled(boolean showTitle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDisplayShowCustomEnabled(boolean showCustom) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBackgroundDrawable(Drawable d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public View getCustomView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CharSequence getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CharSequence getSubtitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNavigationMode() {
		return navigationMode;
	}

	@Override
	public void setNavigationMode(int mode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getDisplayOptions() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Tab newTab() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTab(Tab tab) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTab(Tab tab, boolean setSelected) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTab(Tab tab, int position) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTab(Tab tab, int position, boolean setSelected) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTab(Tab tab) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTabAt(int position) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAllTabs() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectTab(Tab tab) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tab getSelectedTab() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tab getTabAt(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTabCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isShowing() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addOnMenuVisibilityListener(OnMenuVisibilityListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeOnMenuVisibilityListener(OnMenuVisibilityListener listener) {
		// TODO Auto-generated method stub
		
	}

}
