package com.adanac.test.layout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.adanac.test.R;

public class LayoutActivity extends Activity implements OnClickListener {

	private Button btn;

	@Override
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.layout_tablelayout);

		btn = (Button) findViewById(R.id.tbtn3);
		btn.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		if (btn == view) {
			toastDis(btn.getText() + "±»µã»÷ÁË");
		}
	}

	private void toastDis(String string) {
		Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
	}
}
