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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;

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

			ActionBar.Tab totalInfoTab = actionBar
					.newTab()
					.setText("����")
					.setTabListener(
							new TabListener(new TotalInfoTabContentFragment()));
			ActionBar.Tab dispatchArmyTab = actionBar
					.newTab()
					.setText("����")
					.setTabListener(
							new TabListener(
									new DispatchArmyTabContentFragment()));
			ActionBar.Tab armyInfoTab = actionBar
					.newTab()
					.setText("����")
					.setTabListener(
							new TabListener(new ArmyInfoTabContentFragment()));
			actionBar.addTab(totalInfoTab);
			actionBar.addTab(dispatchArmyTab);
			actionBar.addTab(armyInfoTab);

			if (sendarmy == 2) {// ս���״�ҳ��
				actionBar.selectTab(dispatchArmyTab);// �趨����Tabѡ��
			} else {
				actionBar.selectTab(totalInfoTab);// �趨���� Tabѡ��
			}
		}
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

	/**
	 * ���� Fragment
	 * 
	 * @author �ض���
	 * 
	 */
	private class TotalInfoTabContentFragment extends Fragment {
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			LayoutInflater factory = LayoutInflater
					.from(GrandCouncilActivity.this);
			final View totalInfoView = factory.inflate(
					R.layout.grand_council02, null);
			// ������������
			TextView txtTransportAmount = (TextView) totalInfoView
					.findViewById(R.id.grand_council01_transport_amount);
			TextView txtScoutAmount = (TextView) totalInfoView
					.findViewById(R.id.grand_council01_scout_amount);
			TextView txtMilitiaAmount = (TextView) totalInfoView
					.findViewById(R.id.grand_council01_militia_amount);
			TextView txtSpearmanAmount = (TextView) totalInfoView
					.findViewById(R.id.grand_council01_spearman_amount);
			TextView txtAssassinAmount = (TextView) totalInfoView
					.findViewById(R.id.grand_council01_assassin_amount);
			TextView txtMilitaryGeneralAmount = (TextView) totalInfoView
					.findViewById(R.id.grand_council01_military_general_amount);
			TextView txtMarksmanAmount = (TextView) totalInfoView
					.findViewById(R.id.grand_council01_marksman_amount);
			TextView txtVoodoomanAmount = (TextView) totalInfoView
					.findViewById(R.id.grand_council01_voodoo_man_amount);
			TextView txtWarriorAmount = (TextView) totalInfoView
					.findViewById(R.id.grand_council01_warrior_amount);
			TextView txtBatteringRamAmount = (TextView) totalInfoView
					.findViewById(R.id.grand_council01_battering_ram_amount);
			TextView txtCatapultAmount = (TextView) totalInfoView
					.findViewById(R.id.grand_council01_catapult_amount);

			txtTransportAmount.setText(aryGrandCouncil[0]);
			txtScoutAmount.setText(aryGrandCouncil[1]);
			txtMilitiaAmount.setText(aryGrandCouncil[2]);
			txtSpearmanAmount.setText(aryGrandCouncil[3]);
			txtAssassinAmount.setText(aryGrandCouncil[4]);
			txtMilitaryGeneralAmount.setText(aryGrandCouncil[5]);
			txtMarksmanAmount.setText(aryGrandCouncil[6]);
			txtVoodoomanAmount.setText(aryGrandCouncil[7]);
			txtWarriorAmount.setText(aryGrandCouncil[8]);
			txtBatteringRamAmount.setText(aryGrandCouncil[9]);
			txtCatapultAmount.setText(aryGrandCouncil[10]);

			// ������������
			TextView txtSoldierPayAmount = (TextView) totalInfoView
					.findViewById(R.id.txtSoldierPayAmount);
			// ��������
			txtSoldierPayAmount.setText(strSoldierPayAmount);

			// �������������Դ����������
			final EditText txtDispatchTransportCount = (EditText) totalInfoView
					.findViewById(R.id.grand_council01_dispatch_scout_amount);
			txtDispatchTransportCount.setOnKeyListener(new OnKeyListener() {

				@Override
				public boolean onKey(View v, int keyCode, KeyEvent event) {
					if (event.getAction() == KeyEvent.ACTION_UP) {
						String num1 = txtDispatchTransportCount.getText()
								.toString();
						Long num = 0L;
						try {
							num = 6000 * Long.parseLong(num1);
						} catch (Exception e) {
						}
						String numlast = String.valueOf(num);
						TextView keyunshuziyuanzongliangshuliang = (TextView) totalInfoView
								.findViewById(R.id.grand_council01_transport_total_count);
						keyunshuziyuanzongliangshuliang.setText(numlast);
					}
					return false;
				}
			});

			// �Լ��ĳǱ�spinner
			Spinner spinner = (Spinner) totalInfoView
					.findViewById(R.id.grand_council01_spinner_castle_name);
			spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {

				@Override
				public void onItemSelected(AdapterView<?> apv, View view,
						int pos, long id) {
					selectGrandCouncil = aryCastleList[pos];
				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {

				}
			});

			ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(
					GrandCouncilActivity.this,
					android.R.layout.simple_spinner_item, aryCastleList);
			adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			spinner.setAdapter(adapter1);

			return totalInfoView;
		}
	}

	/**
	 * �������� Fragment
	 * 
	 * @author �ض���
	 * 
	 */
	private class DispatchArmyTabContentFragment extends Fragment {
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {

			LayoutInflater factory = LayoutInflater
					.from(GrandCouncilActivity.this);
			final View dispatchArmyView = factory.inflate(
					R.layout.grand_council03, null);

			LinearLayout hidvisaa = (LinearLayout) dispatchArmyView
					.findViewById(R.id.grand_council03_hidvisaa);
			LinearLayout hidvisbb = (LinearLayout) dispatchArmyView
					.findViewById(R.id.grand_council03_hidvisbb);
			LinearLayout hidviscc = (LinearLayout) dispatchArmyView
					.findViewById(R.id.grand_council03_hidviscc);
			LinearLayout hidvisdd = (LinearLayout) dispatchArmyView
					.findViewById(R.id.grand_council03_hidvisdd);

			final CheckBox ckbhero = (CheckBox) dispatchArmyView
					.findViewById(R.id.grand_council03_ckb_hero);

			// 0��û��Ӣ��
			if (AppUtil.herolevel.equals("0")) {
				hidvisaa.setVisibility(View.VISIBLE);
				hidvisbb.setVisibility(View.GONE);
				hidviscc.setVisibility(View.GONE);
				hidvisdd.setVisibility(View.GONE);
			} else {
				hidvisaa.setVisibility(View.GONE);
				hidvisbb.setVisibility(View.VISIBLE);
				hidviscc.setVisibility(View.VISIBLE);
				hidvisdd.setVisibility(View.VISIBLE);
				ckbhero.setText(AppUtil.heroname);
			}

			// ����������������������
			TextView bing01 = (TextView) dispatchArmyView
					.findViewById(R.id.grand_council03_bing01);
			TextView bing02 = (TextView) dispatchArmyView
					.findViewById(R.id.grand_council03_bing02);
			TextView bing03 = (TextView) dispatchArmyView
					.findViewById(R.id.grand_council03_bing03);
			TextView bing04 = (TextView) dispatchArmyView
					.findViewById(R.id.grand_council03_bing04);
			TextView bing05 = (TextView) dispatchArmyView
					.findViewById(R.id.grand_council03_bing05);
			TextView bing06 = (TextView) dispatchArmyView
					.findViewById(R.id.grand_council03_bing06);
			TextView bing07 = (TextView) dispatchArmyView
					.findViewById(R.id.grand_council03_bing07);
			TextView bing08 = (TextView) dispatchArmyView
					.findViewById(R.id.grand_council03_bing08);
			TextView bing09 = (TextView) dispatchArmyView
					.findViewById(R.id.grand_council03_bing09);
			TextView bing10 = (TextView) dispatchArmyView
					.findViewById(R.id.grand_council03_bing10);
			TextView bing11 = (TextView) dispatchArmyView
					.findViewById(R.id.grand_council03_bing11);
			bing01.setText(aryGrandCouncil[0]);
			bing02.setText(aryGrandCouncil[1]);
			bing03.setText(aryGrandCouncil[2]);
			bing04.setText(aryGrandCouncil[3]);
			bing05.setText(aryGrandCouncil[4]);
			bing06.setText(aryGrandCouncil[5]);
			bing07.setText(aryGrandCouncil[6]);
			bing08.setText(aryGrandCouncil[7]);
			bing09.setText(aryGrandCouncil[8]);
			bing10.setText(aryGrandCouncil[9]);
			bing11.setText(aryGrandCouncil[10]);

			// ++++++++++++++++++++ ++++++++++++++++++++
			// �����������
			final RadioGroup radiogroup01 = (RadioGroup) dispatchArmyView
					.findViewById(R.id.grand_council03_radiogroup01);
			radiogroup01
					.setOnCheckedChangeListener(new OnCheckedChangeListener() {

						@Override
						public void onCheckedChanged(RadioGroup group,
								int checkedId) {
							RadioButton rb = (RadioButton) radiogroup01
									.findViewById(checkedId);
							skill2 = rb.getText().toString();

						}
					});

			// ��õ�ѡ��ť����Ԯ�뷢��
			RadioGroup radiogroup02 = (RadioGroup) dispatchArmyView
					.findViewById(R.id.grand_council03_radiogroup02);
			radiogroup02
					.setOnCheckedChangeListener(new OnCheckedChangeListener() {

						@Override
						public void onCheckedChanged(RadioGroup group,
								int checkedId) {
							RadioButton rb = (RadioButton) dispatchArmyView
									.findViewById(checkedId);
							attack = rb.getText().toString();
						}
					});
			Button btnDispatchSoldier = (Button) dispatchArmyView
					.findViewById(R.id.grand_council03_dispatch_soldier);
			btnDispatchSoldier.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					String herostate = "0";
					// ��Ӣ�� ����ѡ��
					if (AppUtil.herolevel.equals("1") && ckbhero.isChecked()) {
						herostate = "1";
					}
					TextView txtSkill2 = (TextView) findViewById(R.id.grand_council03_hero_skill2);
					String hero_skill2 = txtSkill2.getText().toString();

					// ��÷����ı�����Ϣ
					// �����
					EditText txtTransportAmount = (EditText) dispatchArmyView
							.findViewById(R.id.grand_council03_transport_amount);
					// ����
					EditText txtScoutAmount = (EditText) dispatchArmyView
							.findViewById(R.id.grand_council03_scout_amount);
					// ���
					EditText txtMilitiaAmount = (EditText) dispatchArmyView
							.findViewById(R.id.grand_council03_militia_amount);
					// ǹ��
					EditText txtSpearmanAmount = (EditText) dispatchArmyView
							.findViewById(R.id.grand_council03_spearman_amount);
					// �̿�
					EditText txtAssassinAmount = (EditText) dispatchArmyView
							.findViewById(R.id.grand_council03_assassin_amount);
					// ����
					EditText txtMilitaryGeneralAmount = (EditText) dispatchArmyView
							.findViewById(R.id.grand_council03_military_general_amount);
					// ������
					EditText txtMarksmanAmount = (EditText) dispatchArmyView
							.findViewById(R.id.grand_council03_marksman_amount);
					// �׶���ʿ
					EditText txtVoodooManAmount = (EditText) dispatchArmyView
							.findViewById(R.id.grand_council03_voodoo_man_amount);
					// ��ʿ
					EditText txtWarriorAmount = (EditText) dispatchArmyView
							.findViewById(R.id.grand_council03_warrior_amount);
					// ��ײ��
					EditText txtBatteringRramAmount = (EditText) dispatchArmyView
							.findViewById(R.id.grand_council03_battering_ram_amount);
					// Ͷʯ��
					EditText txtCatapultAmount = (EditText) dispatchArmyView
							.findViewById(R.id.grand_council03_catapult_amount);

					// ���������������з����ı�����Ϣ
					String sendsoldieramount[] = new String[11];
					sendsoldieramount[0] = txtTransportAmount.getText()
							.toString();
					sendsoldieramount[1] = txtScoutAmount.getText().toString();
					sendsoldieramount[2] = txtMilitiaAmount.getText()
							.toString();
					sendsoldieramount[3] = txtSpearmanAmount.getText()
							.toString();
					sendsoldieramount[4] = txtAssassinAmount.getText()
							.toString();
					sendsoldieramount[5] = txtMilitaryGeneralAmount.getText()
							.toString();
					sendsoldieramount[6] = txtMarksmanAmount.getText()
							.toString();
					sendsoldieramount[7] = txtVoodooManAmount.getText()
							.toString();
					sendsoldieramount[8] = txtWarriorAmount.getText()
							.toString();
					sendsoldieramount[9] = txtBatteringRramAmount.getText()
							.toString();
					sendsoldieramount[10] = txtCatapultAmount.getText()
							.toString();
					try {
						JSONObject json02 = new JSONObject();
						json02.put("herostate", herostate);
						JSONObject json03 = new JSONObject();
						json03.put("skill2", hero_skill2);
						JSONObject json04 = new JSONObject();
						json04.put("skill1", skill2);

						JSONArray ssa = new JSONArray();
						for (int i = 0; i < sendsoldieramount.length; i++) {
							ssa.put(i, sendsoldieramount[i]);
						}
						JSONObject json05 = new JSONObject();
						json05.put("sendsoldieramount", ssa);

						JSONObject json06 = new JSONObject();
						json06.put("reinforcedefend", attack);

						JSONObject json07 = new JSONObject();
						// ��ó��������
						EditText grand_council03_city_name = (EditText) dispatchArmyView
								.findViewById(R.id.grand_council03_city_name);
						json07.put("attackplacename", grand_council03_city_name
								.getText().toString());

						JSONArray jsonarr = new JSONArray();
						jsonarr.put(0, json02);
						jsonarr.put(1, json03);
						jsonarr.put(2, json04);
						jsonarr.put(3, json05);
						jsonarr.put(4, json06);
						jsonarr.put(5, json07);

						JSONObject param = new JSONObject();
						param.put("verifycode", AppUtil.verifycode);
						param.put("actioncode", 26);
						param.put("data", jsonarr);
						GrandCouncilActivity.this.actioncode = 26;

						requestURL(param.toString(), "grand_council.php");

					} catch (JSONException e) {
						e.printStackTrace();
						AppUtil.button1Dialog(GrandCouncilActivity.this,
								"����JSON�ַ���ʧ�ܣ�");
						release();
					}

				}
			});

			return dispatchArmyView;
		}
	}

	/**
	 * ���� Fragment
	 * 
	 * @author �ض���
	 * 
	 */
	private class ArmyInfoTabContentFragment extends Fragment {
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {

			LayoutInflater factory = LayoutInflater
					.from(GrandCouncilActivity.this);
			final View armyInfoView = factory.inflate(R.layout.grand_council04,
					null);

			// ������������
			ArrayList<HashMap<String, Object>> listData = new ArrayList<HashMap<String, Object>>();
			for (int i = 0; i < warnumber; i++) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("warinfo", war[i][0]);
				map.put("hero_copy", war[i][1]);
				map.put("dispatch_army_amount", war[i][2]);
				map.put("enddate", war[i][3]);
				listData.add(map);
			}

			SimpleAdapter adapter = new SimpleAdapter(
					GrandCouncilActivity.this, listData,
					R.layout.grand_council05, new String[] { "warinfo",
							"hero_copy", "dispatch_army_amount", "enddate" },
					new int[] { R.id.grand_council05_textview1,
							R.id.grand_council05_textview2,
							R.id.grand_council05_textview3,
							R.id.grand_council05_textview4 });

			final ListView list1 = (ListView) armyInfoView
					.findViewById(R.id.grand_council04_listview);
			list1.setAdapter(adapter);

			return armyInfoView;
		}
	}
	
	@Override
	protected boolean showWindowTitle() {
		return true;
	}


}
