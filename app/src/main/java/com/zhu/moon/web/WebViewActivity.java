package com.zhu.moon.web;

import android.content.Context;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.zhu.moon.R;
import com.zhu.moon.base.BaseActivity;
import butterknife.BindView;

/**
 * webView页面
 * Created by zhuguangjun on 2018/7/10.
 */

public class WebViewActivity extends BaseActivity {

    public static final String URL = "url";

    @BindView(R.id.web)
    WebView mWebView;



    /**
     * H5页面url
     */
    private String mUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUrl = getIntent().getStringExtra(URL);
        initWebViewSettings(this,mWebView.getSettings());
        mWebView.loadUrl(mUrl);
    }

    private void initWebViewSettings(Context context, WebSettings webSetting) {
        webSetting.setJavaScriptEnabled(true);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_web;
    }
}
