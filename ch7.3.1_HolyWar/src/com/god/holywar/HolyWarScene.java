/* ������վ��http://www.androidbks.com
* �ǽ�iOS���ã�http://www.51work6.com
* �ǽ�iOS�������߿��ã�http://v.51work6.com
* �ǽ�iOS��������΢����http://weibo.com/u/3215753973
* ����΢����http://weibo.com/516inc
* �ٷ�csdn���ͣ�http://blog.csdn.net/tonny_guan
* QQ��1575716557 ���䣺jylong06@163.com
*/ 

package com.god.holywar;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.work6.designpattern.Scene;
import com.work6.designpattern.Spirit;

/**
 * Ӧ���е���Ϸ������
 * 
 * @author �ض���
 * 
 */
public class HolyWarScene extends Scene {

	private final static String TAG = "HolyWarScene";
	private int[] spiritsImage;
	private String[] spiritsName;

	/** ������Ϣ */
	private Handler handler = new MyHandler();

	/** �̳߳�Ա���� */
	private ActivityThread thread;

	public HolyWarScene(Context context, String[] spirits) {
		super(context);

		// ���� ��ʼ��
		Spirit bgSpirit = new Spirit(BitmapFactory.decodeResource(
				getResources(), R.drawable.castle_bg), 0, 0, 0, 0, null);
		addSpirit(bgSpirit);

		this.spiritsName = spirits;
		this.spiritsImage = AppUtil.getBuidingImgId(this.spiritsName);
		// 1#�ؿ�
		Spirit spirit1 = new Spirit(BitmapFactory.decodeResource(
				getResources(), spiritsImage[0]), 225, 26, 0, 0,
				"onTouchEvent1");
		addSpirit(spirit1);

		// 2#�ؿ�
		Spirit spirit2 = new Spirit(BitmapFactory.decodeResource(
				getResources(), spiritsImage[1]), 300, 30, 0, 0,
				"onTouchEvent2");
		addSpirit(spirit2);

		// 3#�ؿ�
		Spirit spirit3 = new Spirit(BitmapFactory.decodeResource(
				getResources(), spiritsImage[2]), 379, 103, 0, 0,
				"onTouchEvent3");
		addSpirit(spirit3);

		// 4#�ؿ�
		Spirit spirit4 = new Spirit(BitmapFactory.decodeResource(
				getResources(), spiritsImage[3]), 149, 45, 0, 0,
				"onTouchEvent4");
		addSpirit(spirit4);

		// 5#�ؿ�
		Spirit spirit5 = new Spirit(BitmapFactory.decodeResource(
				getResources(), spiritsImage[4]), 91, 80, 0, 0, "onTouchEvent5");
		addSpirit(spirit5);

		// 6#�ؿ�
		Spirit spirit6 = new Spirit(BitmapFactory.decodeResource(
				getResources(), spiritsImage[5]), 40, 120, 0, 0,
				"onTouchEvent6");
		addSpirit(spirit6);

		// 7#�ؿ�
		Spirit spirit7 = new Spirit(BitmapFactory.decodeResource(
				getResources(), spiritsImage[6]), 212, 85, 0, 0,
				"onTouchEvent7");
		addSpirit(spirit7);

		// 8#�ؿ�
		Spirit spirit8 = new Spirit(BitmapFactory.decodeResource(
				getResources(), spiritsImage[7]), 163, 128, 0, 0,
				"onTouchEvent8");
		addSpirit(spirit8);

		// 9#�ؿ�
		Spirit spirit9 = new Spirit(BitmapFactory.decodeResource(
				getResources(), spiritsImage[8]), 100, 150, 0, 0,
				"onTouchEvent9");
		addSpirit(spirit9);

		// 10#�ؿ�
		Spirit spirit10 = new Spirit(BitmapFactory.decodeResource(
				getResources(), spiritsImage[9]), 300, 130, 0, 0,
				"onTouchEvent10");
		addSpirit(spirit10);

		// 11#�ؿ�
		Spirit spirit11 = new Spirit(BitmapFactory.decodeResource(
				getResources(), spiritsImage[10]), 246, 175, 0, 0,
				"onTouchEvent11");
		addSpirit(spirit11);

		// 12#�ؿ�
		Spirit spirit12 = new Spirit(BitmapFactory.decodeResource(
				getResources(), spiritsImage[11]), 180, 220, 0, 0,
				"onTouchEvent12");
		addSpirit(spirit12);

		// 13#�ؿ�
		Spirit spirit13 = new Spirit(BitmapFactory.decodeResource(
				getResources(), spiritsImage[12]), 364, 171, 0, 0,
				"onTouchEvent13");
		addSpirit(spirit13);

		// 14#�ؿ�
		Spirit spirit14 = new Spirit(BitmapFactory.decodeResource(
				getResources(), spiritsImage[13]), 304, 220, 0, 0,
				"onTouchEvent14");
		addSpirit(spirit14);

		// 15#�ؿ�
		Spirit spirit15 = new Spirit(BitmapFactory.decodeResource(
				getResources(), spiritsImage[14]), 240, 265, 0, 0,
				"onTouchEvent15");
		addSpirit(spirit15);

		// 16#�ؿ�
		Spirit spirit16 = new Spirit(BitmapFactory.decodeResource(
				getResources(), spiritsImage[15]), 400, 230, 0, 0,
				"onTouchEvent16");
		addSpirit(spirit16);

		// 17#�ؿ�
		Spirit spirit17 = new Spirit(BitmapFactory.decodeResource(
				getResources(), spiritsImage[16]), 45, 10, 0, 0,
				"onTouchEvent17");
		addSpirit(spirit17);

		// 18#�ؿ�
		Spirit spirit18 = new Spirit(BitmapFactory.decodeResource(
				getResources(), spiritsImage[17]), 49, 178, 0, 0,
				"onTouchEvent18");
		addSpirit(spirit18);

		// 19#�ؿ�
		Spirit spirit19 = new Spirit(BitmapFactory.decodeResource(
				getResources(), spiritsImage[18]), 100, 215, 0, 0,
				"onTouchEvent19");
		addSpirit(spirit19);

		// 20#�ؿ�
		Spirit spirit20 = new Spirit(BitmapFactory.decodeResource(
				getResources(), spiritsImage[19]), 196, 278, 0, 0,
				"onTouchEvent20");
		addSpirit(spirit20);

	}

