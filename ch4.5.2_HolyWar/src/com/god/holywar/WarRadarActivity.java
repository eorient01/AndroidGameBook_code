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
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * ս���״�ҵ��ģ��Activity
 * 
 * @author �ض���
 * 
 */
public class WarRadarActivity extends MenuAppActivity {

	// ����(���)����
	private String aryName[];
	// ����/����
	private String aryFaction[];
	// ����
	private String aryCoordinate[];
	// ������Ŀ
	private String[] it1;
	// �����󼶱�
	private String[] it2;
	// ���޳���
	private String[] it3;
	// ��������������
	private int actioncode;
	// �����е�ListView
	private ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.war_radar);
		// ��ʼ������
		it1 = getResources().getStringArray(R.array.war_radar_search_item);
		// �����󼶱�
		it2 = getResources().getStringArray(R.array.war_radar_Iron_Ore_Level);
		// ���޳���
		it3 = getResources().getStringArray(R.array.war_radar_pet_no_yes);

		final Spinner spinner1 = (Spinner) findViewById(R.id.war_radar_Spinner01);
		final Spinner spinner2 = (Spinner) findViewById(R.id.war_radar_Spinner02);
		// ���� | ����
		final TextView tv1 = (TextView) findViewById(R.id.war_radar_TextView01);
		// ���� | ����
		final TextView tv2 = (TextView) findViewById(R.id.war_radar_TextView02);
		// ��������
		final TextView txtSearchContent = (TextView) findViewById(R.id.txtSearchContent);
		// ���ؿؼ�
		spinner2.setVisibility(View.INVISIBLE);
		txtSearchContent.setVisibility(View.INVISIBLE);

		Button btnss = (Button) findViewById(R.id.war_radar_buttonSearch);

		listView = (ListView) findViewById(R.id.war_radar_ListView01);

		ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, it1);
		spinner1.setAdapter(adapter1);

		spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				if (spinner1.getSelectedItem().toString().equals("��ҳǰ�")) {
					tv1.setText(R.string.name);
					tv2.setText(R.string.faction);
					spinner2.setVisibility(View.INVISIBLE);
					txtSearchContent.setVisibility(View.INVISIBLE);
				} else if (spinner1.getSelectedItem().toString().equals("������")) {
					tv1.setText(R.string.terrain);
					tv2.setText(R.string.describe);
					spinner2.setVisibility(View.VISIBLE);
					txtSearchContent.setVisibility(View.VISIBLE);
					txtSearchContent.setText(R.string.iron_ore_level_2);
					ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(
							WarRadarActivity.this,
							android.R.layout.simple_spinner_item, it2);
					spinner2.setAdapter(adapter2);
				} else {
					tv1.setText(R.string.terrain);
					tv2.setText(R.string.describe);
					spinner2.setVisibility(View.VISIBLE);
					txtSearchContent.setVisibility(View.VISIBLE);
					txtSearchContent.setText(R.string.pet_no_yes_2);
					ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(
							WarRadarActivity.this,
							android.R.layout.simple_spinner_item, it3);
					spinner2.setAdapter(adapter2);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});

		//TODO �����ѯ��ť
		
		//TODO ��ת������������
	}

	@Override
	protected void handleResult(String jsonStr) {
		//TODO �����ѯ��ť
	}
}
