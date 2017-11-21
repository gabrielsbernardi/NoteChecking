package furb.br.notechecking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class NoteCheckingWebviewActivity extends AppCompatActivity {

    private WebView noteCheckingWebView;

    @Override
    public void onBackPressed() {
        if (this.noteCheckingWebView.canGoBack()) {
            this.noteCheckingWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_checking_webview);
        this.setViews();
        this.noteCheckingconfiguration();
    }

    private void setViews() {
        this.noteCheckingWebView = (WebView) findViewById(R.id.noteCheckingWebView);
    }

    private void noteCheckingconfiguration() {
        WebSettings settings = this.noteCheckingWebView.getSettings();

        settings.setJavaScriptEnabled(true);
        this.noteCheckingWebView.setFocusable(true);
        this.noteCheckingWebView.setFocusableInTouchMode(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setAppCacheEnabled(true);
        this.noteCheckingWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        this.noteCheckingWebView.loadUrl("http://192.168.0.7:3000/");
        this.noteCheckingWebView.setWebViewClient(new WebViewClient());
    }
}