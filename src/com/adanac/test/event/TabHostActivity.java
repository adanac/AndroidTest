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

	private TabSpec ts1, ts2, ts3;// ����3����ҳ
	private TabHost tabHost;// ��ҳ�˵�

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		tabHost = this.getTabHost();// ʵ����ҳ�˵�
		// ����LayoutInflater���������ҳ�˵�һ����ʾ
		LayoutInflater.from(this).inflate(R.layout.layout_tabhost,
				tabHost.getTabContentView());
		ts1 = tabHost.newTabSpec("Tab1");// ʵ����һ����ҳ
		ts1.setIndicator("����tab1");// ���ñ���
		ts1.setContent(R.id.btn_host);// ���ô˷�ҳ����Դid
		ts2 = tabHost.newTabSpec("Tab2");
		ts2.setIndicator("����tab2",
				getResources().getDrawable(R.drawable.ic_launcher));
		ts2.setContent(R.id.et);
		ts3 = tabHost.newTabSpec("Tab3");
		ts3.setIndicator("����tab3");
		ts3.setContent(R.id.mylayouthost);// ���ô˷�ҳ�Ĳ���id
		// ����ҳ��� ����ҳ��
		tabHost.addTab(ts1);
		tabHost.addTab(ts2);
		tabHost.addTab(ts3);
	}

	public void onTabChanged(String tabId) {
		if (tabId.equalsIgnoreCase("tab1")) {
			Toast.makeText(this, "��ҳ1", Toast.LENGTH_LONG).show();
		}
		if (tabId.equalsIgnoreCase("tab2")) {
			Toast.makeText(this, "��ҳ2", Toast.LENGTH_SHORT).show();
		}
		if (tabId.equalsIgnoreCase("tab3")) {
			Toast.makeText(this, "��ҳ3", Toast.LENGTH_LONG).show();
		}
	}

}
