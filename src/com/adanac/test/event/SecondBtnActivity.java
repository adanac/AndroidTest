package com.adanac.test.event;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondBtnActivity extends Activity {
	private TextView textView;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		textView = new TextView(this);
		setContentView(textView);
		Intent intent = this.getIntent();
		// get data
		String str = intent.getStringExtra("Main");
		// set value
		textView.setText(str);

	}

}
