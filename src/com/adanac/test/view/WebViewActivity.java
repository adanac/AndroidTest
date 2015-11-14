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
 * WebView点击网页内链接跳转到其他Activity
 * 
 * @author adanac
 * @date 2015-11-14下午11:08:08
 */
public class WebViewActivity extends Activity implements OnClickListener {

	private Button main_button;
	private WebView web_view;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_webview);
		// 初始化数据
		initView();

	}

	private void initView() {
		main_button = (Button) this.findViewById(R.id.main_button);
		web_view = (WebView) this.findViewById(R.id.main_web);

		// 设置监听
		main_button.setOnClickListener(this);

	}

	@Override
	public void onClick(View arg0) {
		web_view.loadUrl("http://www.baidu.com");

		// WebChromeClienty用来处理WebView的Javascript的对话框、
		// 网站图标、网站title、加载进度等,重写里面的方法即可
		web_view.setWebChromeClient(new WebChromeClient());// 此方法此处可不写

		// WebViewClient用来处理WebView各种通知、请求事件等,重写里面的方法即可
		web_view.setWebViewClient(new WebViewClient() {

			// 点击页面中的链接会调用这个方法
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// 跳转到另外的activity
				Intent intent = new Intent(getApplication(),
						RadioBtnActivity.class);
				startActivity(intent);

				Log.i("qing", "shouldOverrideUrlLoading..." + url);
				return super.shouldOverrideUrlLoading(view, url);
			}

		});
	}

}
