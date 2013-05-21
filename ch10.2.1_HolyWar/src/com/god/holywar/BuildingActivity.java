/* ������վ��http://www.androidbks.com
* �ǽ�iOS���ã�http://www.51work6.com
* �ǽ�iOS�������߿��ã�http://v.51work6.com
* �ǽ�iOS��������΢����http://weibo.com/u/3215753973
* ����΢����http://weibo.com/516inc
* �ٷ�csdn���ͣ�http://blog.csdn.net/tonny_guan
* QQ��1575716557 ���䣺jylong06@163.com
*/ 

package com.god.holywar;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

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

	/**
	 * ��������Fragment
	 * 
	 * @author �ض���
	 * 
	 */
	private class BaseInfoShowTabContentFragment extends Fragment {

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			LayoutInflater factory = LayoutInflater.from(BuildingActivity.this);
			View textEntryView = factory.inflate(R.layout.building03, null);

			ListView list1 = (ListView) textEntryView
					.findViewById(R.id.building03_listview);
			ArrayList<Map<String, Object>> listData = new ArrayList<Map<String, Object>>();
			for (int i = 0; i < 4; i++) {
				Map<String, Object> map = new HashMap<String, Object>();
				if (aryBasicBuildingFlag[i].equals("1")) {
					map.put("STATE", "����");
				} else {
					map.put("STATE", "�޷�����");
				}
				map.put("NAME", aryBasicBuildingName[i]);
				map.put("DEV", aryBuildingDev[i]);
				map.put("EFF", aryBuildingFf[i]);
				listData.add(map);
			}

			SimpleAdapter adapter = new SimpleAdapter(BuildingActivity.this,
					listData, R.layout.building02, new String[] { "NAME",
							"DEV", "EFF", "STATE" }, new int[] {
							R.id.building02_name, R.id.building02_dev,
							R.id.building02_eff, R.id.state });
			list1.setAdapter(adapter);
			list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					TextView buname = (TextView) view
							.findViewById(R.id.building02_name);
					String name = buname.getText().toString();
					if (aryBasicBuildingFlag[position].equals("1")) {
						String locName = AppUtil.getNameHanZ(name);
						building(soilid, locName);
					} else {
						Toast.makeText(BuildingActivity.this, "�޷�����ý���",
								Toast.LENGTH_SHORT).show();
					}

				}
			});

			return textEntryView;
		}

	}

	/**
	 * ���½���Fragment
	 * 
	 * @author �ض���
	 * 
	 */
	private class MilitaryInfoShowTabContentFragment extends Fragment {
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			LayoutInflater factory = LayoutInflater.from(BuildingActivity.this);
			View textEntryView = factory.inflate(R.layout.building03, null);

			ListView list1 = (ListView) textEntryView
					.findViewById(R.id.building03_listview);
			ArrayList<Map<String, Object>> mlist = new ArrayList<Map<String, Object>>();
			for (int i = 0; i < 8; i++) {
				Map<String, Object> map = new HashMap<String, Object>();
				if (aryMilitaryBuildingFlag[i].equals("1")) {
					map.put("STATE", "����");
				} else {
					map.put("STATE", "�޷�����");
				}
				if (AppUtil.faction.equals("mingjie")) {
					map.put("NAME", aryMilitaryBuilding1[i]);
				} else {
					map.put("NAME", aryMilitaryBuilding2[i]);
				}

				map.put("DEV", aryBuildingDev1[i]);
				map.put("EFF", aryBuildingFf1[i]);
				map.put("DESCRIBE", aryBuildingScribe1[i]);
				mlist.add(map);
			}

			SimpleAdapter adapter = new SimpleAdapter(BuildingActivity.this,
					mlist, R.layout.building02, new String[] { "NAME", "DEV",
							"EFF", "DESCRIBE", "STATE" }, new int[] {
							R.id.building02_name, R.id.building02_dev,
							R.id.building02_eff, R.id.building02_scribe,
							R.id.state });
			list1.setAdapter(adapter);
			list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					TextView buname = (TextView) view
							.findViewById(R.id.building02_name);
					String name = buname.getText().toString();
					if (aryMilitaryBuildingFlag[position].equals("1")) {
						String locName = AppUtil.getNameHanZ(name);
						building(soilid, locName);
					} else {
						Toast.makeText(BuildingActivity.this, "�޷�����ý���",
								Toast.LENGTH_SHORT).show();
					}
				}
			});
			return textEntryView;
		}
	}

	/**
	 * ���촦��
	 * 
	 * @param soilid
	 *            �ؿ���
	 * @param buildingname
	 *            ��������
	 */
	private void building(int soilid, String buildingname) {
		try {

			JSONArray jsonarr = new JSONArray();
			jsonarr.put(0, soilid);
			jsonarr.put(1, buildingname);

			JSONObject param = new JSONObject();
			param.put("verifycode", AppUtil.verifycode);
			param.put("actioncode", 18);
			this.actioncode = 18;
			param.put("data", jsonarr);

			requestURL(param.toString(), "building.php");

		} catch (JSONException e) {
			e.printStackTrace();
			AppUtil.button1Dialog(this, "����JSON�ַ���ʧ�ܣ�");
			release();
		}
	}

	@Override
	protected void handleResult(String jsonStr) {
		if (this.actioncode == 17) {
			try {
				JSONObject json = new JSONObject(jsonStr);
				if (json != null) {
					JSONArray jsonarray = json.getJSONArray("housebuilddata");
					for (int i = 0; i < jsonarray.length(); i++) {
						JSONObject rec = jsonarray.getJSONObject(i);
						JSONArray jarrayname = rec
								.getJSONArray("basebuildingflag");
						for (int j = 0; j < jarrayname.length(); j++) {
							aryBasicBuildingFlag[j] = jarrayname.getString(j)
									.toString();
						}
						JSONArray jarrayname2 = rec
								.getJSONArray("militarybuildingflag");
						for (int y = 0; y < jarrayname2.length(); y++) {
							aryMilitaryBuildingFlag[y] = jarrayname2.getString(
									y).toString();
						}
					}
				}
			} catch (JSONException e) {
				for (int i = 0; i < 4; i++) {
					aryBasicBuildingFlag[i] = "0";
				}
				for (int i = 0; i < 8; i++) {
					aryMilitaryBuildingFlag[i] = "0";
				}
			}
			release();

			final ActionBar actionBar = getActionBar();
			actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
			actionBar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);

			actionBar.addTab(actionBar
					.newTab()
					.setText("��������")
					.setTabListener(
							new TabListener(
									new BaseInfoShowTabContentFragment())));

			actionBar.addTab(actionBar
					.newTab()
					.setText("���½���")
					.setTabListener(
							new TabListener(
									new MilitaryInfoShowTabContentFragment())));
		}

		if (this.actioncode == 18) {
			String buildingSFBackFlack = "";
			try {

				JSONObject json = new JSONObject(jsonStr);
				if (json != null) {
					buildingSFBackFlack = json.getString("buildingsfbflag");
				}

			} catch (Exception e) {
				buildingSFBackFlack = "44";
			}
			if (buildingSFBackFlack.equals("1")) {
				Toast.makeText(BuildingActivity.this, "���ڽ���...",
						Toast.LENGTH_SHORT).show();
			} else if (buildingSFBackFlack.equals("0")) {
				Toast.makeText(BuildingActivity.this, "�޷�����ý��������ϲ���",
						Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(BuildingActivity.this, "��������ʧ�ܣ�",
						Toast.LENGTH_SHORT).show();
			}
		}
		release();
	}

	/**
	 * ActionBar��ǩ����
	 * 
	 * @author �ض���
	 * 
	 */
	private class TabListener implements ActionBar.TabListener {
		private Fragment mFragment;

		public TabListener(Fragment fragment) {
			mFragment = fragment;
		}

		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			ft.add(R.id.fragment_content, mFragment);
		}

		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			ft.remove(mFragment);
		}

		public void onTabReselected(Tab tab, FragmentTransaction ft) {
		}
	}

}
