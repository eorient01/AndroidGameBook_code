/* ������վ��http://www.androidbks.com
* �ǽ�iOS���ã�http://www.51work6.com
* �ǽ�iOS�������߿��ã�http://v.51work6.com
* �ǽ�iOS��������΢����http://weibo.com/u/3215753973
* ����΢����http://weibo.com/516inc
* �ٷ�csdn���ͣ�http://blog.csdn.net/tonny_guan
* QQ��1575716557 ���䣺jylong06@163.com
*/ 

package com.work6;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class ListView_1 extends ListActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, mStrings));
		getListView().setOnItemClickListener(
				new AdapterView.OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> parent, View v,
							int pos, long id) {
						Toast.makeText(ListView_1.this, mStrings[pos],
								Toast.LENGTH_SHORT).show();
					}
				});
	}

//	@Override
//	protected void onListItemClick(ListView l, View v, int position, long id) {
//		Toast.makeText(ListView_1.this, mStrings[position],
//				Toast.LENGTH_SHORT).show();
//	}

	private String[] mStrings = { "������", "�����", "�Ϻ�", "����", "��³ľ��", "����", "����",
			"���ͺ���", "��ͷ", "����", "������", "����", "����", "����", "����", "����", "ʯ��ׯ",
			"�ػʵ�", "����", "�ൺ", "��̨", "�Ͼ�", "����", "����", "�Ϸ�", "����", "����", "����",
			"����", "����", "��ͷ", "�麣", "����", "����", "����", "����", "�ɶ�", "��ɳ", "�人",
			"֣��", "����", "����", "̫ԭ", "��ͬ", "����", "����", "�Ӱ�", "����", "����", "�ϲ�",
			"�Ž�", "̨��", "̨��", "���", "����" };
}