/* ������վ��http://www.androidbks.com
* �ǽ�iOS���ã�http://www.51work6.com
* �ǽ�iOS�������߿��ã�http://v.51work6.com
* �ǽ�iOS��������΢����http://weibo.com/u/3215753973
* ����΢����http://weibo.com/516inc
* �ٷ�csdn���ͣ�http://blog.csdn.net/tonny_guan
* QQ��1575716557 ���䣺jylong06@163.com
*/ 

package com.god.holywar;


import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;

/**
 * �յؽ���ҵ��ģ��Activity
 * 
 * @author �ض���
 * 
 */
public class BuildingActivity extends MenuAppActivity {

	// ����������Ϣ
	String aryBasicBuildingName[] = { "���", "�ֿ�", "�ܿ�", "����˾" };
	String aryBuildingDev[] = { "�����ǰ�ɾ�ס���������Ľ���������ͨ����������������������ǰ��˿�������",
			"���������Դ�Ľ������ȼ�Խ�߿ɴ洢����ԴԽ�ࡣ",
			"��������Դ���ܱ���������������ս����������ʧ���ܿ�ȼ�Խ�ߣ��ɱ�����ԴԽ�ࡣ",
			"�����ͼ������ɵı�Ҫ�������ȼ�Խ�߿ɼ�������ɳ�ԱԽ�ࡣ" };
	String aryBuildingFf[] = { "ľ��:60    ��ʳ:30    ����:0    �˿�:0    ʱ��:00:00:55",
			"ľ��:150    ��ʳ:120    ����:4    �˿�:9    ʱ��:00:01:14",
			"ľ��:2500    ��ʳ:2500    ����:80    �˿�:4    ʱ��:00:02:09",
			"ľ��:500    ��ʳ:500    ����:100    �˿�:100    ʱ��:00:03:41", };

	// ���½�����Ϣ
	// ������Ϣ�з��ɽ��ڤ�磬����aryMilitaryBuilding1��ڤ��
	String aryMilitaryBuilding1[] = { "������", "������", "��ħ¥", "��Ӫ", "�׶���", "��ʿ��",
			"����Ӫ", "���ɷ�" };
	// ����aryMilitaryBuilding2���ɽ�
	String aryMilitaryBuilding2[] = { "������", "������", "���ɸ�", "��Ӫ", "�׶���", "��ʿ��",
			"����Ӫ", "���ɷ�" };
	String aryBuildingDev1[] = {
			"���������ж�����Ҫ������������顢������������ж����ɾ��������С��������ȼ�Խ�ߣ������ƶ�Խ�졣",
			"��ļ���µĽ����������ȼ�Խ����ļ�ٶ�Խ�죬ս����λ�����ڴ�ѧϰս�����ܡ�",
			"��ħ�ߵ�������������ħ�ߺ�ħ����������ħ¥�����ħ¥�ȼ�Խ�ߣ���ħ�߻�ѪԽ�졣",
			"��ļ�����ֵĽ����������ȼ�Խ����ļ�ٶ�Խ�죬ս����λ�����ڴ�ѧϰս�����ܡ�",
			"��ļ�׶���ʿ�Ľ����������ȼ�Խ����ļ�ٶ�Խ�죬ս����λ�����ڴ�ѧϰս�����ܡ�",
			"��ļ�������ֵĽ����������ȼ�Խ����ļ�ٶ�Խ�죬ս����λ�����ڴ�ѧϰս�����ܡ�",
			"��ļ������Ľ����������ȼ�Խ����ļ�ٶ�Խ�죬ս����λ�����ڴ�ѧϰս�����ܡ�",
			"����������е�Ľ�����ֻ�й�����е���ܹ����������ȼ�Խ������Խ�졣" };

	String aryBuildingFf1[] = {
			"ľ��:260    ��ʳ:210    ����:0    �˿�:0    ʱ��:00:01:50",
			"ľ��:220    ��ʳ:230    ����:0    �˿�:20    ʱ��:00:01:32",
			"ľ��:2000    ��ʳ:2000    ����:100    �˿�:100    ʱ��:00:04:36",
			"ľ��:180    ��ʳ:260    ����:8    �˿�:20    ʱ��:00:02:09",
			"ľ��:220    ��ʳ:200    ����:8    �˿�:20    ʱ��:00:02:18",
			"ľ��:180    ��ʳ:200    ����:10    �˿�:20    ʱ��:00:02:32",
			"ľ��:280    ��ʳ:300    ����:13    �˿�:20    ʱ��:00:02:46",
			"ľ��:240    ��ʳ:230    ����:18    �˿�:20    ʱ��:00:01:32" };

	String aryBuildingScribe1[] = { "", "", "", "",
			"��Ҫ������10����������6����������7������Ӫ3����", "��Ҫ������10����������6����������7������Ӫ3����",
			"��Ҫ������15����������7����������10��,��ħ¥3����", "��Ҫ�׶���10������ʿ��6��������Ӫ5����" };

	// �������޷�����ı�־λ����������
	private String aryBasicBuildingFlag[] = new String[4];
	// �������޷�����ı�־λ�����½���
	private String aryMilitaryBuildingFlag[] = new String[8];
	// ���ճǱ�ҳ�յؽ������صı��
	private int soilid;
	// ��������������
	private int actioncode;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.building01);

		Bundle bundle = this.getIntent().getExtras();
		soilid = bundle.getInt("soilid");

		try {

			JSONObject param = new JSONObject();
			param.put("verifycode", AppUtil.verifycode);
			param.put("actioncode", 17);
			this.actioncode = 17;

			requestURL(param.toString(), "building.php");

		} catch (JSONException e) {
			e.printStackTrace();
			AppUtil.button1Dialog(this, "����JSON�ַ���ʧ�ܣ�");
			release();
		}
	}

	@Override
	protected boolean showWindowTitle() {
		return true;
	}

	@Override
	protected void handleResult(String jsonStr) {

	}
}
