package com.adanac.test.text;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.adanac.test.MainActivity;
import com.adanac.test.R;

public class LinkActivity extends Activity {
	private TextView txtView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text_link);
		init();
	}

	private void init() {
		txtView = (TextView) findViewById(R.id.txt01);
		txtView.setMovementMethod(LinkMovementMethod.getInstance());
		txtView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				Toast.makeText(LinkActivity.this, "你点击了百度", Toast.LENGTH_SHORT)
						.show();
			}
		});
		txtView = (TextView) findViewById(R.id.txt02);
		txtView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(LinkActivity.this, "跳转到MainActivity",
						Toast.LENGTH_SHORT).show();
				startActivity(new Intent(LinkActivity.this, MainActivity.class));

			}
		});
		txtView = (TextView) findViewById(R.id.txt03);
		txtView.setMovementMethod(LinkMovementMethod.getInstance());
		txtView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(LinkActivity.this, "点击adanac",
						Toast.LENGTH_SHORT).show();

			}
		});
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.v("LinkActivity", "OnDestroy");
	}

}
