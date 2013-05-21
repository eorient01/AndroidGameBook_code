/* ������վ��http://www.androidbks.com
* �ǽ�iOS���ã�http://www.51work6.com
* �ǽ�iOS�������߿��ã�http://v.51work6.com
* �ǽ�iOS��������΢����http://weibo.com/u/3215753973
* ����΢����http://weibo.com/516inc
* �ٷ�csdn���ͣ�http://blog.csdn.net/tonny_guan
* QQ��1575716557 ���䣺jylong06@163.com
*/ 

package com.god.holywar;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * ս����ͼҵ��Activity
 * 
 * @author �ض���
 * 
 */
public class AreaMapActivity extends MenuAppActivity {

	private int rs[][] = new int[7][7];

	// +++++++++++ �����ƶ���ͼ start +++++++++
	private GestureDetector gestureDetector;

	// +++++++++++ �����ƶ���ͼ end +++++++++

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.area_map);
		requestData(4, "00");
		// +++++++++++ �����ƶ���ͼ start +++++++++
		gestureDetector = new GestureDetector(new MyGestureListener());
		// +++++++++++ �����ƶ���ͼ end +++++++++
	}

	private void requestData(int actioncode, String orientation) {

		try {

			JSONObject param = new JSONObject();
			JSONArray jarray = new JSONArray();
			jarray.put(0, orientation);

			param.put("verifycode", AppUtil.verifycode);
			param.put("actioncode", actioncode);
			param.put("data", jarray);

			requestURL(param.toString(), "areamap.php");

		} catch (JSONException e) {
			e.printStackTrace();
			AppUtil.button1Dialog(this, "����JSON�ַ���ʧ�ܣ�");
			release();
		}
	}

	// +++++++++++ �����ƶ���ͼ start +++++++++
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		switch (keyCode) {
		case KeyEvent.KEYCODE_DPAD_LEFT:// ��
			this.requestData(42, String.valueOf(1));
			break;
		case KeyEvent.KEYCODE_DPAD_RIGHT:// ��
			this.requestData(42, String.valueOf(3));
			break;
		case KeyEvent.KEYCODE_DPAD_UP:// ��
			this.requestData(42, String.valueOf(0));
			break;
		case KeyEvent.KEYCODE_DPAD_DOWN:// ��
			this.requestData(42, String.valueOf(2));
		}

		return super.onKeyDown(keyCode, event);
	}

	// +++++++++++ �����ƶ���ͼ end +++++++++

	private void load() {
		int num = R.id.area_map_ImageView11;
		for (int i = 0; i < 7; i++) {
			if (i >= 1) {
				num = num + 7;
			}
			for (int j = 0; j < 7; j++) {
				ImageView img = (ImageView) findViewById(num + j);
				switch (rs[i][j]) {
				case 1:
					img.setBackgroundResource(R.drawable.a);
					break;
				case 2:
					img.setBackgroundResource(R.drawable.b);
					break;
				case 3:
					img.setBackgroundResource(R.drawable.c);
					break;
				case 4:
					img.setBackgroundResource(R.drawable.d);
					break;
				case 5:
					img.setBackgroundResource(R.drawable.e);
					break;
				case 6:
					img.setBackgroundResource(R.drawable.f);
					break;
				case 7:
					img.setBackgroundResource(R.drawable.g);
					break;
				case 8:
					img.setBackgroundResource(R.drawable.h);
					break;
				case 9:
					img.setBackgroundResource(R.drawable.i);
					break;
				case 10:
					img.setBackgroundResource(R.drawable.j);
					break;
				case 11:
					img.setBackgroundResource(R.drawable.k);
					break;
				case 12:
					img.setBackgroundResource(R.drawable.mc);
					break;
				}
			}
		}
	}

	@Override
	protected void handleResult(String jsonStr) {

		try {
			JSONObject json = new JSONObject(jsonStr);
			if (json != null) {
				JSONArray jsonResponse = json.getJSONArray("aroundinfo");
				for (int i = 0; i < 7; i++) {
					JSONObject rec = jsonResponse.getJSONObject(i);
					JSONArray jarrayname = rec.getJSONArray("info");
					for (int j = 0; j < 7; j++) {
						rs[i][j] = jarrayname.getInt(j);
					}
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
			AppUtil.button1Dialog(this, "����JSON�ַ���ʧ�ܣ�");
		}
		release();
		load();
	}

	// +++++++++++ �����ƶ���ͼ start +++++++++
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return gestureDetector.onTouchEvent(event);
	}

	public class MyGestureListener extends SimpleOnGestureListener {

		@Override
		public boolean onDown(MotionEvent e) {
			return false;
		}

		@Override
		public void onShowPress(MotionEvent e) {
		}

		@Override
		public boolean onSingleTapUp(MotionEvent e) {
			return false;
		}

		@Override
		public boolean onScroll(MotionEvent e1, MotionEvent e2,
				float distanceX, float distanceY) {

			if (Math.abs(distanceX) > Math.abs(distanceY)) { // ˮƽ�ƶ�
				if (distanceX > 0) {// ��
					requestData(42, String.valueOf(3));
				} else {// ��
					requestData(42, String.valueOf(1));
				}
			} else { // �����ƶ�
				if (distanceY > 0) {// ��
					requestData(42, String.valueOf(2));
				} else {// ��
					requestData(42, String.valueOf(0));
				}
			}

			return false;
		}

		@Override
		public void onLongPress(MotionEvent e) {
		}

		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			return false;
		}

		@Override
		public boolean onDoubleTap(MotionEvent e) {
			return false;
		}

		@Override
		public boolean onDoubleTapEvent(MotionEvent e) {
			return false;
		}

		@Override
		public boolean onSingleTapConfirmed(MotionEvent e) {
			return false;
		}
	}
	// +++++++++++ �����ƶ���ͼ end +++++++++

}
