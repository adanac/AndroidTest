package com.adanac.test.event;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.adanac.test.R;

/**
 * 实现不同Layout的转换功能,setContentview()用法
 * 
 * @author adanac
 * @date 2015-11-22
 * @version 1.0
 */
public class SetContentViewActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.event_setcontentview);

		// 以findViewById()取得Button对象并添加事件onClickLisener
		Button button1 = (Button) findViewById(R.id.bt1);
		button1.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				goToLayout2();

			}
		});

	}

	// 将layout由main.xml切换成mylayout.xml
	public void goToLayout2() {
		// 将layout改成mylayout
		setContentView(R.layout.event_mysetcontentview);
		Button b2 = (Button) findViewById(R.id.bt2);
		b2.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				goToLayout1();
			}
		});
	}

	// 将layout由mylayout.xml切换成main.xml
	public void goToLayout1() {
		setContentView(R.layout.event_setcontentview);
		Button bt1 = (Button) findViewById(R.id.bt1);
		bt1.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				goToLayout2();
			}
		});
	}
}
