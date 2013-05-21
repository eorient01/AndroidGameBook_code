/* ������վ��http://www.androidbks.com
* �ǽ�iOS���ã�http://www.51work6.com
* �ǽ�iOS�������߿��ã�http://v.51work6.com
* �ǽ�iOS��������΢����http://weibo.com/u/3215753973
* ����΢����http://weibo.com/516inc
* �ٷ�csdn���ͣ�http://blog.csdn.net/tonny_guan
* QQ��1575716557 ���䣺jylong06@163.com
*/ 

package com.god.holywar;


import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Ӧ�õ�¼��Activity
 * 
 * @author �ض���
 * 
 */
public class LoginActivity extends Activity {

	private String its[] = { "�׻�����", "��������" };

	private EditText username;
	private EditText password;

	/** ���紦���߳� */
	private NetThread thread;

	/** �����JSON�ַ��� */
	private String jsonStr;

	/** �������˽ű��ļ� */
	private String url;

	/** ������Ϣ */
	private Handler handler = new MyHandler();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// ȫ����ʾ�����ر�����
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		// ����״̬��
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// ���ֺ���
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

		setContentView(R.layout.login);

		Spinner splogin = (Spinner) findViewById(R.id.login_splongin);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, its);
		splogin.setAdapter(adapter);

		Button btn01 = (Button) findViewById(R.id.login_btnlogin);
		Button btn02 = (Button) findViewById(R.id.login_btnexit);

		btn01.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					JSONArray jsonarr = new JSONArray();
					username = (EditText) findViewById(R.id.login_EditTextUsername);
					password = (EditText) findViewById(R.id.login_EditTextPassword);
					jsonarr.put(0, username.getText().toString().trim());
					jsonarr.put(1, password.getText().toString().trim());

					JSONObject param = new JSONObject();
					param.put("actioncode", 1);
					param.put("data", jsonarr);

					LoginActivity.this.requestURL(param.toString(), "login.php");

				} catch (JSONException e) {
					e.printStackTrace();
					AppUtil.button1Dialog(LoginActivity.this, "����JSON�ַ���ʧ�ܣ�");
					release();
				}

			}

		});

		btn02.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				System.exit(0);
			}

		});

	}

	/**
	 * ����������Դ
	 * 
	 * @param jsonStr
	 *            ���ݸ��������˵Ĳ�����JSON�ַ���
	 */
	protected void requestURL(String jsonStr, String url) {
		this.jsonStr = jsonStr;
		this.url = url;
		thread = new NetThread();
		thread.start();
	}

	/**
	 * �ͷ���Դ�������ϲ��̣߳��رյȴ���ȴ���
	 */
	protected void release() {

		try {
			thread.join();
		} catch (InterruptedException e) {
		}
	}

	class MyHandler extends Handler {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 0:
				if (msg.obj != null) {
					String jsonStr = (String) msg.obj;
					try {
						JSONObject json = new JSONObject(jsonStr);
						if (json != null) {
							String loginflag = json.getString("success");
							AppUtil.verifycode = json.getString("result");
							AppUtil.faction = json.getString("faction");

							AppUtil.heroname = json.getString("heroname");
							AppUtil.herolevel = json.getString("herolevel");

							if (loginflag.equals("true")) {
								Intent it = new Intent(LoginActivity.this,
										HolyWarActivity.class);
								startActivity(it);
							} else {
								AppUtil.button1Dialog(LoginActivity.this,
										"��¼ʧ��,�����µ�¼��");
							}
						}
					} catch (Exception e) {
						AppUtil.button1Dialog(LoginActivity.this,
								"����JSON�ַ���ʧ�ܣ�");
					}
				}
				break;
			case -1:
				AppUtil.button1Dialog(LoginActivity.this, "����JSON�ַ���ʧ�ܣ�");
			}
			release();
			super.handleMessage(msg);
		}
	}

	class NetThread extends Thread {

		@Override
		public void run() {

			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(AppUtil.URL_PREFIX + url);
			try {
				StringEntity se = new StringEntity(jsonStr, "utf-8");
				httppost.setEntity(se);

				httpclient.getParams().setIntParameter(
						HttpConnectionParams.SO_TIMEOUT, 10000); // Socket��ʱ����
				httpclient.getParams().setIntParameter(
						HttpConnectionParams.CONNECTION_TIMEOUT, 10000);// ���ӳ�ʱ����

				HttpResponse response = httpclient.execute(httppost);
				HttpEntity entityOut = response.getEntity();

				if (entityOut != null) {
					BufferedReader br = new BufferedReader(
							new InputStreamReader(entityOut.getContent(),
									"utf-8"));
					StringBuffer sb = new StringBuffer();
					String line;
					while ((line = br.readLine()) != null) {
						sb.append(line);
					}
					Message lmsg;
					lmsg = new Message();
					lmsg.obj = sb == null ? "" : sb.toString();
					lmsg.what = 0;// ����ɹ�
					handler.sendMessage(lmsg);
				}

			} catch (Exception e) {
				handler.sendEmptyMessage(-1);
			}
		}
	}
}