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

		setContentView(R.layout.faction01);

		ImageButton imgbtn11 = (ImageButton) findViewById(R.id.faction01_ImageButton11);
		if (arySpiritMountain[0].equals("")) {
			imgbtn11.setBackgroundResource(R.drawable.spirit_mountain01);
		} else {
			imgbtn11.setBackgroundResource(R.drawable.spirit_mountain02);
		}
		imgbtn11.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String name = "˴Դ��" + arySpiritMountain[0];
				Toast.makeText(FactionActivity.this, name, Toast.LENGTH_SHORT)
						.show();

			}
		});

		ImageButton imgbtn12 = (ImageButton) findViewById(R.id.faction01_ImageButton12);
		if (arySpiritMountain[1].equals("")) {
			imgbtn12.setBackgroundResource(R.drawable.spirit_mountain01);
		} else {
			imgbtn12.setBackgroundResource(R.drawable.spirit_mountain02);
		}
		imgbtn12.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String name = "���ط�" + arySpiritMountain[1];
				Toast.makeText(FactionActivity.this, name, Toast.LENGTH_SHORT)
						.show();
			}
		});

		ImageButton imgbtn13 = (ImageButton) findViewById(R.id.faction01_ImageButton13);
		if (arySpiritMountain[2].equals("")) {
			imgbtn13.setBackgroundResource(R.drawable.spirit_mountain01);
		} else {
			imgbtn13.setBackgroundResource(R.drawable.spirit_mountain02);
		}
		imgbtn13.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String name = "��ַ�" + arySpiritMountain[2];
				Toast.makeText(FactionActivity.this, name, Toast.LENGTH_SHORT)
						.show();
			}
		});

		ImageButton imgbtn14 = (ImageButton) findViewById(R.id.faction01_ImageButton14);
		if (arySpiritMountain[3].equals("")) {
			imgbtn14.setBackgroundResource(R.drawable.spirit_mountain01);
		} else {
			imgbtn14.setBackgroundResource(R.drawable.spirit_mountain02);
		}
		imgbtn14.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(FactionActivity.this,
						"ŮӢ��" + arySpiritMountain[3], Toast.LENGTH_SHORT)
						.show();

			}
		});

		ImageButton imgbtn15 = (ImageButton) findViewById(R.id.faction01_ImageButton15);
		if (arySpiritMountain[4].equals("")) {
			imgbtn15.setBackgroundResource(R.drawable.spirit_mountain01);
		} else {
			imgbtn15.setBackgroundResource(R.drawable.spirit_mountain02);
		}
		imgbtn15.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String name = "���ַ�" + arySpiritMountain[4];
				Toast.makeText(FactionActivity.this, name, Toast.LENGTH_SHORT)
						.show();

			}
		});

		ImageButton imgbtn16 = (ImageButton) findViewById(R.id.faction01_ImageButton16);
		if (arySpiritMountain[5].equals("")) {
			imgbtn16.setBackgroundResource(R.drawable.spirit_mountain01);
		} else {
			imgbtn16.setBackgroundResource(R.drawable.spirit_mountain02);
		}
		imgbtn16.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String name = "ʯ¥��" + arySpiritMountain[5];
				Toast.makeText(FactionActivity.this, name, Toast.LENGTH_SHORT)
						.show();

			}
		});

		ImageButton imgbtn17 = (ImageButton) findViewById(R.id.faction01_ImageButton17);
		if (arySpiritMountain[6].equals("")) {
			imgbtn17.setBackgroundResource(R.drawable.spirit_mountain01);
		} else {
			imgbtn17.setBackgroundResource(R.drawable.spirit_mountain02);
		}
		imgbtn17.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String name = "��ʷ�" + arySpiritMountain[6];
				Toast.makeText(FactionActivity.this, name, Toast.LENGTH_SHORT)
						.show();
			}
		});

		ImageButton imgbtn18 = (ImageButton) findViewById(R.id.faction01_ImageButton18);
		if (arySpiritMountain[7].equals("")) {
			imgbtn18.setBackgroundResource(R.drawable.spirit_mountain01);
		} else {
			imgbtn18.setBackgroundResource(R.drawable.spirit_mountain02);
		}
		imgbtn18.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String name = "ʯ���" + arySpiritMountain[7];
				Toast.makeText(FactionActivity.this, name, Toast.LENGTH_SHORT)
						.show();
			}
		});

		ImageButton imgbtn19 = (ImageButton) findViewById(R.id.faction01_ImageButton19);
		if (arySpiritMountain[8].equals("")) {
			imgbtn19.setBackgroundResource(R.drawable.spirit_mountain01);
		} else {
			imgbtn19.setBackgroundResource(R.drawable.spirit_mountain02);
		}
		imgbtn19.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String name = "������" + arySpiritMountain[8];
				Toast.makeText(FactionActivity.this, name, Toast.LENGTH_SHORT)
						.show();
			}
		});

		if (AppUtil.faction.equals(AppUtil.FACTION_FAIRYLAND)) {
			ImageButton imgbtn01 = (ImageButton) findViewById(R.id.faction01_ImageButton911);
			imgbtn01.setBackgroundResource(R.drawable.spirit_mountain_challenge01);
			imgbtn01.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Intent it = new Intent(FactionActivity.this,
							ChallengeActivity.class);
					it.putExtra("spirit_mountain_name", "˴Դ��");
					startActivity(it);

				}
			});

			ImageButton imgbtn02 = (ImageButton) findViewById(R.id.faction01_ImageButton912);
			imgbtn02.setBackgroundResource(R.drawable.spirit_mountain_challenge01);
			imgbtn02.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Intent it = new Intent(FactionActivity.this,
							ChallengeActivity.class);
					it.putExtra("spirit_mountain_name", "���ط�");
					startActivity(it);

				}
			});

			ImageButton imgbtn03 = (ImageButton) findViewById(R.id.faction01_ImageButton913);
			imgbtn03.setBackgroundResource(R.drawable.spirit_mountain_challenge02);

			ImageButton imgbtn04 = (ImageButton) findViewById(R.id.faction01_ImageButton914);
			imgbtn04.setBackgroundResource(R.drawable.spirit_mountain_challenge01);
			imgbtn04.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Intent it = new Intent(FactionActivity.this,
							ChallengeActivity.class);
					it.putExtra("spirit_mountain_name", "ŮӢ��");
					startActivity(it);

				}
			});
			ImageButton imgbtn05 = (ImageButton) findViewById(R.id.faction01_ImageButton915);
			imgbtn05.setBackgroundResource(R.drawable.spirit_mountain_challenge01);
			imgbtn05.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Intent it = new Intent(FactionActivity.this,
							ChallengeActivity.class);
					it.putExtra("spirit_mountain_name", "���ַ�");
					startActivity(it);

				}
			});
			ImageButton imgbtn06 = (ImageButton) findViewById(R.id.faction01_ImageButton916);
			imgbtn06.setBackgroundResource(R.drawable.spirit_mountain_challenge01);
			imgbtn06.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Intent it = new Intent(FactionActivity.this,
							ChallengeActivity.class);
					it.putExtra("spirit_mountain_name", "ʯ¥��");
					startActivity(it);

				}
			});

			ImageButton imgbtn07 = (ImageButton) findViewById(R.id.faction01_ImageButton917);
			imgbtn07.setBackgroundResource(R.drawable.spirit_mountain_challenge02);
			ImageButton imgbtn08 = (ImageButton) findViewById(R.id.faction01_ImageButton918);
			imgbtn08.setBackgroundResource(R.drawable.spirit_mountain_challenge02);
			ImageButton imgbtn09 = (ImageButton) findViewById(R.id.faction01_ImageButton919);
			imgbtn09.setBackgroundResource(R.drawable.spirit_mountain_challenge02);

		} else if (AppUtil.faction.equals(AppUtil.FACTION_GHOSTLAND)) {
			ImageButton imgbtn01 = (ImageButton) findViewById(R.id.faction01_ImageButton911);
			imgbtn01.setBackgroundResource(R.drawable.spirit_mountain_challenge01);
			imgbtn01.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Intent it = new Intent(FactionActivity.this,
							ChallengeActivity.class);
					it.putExtra("spirit_mountain_name", "˴Դ��");
					startActivity(it);

				}
			});

			ImageButton imgbtn02 = (ImageButton) findViewById(R.id.faction01_ImageButton912);
			imgbtn02.setBackgroundResource(R.drawable.spirit_mountain_challenge02);

			ImageButton imgbtn03 = (ImageButton) findViewById(R.id.faction01_ImageButton913);
			imgbtn03.setBackgroundResource(R.drawable.spirit_mountain_challenge01);
			imgbtn03.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Intent it = new Intent(FactionActivity.this,
							ChallengeActivity.class);
					it.putExtra("spirit_mountain_name", "��ַ�");
					startActivity(it);

				}
			});

			ImageButton imgbtn04 = (ImageButton) findViewById(R.id.faction01_ImageButton914);
			imgbtn04.setBackgroundResource(R.drawable.spirit_mountain_challenge02);

			ImageButton imgbtn05 = (ImageButton) findViewById(R.id.faction01_ImageButton915);
			imgbtn05.setBackgroundResource(R.drawable.spirit_mountain_challenge02);

			ImageButton imgbtn06 = (ImageButton) findViewById(R.id.faction01_ImageButton916);
			imgbtn06.setBackgroundResource(R.drawable.spirit_mountain_challenge02);

			ImageButton imgbtn07 = (ImageButton) findViewById(R.id.faction01_ImageButton917);
			imgbtn07.setBackgroundResource(R.drawable.spirit_mountain_challenge01);
			imgbtn07.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Intent it = new Intent(FactionActivity.this,
							ChallengeActivity.class);
					it.putExtra("spirit_mountain_name", "��ʷ�");
					startActivity(it);

				}
			});

			ImageButton imgbtn08 = (ImageButton) findViewById(R.id.faction01_ImageButton918);
			imgbtn08.setBackgroundResource(R.drawable.spirit_mountain_challenge01);
			imgbtn08.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Intent it = new Intent(FactionActivity.this,
							ChallengeActivity.class);
					it.putExtra("spirit_mountain_name", "ʯ���");
					startActivity(it);

				}
			});
			ImageButton imgbtn09 = (ImageButton) findViewById(R.id.faction01_ImageButton918);
			imgbtn09.setBackgroundResource(R.drawable.spirit_mountain_challenge01);
			imgbtn09.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Intent it = new Intent(FactionActivity.this,
							ChallengeActivity.class);
					it.putExtra("spirit_mountain_name", "������");
					startActivity(it);

				}
			});
		}
	}

}
