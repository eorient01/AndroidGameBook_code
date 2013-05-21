/* ������վ��http://www.androidbks.com
* �ǽ�iOS���ã�http://www.51work6.com
* �ǽ�iOS�������߿��ã�http://v.51work6.com
* �ǽ�iOS��������΢����http://weibo.com/u/3215753973
* ����΢����http://weibo.com/516inc
* �ٷ�csdn���ͣ�http://blog.csdn.net/tonny_guan
* QQ��1575716557 ���䣺jylong06@163.com
*/ 

package com.god.holywar;


import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

/**
 * �����Ӧ�ò˵���Activity����
 * 
 * @author �ض���
 *
 */
public abstract class MenuAppActivity extends AppActivity {

	private static final int CASTLE_MENU_ID = Menu.FIRST;// �Ǳ�
	private static final int WARRADAR_MENU_ID = Menu.FIRST + 1;// ս���״�
	private static final int AREAMAP_MENU_ID = Menu.FIRST + 2;// ��ս��ͼ
	private static final int FACTION_MENU_ID = Menu.FIRST + 3;// ����
	private static final int EXIT_MENU_ID = Menu.FIRST + 4;// �˳�

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, CASTLE_MENU_ID, Menu.NONE, R.string.castle);
		menu.add(0, WARRADAR_MENU_ID, Menu.NONE, R.string.warradar);
		menu.add(0, AREAMAP_MENU_ID, Menu.NONE, R.string.areamap);
		menu.add(0, FACTION_MENU_ID, Menu.NONE, R.string.faction);
		menu.add(0, EXIT_MENU_ID, Menu.NONE, R.string.exit);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		Intent i = new Intent();
		
		switch (item.getItemId()) {
		case CASTLE_MENU_ID:
			i.setClassName(this, "com.god.holywar.HolyWarActivity");
			break;
		case AREAMAP_MENU_ID:
			i.setClassName(this, "com.god.holywar.AreaMapActivity");
			break;
		case WARRADAR_MENU_ID:
			i.setClassName(this, "com.god.holywar.WarRadarActivity");
			break;
		case FACTION_MENU_ID:
			i.setClassName(this, "com.god.holywar.FactionActivity");
			break;
		case EXIT_MENU_ID:
			i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			i.setClassName(this, "com.god.holywar.LoginActivity");
			break;
		default:
			i = null;
		}

		if (i != null) {
			this.startActivity(i);
		}

		return super.onOptionsItemSelected(item);
	}
}
