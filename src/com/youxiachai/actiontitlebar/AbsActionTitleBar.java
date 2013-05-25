package com.youxiachai.actiontitlebar;

import android.app.Activity;
import android.app.v4.ActionBar;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

import com.youxiachai.utils.AppInfo;

/**  base actionbar default impl
 * 1. app name
 * 2. app logo
 * @author youxiachai
 * @date   2013-5-25
 */
public abstract class AbsActionTitleBar extends ActionBar {
	// app title view pos
	protected final static int WINDOWNTOP = 0;
	protected Activity mContext;
	protected static ActionTitleMenu mTitleMenu = new ActionTitleMenu();;
	protected int navigationMode = -1;
	
	protected OnClickListener onBackListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			((Activity)v.getContext()).onBackPressed();
		}
	};
	
	public  void setHomeUpListener(OnClickListener click){
		findView(mBasicActionView, R.id.action_home_up).setOnClickListener(click);
	}

	// base actionbar view
	protected ViewGroup mBasicActionView;

	public AbsActionTitleBar(Activity context) {
		this.mContext = context;
		build();
	}

	/**
	 * get app top view
	 * 
	 * @return
	 */
	protected ViewGroup getWindowView() {
		return (ViewGroup) mContext.getWindow().getDecorView();
	}

	/**get app title view group
	 * @return
	 */
	protected ViewGroup getAppTitleGroup() {
		return (ViewGroup) getWindowView().getChildAt(WINDOWNTOP);
	}

	/**get app title view
	 * @return
	 */
	protected View getAppTiteView() {
		return getWindowView().findViewById(android.R.id.title);
	}

	/**
	 * create basic actionbar view 
	 */
	protected void build() {
		mBasicActionView = (ViewGroup) mContext.getLayoutInflater()
				.inflate(R.layout.action_bar_container, null);
		// windowView.removeViews(0, 1);
		// 获得顶层view 的第一级,并且把actionview 设置进去
		// windowView.addView(getView());
		View titleView = getAppTiteView();
		if (titleView != null) {
			// ((ViewGroup) windowView.getChildAt(0)).removeViewsInLayout(0, 1);
			// 移除掉 2.x 的title
			getAppTitleGroup().removeViewInLayout(
					(View) titleView.getParent());
		} else {
			// 移除原来的actionbar view
			View actBarView = getAppTitleGroup().getChildAt(WINDOWNTOP);
			if (actBarView != null) {
				getAppTitleGroup().removeViewInLayout(actBarView);
			}
		}
		//add my custom actionbar view
		getAppTitleGroup().addView(getActionView(), WINDOWNTOP);
		// init basic app info
		setIcon(AppInfo.getAppLogo(mContext));
		setTitle(AppInfo.getAppName(mContext));
		
		
	}

	protected View getActionView() {
		return mBasicActionView;
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

	/* change actionbar icon
	 * @see android.app.v4.ActionBar#setIcon(int)
	 */
	@Override
	public void setIcon(int resId) {
		findView(mBasicActionView, R.id.home).setBackgroundResource(resId);
	}
	
	/**find view utils
	 * @param view
	 * @param id
	 * @return
	 */
	protected View findView(View view, int id){
		return view.findViewById(id);
	}
	
	/* 
	 * 
	 */
	@Override
	public void setTitle(int resId) {
		setTitle(mContext.getString(resId));
	}


	@Override
	public void setTitle(CharSequence title) {
		TextView titleView = (TextView) findView(mBasicActionView, R.id.action_bar_title);
		if (title == null) {
			titleView.setText(AppInfo.getAppName(mContext));
		} else {
			titleView.setText(title);
		}

	}

	/* is use change activiy show
	 * @see android.app.v4.ActionBar#setIcon(android.graphics.drawable.Drawable)
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void setIcon(Drawable icon) {
		// setBackground() add api 16 ...
		findView(mBasicActionView, R.id.home).setBackgroundDrawable(icon);
		
	}

	/* app icon
	 * @see android.app.v4.ActionBar#setLogo(int)
	 */
	@Override
	public void setLogo(int resId) {
		findView(mBasicActionView, R.id.home).setBackgroundResource(resId);
	}

	/*  app icon
	 * @see android.app.v4.ActionBar#setLogo(android.graphics.drawable.Drawable)
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void setLogo(Drawable logo) {
		// setBackground() add api 16 ...
		findView(mBasicActionView, R.id.home).setBackgroundDrawable(logo);
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
		if(useLogo){
			setViewVisibility(findView(mBasicActionView, R.id.home), View.VISIBLE);
		}else{
			setViewVisibility(findView(mBasicActionView, R.id.home), View.GONE);
		}
	}

	@Override
	public void setDisplayShowHomeEnabled(boolean showHome) {
		if (showHome == true) {
			setViewVisibility( (View)findView(mBasicActionView, R.id.up).getParent(), View.VISIBLE);
		} else {
			setViewVisibility( (View)findView(mBasicActionView, R.id.up).getParent(), View.GONE);
		}
	}

	@Override
	public void setDisplayHomeAsUpEnabled(boolean showHomeAsUp) {
		if (showHomeAsUp) {
			setViewVisibility( findView(mBasicActionView, R.id.up) ,  View.VISIBLE);
		} else {
			setViewVisibility( findView(mBasicActionView, R.id.up) ,  View.INVISIBLE);
		}
	}

	@Override
	public void setDisplayShowTitleEnabled(boolean showTitle) {
		if (showTitle) {
			setViewVisibility(findView(mBasicActionView, R.id.action_bar_tilte_context), View.VISIBLE);
		} else {
			setViewVisibility(findView(mBasicActionView, R.id.action_bar_tilte_context), View.GONE);
		}
	}

	@Override
	public void setDisplayShowCustomEnabled(boolean showCustom) {
		// TODO Auto-generated method stub

	}

	/* set actionbar background
	 * @see android.app.v4.ActionBar#setBackgroundDrawable(android.graphics.drawable.Drawable)
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void setBackgroundDrawable(Drawable d) {
		mBasicActionView.setBackgroundDrawable(d);
	}

	@Override
	public CharSequence getTitle() {
		TextView titleView = (TextView) findView(mBasicActionView, R.id.action_bar_title);
		return titleView.getText();
	}

	@Override
	public View getCustomView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CharSequence getSubtitle() {
		// TODO Auto-generated method stub
		return null;
	}

	/* 
	 * @see android.app.v4.ActionBar#getNavigationMode()
	 */
	@Override
	public int getNavigationMode() {
		return navigationMode;
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

	/* 获得actionbar 高度
	 * @see android.app.v4.ActionBar#getHeight()
	 */
	@Override
	public int getHeight() {
		return mBasicActionView.getHeight();
	}

	/* 显示actionbar view
	 * @see android.app.v4.ActionBar#show()
	 */
	@Override
	public void show() {
		setViewVisibility(mBasicActionView, View.VISIBLE);
	}
	
	/**设置view 显示与否
	 * @param v
	 * @param mark
	 */
	private void setViewVisibility(View v,int mark){
		v.setVisibility(mark);
	}

	/* 隐藏actionbar view
	 * @see android.app.v4.ActionBar#hide()
	 */
	@Override
	public void hide() {
		setViewVisibility(mBasicActionView, View.GONE);
	}

	@Override
	public boolean isShowing() {
		return mBasicActionView.getVisibility() == View.VISIBLE? true : false;
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
