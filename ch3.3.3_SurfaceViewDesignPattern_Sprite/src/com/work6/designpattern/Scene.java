/* ������վ��http://www.androidbks.com
* �ǽ�iOS���ã�http://www.51work6.com
* �ǽ�iOS�������߿��ã�http://v.51work6.com
* �ǽ�iOS��������΢����http://weibo.com/u/3215753973
* ����΢����http://weibo.com/516inc
* �ٷ�csdn���ͣ�http://blog.csdn.net/tonny_guan
* QQ��1575716557 ���䣺jylong06@163.com
*/ 

package com.work6.designpattern;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Scene extends SurfaceView implements SurfaceHolder.Callback {

	private final static String TAG = "Scene";

	private SurfaceHolder holder;
	private Director mDirector;

	private ArrayList<Spirit> spirits = new ArrayList<Spirit>();

	public Scene(Context context) {
		super(context);
		// ����һ���µ�SurfaceHolder
		holder = getHolder();
		holder.addCallback(this);

		// ����
		Spirit bgSpirit = new Spirit(BitmapFactory.decodeResource(
				getResources(), R.drawable.chengbao));
		bgSpirit.getSpeed().setX(0);
		bgSpirit.getSpeed().setY(0);
		bgSpirit.getCoordinates().setX(0);
		bgSpirit.getCoordinates().setY(0);
		spirits.add(bgSpirit);

		// ������
		Spirit junjichuSpirit = new Spirit(BitmapFactory.decodeResource(
				getResources(), R.drawable.zhongzhengdianimg));
		spirits.add(junjichuSpirit);
		junjichuSpirit.getSpeed().setX(0);
		junjichuSpirit.getSpeed().setY(0);
		junjichuSpirit.getCoordinates().setX(300);
		junjichuSpirit.getCoordinates().setY(30);

		// �˶��ľ���
		Spirit runSpirit = new Spirit(BitmapFactory.decodeResource(
				getResources(), R.drawable.chengzhuimgbtn));
		runSpirit.getSpeed().setX(2);
		junjichuSpirit.getSpeed().setY(0);
		runSpirit.getCoordinates().setX(0);
		runSpirit.getCoordinates().setY(160);
		spirits.add(runSpirit);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {

		if (event.getAction() != MotionEvent.ACTION_DOWN) {
			return false;
		}

		synchronized (holder) {

			float X = event.getX();
			float Y = event.getY();
			// ������
			Spirit junjichuSpirit = spirits.get(1);
			// ����������
			if ((X >= junjichuSpirit.getCoordinates().getX() && X <= (junjichuSpirit
					.getCoordinates().getX() + junjichuSpirit.getImage()
					.getWidth()))
					&& (Y >= junjichuSpirit.getCoordinates().getY() && Y <= (junjichuSpirit
							.getCoordinates().getY() + junjichuSpirit
							.getImage().getHeight()))) {
				Log.v(TAG, "���� ������...");
			}

			// �˶��ľ���
			Spirit runSpirit = spirits.get(2);
			// �����˶��ľ���
			if ((X >= runSpirit.getCoordinates().getX() && X <= (runSpirit
					.getCoordinates().getX() + runSpirit.getImage().getWidth()))
					&& (Y >= runSpirit.getCoordinates().getY() && Y <= (runSpirit
							.getCoordinates().getY() + runSpirit.getImage()
							.getHeight()))) {
				Log.v(TAG, "���� �˶��ľ���...");
			}

			return true;
		}
	}

	@Override
	public void onDraw(Canvas canvas) {

		for (Spirit graphic : spirits) {

			Spirit.Coordinates coord;
			Spirit.Speed speed;

			coord = graphic.getCoordinates();
			speed = graphic.getSpeed();

			// Direction
			if (speed.getXDirection() == Spirit.Speed.X_DIRECTION_RIGHT) {
				coord.setX(coord.getX() + speed.getX());
			} else {
				coord.setX(coord.getX() - speed.getX());
			}
			if (speed.getYDirection() == Spirit.Speed.Y_DIRECTION_DOWN) {
				coord.setY(coord.getY() + speed.getY());
			} else {
				coord.setY(coord.getY() - speed.getY());
			}

			// borders for x...
			if (coord.getX() < 0) {
				speed.toggleXDirection();
				coord.setX(-coord.getX());
			} else if (coord.getX() + graphic.getImage().getWidth() > getWidth()) {
				speed.toggleXDirection();
				coord.setX(coord.getX() + getWidth()
						- (coord.getX() + graphic.getImage().getWidth()));
			}

			// borders for y...
			if (coord.getY() < 0) {
				speed.toggleYDirection();
				coord.setY(-coord.getY());
			} else if (coord.getY() + graphic.getImage().getHeight() > getHeight()) {
				speed.toggleYDirection();
				coord.setY(coord.getY() + getHeight()
						- (coord.getY() + graphic.getImage().getHeight()));
			}

			Bitmap bitmap = graphic.getImage();

			canvas.drawBitmap(bitmap, coord.getX(), coord.getY(), null);
		}

	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// �����߳�
		mDirector = new Director();
		mDirector.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// ͣ���߳�
		if (mDirector != null) {
			mDirector.requestExitAndWait();
			mDirector = null;
		}
	}

	class Director extends Thread {

		private boolean done;

		Director() {
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
					// �ص�MySurfaceView��onDraw����
					onDraw(canvas);
				}
				// ������������Ⱦ��ǰͼ��
				surfaceHolder.unlockCanvasAndPost(canvas);
				try {
					Thread.sleep(1000 / 60);// 60֡��
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
