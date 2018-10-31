package com.urbanrake.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;

import com.thefinestartist.finestwebview.FinestWebView;


public class HomeActivityFromLink extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.home_layout);
        Intent in = getIntent();
        Uri data = in.getData();
        Log.e("data got",data+"");
        new FinestWebView.Builder(this).theme(R.style.FinestWebViewTheme)
                .titleDefault("Urbanrake")
                .toolbarScrollFlags(0)
                .showSwipeRefreshLayout(false)
                .statusBarColorRes(R.color.colorPrimary)
                .toolbarColorRes(R.color.colorPrimary)
                .titleColorRes(R.color.finestWhite)
                .dividerColorRes(R.color.colorPrimary)
                .showUrl(false)

                .iconDefaultColorRes(R.color.finestWhite)
                .progressBarColorRes(R.color.finestWhite)
                .menuSelector(R.drawable.selector_light_theme)
                .menuTextGravity(Gravity.CENTER_VERTICAL | Gravity.RIGHT)
                .menuTextPaddingRightRes(R.dimen.defaultMenuTextPaddingLeft)
                .dividerHeight(10)
                .progressBarHeight(5)
                .gradientDivider(false)


    //                    .setCustomAnimations(R.anim.slide_up, R.anim.hold, R.anim.hold, R.anim.slide_down)
              //  .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,R.anim.fade_in_medium, R.anim.fade_out_fast)

                       .setCustomAnimations(R.anim.fade_in_fast, R.anim.fade_out_medium, R.anim.modal_activity_close_enter, R.anim.modal_activity_close_exit)
                .disableIconBack(false)
                .showIconForward(false)
                .showIconClose(false)
               /* .disableIconMenu(false)
                .showMenuRefresh(true)*/
                .webViewAppCacheEnabled(true)
                .webViewJavaScriptEnabled(true)
                .webViewSupportZoom(true)
                .webViewBuiltInZoomControls(true)
                .webViewUseWideViewPort(true)
                .webViewAllowFileAccess(true)
                .webViewAllowContentAccess(true)
                .webViewAllowUniversalAccessFromFileURLs(true)
                .webViewDomStorageEnabled(true)
                .webViewLoadWithOverviewMode(true)


                .show(String.valueOf(data));
    finish();
}
}
