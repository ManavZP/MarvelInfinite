package com.hfad.marvelinfinite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebActivity extends AppCompatActivity {

    private WebView chars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        wireWidgets();
        setOnClickListeners();
        mapMake();

    }

    private void mapMake() {

        WebView view = new WebView(this);
        view.getSettings().setJavaScriptEnabled(true);
        view.loadUrl("file:///android_asset/marvelcharmap/leaflet.html");
        setContentView(view);

    }

    private void setOnClickListeners() {
    }

    private void wireWidgets() {
    }


}
