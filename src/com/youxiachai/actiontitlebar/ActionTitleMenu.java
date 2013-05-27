package com.youxiachai.actiontitlebar;

import java.util.ArrayList;
import java.util.List;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.v4.ActionMode;

/**
 * 用于模拟actionbar menu
 * @author youxiachai
 * @date   2013-5-25
 */
public class ActionTitleMenu extends ActionMode{
	List<View> menuViews = new ArrayList<View>();
	
	ActionTitleBar mActiontitleBar;
	
	
	
	void setActionTitleBar(ActionTitleBar titleBar){
		this.mActiontitleBar = titleBar;
	}
	
	/**add menu view and build
	 * @param menuView
	 */
	public void addActionView(View menuView){
		menuViews.add(menuView);
		if(mActiontitleBar != null){
			mActiontitleBar.addActionView(menuView);
		}
	}
	
	/**
	 * @param pos
	 */
	public void removeActionView(int pos){
		menuViews.remove(pos);
		mActiontitleBar.getActionViewsContext().removeViewAt(pos);
	}
	
	/**how many right menu count
	 * @return
	 */
	public int getCount(){
		return menuViews.size();
	}
	
	/**get right index menu 
	 * @param pos
	 * @return
	 */
	public View getIndex(int pos){
		if(menuViews.size() > 0){
			return menuViews.get(pos);
		}else{
			return null;
		}
	}
	
	public void clean(){
		menuViews.clear();
		mActiontitleBar.getActionViewsContext().removeAllViews();
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
	public void setCustomView(View view) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void invalidate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finish() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Menu getMenu() {
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
	public View getCustomView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MenuInflater getMenuInflater() {
		// TODO Auto-generated method stub
		return null;
	}
}
