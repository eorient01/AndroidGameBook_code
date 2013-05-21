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
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

public class ExArc1 extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new MyView(this));
	}

	private class MyView extends View {
		public MyView(Context context) {
			super(context);
		}

		
		@Override
		public void onDraw(Canvas canvas) {
			
			Paint paint = new Paint();
			paint.setAntiAlias(true);
			paint.setColor(Color.WHITE);
			
			RectF oval1 = new RectF(20.0f, 20.0f, 60.0f, 60.0f);
			canvas.drawRect(oval1, paint);
			
			paint.setColor(Color.RED);
			canvas.drawArc(oval1, 0, 360, true, paint);
			
			RectF oval2 = new RectF(180.0f, 20.0f, 220.0f, 60.0f);
			canvas.drawArc(oval2, 90, 135, true, paint);

			RectF oval3 = new RectF(260.0f, 20.0f, 300.0f, 60.0f);
			canvas.drawArc(oval3, 90, 135, false, paint);
		}
	}
}
