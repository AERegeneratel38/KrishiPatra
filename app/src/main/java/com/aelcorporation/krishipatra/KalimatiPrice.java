package com.aelcorporation.krishipatra;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.aelcorporation.krishipatra.forumsection.ForumActivity;

public class KalimatiPrice extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalimati_price);


        WebView webView = (WebView)findViewById( R.id.webview1);
        String KalimatiUrl = "http://kalimatimarket.gov.np/daily-price-information";

        webView.loadUrl(KalimatiUrl);

        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.setScrollbarFadingEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);

        final String js = "javascript:document.getElementById('datepicker').value='02/05/2019';" +"javascript:dlypriceview()" ;

        webView.setWebViewClient(new WebViewClient(){

            @Override
            public void onPageFinished(WebView view, String url) {

                if(Build.VERSION.SDK_INT>=19) {

                    view.evaluateJavascript(js, new ValueCallback<String>() {
                        @Override
                        public void onReceiveValue(String value) {

                        }
                    });


                }



                super.onPageFinished(view, url);


            }
        });




        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fabback);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });


    }


}
