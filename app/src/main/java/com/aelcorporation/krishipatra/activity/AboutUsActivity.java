package com.aelcorporation.krishipatra.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.aelcorporation.krishipatra.R;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vabout_us);

        initViews();

    }

    private void initViews() {
        TextView title = findViewById(R.id.title);
        title.setText(R.string.txt_about_us);
        title.setTypeface(HomeActivity.tf_main_medium);
        ImageView btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        WebView webView = findViewById(R.id.webView);
        webView.loadUrl("http://www.mukunda.ml");
    }
}
