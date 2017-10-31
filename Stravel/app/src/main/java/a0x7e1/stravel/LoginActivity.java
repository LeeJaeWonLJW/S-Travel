package a0x7e1.stravel;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Handler;

import static a0x7e1.stravel.R.id.passwordinput;

/**
 * Created by jaewon on 2017. 10. 30..
 */

public class LoginActivity extends AppCompatActivity {
    Intent LoginToMain = null;
    Intent LoginToSignin = null;

    EditText idinput = null;
    EditText passwordinput = null;

    int a;
    String sId,sPw;

    private static String TAG = "phptest";

    private static final String TAG_JSON="stravel";
    private static final String TAG_KEY="Key";

    String mJsonString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        idinput = (EditText) findViewById(R.id.idinput);
        passwordinput = (EditText) findViewById(R.id.passwordinput);

        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setAlpha(45);
        ((LinearLayout)findViewById(R.id.backLin)).setBackgroundColor(paint.getColor());

        LoginToMain = new Intent(this, FeedActivity.class);
        LoginToSignin = new Intent(this, SigninActivity.class);
    }

    public void login(View v){
        sId = idinput.getText().toString();
        sPw = passwordinput.getText().toString();

        if(idinput.getText().toString().equals("") || passwordinput.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "아이디나 비밀번호를 입력하세요", Toast.LENGTH_SHORT).show();
            return;
        }

        GetData task = new GetData();
        task.execute("https://tshlab.com/login/login?ID="+sId+"&PW="+sPw);


    }

    private class GetData extends AsyncTask<String, Void, String> {
        ProgressDialog progressDialog;
        String errorString = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(LoginActivity.this,
                    "Please Wait", null, true, true);
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            progressDialog.dismiss();
//            Log.d(TAG, "response  - " + result);

            if (result == null){
            }
            else {
                Log.d(TAG, "response  - " + result);
                mJsonString = result;
                showResult();
            }
        }


        @Override
        protected String doInBackground(String... params) {

            String serverURL = params[0];


            try {

                URL url = new URL(serverURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();


                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.connect();


                int responseStatusCode = httpURLConnection.getResponseCode();
                Log.d(TAG, "response code - " + responseStatusCode);

                InputStream inputStream;
                if(responseStatusCode == HttpURLConnection.HTTP_OK) {
                    inputStream = httpURLConnection.getInputStream();
                }
                else{
                    inputStream = httpURLConnection.getErrorStream();
                }


                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuilder sb = new StringBuilder();
                String line;

                while((line = bufferedReader.readLine()) != null){
                    sb.append(line);
                }


                bufferedReader.close();


                return sb.toString().trim();


            } catch (Exception e) {

                Log.d(TAG, "InsertData: Error ", e);
                errorString = e.toString();

                return null;
            }

        }
    }


    private void showResult(){
        try {
            JSONObject jsonObject = new JSONObject(mJsonString);
            JSONArray jsonArray = jsonObject.getJSONArray(TAG_JSON);

            JSONObject item = jsonArray.getJSONObject(0);

            String Key = item.getString(TAG_KEY);

            a = Integer.parseInt(Key);
            Log.d(TAG, "a - " + a + " , Key -"+Integer.parseInt(Key));

            boolean b = (a != 0);

            if (b) {
                startActivity(LoginToMain);
                this.finish();
            } else if (b==false){
                Toast.makeText(getApplicationContext(),"비밀번호나 아이디를 다시 확인하세요.",Toast.LENGTH_SHORT).show();
            }

        } catch (JSONException e) {

            Log.d(TAG, "showResult : ", e);
        }

    }

    public void signin(View v) {
        startActivity(LoginToSignin);
        this.finish();
    }
}