/* ������վ��http://www.androidbks.com
* �ǽ�iOS���ã�http://www.51work6.com
* �ǽ�iOS�������߿��ã�http://v.51work6.com
* �ǽ�iOS��������΢����http://weibo.com/u/3215753973
* ����΢����http://weibo.com/516inc
* �ٷ�csdn���ͣ�http://blog.csdn.net/tonny_guan
* QQ��1575716557 ���䣺jylong06@163.com
*/ 

package com.work6;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ExMenu2Act extends Activity {
	private TextView mTextView;
	public static final int RED_MENU_ID = Menu.FIRST;
	public static final int GREEN_MENU_ID = Menu.FIRST + 1;
	public static final int BLUE_MENU_ID = Menu.FIRST + 2;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		mTextView = (TextView) findViewById(R.id.textview);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		menu.add(0, RED_MENU_ID, 0, R.string.menu1)
				.setIcon(R.drawable.redimage);
		menu.add(0, GREEN_MENU_ID, 0, R.string.menu2).setIcon(
				R.drawable.yellowimage);
		menu.add(0, BLUE_MENU_ID, 0, R.string.menu3).setIcon(
				R.drawable.blueimage);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case RED_MENU_ID:
			mTextView.setText(R.string.menu1);
			return true;
		case GREEN_MENU_ID:
			mTextView.setText(R.string.menu2);
			return true;
		case BLUE_MENU_ID:
			mTextView.setText(R.string.menu3);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}