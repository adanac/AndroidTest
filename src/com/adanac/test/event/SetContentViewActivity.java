package com.adanac.test.event;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.adanac.test.R;

/**
 * ʵ�ֲ�ͬLayout��ת������,setContentview()�÷�
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

		// ��findViewById()ȡ��Button��������¼�onClickLisener
		Button button1 = (Button) findViewById(R.id.bt1);
		button1.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				goToLayout2();

			}
		});

	}

	// ��layout��main.xml�л���mylayout.xml
	public void goToLayout2() {
		// ��layout�ĳ�mylayout
		setContentView(R.layout.event_mysetcontentview);
		Button b2 = (Button) findViewById(R.id.bt2);
		b2.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				goToLayout1();
			}
		});
	}

	// ��layout��mylayout.xml�л���main.xml
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
