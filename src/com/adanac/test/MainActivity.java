package com.adanac.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.adanac.test.event.FirstBtnActivity;

public class MainActivity extends Activity {
	private Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}

	private void init() {
		btn = (Button) findViewById(R.id.v_btn);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				Toast.makeText(MainActivity.this, "»¶Ó­", Toast.LENGTH_SHORT)
						.show();
				startActivity(new Intent(MainActivity.this,
						FirstBtnActivity.class));
			}
		});
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.v("MainActivity", "OnDestroy");
	}

}
