package org.androidtown.janicoproject;

        import android.app.Activity;
        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.Button;
        import android.widget.ImageButton;
        import android.widget.ImageView;
        import android.widget.TextView;

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

    ImageButton cheonggyecheon, coex, dongdaemoon, gwanghwa, gyeongbok, hanok, hongdae, insadong, itaewon, lottetower, naksan, namdaemoon, namsantower, soongrye;
    ImageView cheonggyecheon_text, coex_text, dongdaemoon_text, gwanghwa_text, gyeongbok_text, hanok_text, hongdae_text, insadong_text, itaewon_text, lottetower_text, naksan_text, namdaemoon_text, namsantower_text, soongrye_text;

    int a=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cheonggyecheon = (ImageButton) findViewById(R.id.cheonggyecheon);
        cheonggyecheon_text = (ImageView) findViewById(R.id.cheonggyecheon_text);

        coex = (ImageButton) findViewById(R.id.coex);
        coex_text = (ImageView) findViewById(R.id.coex_text);

        dongdaemoon = (ImageButton) findViewById(R.id.dongdaemoon);
        dongdaemoon_text = (ImageView) findViewById(R.id.dongdaemoon_text);

        gwanghwa = (ImageButton) findViewById(R.id.gwanghwa);
        gwanghwa_text = (ImageView) findViewById(R.id.gwanghwa_text);

        gyeongbok = (ImageButton) findViewById(R.id.gyeongbok);
        gyeongbok_text = (ImageView) findViewById(R.id.gyeongbok_text);

        hanok = (ImageButton) findViewById(R.id.hanok);
        hanok_text = (ImageView) findViewById(R.id.hanok_text);

        hongdae = (ImageButton) findViewById(R.id.hongdae);
        hongdae_text = (ImageView) findViewById(R.id.hongdae_text);

        insadong = (ImageButton) findViewById(R.id.insadong);
        insadong_text = (ImageView) findViewById(R.id.insadong_text);

        itaewon = (ImageButton) findViewById(R.id.itaewon);
        itaewon_text = (ImageView) findViewById(R.id.itaewon_text);

        lottetower = (ImageButton) findViewById(R.id.lottetower);
        lottetower_text = (ImageView) findViewById(R.id.lottetower_text);

        naksan = (ImageButton) findViewById(R.id.naksan);
        naksan_text = (ImageView) findViewById(R.id.naksan_text);

        namdaemoon = (ImageButton) findViewById(R.id.namdaemoon);
        namdaemoon_text = (ImageView) findViewById(R.id.namdaemoon_text);

        namsantower = (ImageButton) findViewById(R.id.namsantower);
        namsantower_text = (ImageView) findViewById(R.id.namsantower_text);

        soongrye = (ImageButton) findViewById(R.id.soongrye);
        soongrye_text = (ImageView) findViewById(R.id.soongrye_text);


        cheonggyecheon.setEnabled(false);
        coex.setEnabled(false);
        dongdaemoon.setEnabled(false);
        gwanghwa.setEnabled(false);
        gyeongbok.setEnabled(false);
        hanok.setEnabled(false);
        hongdae.setEnabled(false);
        insadong.setEnabled(false);
        itaewon.setEnabled(false);
        lottetower.setEnabled(false);
        naksan.setEnabled(false);
        namdaemoon.setEnabled(false);
        namsantower.setEnabled(false);
        soongrye.setEnabled(false);

        //다른 액티비티로 전환 (인증서 액티비티)
        findViewById(R.id.menu).setOnClickListener(
                new ImageButton.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, CertificationActivity.class);
                        startActivity(intent);
                    }
                }
        );

        //지금은 타이틀바 제일 오른쪽 사람모양 클릭하면 a가 하나씩 증가하면서
        //하나씩 색칠되게 해놨다 알아서 바꿔랑
        findViewById(R.id.rightmenu).setOnClickListener(
                new ImageButton.OnClickListener() {
                    public void onClick(View v) {
                        a++;
                        if (a == 1) {
                            cheonggyecheon.setImageResource(R.drawable.cheonggyecheon);
                            cheonggyecheon_text.setImageResource(R.drawable.cheonggyecheon_text);
                            cheonggyecheon.setEnabled(true);
                        } else if (a == 2) {
                            coex.setImageResource(R.drawable.coex);
                            coex_text.setImageResource(R.drawable.coex_text);
                        } else if (a == 3) {
                            dongdaemoon.setImageResource(R.drawable.dongdaemoon);
                            dongdaemoon_text.setImageResource(R.drawable.dongdaemoon_text);
                        } else if (a == 4) {
                            gwanghwa.setImageResource(R.drawable.gwanghwa);
                            gwanghwa_text.setImageResource(R.drawable.gwanghwa_text);
                        } else if (a == 5) {
                            gyeongbok.setImageResource(R.drawable.gyeongbok);
                            gyeongbok_text.setImageResource(R.drawable.gyeongbok_text);
                        } else if (a == 6) {
                            hanok.setImageResource(R.drawable.hanok);
                            hanok_text.setImageResource(R.drawable.hanok_text);
                        } else if (a == 7) {
                            hongdae.setImageResource(R.drawable.hongdae);
                            hongdae_text.setImageResource(R.drawable.hongdae_text);
                        } else if (a == 8) {
                            insadong.setImageResource(R.drawable.insadong);
                            insadong_text.setImageResource(R.drawable.insadong_text);
                        } else if (a == 9) {
                            itaewon.setImageResource(R.drawable.itaewon);
                            itaewon_text.setImageResource(R.drawable.itaewon_text);
                        } else if (a == 10) {
                            lottetower.setImageResource(R.drawable.lottetower);
                            lottetower_text.setImageResource(R.drawable.lottetower_text);
                        } else if (a == 11) {
                            naksan.setImageResource(R.drawable.naksan);
                            naksan_text.setImageResource(R.drawable.naksan_text);
                        } else if (a == 12) {
                            namdaemoon.setImageResource(R.drawable.namdaemoon);
                            namdaemoon_text.setImageResource(R.drawable.namdaemoon_text);
                        } else if (a == 13) {
                            namsantower.setImageResource(R.drawable.namsantower);
                            namsantower_text.setImageResource(R.drawable.namsantower_text);
                        } else if (a == 14) {
                            soongrye.setImageResource(R.drawable.soongrye);
                            soongrye_text.setImageResource(R.drawable.soongrye_text);
                        }
                    }
                }
        );

        cheonggyecheon.setOnClickListener(
                new ImageButton.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(MainActivity.this, CertificationActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }
}