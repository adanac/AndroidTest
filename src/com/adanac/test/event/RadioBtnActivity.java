package com.adanac.test.event;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

import com.adanac.test.R;

public class RadioBtnActivity extends Activity implements
		OnCheckedChangeListener {

	private RadioButton rb1, rb2, rb3;
	private RadioGroup rg;

	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.layout_linearlayout);
		rb1 = (RadioButton) findViewById(R.id.rb1);
		rb2 = (RadioButton) findViewById(R.id.rb2);
		rb3 = (RadioButton) findViewById(R.id.rb3);
		rg = (RadioGroup) findViewById(R.id.radGroup);
		// 将单元组绑定监听器
		rg.setOnCheckedChangeListener((android.widget.RadioGroup.OnCheckedChangeListener) this);
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (rg == group) { // 如果 只有一个radioGroup也可以不进行判断
			String rbName = null;
			if (checkedId == rb1.getId()) {
				rbName = rb1.getText().toString();
			} else if (checkedId == rb2.getId()) {
				rbName = rb2.getText().toString();
			} else if (checkedId == rb3.getId()) {
				rbName = rb3.getText().toString();
			}
			Toast.makeText(this, "选择了下标为" + rbName + "的单选按键",
					Toast.LENGTH_SHORT).show();
		}

	}

}
