package com.test.hakolightnovelclone;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class DetailActivity extends AppCompatActivity {
    Context context;
    WebView webView;
    Bundle extra;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        context = DetailActivity.this;
        webView = findViewById(R.id.webview);
        extra = getIntent().getExtras();
        if (extra != null) {
            String data = extra.getString("title");
            String path = extra.getString("path").replaceAll("[-+.^:,?!]","");
            String url = "file:///android_asset/" + path + "/" + data + ".html";
            webView.loadUrl(url);
            WebSettings webSettings = webView.getSettings();
            webSettings.setBuiltInZoomControls(true);
            webSettings.setDisplayZoomControls(false);

            Objects.requireNonNull(getSupportActionBar()).setTitle(data);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
