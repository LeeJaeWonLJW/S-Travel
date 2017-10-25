package org.androidtown.janicoproject;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class CertificationActivity extends Activity{

    TextView namename, coursecourse;
    ImageView image;
    ImageButton closebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certification);

        namename = (TextView) findViewById(R.id.namename);
        coursecourse = (TextView) findViewById(R.id.coursecourse);
        closebutton = (ImageButton) findViewById(R.id.closebutton);

        //코스 이미지 배열
        int[] courseimage={R.drawable.cheonggyecheon, R.drawable.coex, R.drawable.dongdaemoon, R.drawable.gwanghwa, R.drawable.gyeongbok, R.drawable.hanok,
                R.drawable.hongdae, R.drawable.insadong, R.drawable.itaewon, R.drawable.lottetower, R.drawable.naksan, R.drawable.namdaemoon, R.drawable.namsantower, R.drawable.soongrye};

        String[] coursename={"청계천", "코엑스", "동대문시장", "광화문", "경복궁", "북촌한옥마을", "홍대", "인사동", "이태원", "롯데타워", "낙산공원", "남대문시장", "남산타워", "숭례문"};

        image = (ImageView) findViewById(R.id.courseimage);

        //이미지변수 받아오기
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        int coursenum = prefs.getInt("course", 0);

        //이미지 바꾸기
        image.setImageResource(courseimage[coursenum]);
        coursecourse.setText(coursename[coursenum]);

        closebutton.setOnClickListener(
                new ImageButton.OnClickListener() {
                    public void onClick(View v) {
                        finish();
                    }
                }
        );

    }
}