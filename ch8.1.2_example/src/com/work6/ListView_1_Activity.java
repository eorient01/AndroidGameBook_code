/* ������վ��http://www.androidbks.com
* �ǽ�iOS���ã�http://www.51work6.com
* �ǽ�iOS�������߿��ã�http://v.51work6.com
* �ǽ�iOS��������΢����http://weibo.com/u/3215753973
* ����΢����http://weibo.com/516inc
* �ٷ�csdn���ͣ�http://blog.csdn.net/tonny_guan
* QQ��1575716557 ���䣺jylong06@163.com
*/ 

package com.work6;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListView_1_Activity extends Activity {
	private ListView listview;
	private String[] mStrings = { "������", "�����", "�Ϻ�", "����", "��³ľ��", "����", "����",
			"���ͺ���", "��ͷ", "����", "������", "����", "����", "����", "����", "����", "ʯ��ׯ",
			"�ػʵ�", "����", "�ൺ", "��̨", "�Ͼ�", "����", "����", "�Ϸ�", "����", "����", "����",
			"����", "����", "��ͷ", "�麣", "����", "����", "����", "����", "�ɶ�", "��ɳ", "�人",
			"֣��", "����", "����", "̫ԭ", "��ͬ", "����", "����", "�Ӱ�", "����", "����", "�ϲ�",
			"�Ž�", "̨��", "̨��", "���", "����" };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview_activity);

		listview = (ListView) findViewById(R.id.ListView01);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, mStrings);
		listview.setAdapter(adapter);
		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v, int pos,
					long id) {
				Toast.makeText(ListView_1_Activity.this, mStrings[pos],
						Toast.LENGTH_SHORT).show();
			}
		});
	}
}
