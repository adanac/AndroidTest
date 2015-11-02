package com.adanac.test.event;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.adanac.test.R;

public class FirstBtnActivity extends Activity implements OnClickListener {
	private Button btnOpen, btnHidden, btnExit;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_activities);
		btnOpen = (Button) findViewById(R.id.btnOpen);
		btnHidden = (Button) findViewById(R.id.btnHidden);
		btnExit = (Button) findViewById(R.id.btnExit);
		btnOpen.setOnClickListener(this);
		btnHidden.setOnClickListener(this);
		btnExit.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v == btnOpen) {
			Intent intent = new Intent(FirstBtnActivity.this,
					SecondBtnActivity.class);
			intent.putExtra("Main", "我是main发送来的数据");
			this.startActivity(intent);
		} else if (v == btnHidden) {
			this.finish();
		} else if (v == btnExit) {
			System.exit(0);
		}
	}
}
