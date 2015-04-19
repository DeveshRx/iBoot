package com.devesh.bootswitch;

import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);

		WebView myWebView = (WebView) findViewById(R.id.webView1);
		WebSettings webSettings = myWebView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		myWebView.setWebViewClient(new WebViewClient());
		myWebView.loadUrl("http://sh.st/aioB0");

		
		
		final Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("su"); // or whatever command.
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void restart(View v) { // Restart Phone
		final Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("su adb reboot");
		}

		catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void bl(View v) { // Bootloader
		final Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("su adb reboot bootloader");
		}

		catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void recovery(View v) { // Recovery
		final Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("su adb reboot recovery");
		}

		catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void about(View v) {
		Intent intent = new Intent(this, About.class);
		startActivity(intent);
	}

	public void exit(View v) {
		finish();

	}

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	// getMenuInflater().inflate(R.menu.main, menu);
	// return true;
	// }

	// @Override
	// public boolean onOptionsItemSelected(MenuItem item) {
	// Handle action bar item clicks here. The action bar will
	// automatically handle clicks on the Home/Up button, so long
	// as you specify a parent activity in AndroidManifest.xml.
	// int id = item.getItemId();
	// if (id == R.id.action_settings) {
	// return true;
	// }
	// return super.onOptionsItemSelected(item);
	// }

}