	/**
	 * ����1#�ؿ�
	 * 
	 * @param sp
	 * @param event
	 */
	public void onTouchEvent1(Spirit sp, MotionEvent event) {
		Log.v(TAG, "����1#�ؿ� " + sp.getCoordinates());
		handleSoilid(1);
	}

	/**
	 * ����2#�ؿ�
	 * 
	 * @param sp
	 * @param event
	 */
	public void onTouchEvent2(Spirit sp, MotionEvent event) {
		Log.v(TAG, "����2#�ؿ� " + sp.getCoordinates());
		handleSoilid(2);
	}

	/**
	 * ����3#�ؿ�
	 * 
	 * @param sp
	 * @param event
	 */
	public void onTouchEvent3(Spirit sp, MotionEvent event) {
		Log.v(TAG, "����3#�ؿ� " + sp.getCoordinates());
		handleSoilid(3);
	}

	/**
	 * ����4#�ؿ�
	 * 
	 * @param sp
	 * @param event
	 */
	public void onTouchEvent4(Spirit sp, MotionEvent event) {
		Log.v(TAG, "����4#�ؿ� " + sp.getCoordinates());
		handleSoilid(4);
	}

	/**
	 * ����5#�ؿ�
	 * 
	 * @param sp
	 * @param event
	 */
	public void onTouchEvent5(Spirit sp, MotionEvent event) {
		Log.v(TAG, "����5#�ؿ� " + sp.getCoordinates());
		handleSoilid(5);
	}

	/**
	 * ����6#�ؿ�
	 * 
	 * @param sp
	 * @param event
	 */
	public void onTouchEvent6(Spirit sp, MotionEvent event) {
		Log.v(TAG, "����6#�ؿ� " + sp.getCoordinates());
		handleSoilid(6);
	}

	/**
	 * ����7#�ؿ�
	 * 
	 * @param sp
	 * @param event
	 */
	public void onTouchEvent7(Spirit sp, MotionEvent event) {
		Log.v(TAG, "����7#�ؿ� " + sp.getCoordinates());
		handleSoilid(7);
	}

	/**
	 * ����8#�ؿ�
	 * 
	 * @param sp
	 * @param event
	 */
	public void onTouchEvent8(Spirit sp, MotionEvent event) {
		Log.v(TAG, "����8#�ؿ� " + sp.getCoordinates());
		handleSoilid(8);
	}

	/**
	 * ����9#�ؿ�
	 * 
	 * @param sp
	 * @param event
	 */
	public void onTouchEvent9(Spirit sp, MotionEvent event) {
		Log.v(TAG, "����9#�ؿ� " + sp.getCoordinates());
		handleSoilid(9);
	}

	/**
	 * ����10#�ؿ�
	 * 
	 * @param sp
	 * @param event
	 */
	public void onTouchEvent10(Spirit sp, MotionEvent event) {
		Log.v(TAG, "����10#�ؿ� " + sp.getCoordinates());
		handleSoilid(10);
	}

