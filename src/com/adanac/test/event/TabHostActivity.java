package com.adanac.test.event;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;

import com.adanac.test.R;

public class TabHostActivity extends TabActivity implements OnTabChangeListener {

	private TabSpec ts1, ts2, ts3;// 声明3个分页
	private TabHost tabHost;// 分页菜单

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		tabHost = this.getTabHost();// 实例分页菜单
		// 利用LayoutInflater将布局与分页菜单一起显示
		LayoutInflater.from(this).inflate(R.layout.layout_tabhost,
				tabHost.getTabContentView());
		ts1 = tabHost.newTabSpec("Tab1");// 实例化一个分页
		ts1.setIndicator("我是tab1");// 设置标题
		ts1.setContent(R.id.btn_host);// 设置此分页的资源id
		ts2 = tabHost.newTabSpec("Tab2");
		ts2.setIndicator("我是tab2",
				getResources().getDrawable(R.drawable.ic_launcher));
		ts2.setContent(R.id.et);
		ts3 = tabHost.newTabSpec("Tab3");
		ts3.setIndicator("我是tab3");
		ts3.setContent(R.id.mylayouthost);// 设置此分页的布局id
		// 将分页添加 到分页中
		tabHost.addTab(ts1);
		tabHost.addTab(ts2);
		tabHost.addTab(ts3);
	}

	public void onTabChanged(String tabId) {
		if (tabId.equalsIgnoreCase("tab1")) {
			Toast.makeText(this, "分页1", Toast.LENGTH_LONG).show();
		}
		if (tabId.equalsIgnoreCase("tab2")) {
			Toast.makeText(this, "分页2", Toast.LENGTH_SHORT).show();
		}
		if (tabId.equalsIgnoreCase("tab3")) {
			Toast.makeText(this, "分页3", Toast.LENGTH_LONG).show();
		}
	}

}
