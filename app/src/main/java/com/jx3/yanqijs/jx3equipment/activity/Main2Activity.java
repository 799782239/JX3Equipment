package com.jx3.yanqijs.jx3equipment.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
//import android.webkit.WebChromeClient;
//import android.webkit.WebResourceResponse;
//import android.webkit.WebSettings;
//import android.webkit.WebView;
//import android.webkit.WebViewClient;
import android.widget.TextView;

import com.jx3.yanqijs.jx3equipment.R;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

public class Main2Activity extends BaseActivity {
    private TextView textView;
    private WebView mWebView;
    private static final String TAG = "webMain";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        textView = (TextView) findViewById(R.id.text);
        mWebView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        // webSettings.setPluginsEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setAllowFileAccess(true);
//        webSettings.setBlockNetworkImage(true);
        // 设置触摸获取焦点，解决魅族9手机wap页面点击输入框无法弹出输入法问题
        mWebView.requestFocusFromTouch();
        webSettings.setLoadsImagesAutomatically(false);
        webSettings.setCacheMode(android.webkit.WebSettings.LOAD_NO_CACHE);
        webSettings.setSupportMultipleWindows(true);
//        mWebView.setWebChromeClient(new com.tencent.smtt.sdk.WebChromeClient() {
//
//        });
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
                Log.i(TAG, url);
                return super.shouldInterceptRequest(view, url);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                Log.i(TAG, "start-------------" + url);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Log.i(TAG, "finish----------" + url);
//                mWebView.getSettings().setBlockNetworkImage(false);
                mWebView.getSettings().setLoadsImagesAutomatically(true);
            }
        });
        mWebView.loadUrl("http://touch.m.dangdang.com/auction.php");
//        ObservableData.getInstance().getJdId("J_3133811", "1")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<M>() {
//                    @Override
//                    public void onCompleted() {
//                        Log.i("main", "complete");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(M m) {
//                        textView.setText(m.id);
//                    }
//                });
    }

    @Override
    public int LayoutId() {
        return R.layout.activity_main2;
    }

}
