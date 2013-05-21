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
import android.os.Bundle;
import android.view.View;

public class ExPointLine extends Activity {
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
			int x = 0, y = 10;
			int height = 100;
			Paint paint = new Paint();
			paint.setColor(Color.RED);
			canvas.drawLine(x, y, x + canvas.getWidth() - 1, y, paint);
			canvas.drawLine(x, y + height - 1, x + canvas.getWidth(), y
					+ height - 1, paint);
			paint.setColor(Color.WHITE);
			canvas.drawPoint(x + 5, y + 5, paint);
		}
	}
}
