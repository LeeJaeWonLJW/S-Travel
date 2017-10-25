package org.androidtown.janicoproject;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class CertificationActivity extends Activity{

    TextView namename, coursecourse;
    ImageView courseimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certification);

        namename = (TextView) findViewById(R.id.namename);
        coursecourse = (TextView) findViewById(R.id.coursecourse);
        courseimage = (ImageView) findViewById(R.id.courseimage);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        int coursenum = prefs.getInt("course", 0);

        switch(coursenum){
            case 1: courseimage.setImageResource(R.drawable.cheonggyecheon);
                break;
            case 2: courseimage.setImageResource(R.drawable.coex);
                break;
            case 3: courseimage.setImageResource(R.drawable.dongdaemoon);
                break;
            case 4: courseimage.setImageResource(R.drawable.gwanghwa);
                break;
            case 5: courseimage.setImageResource(R.drawable.gyeongbok);
                break;
            case 6: courseimage.setImageResource(R.drawable.hanok);
                break;
            case 7: courseimage.setImageResource(R.drawable.hongdae);
                break;
            case 8: courseimage.setImageResource(R.drawable.insadong);
                break;
            case 9: courseimage.setImageResource(R.drawable.itaewon);
                break;
            case 10: courseimage.setImageResource(R.drawable.lottetower);
                break;
            case 11: courseimage.setImageResource(R.drawable.naksan);
                break;
            case 12: courseimage.setImageResource(R.drawable.namdaemoon);
                break;
            case 13: courseimage.setImageResource(R.drawable.namsantower);
                break;
            case 14: courseimage.setImageResource(R.drawable.soongrye);
                break;
        }

        //confirm버튼 누를 시 반영되는 부분
        /*findViewById(R.id.confirm).setOnClickListener(
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
        );*/
    }
}