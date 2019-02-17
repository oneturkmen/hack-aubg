package com.example.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class WebView extends Activity {
    Button btn;
    EditText editText;
    WebView webview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webview.setWebViewClient(new WebViewClient());
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setDomStorageEnabled(true);
        webview.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
        webview.loadUrl("https://www.google.com");


        openWebPage("https://dry-cliffs-55720.herokuapp.com/");


        btn = (Button) findViewById(R.id.button_1);
        editText = (EditText) findViewById(R.id.edit_text_1);
    }

    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("TextBox", editText.getText().toString());
                startActivityForResult(intent, 1);
            }
        });
    }

}
