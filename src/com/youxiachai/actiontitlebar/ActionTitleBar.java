package com.youxiachai.actiontitlebar;

import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.v4.ActionMode;

public class ActionTitleBar extends AbsActionTitleBarNav {
	
	public static int acthash ;
	public static ActionTitleBar mActionbar;
	
	public static ActionTitleBar getActionBar(FragmentActivity act){
		return getActionBar(act, null);
	}
	
	public static ActionTitleBar getActionBar(FragmentActivity act, ActionTitleMenu titleMenu){
		//if act is create actionbar not re create
		int nowActCode = act.toString().hashCode();
		if(acthash != nowActCode){
			Log.d("actionbar", "init" + nowActCode);
			if(titleMenu != null){
				mTitleMenu =titleMenu;
			}else{
				mTitleMenu = new ActionTitleMenu();
			}
			mActionbar = new ActionTitleBar(act);
			acthash =  nowActCode;
		}else{
			Log.d("actionbar", "reuse" + acthash + "currs" + nowActCode);
		}
		
		return mActionbar;
	}
	ActionTitleBar(FragmentActivity context) {
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
		getActionViewsContext().addView(v);
	}
	
	/**get right menu context
	 * @return
	 */
	 ViewGroup getActionViewsContext() {
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

	


	/**get right bar views
	 * @return
	 */
	public ActionTitleMenu getActionViews() {
		return mTitleMenu;
	}
	
	/**like normal actionmode
	 * @return
	 */
	public ActionMode getActionMode(){
		return mTitleMenu;
	}
	
	


	


}
