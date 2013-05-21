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
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class ExViewTouchEvent extends Activity {

	private static final String TAG = "ExViewTouchEvent";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new MyView(this));
	}

	private class MyView extends View {
		public MyView(Context context) {
			super(context);
			setFocusable(true);
			setLongClickable(true);
		}

		@Override
		public void onDraw(Canvas canvas) {

			Paint paint = new Paint();
			Bitmap pic = BitmapFactory.decodeResource(getResources(),
					R.drawable.cat);
			canvas.drawBitmap(pic, 10, 10, paint);
		}

		@Override
		public boolean onTouchEvent(MotionEvent event) {
			Log.v(TAG, "onTouchEvent Action = " + event.getAction());
			return super.onTouchEvent(event);
		}
	}
}