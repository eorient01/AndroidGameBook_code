/* ������վ��http://www.androidbks.com
* �ǽ�iOS���ã�http://www.51work6.com
* �ǽ�iOS�������߿��ã�http://v.51work6.com
* �ǽ�iOS��������΢����http://weibo.com/u/3215753973
* ����΢����http://weibo.com/516inc
* �ٷ�csdn���ͣ�http://blog.csdn.net/tonny_guan
* QQ��1575716557 ���䣺jylong06@163.com
*/ 

package com.god.holywar;


import android.os.Bundle;

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

	// ++++++++++�����������趨������ start+++++++
	// ���Է�����������������
	private String strGrandCouncilLevel;
	// ���Է�����������������һ������Ҫ�Ĳ���
	private String[] aryUpgradeStuff = new String[5];
	// ����صı��
	private int soilid;
	// ���������ĸ�ҳ�����ת����
	private int sendarmy;
	// ++++++++++�����������趨������ end+++++++++
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
	}

	@Override
	protected void handleResult(String jsonStr) {

	}

	@Override
	protected boolean showWindowTitle() {
		return true;
	}

}
