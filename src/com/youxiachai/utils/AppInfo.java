package com.youxiachai.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;

/**
 * @author youxiachai
 *
 */
public class AppInfo {
	//程序标签
	public String appLabel;
	//程序图像
	public Drawable appIcon;
	///启动应用程序的Intent ，一般是Action为Main和Category为Lancher的Activity 
	public Intent intent;
	
	//应用程序所对应的包名  
	public String pkgName;
	
	
	public static CharSequence getAppName(Context ctx){
		return ctx.getPackageManager().getApplicationLabel(ctx.getApplicationInfo());
	}
	
	public static Drawable getAppLogo(Context ctx){
		PackageManager pm = ctx.getPackageManager();
		return pm.getApplicationIcon(ctx.getApplicationInfo());
	}
	
	
}
