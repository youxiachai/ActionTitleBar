package com.youxiachai.actiontitlebar;

import java.util.ArrayList;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

/**
 * @author youxiachai
 * @date   2013-6-19
 */
public abstract class AbsActionTitleBarNav extends AbsActionTitleBar {
	ViewGroup mNavViewContext;
	
	ArrayList<Tab> tabsList = new ArrayList<Tab>();
	LinearLayout tabsLayout;
	
;
	public AbsActionTitleBarNav(FragmentActivity context) {
		super(context);
	}
	

	/* (non-Javadoc)
	 * @see android.app.v4.ActionBar#newTab()
	 */
	@Override
	public Tab newTab() {
		ActionTabImpl tabImpl = new ActionTabImpl(getActivity());
		return tabImpl;
	}

	/* (non-Javadoc)
	 * @see android.app.v4.ActionBar#addTab(android.app.v4.ActionBar.Tab)
	 */
	@Override
	public void addTab(Tab tab) {
		tabsList.add(tab);
		tabsLayout.addView(tab.getCustomView());
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
		tabsList.remove(tab);
		tabsLayout.removeView(tab.getCustomView());
	}

	@Override
	public void removeTabAt(int position) {
		tabsList.remove(position);
		tabsLayout.removeViewAt(position);
	}

	@Override
	public void removeAllTabs() {
		tabsList.removeAll(tabsList);
		tabsLayout.removeAllViews();
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
		return tabsList.get(index);
	}

	@Override
	public int getTabCount() {
		// TODO Auto-generated method stub
		return tabsList.size();
	}
	
	//TODO -----------list nav
	protected ViewGroup getActionBarNavView(){
		return (ViewGroup) mNavViewContext.getChildAt(0);
	}
	
	/* 
	 * @see android.app.v4.ActionBar#setNavigationMode(int)
	 */
	@Override
	public void setNavigationMode(int mode) {
		mNavViewContext = initActionBarNavView();
		if(mode != getNavigationMode()){
			navigationMode = mode;
			switch (mode) {
			case NAVIGATION_MODE_TABS:
				//TODO impl tab fragment change
				tabsLayout = (LinearLayout) findView(getActionView(), R.id.actiontitle_bar_nav);
				if(tabsLayout == null){
					tabsLayout = (LinearLayout) mNavViewContext;
				}
				
				break;
			case NAVIGATION_MODE_LIST:
				if(mNavViewContext.getChildCount() > 0){
					getActionBarNavView().setVisibility(View.VISIBLE);
				}else{
					Spinner spinner = new Spinner(mContext);
					mNavViewContext.addView(spinner);
				}
				
				break;
			case NAVIGATION_MODE_STANDARD:
				// NAVIGATION up
				setDisplayHomeAsUpEnabled(true);
				//default home up 
				findView(mBasicActionView, R.id.action_home_up).setOnClickListener(onBackListener);
				break;
			default:
				//if not mode set clean home up
				setDisplayHomeAsUpEnabled(false);
				break;
			}
		}
	}
	
	/**
	 * @return
	 */
	private ViewGroup initActionBarNavView(){
		View navView = getActionView().findViewById(R.id.action_bar_nav_list);
		if(navView instanceof ViewStub){
			ViewGroup actionViewContext = (ViewGroup) ((ViewStub) navView).inflate();
			actionViewContext.removeAllViews();
			return actionViewContext;
		}else{
			ViewGroup actionViewContext = (ViewGroup) navView;
			actionViewContext.removeAllViews();
			return actionViewContext;
		}
	}
	
	
	//TODO callback
	 private OnNavigationListener mCallback;
		
	 /**
	 *  actionbar list nav listener
	 */
	private final AdapterView.OnItemSelectedListener mNavItemSelectedListener =
	            new AdapterView.OnItemSelectedListener() {
	        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
	            if (mCallback != null) {
	                mCallback.onNavigationItemSelected(position, id);
	            }
	        }
	        public void onNothingSelected(AdapterView<?> parent) {
	            // Do nothing
	        }
	    };
	    
	

	/* (non-Javadoc)
	 * @see android.app.v4.ActionBar#setListNavigationCallbacks(android.widget.SpinnerAdapter, android.app.v4.ActionBar.OnNavigationListener)
	 */
	@Override
	public void setListNavigationCallbacks(SpinnerAdapter adapter,
			OnNavigationListener callback) {
		ViewGroup navView = getActionBarNavView();
		if(navView instanceof Spinner){
			Spinner spinner = ((Spinner) navView);
			spinner.setAdapter(adapter);
			mCallback = callback;
			spinner.setOnItemSelectedListener(mNavItemSelectedListener);
		}else{
			throw new IllegalArgumentException("please check nav view init");
		}
	}
	
	


}
