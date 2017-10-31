package a0x7e1.stravel;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

/**
 * Created by jaewon on 2017. 10. 29..
 */

public class FindDialog extends Activity {
    WebView mWebview = null;
    String search="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.8f;

        getWindow().setAttributes(lpWindow);

        setContentView(R.layout.dialog_find);

        //Intent intent = getIntent();
        //String search = intent.getStringExtra("search");
        search = "SM면세점";

        TitleWebView();
        ContentWebView();
    }

    public void exit(View v) {
        this.finish();
    }

    private void ContentWebView(){
        mWebview = (WebView) findViewById(R.id.content);
        mWebview.setBackgroundColor(0);
        mWebview.setHorizontalScrollBarEnabled(false);
        mWebview.setVerticalScrollBarEnabled(false);

        //mWebview.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);

        mWebview.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);

        //mWebview.getSettings().setBuiltInZoomControls(true);
        //mWebview.getSettings().setSupportZoom(true);

        //mWebview.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
        //mWebview.getSettings().setJavaScriptEnabled(false);

        //mWebview.getSettings().setUseWideViewPort(true);

        //mWebview.loadUrl("https://lunch.jaewon.me/starter-template/");
        mWebview.loadUrl("https://tshlab.com/rss/?search="+search);
        mWebview.setWebViewClient(new WishWebViewClient());
    }

    private void TitleWebView(){
        mWebview = (WebView) findViewById(R.id.title);
        mWebview.setBackgroundColor(0);
        mWebview.setHorizontalScrollBarEnabled(false);
        mWebview.setVerticalScrollBarEnabled(false);

        //mWebview.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);

        mWebview.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);

        //mWebview.getSettings().setBuiltInZoomControls(true);
        //mWebview.getSettings().setSupportZoom(true);

        //mWebview.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
        //mWebview.getSettings().setJavaScriptEnabled(false);

        //mWebview.getSettings().setUseWideViewPort(true);

        //mWebview.loadUrl("https://lunch.jaewon.me/starter-template/");
        mWebview.loadUrl("https://tshlab.com/rss/title/?search="+search);
        mWebview.setWebViewClient(new WishWebViewClient());
    }

    private class WishWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        // destroy the webview
        mWebview.destroy();
        mWebview = null;
    }
}
