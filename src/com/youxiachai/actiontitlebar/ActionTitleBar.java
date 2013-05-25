package com.youxiachai.actiontitlebar;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class ActionTitleBar extends AbsActionTitleBar {
	
	public static int acthash ;
	public static ActionTitleBar mActionbar;
	
	public static ActionTitleBar getActionBar(Activity act){
		return getActionBar(act, null);
	}
	
	public static ActionTitleBar getActionBar(Activity act, ActionTitleMenu ao){
		//if act is create actionbar not re create
		int nowActCode = act.toString().hashCode();
		if(acthash != nowActCode){
			Log.d("actionbar", "init" + nowActCode);
			if(ao != null){
				mTitleMenu =ao;
			}
			mActionbar = new ActionTitleBar(act);
			acthash =  nowActCode;
		}else{
			Log.d("actionbar", "reuse" + acthash + "currs" + nowActCode);
		}
		
		return mActionbar;
	}
	ActionTitleBar(Activity context) {
		super(context);
		mTitleMenu.setActionTitleBar(this);
		buildMenuContent();
	}

	/**
	 * init actionbar view item
	 */
	private void buildMenuContent() {
		// init actionbar view item
		if (mTitleMenu.menuViews.size() > 0) {
			for (View itemView : mTitleMenu.menuViews) {
				addActionView(itemView);
			}
		}
	}

	/**add menu
	 * @param v
	 */
	 void addActionView(View v) {
		getActionViews().addView(v);
	}
	
	/**get right menu
	 * @return
	 */
	 ViewGroup getActionViews() {
		View menuContext = findView(mBasicActionView, R.id.action_bar_context);
		// if first use stub
		if(menuContext instanceof ViewStub){
			ViewGroup actionViewContext = (ViewGroup) ((ViewStub) menuContext).inflate();
			return actionViewContext;
		}else{
			ViewGroup actionViewContext = (ViewGroup) menuContext;
			return actionViewContext;
		}
	}

	
	private ViewGroup initActionBarNavView(){
		View navView = getActionView().findViewById(R.id.action_bar_menu);
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
	
	protected ViewGroup getActionBarNavView(){
		return (ViewGroup) mNavViewContext.getChildAt(0);
	}


	public ActionTitleMenu getActionMenu() {
		return mTitleMenu;
	}
	
	
	private ViewGroup mNavViewContext;
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
	
	 private OnNavigationListener mCallback;
	
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
