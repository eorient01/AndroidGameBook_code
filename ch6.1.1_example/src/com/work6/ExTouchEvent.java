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
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

public class ExTouchEvent extends Activity {

	private static final String TAG = "ExTouchEvent";
	private TextView mAction;
	private TextView mPostion;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		mAction = (TextView) findViewById(R.id.action);
		mPostion = (TextView) findViewById(R.id.postion);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int Action = event.getAction();
		float X = event.getX();
		float Y = event.getY();
		Log.v(TAG, "Action = " + Action);
		Log.v(TAG, "(" + X + "," + Y + ")");
		mAction.setText("Action = " + Action);
		mPostion.setText("Postion = (" + X + "," + Y + ")");
		return true;
	}

}