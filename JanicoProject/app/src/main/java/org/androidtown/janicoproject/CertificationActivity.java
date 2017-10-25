package org.androidtown.janicoproject;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class CertificationActivity extends Activity{

    TextView namename, coursecourse;
    ImageView courseimage;
    LinearLayout imageLayout;
    int coursenum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certification);

        namename = (TextView) findViewById(R.id.namename);
        coursecourse = (TextView) findViewById(R.id.coursecourse);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        int coursenum = prefs.getInt("course", 0);

        if(coursenum==1){
            courseimage.setImageResource(R.drawable.cheonggyecheon);
        }

        //confirm버튼 누를 시 반영되는 부분
        findViewById(R.id.confirm).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        name = nameinput.getText().toString();
                        date = dateinput.getText().toString();
                        namename.setText(name);
                        coursecourse.setImageResource(R.drawable.soongrye);
                        datedate.setText(date);
                        capture.setVisibility(View.VISIBLE);
                    }
                }
        );

        //사진 캡쳐 후 저장 알아서 구현해라 난 모른다ㅜㅜ
        //id가 certification인 리니어 레이아웃을 캡쳐 한 후 저장하면된다
        findViewById(R.id.capture).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v){

                    }
                }
        );
    }
}