	/**
	 * ����11#�ؿ�
	 * 
	 * @param sp
	 * @param event
	 */
	public void onTouchEvent11(Spirit sp, MotionEvent event) {
		Log.v(TAG, "����11#�ؿ� " + sp.getCoordinates());
		handleSoilid(11);
	}

	/**
	 * ����12#�ؿ�
	 * 
	 * @param sp
	 * @param event
	 */
	public void onTouchEvent12(Spirit sp, MotionEvent event) {
		Log.v(TAG, "����12#�ؿ� " + sp.getCoordinates());
		handleSoilid(12);
	}

	/**
	 * ����13#�ؿ�
	 * 
	 * @param sp
	 * @param event
	 */
	public void onTouchEvent13(Spirit sp, MotionEvent event) {
		Log.v(TAG, "����13#�ؿ� " + sp.getCoordinates());
		handleSoilid(13);
	}

	/**
	 * ����14#�ؿ�
	 * 
	 * @param sp
	 * @param event
	 */
	public void onTouchEvent14(Spirit sp, MotionEvent event) {
		Log.v(TAG, "����14#�ؿ� " + sp.getCoordinates());
		handleSoilid(14);
	}

	/**
	 * ����15#�ؿ�
	 * 
	 * @param sp
	 * @param event
	 */
	public void onTouchEvent15(Spirit sp, MotionEvent event) {
		Log.v(TAG, "����15#�ؿ� " + sp.getCoordinates());
		handleSoilid(15);
	}

	/**
	 * ����16#�ؿ�
	 * 
	 * @param sp
	 * @param event
	 */
	public void onTouchEvent16(Spirit sp, MotionEvent event) {
		Log.v(TAG, "����16#�ؿ� " + sp.getCoordinates());
		handleSoilid(16);
	}

	/**
	 * ����17#�ؿ�
	 * 
	 * @param sp
	 * @param event
	 */
	public void onTouchEvent17(Spirit sp, MotionEvent event) {
		Log.v(TAG, "����17#�ؿ� " + sp.getCoordinates());
		handleSoilid(17);
	}

	/**
	 * ����18#�ؿ�
	 * 
	 * @param sp
	 * @param event
	 */
	public void onTouchEvent18(Spirit sp, MotionEvent event) {
		Log.v(TAG, "����18#�ؿ� " + sp.getCoordinates());
		handleSoilid(18);
	}

	/**
	 * ����19#�ؿ�
	 * 
	 * @param sp
	 * @param event
	 */
	public void onTouchEvent19(Spirit sp, MotionEvent event) {
		Log.v(TAG, "����19#�ؿ� " + sp.getCoordinates());
		handleSoilid(19);
	}

	/**
	 * ����20#�ؿ�
	 * 
	 * @param sp
	 * @param event
	 */
	public void onTouchEvent20(Spirit sp, MotionEvent event) {
		Log.v(TAG, "����20#�ؿ� " + sp.getCoordinates());
		handleSoilid(20);
	}

