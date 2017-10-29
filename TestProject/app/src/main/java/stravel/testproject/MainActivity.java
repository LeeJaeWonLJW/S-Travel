package stravel.testproject;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    private static String TAG = "phptest_MainActivity";

    private static final String TAG_JSON="stravel";
    private static final String TAG_uploadID="uploadID";
    private static final String TAG_userNumber="userNumber";
    private static final String TAG_userProfileIMG="userProfileIMG";
    private static final String TAG_userName="userName";
    private static final String TAG_uploadCommentNum="uploadCommentNum";
    private static final String TAG_uploadContent="uploadContent";
    private static final String TAG_uploadDate="uploadDate";
    private static final String TAG_uploadIMG="uploadIMG";
    private static final String TAG_uploadLike="uploadLike";

    private TextView mTextViewResult;
    ArrayList<HashMap<String, String>> mArrayList;
    ListView mlistView;
    String mJsonString;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewResult = (TextView)findViewById(R.id.textView_main_result);
        mlistView = (ListView) findViewById(R.id.listView_main_list);
        mArrayList = new ArrayList<>();

        GetData task = new GetData();
        task.execute("https://tshlab.com/doc/getjson.php");
    }


    private class GetData extends AsyncTask<String, Void, String>{
        ProgressDialog progressDialog;
        String errorString = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(MainActivity.this,
                    "Please Wait", null, true, true);
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            progressDialog.dismiss();
            mTextViewResult.setText(result);
            Log.d(TAG, "response  - " + result);

            if (result == null){

                mTextViewResult.setText(errorString);
            }
            else {

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

            for(int i=0;i<jsonArray.length();i++){

                JSONObject item = jsonArray.getJSONObject(i);

                String uploadID = item.getString(TAG_uploadID);
                String userNumber = item.getString(TAG_userNumber);
                String userProfileIMG= item.getString(TAG_userProfileIMG);
                String userName = item.getString(TAG_userName);
                String uploadDate= item.getString(TAG_uploadDate);
                String uploadContent= item.getString(TAG_uploadContent);
                String uploadIMG= item.getString(TAG_uploadIMG);


                HashMap<String,String> hashMap = new HashMap<>();


                hashMap.put(TAG_uploadID, uploadID);
                hashMap.put(TAG_userNumber, userNumber);
                hashMap.put(TAG_userProfileIMG, userProfileIMG);
                hashMap.put(TAG_userName, userName);
                hashMap.put(TAG_uploadContent, uploadContent);
                hashMap.put(TAG_uploadDate, uploadDate);
                hashMap.put(TAG_uploadIMG, uploadIMG);


                mArrayList.add(hashMap);
            }

            ListAdapter adapter = new SimpleAdapter(
                    MainActivity.this, mArrayList, R.layout.activity_cert,
                    new String[]{TAG_uploadID,TAG_userProfileIMG,TAG_userName,TAG_uploadDate,TAG_uploadContent,TAG_uploadIMG},
                    new int[]{R.id.uploadID, R.id.userProfileIMG, R.id.userName, R.id.uploadDate, R.id.uploadContent, R.id.uploadIMG}
            );

            mlistView.setAdapter(adapter);

        } catch (JSONException e) {

            Log.d(TAG, "showResult : ", e);
        }

    }

}