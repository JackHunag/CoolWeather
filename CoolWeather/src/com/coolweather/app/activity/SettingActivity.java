package com.coolweather.app.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;

import com.coolweather.app.R;
public class SettingActivity extends Activity implements OnClickListener {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_setting);

		ImageButton ibnBack = (ImageButton) findViewById(R.id.ibn_back);

		ibnBack.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.ibn_back:

			
			SettingActivity.this.finish();
			break;

		default:
			break;
		}

	}
}
