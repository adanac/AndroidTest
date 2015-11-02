package com.adanac.test.event;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.adanac.test.R;

public class ProgressBarActivity extends Activity implements Runnable {

	private Thread th; // 声明一个线程
	private ProgressBar pb; // 声明一个进度条对象
	private boolean state;// 标识进度值的最大和最小的状态

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_progressbar);
		// 实例进度条对象
		pb = (ProgressBar) findViewById(R.id.pb4);
		th = new Thread(this);// 实例进程对象
		th.start();
	}

	@Override
	public void run() {
		while (true) {
			int current = pb.getProgress();// 得到当前进度值
			int currentMax = pb.getMax();// 进度条的最大进度值
			int secCurrent = pb.getSecondaryProgress();// 底层当前进度值
			// 实现进度值越来越大，越来越小的动态效果
			if (state == false) {
				if (current > currentMax) {
					state = true;
				} else {
					// 设置进度值
					pb.setProgress(current + 1);
					// 设置底层进度值
					pb.setSecondaryProgress(current + 1);
				}
			} else {
				if (current <= 0) {
					state = false;
				} else {
					pb.setProgress(current - 1);
				}
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
