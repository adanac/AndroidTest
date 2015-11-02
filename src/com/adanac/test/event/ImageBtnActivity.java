package com.adanac.test.event;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;

import com.adanac.test.R;

public class ImageBtnActivity extends Activity {
	private ImageButton imageButton;

	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.layout_linearlayout);
		// ʵ����
		imageButton = (ImageButton) findViewById(R.id.imageBtn);
		// ΪͼƬ��Ӱ������ ��������
		imageButton.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View view, MotionEvent event) {
				// ����
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					// ���ñ���ͼ
					imageButton.setBackgroundDrawable(getResources()
							.getDrawable(R.drawable.press));
				} else if (event.getAction() == MotionEvent.ACTION_UP) {
					imageButton.setBackgroundDrawable(getResources()
							.getDrawable(R.drawable.nopress));
				}
				return false;
			}
		});
	}
}
