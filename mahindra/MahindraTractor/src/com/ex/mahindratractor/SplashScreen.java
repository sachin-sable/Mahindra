package com.ex.mahindratractor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);
		findViewById(android.R.id.content).postDelayed(new Runnable() {
			
			@Override
			public void run() {
				Intent intent=new Intent(SplashScreen.this, LoginActivity.class);
				startActivity(intent);
				finish();
			}
		}, 3000);
	}
}
