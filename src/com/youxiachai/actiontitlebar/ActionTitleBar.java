package com.youxiachai.actiontitlebar;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class ActionTitleBar extends AbsActionTitleBar {
	private ViewGroup mActionView;
	
//	public static HashMap<String, ActionBarCompat> tempActionBar = new HashMap<String, ActionBarCompat>();
	public static String actString = "";
	public static ActionTitleBar mActionbar;
	public static ActionTitleBarOption mActionOption = new ActionTitleBarOption();
	
	public static ActionTitleBar getActionBar(Activity act){
		String tempString = act.toString();
		if(!actString.equals(tempString)){
			Log.d("actionbar", "init" + tempString);
			mActionbar = new ActionTitleBar(act, mActionOption);
			actString =  tempString;
		}else{
			Log.d("actionbar", "reuse" + actString + "currs" + tempString);
		}
		return mActionbar;
	}
	
	public static ActionTitleBar getActionBar(Activity context, ActionTitleBarOption ao){
		//用于复用对象
		String tempString = context.toString();
		if(!actString.equals(tempString)){
			Log.d("actionbar", "init" + tempString);
			mActionOption =ao;
			mActionbar = new ActionTitleBar(context, ao);
			actString =  tempString;
		}else{
			Log.d("actionbar", "reuse" + actString + "currs" + tempString);
		}
		
		return mActionbar;
	}
	ActionTitleBar(Activity context, ActionTitleBarOption ao) {
		super(context, ao);
		init();
	}

	/**
	 * 获得 程序的 最顶层 view
	 * 
	 * @return
	 */
	private ViewGroup getWindowView() {
		return (ViewGroup) mContext.getWindow().getDecorView();
	}

	private ViewGroup getWindowTitleGoup() {
		return (ViewGroup) getWindowView().getChildAt(WINDOWNTOP);
	}

	/**
	 * @return
	 */
	private View getTiteView() {
		return getWindowView().findViewById(android.R.id.title);
	}

	/**
	 * 初始化
	 * 
	 * @param ctx
	 */
	private void init() {
		this.mActionView = (ViewGroup) mContext.getLayoutInflater().inflate(
				R.layout.action_bar_container, null);

		// windowView.removeViews(0, 1);
		// 获得顶层view 的第一级,并且把actionview 设置进去
		// windowView.addView(getView());
		View titleView = getTiteView();
		if (titleView != null) {
			// ((ViewGroup) windowView.getChildAt(0)).removeViewsInLayout(0, 1);
			//移除掉 2.x 的title
			getWindowTitleGoup().removeViewInLayout(
					(View) titleView.getParent());
		}else{
			//移除原来的actionbar view
			View actBarView = getWindowTitleGoup().getChildAt(WINDOWNTOP);
			if(actBarView != null){
				getWindowTitleGoup().removeViewInLayout(actBarView);
			}
		}
		
		
		
		getWindowTitleGoup().addView(getView(), WINDOWNTOP);
		setBarOption();
	}
	
	public void actionBarChange(){
		setBarOption();
	}

	/**
	 * init actionbar view item
	 */
	private void setBarOption() {
		// init actionbar view item
		if (mActionBarOption.itemViews.size() > 0) {
			for (View itemView : mActionBarOption.itemViews) {
				addBarItem(itemView);
			}
		}

		setTitle(mActionBarOption.title);
		setHomeAsUpListener(mActionBarOption.homeAsUp);
	}

	public void addBarItem(View v) {
		getBarItems().addView(v);
	}

	public ViewGroup getBarItems() {
//		return (LinearLayout) getActionbar()
//				.findViewById(R.id.action_bar_items);
		View stub = (View) getActionbarView().findViewById(R.id.action_bar_context);
		if(stub instanceof ViewStub){
			return (ViewGroup) ((ViewStub) stub).inflate();
		}
		
		return  (ViewGroup) stub;
	}

	public View getView() {
		return mActionView;
	}
	
	
	
	private ViewGroup initActionBarNavView(){
		View navView = getActionbarView().findViewById(R.id.action_bar_menu);
		if(navView instanceof ViewStub){
			return (ViewGroup) ((ViewStub) navView).inflate();
		}
		return (ViewGroup) navView;
	}
	
	public ViewGroup getActionBarNavView(){
		
		return (ViewGroup) mNavViewContext.getChildAt(0);
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
		TextView titleView = (TextView) mActionView
				.findViewById(R.id.action_bar_title);
		if (title == null) {
			String iconTitle = (String) mPkgManager
					.getApplicationLabel(mContext.getApplicationInfo());
			titleView.setText(iconTitle);
		} else {
			titleView.setText(title);
		}

	}

	@Override
	public void setDisplayHomeAsUpEnabled(boolean showHomeAsUp) {
		if (showHomeAsUp) {
			mActionView.findViewById(R.id.up).setVisibility(View.VISIBLE);
		} else {
			mActionView.findViewById(R.id.up).setVisibility(View.INVISIBLE);
		}
	}

	public View getHomeAsUp() {
		return (View) mActionView.findViewById(R.id.up).getParent();
	}

	public void setHomeAsUpListener(OnClickListener clickListener) {
		if (clickListener != null) {
			getHomeAsUp().setOnClickListener(clickListener);
			setDisplayHomeAsUpEnabled(true);
		} else {
			setDisplayHomeAsUpEnabled(false);
		}
		// mActionView.findViewById(R.id.action_bar_home_up).setOnClickListener(mHomeAsUpListener);
	}

	@Override
	public void setDisplayShowHomeEnabled(boolean showHome) {
		if (showHome == true) {
			getHomeAsUp().setVisibility(View.VISIBLE);
		} else {
			getHomeAsUp().setVisibility(View.GONE);
		}
	}

	public View getActionbarView() {
		return mActionView;
	}

	public ActionTitleBarOption getActionOption() {
		return mActionBarOption;
	}
	
	
	private ViewGroup mNavViewContext;
	@Override
	public void setNavigationMode(int mode) {
		mNavViewContext = initActionBarNavView();
		if(mode != getNavigationMode()){
			switch (mode) {
			case NAVIGATION_MODE_TABS:
				//TODO 实现tab 的导航模式
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
				//TODO 這個是用logo 的導航
				getActionBarNavView().setVisibility(View.GONE);
				break;
			default:
				break;
			}
			
			this.navigationMode = mode;
		}
	
		
		
	}

	@Override
	public void setDisplayShowTitleEnabled(boolean showTitle) {
		if(showTitle){
			getActionbarView().findViewById(R.id.action_bar_tilte_context).setVisibility(View.VISIBLE);
		}else{
			getActionbarView().findViewById(R.id.action_bar_tilte_context).setVisibility(View.GONE);
		}
	}

	
	 private OnNavigationListener mCallback;
	
	 private final AdapterView.OnItemSelectedListener mNavItemSelectedListener =
	            new AdapterView.OnItemSelectedListener() {
	        public void onItemSelected(AdapterView parent, View view, int position, long id) {
	            if (mCallback != null) {
	                mCallback.onNavigationItemSelected(position, id);
	            }
	        }
	        public void onNothingSelected(AdapterView parent) {
	            // Do nothing
	        }
	    };

	@Override
	public void setListNavigationCallbacks(SpinnerAdapter adapter,
			OnNavigationListener callback) {
		// TODO Auto-generated method stub
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
