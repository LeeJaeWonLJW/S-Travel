package org.androidtown.janicoproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        button=(Button) findViewById(R.id.button);


        //특정조건 만족 버튼 추후에 조건으로 수정바람
        button.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(SettingActivity.this, CertificationActivity.class);
                        intent.putExtra("course", 0);
                        startActivity(intent);
                    }
                }
        );
    }
}
