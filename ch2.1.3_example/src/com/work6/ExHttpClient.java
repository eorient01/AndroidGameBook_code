/* ������վ��http://www.androidbks.com
* �ǽ�iOS���ã�http://www.51work6.com
* �ǽ�iOS�������߿��ã�http://v.51work6.com
* �ǽ�iOS��������΢����http://weibo.com/u/3215753973
* ����΢����http://weibo.com/516inc
* �ٷ�csdn���ͣ�http://blog.csdn.net/tonny_guan
* QQ��1575716557 ���䣺jylong06@163.com
*/ 

package com.work6;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ExHttpClient extends Activity {

	final String TAG = "ExHttpClient";

	EditText eText;
	TextView tView;
	Button button;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		eText = (EditText) findViewById(R.id.address);
		tView = (TextView) findViewById(R.id.pagetext);
		button = (Button) findViewById(R.id.ButtonGo);

		button.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				try {

					HttpClient httpclient = new DefaultHttpClient();
					HttpGet httpget = new HttpGet(eText.getText().toString());
					HttpResponse response = httpclient.execute(httpget);
					HttpEntity entityOut = response.getEntity();
					if (entityOut != null) {
						BufferedReader br = new BufferedReader(
								new InputStreamReader(entityOut.getContent(),"gbk"));
						StringBuffer sb = new StringBuffer();
						String line = br.readLine();
						while (line != null) {
							sb.append(line);
							sb.append("\n");
							line = br.readLine();
						}
						br.close();
						Log.i(TAG, sb.toString());
						tView.setText(sb.toString());
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
