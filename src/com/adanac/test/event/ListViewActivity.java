package com.adanac.test.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.adanac.test.R;

public class ListViewActivity extends Activity {
	private SimpleAdapter simpleAdapter;// ��������������
	private ListView listView;// �б���ͼ����
	private List<Map<String, Object>> list;// �б�����

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		list = new ArrayList<Map<String, Object>>();// ʵ�����б�����
		listView = new ListView(this);// ʵ�����б���ͼ
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("item_imageview", R.drawable.ic_launcher);
		map.put("item_bigtv", "bigTv");
		map.put("item_smalltv", "smallTv");
		list.add(map);
		// ʵ��������
		simpleAdapter = new SimpleAdapter(
				this,
				list,
				R.layout.layout_listview,
				new String[] { "item_imageview", "item_bigtv", "item_smalltv" },
				new int[] { R.id.listview, R.id.biglv, R.id.smalllv });
		// ������ӳ�䵽�б���ͼ��
		listView.setAdapter(simpleAdapter);
		// ��ʾ�б���ͼ
		this.setContentView(listView);
	}
}
