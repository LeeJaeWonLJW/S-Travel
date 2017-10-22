package org.androidtown.janicoproject;

import android.graphics.Bitmap;
import android.icu.text.SimpleDateFormat;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

public class CertificationActivity extends AppCompatActivity {

    EditText nameinput, dateinput, courseinput;
    String name, date, course;
    TextView namename, datedate, coursecourse;
    LinearLayout imageLayout;
    Button capture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certification);
        nameinput = (EditText) findViewById(R.id.nameinput);
        dateinput = (EditText) findViewById(R.id.dateinput);
        courseinput = (EditText) findViewById(R.id.courseinput);
        namename = (TextView) findViewById(R.id.namename);
        coursecourse = (TextView) findViewById(R.id.coursecourse);
        datedate = (TextView) findViewById(R.id.datedate);
        capture = (Button) findViewById(R.id.capture);

        findViewById(R.id.confirm).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        name = nameinput.getText().toString();
                        date = dateinput.getText().toString();
                        course = courseinput.getText().toString();
                        namename.setText(name);
                        coursecourse.setText(course);
                        datedate.setText(date);
                        capture.setVisibility(View.VISIBLE);
                    }
                });


        //사진 캡쳐 후 저장 알아서 구현해라 난 모른다
        //id가 certification인 리니어 레이아웃을 캡쳐 한 후 저장하면된다
        findViewById(R.id.capture).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v){

                    }
                });
    }
}