package org.androidtown.janicoproject;

        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.preference.PreferenceManager;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ImageButton;
        import android.widget.ImageView;

    /*
    광화문		gwanghwa
    경복궁		gyeongbok
    숭례문		soongrye
    인사동		insadong
    북촌한옥마을	hanok
    홍대		hongdae
    청계천		cheonggyecheon
    동대문시장	dongdaemoon
    남대문시장	namdaemoon
    남산타워	namsantower
    롯데타워	lottetower
    이태원		itaewon
    낙산공원	naksan
    코엑스		coex
    */

public class MainActivity extends AppCompatActivity{

    private ImageButton[] course = null;
    private ImageView[] coursetext=null;

    int a=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        course = new ImageButton[14];
        coursetext = new ImageView[14];

        //코스 아이디배열
        int[] courseid={R.id.cheonggyecheon, R.id.coex, R.id.dongdaemoon, R.id.gwanghwa, R.id.gyeongbok, R.id.hanok, R.id.hongdae, R.id.insadong, R.id.itaewon, R.id.lottetower, R.id.naksan, R.id.namdaemoon, R.id.namsantower, R.id.soongrye};

        //코스 텍스트아이디배열
        int[] coursetextid={R.id.cheonggyecheon_text, R.id.coex_text, R.id.dongdaemoon_text, R.id.gwanghwa_text, R.id.gyeongbok_text, R.id.hanok_text, R.id.hongdae_text,
                R.id.insadong_text, R.id.itaewon_text, R.id.lottetower_text, R.id.naksan_text, R.id.namdaemoon_text, R.id.namsantower_text, R.id.soongrye_text};

        //코스 이미지배열
        final int[] courseimage={R.drawable.cheonggyecheon, R.drawable.coex, R.drawable.dongdaemoon, R.drawable.gwanghwa, R.drawable.gyeongbok, R.drawable.hanok,
                R.drawable.hongdae, R.drawable.insadong, R.drawable.itaewon, R.drawable.lottetower, R.drawable.naksan, R.drawable.namdaemoon, R.drawable.namsantower, R.drawable.soongrye};

        //코스 텍스트이미지배열
        final int[] coursetextimage={R.drawable.cheonggyecheon_text, R.drawable.coex_text, R.drawable.dongdaemoon_text, R.drawable.gwanghwa_text, R.drawable.gyeongbok_text, R.drawable.hanok_text,
                R.drawable.hongdae_text, R.drawable.insadong_text, R.drawable.itaewon_text, R.drawable.lottetower_text, R.drawable.naksan_text, R.drawable.namdaemoon_text, R.drawable.namsantower_text, R.drawable.soongrye_text};

        //아이디별로 버튼 지정
        for(int i=0;i<14;i++){
            this.course[i]=(ImageButton) findViewById(courseid[i]);
            this.coursetext[i]=(ImageView) findViewById(coursetextid[i]);
            this.course[i].setEnabled(false);
        }

        //지금은 타이틀바 제일 오른쪽 사람모양 클릭하면 a가 하나씩 증가하면서
        //하나씩 색칠되게 해놨다 알아서 바꿔랑
        findViewById(R.id.rightmenu).setOnClickListener(
                new ImageButton.OnClickListener() {
                    public void onClick(View v) {
                        course[a].setImageResource(courseimage[a]);
                        coursetext[a].setImageResource(coursetextimage[a]);
                        course[a].setEnabled(true);
                        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("course", a);
                        editor.commit();
                        a++;
                    }
                }
        );
        //버튼 구현
        for(int i=0;i<14;i++) {
            course[i].setOnClickListener(
                    new ImageButton.OnClickListener() {
                        public void onClick(View v) {
                            Intent intent = new Intent(MainActivity.this, CertificationActivity.class);
                            startActivity(intent);
                        }
                    }
            );
        }
    }
}