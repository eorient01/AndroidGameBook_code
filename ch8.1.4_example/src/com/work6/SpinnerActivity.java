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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class SpinnerActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final TextView txt2 = (TextView) findViewById(R.id.TextView02);
        Spinner s1 = (Spinner) findViewById(R.id.Spinner01);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.colors, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(adapter);
        s1.setOnItemSelectedListener(
                new OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                            txt2.setText(adapter.getItem(position).toString());
                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                    	txt2.setText("ûѡ�е�");
                    }
                });

        final TextView txt4 = (TextView) findViewById(R.id.TextView04);
        Spinner s2 = (Spinner) findViewById(R.id.Spinner02);
        ArrayAdapter<CharSequence> adapterC = new ArrayAdapter<CharSequence>(this,
                android.R.layout.simple_spinner_item, CONSTELLATIONS);
        adapterC.setDropDownViewResource(android.R.layout.simple_spinner_item);
        s2.setAdapter(adapterC);
        s2.setOnItemSelectedListener(
                new OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                    	txt4.setText(CONSTELLATIONS[position]);
                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                    	txt4.setText("ûѡ�е�");
                    }
                });
    }
    
    static final String[] CONSTELLATIONS = new String[] {
    	"������", "��ţ��", "˫����",
    	"��з��", "ʨ����", "��Ů��",
    	"������", "��Ы��", "������", 
    	"ħЫ��", "ˮƿ��", "˫����"
        };
}