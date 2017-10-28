package org.androidtown.janicoproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SettingActivity extends AppCompatActivity {

    Button button, button2, clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        final DBHelper dbHelper = new DBHelper(getApplicationContext(), "Stamp.db", null, 1);

        button=(Button) findViewById(R.id.button);
        button2=(Button) findViewById(R.id.button2);
        clear=(Button) findViewById(R.id.clean);

        TextView result = (TextView) findViewById(R.id.result);
        result.setText(dbHelper.getResult());

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
        button2.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(SettingActivity.this, CertificationActivity.class);
                        intent.putExtra("course", 1);
                        startActivity(intent);
                    }
                }
        );
        clear.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        dbHelper.delete();
                    }
                }
        );
    }
}
