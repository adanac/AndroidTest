package com.adanac.test.event;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MyIntentActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView tv = new TextView(this);
		tv.setText("����MyIntentActivity���tv");
		setContentView(tv);
	}
}