	/**
	 * �����Ӧ�غŵ�ҵ��
	 * 
	 * @param soilid
	 *            �ؿ���
	 */
	private void handleSoilid(int soilid) {

		JSONArray jsonarr = new JSONArray();
		try {
			jsonarr.put(0, soilid);
			JSONObject param = new JSONObject();
			param.put("actioncode", 14);
			param.put("verifycode", AppUtil.verifycode);
			param.put("data", jsonarr);
			thread = new ActivityThread(param.toString(), "castle.php", soilid,
					14);
			thread.start();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �����ʹ���ռ����Ի���
	 * @param soilid
	 */
	private void handleSpaceLandTowerDialog(final int soilid) {

		//TODO 
	}

	/**
	 * �����б���������
	 * 
	 * @param jsonStr
	 * @param soilid
	 */
	private void handleRequestUpgradeRecruitSoldierInfoResult(String jsonStr,
			final int soilid) {

		//TODO
	}

	/**
	 * ��ͨ��������
	 * 
	 * @param jsonStr
	 * @param soilid
	 */
	private void handleRequestUpgradeInfoResult(String jsonStr, final int soilid) {
		//TODO
	}

	/**
	 * 
	 * ��ļʿ���Ի�����
	 * 
	 * @param soilid
	 *            �ؿ���
	 */
	private void popupRecruitSoldierDialog(final int soilid) {
		//TODO
	}

	/**
	 * ͨ����ļʿ����Ϣ��ͼƬ��������ļʿ�������Ի���
	 * 
	 * @param soldierInfo
	 *            ʿ����ļ��Ϣ
	 * @param img
	 *            ��ļʿ��ͼƬid
	 */
	private void popupRecruitSoldierNumberDialog(final String soldierInfo[],
			int img) {

		//TODO
	}

	/**
	 * ʿ����ļ��ɻص�������
	 * 
	 * @param jsonStr
	 *            ���ص�JSON�ַ���
	 */
	private void handleRequestRecruitSoldierResult(String jsonStr) {
		//TODO
	}

	/**
	 * ���������ť�Ļص�����
	 */
	private void handleClickBuildingUpgrade(String jsonStr) {
		String backFlag = "44";
		JSONObject json;
		try {
			json = new JSONObject(jsonStr);
			if (json != null) {
				backFlag = json.getString("upgrade_back_flag");
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

		if (backFlag.equals("1")) {
			Toast.makeText(this.getContext(), "������...", Toast.LENGTH_SHORT)
					.show();
		} else if (backFlag.equals("44")) {
			Toast.makeText(this.getContext(), "���ݴ���", Toast.LENGTH_LONG)
					.show();
		} else {
			Toast.makeText(this.getContext(), "���ϲ��㣬����������", Toast.LENGTH_SHORT)
					.show();
		}
	}

	class MyHandler extends Handler {

		@Override
		public void handleMessage(Message msg) {

			switch (msg.what) {
			case 0:
				if (msg.obj != null) {
					Map data = (Map) msg.obj;
					Integer soilid = (Integer) data.get("soilid");
					Integer actioncode = (Integer) data.get("actioncode");
					String jsonData = (String) data.get("jsonData");
					if (actioncode == 14) {
						String name = spiritsName[soilid - 1];
						if (name.equals("temple") || name.equals("residence")
								|| name.equals("storehouse")
								|| name.equals("chamber_secrets")
								|| name.equals("meeting_room")
								|| name.equals("demons_pavilion")
								|| name.equals("wall")
								|| name.equals("sawmill")
								|| name.equals("grain_field")
								|| name.equals("land_tower_air_defense")
								|| name.equals("land_tower_ground_defense")) {
							handleRequestUpgradeInfoResult(jsonData, soilid);
						} else if (name.equals("parade_ground")
								|| name.equals("archery_camp")
								|| name.equals("voodoo")
								|| name.equals("martial_club")
								|| name.equals("cavalry_camp")
								|| name.equals("army_arsenal")) {
							handleRequestUpgradeRecruitSoldierInfoResult(
									jsonData, soilid);
						} else if (name.equals("space_land_tower")) {
							handleSpaceLandTowerDialog(soilid);
						}
					} else if (actioncode == 15) {
						handleClickBuildingUpgrade(jsonData);
					} else if (actioncode == 16) {
						handleRequestRecruitSoldierResult(jsonData);
					}
				}
				break;
			}
			try {
				thread.join();
			} catch (InterruptedException e) {
			}
			super.handleMessage(msg);
		}
	};

	class ActivityThread extends Thread {

		/** �����JSON�ַ��� */
		private String jsonStr;

		/** �������˽ű��ļ� */
		private String url;

		/** ��ǰ����ĵغ� */
		private int soilid;

		/**
		 * ������ 12 �Ǳ���ʼ�� 14 �������� 15 ��������ҳ�棨��������ġ���������ť�� 16
		 * �����д���ļʿ���ģ������ļʿ���ġ���ļ����ť��
		 */
		private int actioncode = 14;

		ActivityThread(String jsonStr, String url, int soilid, int actioncode) {
			super();
			this.jsonStr = jsonStr;
			this.url = url;
			this.soilid = soilid;
			this.actioncode = actioncode;
		}

		@Override
		public void run() {

			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(AppUtil.URL_PREFIX + url);
			try {
				StringEntity se = new StringEntity(jsonStr);
				httppost.setEntity(se);

				HttpResponse response = httpclient.execute(httppost);
				HttpEntity entityOut = response.getEntity();

				if (entityOut != null) {
					BufferedReader br = new BufferedReader(
							new InputStreamReader(entityOut.getContent(),
									"utf-8"));
					StringBuffer sb = new StringBuffer();
					String line;
					while ((line = br.readLine()) != null) {
						sb.append(line);
					}
					Map data = new HashMap();
					data.put("soilid", soilid);
					data.put("actioncode", actioncode);
					data.put("jsonData", sb == null ? "" : sb.toString());
					Message lmsg = new Message();
					lmsg.obj = data;
					lmsg.what = 0;// ����ɹ�
					handler.sendMessage(lmsg);
				}

			} catch (Exception e) {
				AppUtil.button1Dialog(HolyWarScene.this.getContext(), "�����쳣����");
				handler.sendEmptyMessage(-1);
			}

		}
	}

}
