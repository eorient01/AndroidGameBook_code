/* ������վ��http://www.androidbks.com
* �ǽ�iOS���ã�http://www.51work6.com
* �ǽ�iOS�������߿��ã�http://v.51work6.com
* �ǽ�iOS��������΢����http://weibo.com/u/3215753973
* ����΢����http://weibo.com/516inc
* �ٷ�csdn���ͣ�http://blog.csdn.net/tonny_guan
* QQ��1575716557 ���䣺jylong06@163.com
*/ 

package com.work6.designpattern;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MySurfaceView extends SurfaceView implements
		SurfaceHolder.Callback {

	private SurfaceHolder holder;
	private MySurfaceViewThread mySurfaceViewThread;

	public MySurfaceView(Context context) {
		super(context);
		// ����һ���µ�SurfaceHolder
		holder = getHolder();
		holder.addCallback(this);
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// �����߳�
		mySurfaceViewThread = new MySurfaceViewThread();
		mySurfaceViewThread.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// ͣ���߳�
		if (mySurfaceViewThread != null) {
			mySurfaceViewThread.requestExitAndWait();
			mySurfaceViewThread = null;
		}
	}

	class MySurfaceViewThread extends Thread {

		private boolean done;

		MySurfaceViewThread() {
			super();
			done = false;
		}

		@Override
		public void run() {
			SurfaceHolder surfaceHolder = holder;
			// ����ѭ��ִ���߳�
			while (!done) {
				// ����surface������canvas���ڻ���2Dͼ��
				Canvas canvas = surfaceHolder.lockCanvas();
				synchronized (surfaceHolder) {
					// TODO: Draw on the canvas! ����ͼ��
					Bitmap gbImage = BitmapFactory.decodeResource(
							getResources(), R.drawable.castle_bg);// ����ͼ
					canvas.drawBitmap(gbImage, 0, 0, null);
				}
				// ������������Ⱦ��ǰͼ��
				surfaceHolder.unlockCanvasAndPost(canvas);
				try {
					Thread.sleep(1000 / 60);//60֡��
				} catch (InterruptedException e) {
				}
			}

		}

		public void requestExitAndWait() {
			// ����̲߳��ϲ����̵߳����߳�
			done = true;
			try {
				join();
			} catch (InterruptedException ex) {
			}
		}

	}

}
