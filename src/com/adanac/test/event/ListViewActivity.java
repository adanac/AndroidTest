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
	private SimpleAdapter simpleAdapter;// 声明适配器对象
	private ListView listView;// 列表视图对象
	private List<Map<String, Object>> list;// 列表容器

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		list = new ArrayList<Map<String, Object>>();// 实例化列表容器
		listView = new ListView(this);// 实例化列表视图
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("item_imageview", R.drawable.ic_launcher);
		map.put("item_bigtv", "bigTv");
		map.put("item_smalltv", "smallTv");
		list.add(map);
		// 实例适配器
		simpleAdapter = new SimpleAdapter(
				this,
				list,
				R.layout.layout_listview,
				new String[] { "item_imageview", "item_bigtv", "item_smalltv" },
				new int[] { R.id.listview, R.id.biglv, R.id.smalllv });
		// 将数据映射到列表视图中
		listView.setAdapter(simpleAdapter);
		// 显示列表视图
		this.setContentView(listView);
	}
}
