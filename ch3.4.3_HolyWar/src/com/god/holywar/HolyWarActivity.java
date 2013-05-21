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
import org.json.JSONObject;

import android.os.Bundle;

/**
 * �Ǳ���ʼ������Activity��Ҳ����Ϸ������Ҫ�Ĳ��֡�
 * 
 * @author �ض���
 * 
 */
public class HolyWarActivity extends AppActivity {

	// ����������
	private String[] aryBuildingName;
	// ��Ϸ����
	private HolyWarScene myScene = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// ��ʼ���������������飬����20�����
		aryBuildingName = new String[20];
		for (int i = 0; i < 20; i++) {
			aryBuildingName[i] = "space";
		}
		try {
			// ����JSON������JSON�ַ���
			JSONObject param = new JSONObject();
			param.put("verifycode", AppUtil.verifycode);
			param.put("actioncode", 12);
			HolyWarActivity.this.requestURL(param.toString(), "castle.php");
		} catch (Exception e) {
			e.printStackTrace();
			AppUtil.button1Dialog(this, "����JSON�ַ���ʧ�ܣ�");
		}
	}

	@Override
	protected void handleResult(String jsonStr) {
		try {
			// ����JSON
			JSONObject json = new JSONObject(jsonStr);
			if (json != null) {
				JSONArray jsonResponse = json.getJSONArray("initdata");
				for (int i = 0; i < jsonResponse.length(); i++) {
					aryBuildingName[i] = jsonResponse.getString(i).toString();
				}
			}
			// ���Զ����SurfaceView��ӵ�Activity������ͼ
			myScene = new HolyWarScene(this, aryBuildingName);
			setContentView(myScene);

		} catch (Exception e) {
			e.printStackTrace();
			AppUtil.button1Dialog(this, "����JSON�ַ���ʧ�ܣ�");
		}
		release();

	}

}
