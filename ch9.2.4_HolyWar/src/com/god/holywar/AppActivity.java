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

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.view.WindowManager;

/**
 * Ӧ��Activity���࣬��װ������ͨѶ���̡߳�
 * 
 * @author �ض���
 * 
 */
public abstract class AppActivity extends Activity {

	/** ���紦���߳� */
	private NetThread thread;

	/** �����JSON�ַ��� */
	private String jsonStr;

	/** �������˽ű��ļ� */
	private String url;

	/** ������Ϣ */
	private Handler handler = new MyHandler();

	/**
	 * ���������������Ľ��
	 * 
	 * @param jsonStr
	 *            �ӷ������˷��ص�JSON�ַ���
	 */
	protected abstract void handleResult(String jsonStr);

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
		showDialog(1);

	}

	/**
	 * �ͷ���Դ�������ϲ��̣߳��رյȴ���ȴ���
	 */
	protected void release() {

		dismissDialog(1);
		try {
			thread.join();
		} catch (InterruptedException e) {
		}
	}

	/**
	 * ������д���������Ƿ���ʾ���ڱ���
	 * 
	 * @return false �ǲ���ʾ true ����ʾ
	 */
	protected boolean showWindowTitle() {
		return false;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (!showWindowTitle()) {
			// ȫ����ʾ�����ر�����
			requestWindowFeature(Window.FEATURE_NO_TITLE);
		}
		// ����״̬��
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// ���ֺ���
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		ProgressDialog dialog = new ProgressDialog(this);
		dialog.setMessage("���Ժ�...");
		dialog.setIndeterminate(true);
		dialog.setCancelable(true);
		return dialog;
	}

	class MyHandler extends Handler {
		@Override
		public void handleMessage(Message msg) {
			// process incoming messages here
			switch (msg.what) {
			case 0:
				if (msg.obj != null) {
					String jsonStr = (String) msg.obj;
					handleResult(jsonStr);
				} else {
					dismissDialog(1);
				}
				break;
			case -1:
				AppUtil.button1Dialog(AppActivity.this, "�����쳣����");				
				break;
			case -2:
				AppUtil.button1Dialog(AppActivity.this, "�뵽androidbks.comע�ᣬ�滻AppUtil.email!");				
			}
			try {
				thread.join();
			} catch (InterruptedException e) {
			}
			super.handleMessage(msg);
		}
	}

	class NetThread extends Thread {

		@Override
		public void run() {

			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(AppUtil.URL_PREFIX + url + "?email=" +AppUtil.email);
			try {
				// StringEntity se = new StringEntity(jsonStr);
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
					if (sb == null || sb.toString().equals("")) {
						handler.sendEmptyMessage(-2); //����Ȩ�û�����
					} else {						
						Message lmsg;
						lmsg = new Message();
						lmsg.obj = sb == null ? "" : sb.toString();
						lmsg.what = 0;// ����ɹ�
						handler.sendMessage(lmsg);
					}
				}

			} catch (Exception e) {
				handler.sendEmptyMessage(-1);
			}
		}
	}

}
