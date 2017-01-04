package com.coolweather.app.activity;

import java.util.Random;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.coolweather.app.util.DrawableUtils;
import com.coolweather.app.view.FlowLayout;


public class HotActivity extends Activity {
	private static String[] data = { "QQ", "视频", "放开那三国", "电子书", "酒店", "单机",
			"小说", "播放器", "机票", "浏览器", "2048", "天天动听", "百度地图", "京东", "斗地主",
			"游戏", "WIFI万能钥匙", "免费游戏", "谷歌地图", "捕鱼达人2", "我的世界", "节奏大师", "锁屏",
			"装机必备", "海淘网", "支付宝钱包", "微信", "美图秀秀", "京东", "斗地主", "游戏",
			"WIFI万能钥匙", "免费游戏", "谷歌地图", "捕鱼达人2", "我的世界", "节奏大师", "锁屏", "装机必备",
			"海淘网", "支付宝钱包", "微信", "美图秀秀", "QQ", "视频", "放开那三国", "电子书", "酒店",
			"单机", "锁屏", "装机必备" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		View view = initView();
		setContentView(view);

	}

	private View initView() {
		FlowLayout flow = new FlowLayout(this);

		flow.setPadding(20, 20, 20, 20);// 设置内边距

		flow.setHorizontalSpacing(6);// 水平间距
		flow.setVerticalSpacing(8);// 竖直间距

		for (int i = 0; i < data.length; i++) {
			final String keyword = data[i];
			TextView view = new TextView(getApplicationContext());
			view.setText(keyword);

			view.setTextColor(Color.WHITE);
			view.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);// 18sp
			view.setPadding(10, 10, 10, 10);
			view.setGravity(Gravity.CENTER);

			// 生成随机颜色
			Random random = new Random();
			int r = 30 + random.nextInt(200);
			int g = 30 + random.nextInt(200);
			int b = 30 + random.nextInt(200);

			int color = 0xffcecece;// 按下后偏白的背景色

			// GradientDrawable bgNormal = DrawableUtils.getGradientDrawable(
			// Color.rgb(r, g, b), UIUtils.dip2px(6));
			// GradientDrawable bgPress = DrawableUtils.getGradientDrawable(
			// color, UIUtils.dip2px(6));
			// StateListDrawable selector = DrawableUtils.getSelector(bgNormal,
			// bgPress);

			StateListDrawable selector = DrawableUtils.getSelector(
					Color.rgb(r, g, b), color, 6);
			view.setBackgroundDrawable(selector);

			flow.addView(view);

			// 只有设置点击事件, 状态选择器才起作用
			view.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Toast.makeText(getApplicationContext(), keyword,
							Toast.LENGTH_SHORT).show();
				}
			});
		}
		return flow;

	}

	/**
	 * 捕获Back按键，根据当前的级别来判断，此时应该返回市列表、省列表、还是直接退出。
	 */
	@Override
	public void onBackPressed() {

		finish();

	}
}
