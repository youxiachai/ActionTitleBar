package com.youxiachai.actiontitlebar;

import java.util.ArrayList;
import java.util.List;

import android.view.View;

/**
 * 用于模拟actionbar menu
 * @author youxiachai
 * @date   2013-5-25
 */
public class ActionTitleMenu {
	List<View> menuViews = new ArrayList<View>();
	
	ActionTitleBar mActiontitleBar;
	
	
	
	void setActionTitleBar(ActionTitleBar titleBar){
		this.mActiontitleBar = titleBar;
	}
	
	/**add menu view and build
	 * @param menuView
	 */
	public void addMenuView(View menuView){
		menuViews.add(menuView);
		if(mActiontitleBar != null){
			mActiontitleBar.addActionView(menuView);
		}
	}
	
	/**
	 * @param pos
	 */
	public void removeMenuView(int pos){
		menuViews.remove(pos);
		mActiontitleBar.getActionViews().removeViewAt(pos);
	}
	
	/**how many right menu count
	 * @return
	 */
	public int getMenuCount(){
		return menuViews.size();
	}
	
	/**get right index menu 
	 * @param pos
	 * @return
	 */
	public View getMenuIndex(int pos){
		if(menuViews.size() > 0){
			return menuViews.get(pos);
		}else{
			return null;
		}
	}
	
	public void clean(){
		menuViews.clear();
		mActiontitleBar.getActionViews().removeAllViews();
	}
}
