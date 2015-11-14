package com.adanac.test.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.adanac.test.R;
import com.adanac.test.event.RadioBtnActivity;

/**
 * WebView�����ҳ��������ת������Activity
 * 
 * @author adanac
 * @date 2015-11-14����11:08:08
 */
public class WebViewActivity extends Activity implements OnClickListener {

	private Button main_button;
	private WebView web_view;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_webview);
		// ��ʼ������
		initView();

	}

	private void initView() {
		main_button = (Button) this.findViewById(R.id.main_button);
		web_view = (WebView) this.findViewById(R.id.main_web);

		// ���ü���
		main_button.setOnClickListener(this);

	}

	@Override
	public void onClick(View arg0) {
		web_view.loadUrl("http://www.baidu.com");

		// WebChromeClienty��������WebView��Javascript�ĶԻ���
		// ��վͼ�ꡢ��վtitle�����ؽ��ȵ�,��д����ķ�������
		web_view.setWebChromeClient(new WebChromeClient());// �˷����˴��ɲ�д

		// WebViewClient��������WebView����֪ͨ�������¼���,��д����ķ�������
		web_view.setWebViewClient(new WebViewClient() {

			// ���ҳ���е����ӻ�����������
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// ��ת�������activity
				Intent intent = new Intent(getApplication(),
						RadioBtnActivity.class);
				startActivity(intent);

				Log.i("qing", "shouldOverrideUrlLoading..." + url);
				return super.shouldOverrideUrlLoading(view, url);
			}

		});
	}

}
