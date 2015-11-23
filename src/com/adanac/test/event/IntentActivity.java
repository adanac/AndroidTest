package com.adanac.test.event;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * ͨ�õ�ҳ����ת���������֣�
 * 
 * 1��Intent
 * 
 * Intent�ʺ�Activity��Activity֮�����ת�������ؼ�����ֱ�ӷ���ǰһҳ��
 * 
 * ȱ�㣺��Ҫ��Manifestע��Activity
 * 
 * 2��setContentView
 * 
 * �ʺ�ͬһActivity��Ĳ�ͬView֮����ת
 * 
 * �ŵ㣺�����ؼ����᷵�ص�ǰһҳ�棬��Ҫ�Լ���Ӱ�������������ʵ��
 * 
 * @author adanac
 * @date 2015-11-22
 * @version 1.0
 */
public class IntentActivity extends Activity {

	private LinearLayout mainView = null;
	private Button button1 = null;
	private Button button2 = null;

	private LinearLayout layout = null;
	private TextView tv = null;

	/*
	 * ����setContentVeiw()����������void��ϵͳ��û���ṩ��ȡ��ǰView�ĺ��� ���Դ˴����һ�����α�������ָʾ��ǰView��id
	 */
	private int currentViewId;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// tv��ʼ��
		tv = new TextView(this);
		tv.setText("����layout�����tv");
		// layout��ʼ��
		layout = new LinearLayout(this);
		layout.setId(100);// ������Ҫָ��id������Ĭ�ϵ�id���mainViewһ��������-1
		layout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
		layout.addView(tv);
		// button1��ʼ��
		button1 = new Button(this);
		button1.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
		button1.setText("Intent��ʽ��ת");
		button1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				/* �˴���Intent��ʵ��Activity��Activity֮�����ת */
				Intent intent = new Intent();
				intent.setClass(IntentActivity.this, MyIntentActivity.class);
				// Intent intent=new Intent(IntentTest.this,MyActivity.class);
				startActivity(intent);
			}
		});
		// button2��ʼ��
		button2 = new Button(this);
		button2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
		button2.setText("setContentView��ʽ��ת");
		button2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// �˴���setContentView��ʽ��ʵ��ͳһActivity��ͬView��ת
				setCurrentView(layout);
			}
		});
		// mainView��ʼ��
		mainView = new LinearLayout(this);
		mainView.setId(1000);// ָ��id
		mainView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
		mainView.setOrientation(LinearLayout.VERTICAL);
		mainView.addView(button1);
		mainView.addView(button2);
		// ��ʾmainView
		setCurrentView(mainView);
	}

	/*
	 * ������дonKeyDown()������ʵ�ַ��ؼ��ļ��� ���ͨ����ʾ��View��keyListener���м������򷵻ؼ���������
	 * ���Դ˴���ͨ����Activity������дonKeyDown()������ʵ�ּ���
	 * �˴���������ؼ����Ļ�������ʾlayout�󰴷��ؼ���ֱ��ִ���˳�����
	 */
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (currentViewId == layout.getId()) {
				setCurrentView(mainView);
			} else {
				System.exit(0);
			}
			return false;
		}
		return false;
	}

	/* �Զ��庯��setCurrentView() */
	public void setCurrentView(View view) {
		currentViewId = view.getId();
		// �˴���setContentView��ʽ��ʵ��ͳһActivity��ͬView��ת
		setContentView(view);
	}

}
