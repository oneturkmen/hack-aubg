package com.example.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class WebViewer extends Activity {
    Button btn;
    EditText editText;
    WebView webview;

    @Override
    public void onBackPressed() {
        if (webview.canGoBack()) {
            webview.goBack();
            return;
        }

        // Otherwise defer to system default behavior.
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webview = (WebView) findViewById(R.id.webView);
        webview.setWebViewClient(new WebViewClient());
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setDomStorageEnabled(true);
        webview.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
        webview.loadUrl("https://dry-cliffs-55720.herokuapp.com");

        btn = (Button) findViewById(R.id.button_1);
        editText = (EditText) findViewById(R.id.edit_text_1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("TextBox", editText.getText().toString());

//                try {
//                    List<Question> questions = new ArrayList<>();
//                    questions.
//
//                    System.out.println();
//                    for (Question q : questions) {
//                        System.out.println(q);
//                    }
//                    System.out.println();
//                    finish();
//                    System.exit(0);
//
//                    Popup.setQuestions(questions);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }

                startActivityForResult(intent, 1);
            }
        });
    }
}
