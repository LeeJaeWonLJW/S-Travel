package a0x7e1.stravel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.makeText;

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

public class StampActivity extends AppCompatActivity{

    private ImageButton[] course = null;
    private ImageView[] coursetext=null;

    //데이터베이스부분
    int version=1;
    DBHelper dbhelper;
    SQLiteDatabase database;
    int status=0;
    int j;
    //데이터베이스부분

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stamp);

        course = new ImageButton[14];
        coursetext = new ImageView[14];

        //데이터베이스부분
        dbhelper = new DBHelper(StampActivity.this, DBHelper.tableName, null, version);
        database= dbhelper.getWritableDatabase();
        //데이터베이스부분

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

        //db에서 값 받아와서 버튼 활성화하기
        for(int i=0;i<14;i++){
            status = dbhelper.getStatus(i);
            if(status==1) {
                course[i].setImageResource(courseimage[i]);
                coursetext[i].setImageResource(coursetextimage[i]);
                course[i].setEnabled(true);
            }
            else continue;
        }

        //시즌완료 메세지
        for(int i=0;i<14;i++){
            status = dbhelper.getStatus(i);
            if(status==1) {
                j++;
                if(j==14){
                    Intent intent = new Intent(StampActivity.this, CompleteActivity.class);
                    startActivity(intent);
                    break;
                }
                continue;
            }
            else {
                j=0;
                break;
            }
        }

        //버튼 구현 (MainActivity 에서 PopupActivity로 값 보내면서 띄우기)
        for(int i=0;i<14;i++) {
            final int b=i;
            course[i].setOnClickListener(
                    new ImageButton.OnClickListener() {
                        public void onClick(View v) {
                            Intent intent = new Intent(StampActivity.this, PopupActivity.class);
                            intent.putExtra("course", b);
                            startActivity(intent);
                        }
                    }
            );
        }
    }
}