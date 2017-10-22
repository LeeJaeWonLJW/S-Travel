package org.androidtown.janicoproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CertificationActivity extends AppCompatActivity {

    EditText nameinput, dateinput, courseinput;
    String name, date, course;
    TextView namename,datedate,coursecourse;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certification);
        findViewById(R.id.confirm).setOnClickListener(mClickListener);
        nameinput = (EditText) findViewById(R.id.nameinput);
        dateinput = (EditText) findViewById(R.id.dateinput);
        courseinput = (EditText) findViewById(R.id.courseinput);
        namename = (TextView) findViewById(R.id.namename);
        coursecourse = (TextView) findViewById(R.id.coursecourse);
        datedate = (TextView) findViewById(R.id.datedate);
    }

    Button.OnClickListener mClickListener = new View.OnClickListener(){
        public void onClick(View v){
            name=nameinput.getText().toString();
            date=dateinput.getText().toString();
            course=courseinput.getText().toString();
            namename.setText(name);
            coursecourse.setText(course);
            datedate.setText(date);
        }
    };
}