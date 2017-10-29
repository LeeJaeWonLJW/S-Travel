package org.androidtown.janicoproject;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class CertificationActivity extends Activity{

    TextView namename, coursecourse;
    ImageView image;
    Button confirm;

    //데이터베이스부분
    int version=1;
    DBHelper dbhelper;
    SQLiteDatabase database;
    //데이터베이스부분

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certification);
        this.setFinishOnTouchOutside(false);


        namename = (TextView) findViewById(R.id.namename);
        coursecourse = (TextView) findViewById(R.id.coursecourse);
        confirm=(Button) findViewById(R.id.confirm);
        image = (ImageView) findViewById(R.id.courseimage);

        //데이터베이스부분
        dbhelper = new DBHelper(CertificationActivity.this, DBHelper.tableName, null, version);
        database= dbhelper.getWritableDatabase();
        //데이터베이스부분

        //코스 이미지 배열
        int[] courseimage={R.drawable.cheonggyecheon, R.drawable.coex, R.drawable.dongdaemoon, R.drawable.gwanghwa, R.drawable.gyeongbok, R.drawable.hanok,
                R.drawable.hongdae, R.drawable.insadong, R.drawable.itaewon, R.drawable.lottetower, R.drawable.naksan, R.drawable.namdaemoon, R.drawable.namsantower, R.drawable.soongrye};
        //코스 한글이름
        String[] coursename={"청계천", "코엑스", "동대문시장", "광화문", "경복궁", "북촌한옥마을", "홍대", "인사동", "이태원", "롯데타워", "낙산공원", "남대문시장", "남산타워", "숭례문"};

        //SettingActivity 에서 Intent로 이미지변수 받아오기
        Intent intent = getIntent();
        int coursenum=intent.getIntExtra("course", 0);

        //이미지 바꾸기
        image.setImageResource(courseimage[coursenum]);
        coursecourse.setText(coursename[coursenum]);
        final int coursenumnum=coursenum;

        //도장확인버튼 누르면 db로 정보 업데이트
       confirm.setOnClickListener(
                new ImageButton.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(CertificationActivity.this, MainActivity.class);
                        startActivity(intent);
                        dbhelper.updateStatus(database, coursenumnum);
                        finish();
                    }
                }
        );
    }
}