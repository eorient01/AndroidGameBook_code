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
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * ����ҵ��ģ��Activity
 * 
 * @author �ض���
 * 
 */
public class FactionActivity extends MenuAppActivity {

	private String arySpiritMountain[] = new String[9];
	// ��������������
	private int actioncode;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		try {

			JSONObject param = new JSONObject();
			param.put("verifycode", AppUtil.verifycode);
			param.put("actioncode", 21);
			this.actioncode = 21;

			requestURL(param.toString(), "spirit_mountain.php");

		} catch (JSONException e) {
			e.printStackTrace();
			AppUtil.button1Dialog(this, "����JSON�ַ���ʧ�ܣ�");
			release();
		}

	}

	@Override
	protected void handleResult(String jsonStr) {

		if (this.actioncode == 21) {
			try {
				JSONObject json = new JSONObject(jsonStr);
				if (json != null) {
					JSONArray jsonarray = json.getJSONArray("info");
					for (int i = 0; i < jsonarray.length(); i++) {
						arySpiritMountain[i] = jsonarray.getString(i)
								.toString();
					}
				}
			} catch (JSONException e) {
				for (int i = 0; i < 9; i++) {
					arySpiritMountain[i] = "";
				}
			}
			release();
		}

		init();
	}

	/**
	 * �����ʼ��
	 */
	private void init() {

		// TODO �����ʼ��
	}

}
