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

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * ������ս����Activity
 * 
 * @author �ض���
 * 
 */
public class ChallengeActivity extends MenuAppActivity {

	// ��ɽ����
	private String strSpiritMountainName;
	// ��ɽռ��
	private String strSpiritMountainOccupy;
	// ռ��ʱ��
	private String strOccupyTime;
	// ��ս���Ƿ��ر�־
	private String flag;
	// ��������������
	private int actioncode;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.faction02);

		Bundle bundle = this.getIntent().getExtras();
		strSpiritMountainName = bundle.getString("spirit_mountain_name");

		try {

			JSONArray jsonarr = new JSONArray();
			jsonarr.put(0, strSpiritMountainName);

			JSONObject param = new JSONObject();
			param.put("actioncode", 22);
			param.put("data", jsonarr);

			this.actioncode = 22;

			requestURL(param.toString(), "spirit_mountain.php");

		} catch (JSONException e) {
			e.printStackTrace();
			AppUtil.button1Dialog(this, "����JSON�ַ���ʧ�ܣ�");
			release();
		}

	}

	@Override
	protected void handleResult(String jsonStr) {

		if (this.actioncode == 22) {
			try {
				JSONObject json = new JSONObject(jsonStr);
				if (json != null) {
					JSONArray jsonarray = json.getJSONArray("challenge_info");
					strSpiritMountainOccupy = jsonarray.getString(0);
					strOccupyTime = jsonarray.getString(1);
					flag = jsonarray.getString(2);
				}
			} catch (JSONException e) {
				strSpiritMountainOccupy = "";
				strOccupyTime = "0";
				flag = "";
			}
			release();
			init();
		}
	}

	/**
	 * ��ʼ������
	 */
	private void init() {

		TextView txtSpiritMountainName = (TextView) findViewById(R.id.faction02_spirit_mountain_name);
		txtSpiritMountainName.setText(strSpiritMountainName);

		TextView txtSpiritMountainOccupy = (TextView) findViewById(R.id.faction02_spirit_mountain_occupy);
		txtSpiritMountainOccupy.setText(strSpiritMountainOccupy);
		TextView txtfactionOccupyTime = (TextView) findViewById(R.id.faction02_occupy_time);
		txtfactionOccupyTime.setText(strOccupyTime);

		Button btnChallenge = (Button) findViewById(R.id.faction02_btn_challenge);

		if (flag.equals("btn_defend")) {
			btnChallenge.setText("���ؾݵ�");
		} else if (flag.equals("btn_challenge")) {
			btnChallenge.setText("��ս�ݵ�");
		} else {
			btnChallenge.setVisibility(View.GONE);
		}

		// TODO �����ս�ݵ㰴ť 
	}
}
