package a0x7e1.stravel;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *  이 곳은 글쓰기 Activity
 *  DataBase로 전송함.
 *  UserData를 받아와서 String 으로 변수값 선언 해주세여
 **/


public class WriteActivity extends AppCompatActivity {

    private static String TAG = "phptest_WriteActivity";

    private EditText muploadContent;
    private TextView mTextViewResult;
    private EditText muserName;

    String userNumber = "0";
    String userProfileIMG = "0";
    String uploadCommentNum = "0";
    String uploadIMG = "0";
    String uploadLike =  "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        muploadContent = (EditText)findViewById(R.id.uploadContent);
        //muserName = // userName 정보를 받아와 주세요
        mTextViewResult = (TextView)findViewById(R.id.textView_main_result);

        Button buttonInsert = (Button)findViewById(R.id.submitBtn);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String uploadContent = muploadContent.getText().toString();
                String userName = muserName.getText().toString();

                InsertData task = new InsertData();
                task.execute(uploadContent,userName);

                muploadContent.setText("");
                muserName.setText("");

            }
        });
    }


    class InsertData extends AsyncTask<String, Void, String> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(WriteActivity.this,
                    "Please Wait", null, true, true);
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            progressDialog.dismiss();
            mTextViewResult.setText(result);
            Log.d(TAG, "POST response  - " + result);
        }


        @Override
        protected String doInBackground(String... params) {

            String uploadContent = (String)params[0];
            String userName = (String)params[1];

            String serverURL = "https://tshlab.com/doc/insert";
            String postParameters = "userNumber=" + userNumber +  "&userProfileIMG=" + userProfileIMG + "&userName=" + userName + "&uploadCommentNum=" + uploadCommentNum + "&uploadContent=" + uploadContent + "&uploadIMG=" + uploadIMG + "&uploadLike=" + uploadLike ;

            try {

                URL url = new URL(serverURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();


                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setRequestMethod("POST");
                //httpURLConnection.setRequestProperty("content-type", "application/json");
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();


                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(postParameters.getBytes("UTF-8"));
                outputStream.flush();
                outputStream.close();


                int responseStatusCode = httpURLConnection.getResponseCode();
                Log.d(TAG, "POST response code - " + responseStatusCode);

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
                String line = null;

                while((line = bufferedReader.readLine()) != null){
                    sb.append(line);
                }


                bufferedReader.close();


                return sb.toString();


            } catch (Exception e) {

                Log.d(TAG, "InsertData: Error ", e);

                return new String("Error: " + e.getMessage());
            }

        }
    }

}
