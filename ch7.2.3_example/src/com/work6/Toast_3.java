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
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Toast_3 extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button btn01 = (Button) findViewById(R.id.Button01);
		btn01.setText(R.string.mixtoast);
		btn01.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Toast toast = new Toast(Toast_3.this);
				LinearLayout layout = new LinearLayout(Toast_3.this);
				layout.setOrientation(LinearLayout.VERTICAL);

				ImageView view = new ImageView(Toast_3.this);
				view.setImageResource(R.drawable.image);
				TextView textView = new TextView(Toast_3.this);
				textView.setText("�����");

				layout.addView(view);
				layout.addView(textView);
				toast.setView(layout);
				toast.show();
			}
		});
	}
}