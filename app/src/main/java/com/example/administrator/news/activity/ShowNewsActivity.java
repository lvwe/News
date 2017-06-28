package com.example.administrator.news.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.news.R;

import cn.bmob.v3.BmobUser;

/**
 * Created by Administrator on 2017/5/24 0024.
 */
public class ShowNewsActivity extends Activity {
    public static final String URL_EXTRA = "URL_EXTRA";
    public static final String KEY_EXTRA = "KEY_EXTRA";
    public static final String TITLE_EXTRA = "TITLE_EXTRA";
    private WebView mWebView;
    private EditText mEdtComment;
    private Button mButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_show);

        mWebView = (WebView) findViewById(R.id.id_show_webView);
        mEdtComment = (EditText) findViewById(R.id.id_show_edt);
        mButton = (Button) findViewById(R.id.id_show_btn);


        Intent intent = getIntent();
        String url = intent.getStringExtra(URL_EXTRA);
        if (url !=null && url.length() > 0){
            mWebView.loadUrl(url);

        }
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BmobUser user = BmobUser.getCurrentUser();
                if (user == null){
                    startActivity(new Intent(ShowNewsActivity.this,LoginActivity.class));
                }else {

                }
            }
        });

    }
}
