package com.adanac.test.event;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.adanac.test.R;

public class ProgressBarActivity extends Activity implements Runnable {

	private Thread th; // ����һ���߳�
	private ProgressBar pb; // ����һ������������
	private boolean state;// ��ʶ����ֵ��������С��״̬

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_progressbar);
		// ʵ������������
		pb = (ProgressBar) findViewById(R.id.pb4);
		th = new Thread(this);// ʵ�����̶���
		th.start();
	}

	@Override
	public void run() {
		while (true) {
			int current = pb.getProgress();// �õ���ǰ����ֵ
			int currentMax = pb.getMax();// ��������������ֵ
			int secCurrent = pb.getSecondaryProgress();// �ײ㵱ǰ����ֵ
			// ʵ�ֽ���ֵԽ��Խ��Խ��ԽС�Ķ�̬Ч��
			if (state == false) {
				if (current > currentMax) {
					state = true;
				} else {
					// ���ý���ֵ
					pb.setProgress(current + 1);
					// ���õײ����ֵ
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
