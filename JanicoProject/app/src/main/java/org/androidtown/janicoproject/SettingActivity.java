package org.androidtown.janicoproject;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SettingActivity extends AppCompatActivity {

    Button button, button2, clear;
    TextView result;

    //데이터베이스부분
    int version=1;
    DBHelper dbhelper;
    SQLiteDatabase database;
    //데이터베이스부분

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        button=(Button) findViewById(R.id.button);
        button2=(Button) findViewById(R.id.button2);
        clear=(Button) findViewById(R.id.clear);
        result=(TextView) findViewById(R.id.result);

        //데이터베이스부분
        dbhelper = new DBHelper(SettingActivity.this, DBHelper.tableName, null, version);
        database= dbhelper.getWritableDatabase();
        //데이터베이스부분

        result.setText(dbhelper.getResult());

        //특정조건 만족 버튼 추후에 조건으로 수정바람
        button.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(SettingActivity.this, CertificationActivity.class);
                        intent.putExtra("course", 0);
                        result.setText(dbhelper.getResult());
                        startActivity(intent);
                    }
                }
        );
        button2.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        for(int i=0;i<14;i++){dbhelper.updateStatus(database, i);}
                        result.setText(dbhelper.getResult());
                    }
                }
        );
        clear.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        dbhelper.deleteStatus(database);
                        result.setText(dbhelper.getResult());
                    }
                }
        );
    }
}
