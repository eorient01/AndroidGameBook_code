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
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {

	private final static String TAG = "LoginActivity";
	private EditText userid;
	private EditText pwd;
	private Button btnLogin;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		btnLogin = (Button) findViewById(R.id.btnLogin);
		userid = (EditText) findViewById(R.id.userid);
		pwd = (EditText) findViewById(R.id.password);

		btnLogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (userid.getText().toString().equals("tony")
						&& pwd.getText().toString().equals("1")) {
					Intent it = new Intent(LoginActivity.this,
							SuccessActivity.class);
					it.putExtra("userid", userid.getText().toString());
					startActivityForResult(it, 1);
				} else {
					Intent it = new Intent(LoginActivity.this,
							FailureActivity.class);
					startActivityForResult(it, 2);
				}
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case 1:
			// ��¼�ɹ�֮�󷵻صġ�
			Log.v(TAG, "from success activity return. resultCode=" + resultCode);
			break;
		case 2:
			// ��¼ʧ��֮�󷵻صġ�
			Log.v(TAG, "from failure activity return. resultCode=" + resultCode);
		}
		super.onActivityResult(requestCode, resultCode, data);

	}

}