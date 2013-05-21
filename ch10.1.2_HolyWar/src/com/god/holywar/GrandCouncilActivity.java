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

import android.app.ActionBar;
import android.os.Bundle;
import android.view.View;

/**
 * ������Activity
 * 
 * @author �ض��� si92@sina.com
 * 
 * 
 */
public class GrandCouncilActivity extends MenuAppActivity {

	// ���Է����������־��ӵ�����
	private String[] aryGrandCouncil = new String[11];
	// ���Է�������������������
	private String strSoldierPayAmount;
	// ���Է��������Լ��ĳǱ������б�
	private String[] aryCastleList;
	// ���Է�������ս������
	private int warnumber;
	// ���Է�������ս���ľ���������Ϣ
	private String[][] war;

	// ���Է�����������������
	private String strGrandCouncilLevel;
	// ���Է�����������������һ������Ҫ�Ĳ���
	private String[] aryUpgradeStuff = new String[5];
	// ����صı��
	private int soilid;
	// ���������ĸ�ҳ�����ת����
	private int sendarmy;

	// ��������������
	private int actioncode;

	// ++++++++++ and ++++++++++++
	// ѡ��ĳǱ�����
	private String selectGrandCouncil;
	// Ӣ����������
	private String skill2 = "��ʹ����������";
	// ����������Ԯ
	private String attack = "����";

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.building01);

		Bundle bundle = this.getIntent().getExtras();
		soilid = bundle.getInt("soilid");
		sendarmy = bundle.getInt("sendarmy");

		try {

			JSONObject param = new JSONObject();
			param.put("verifycode", AppUtil.verifycode);
			param.put("actioncode", 23);
			this.actioncode = 23;

			requestURL(param.toString(), "grand_council.php");

		} catch (JSONException e) {
			e.printStackTrace();
			AppUtil.button1Dialog(this, "����JSON�ַ���ʧ�ܣ�");
			release();
		}
	}

	@Override
	protected void handleResult(String jsonStr) {

		if (this.actioncode == 23) {
			try {
				JSONObject json = new JSONObject(jsonStr);

				JSONArray jsonResponse2 = json.getJSONArray("total_info");
				for (int i = 0; i < jsonResponse2.length(); i++) {
					JSONObject jsonResponse22 = jsonResponse2.getJSONObject(i);
					JSONArray jsonResponse221 = jsonResponse22
							.getJSONArray("army_amount");
					for (int j = 0; j < jsonResponse221.length(); j++) {
						aryGrandCouncil[j] = jsonResponse221.getString(j);
					}
					JSONArray jsonResponse222 = jsonResponse22
							.getJSONArray("soldier_pay_amount");
					strSoldierPayAmount = jsonResponse222.getString(0);
					JSONArray jsonResponse223 = jsonResponse22
							.getJSONArray("self_castle_list");
					aryCastleList = new String[jsonResponse223.length()];
					for (int j = 0; j < jsonResponse223.length(); j++) {
						aryCastleList[j] = jsonResponse223.getString(j);
					}
				}

				JSONObject jsonResponse4 = json.getJSONObject("warsituating");
				warnumber = jsonResponse4.getInt("warnumber");
				JSONArray jsonResponse5 = jsonResponse4.getJSONArray("war");
				war = new String[warnumber][4];
				for (int i = 0; i < warnumber; i++) {
					JSONObject warin = jsonResponse5.getJSONObject(i);
					JSONArray warnw = warin.getJSONArray("warin");
					for (int j = 0; j < warnw.length(); j++) {
						war[i][j] = warnw.getString(j);
					}
				}
				// ������������Ϣ
				strGrandCouncilLevel = json.getString("building_level");
				JSONArray jsonResponse1 = json
						.getJSONArray("building_upgrade_info");
				for (int i = 0; i < jsonResponse1.length(); i++) {
					aryUpgradeStuff[i] = jsonResponse1.getString(i);
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			release();

			final ActionBar actionBar = getActionBar();
			View actionvBarView = getLayoutInflater().inflate(
					R.layout.action_bar_custom, null);
			actionBar.setCustomView(actionvBarView);
			actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM
					| ActionBar.DISPLAY_SHOW_TITLE
					| ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_USE_LOGO);
			actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
			actionBar.setTitle("������  " + strGrandCouncilLevel + "  ��");
			actionBar.setLogo(R.drawable.grand_council);

			// TODO
		}
	}
	
	@Override
	protected boolean showWindowTitle() {
		return true;
	}

}
