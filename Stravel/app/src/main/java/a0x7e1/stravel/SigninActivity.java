package a0x7e1.stravel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;

/**
 * Created by jaewon on 2017. 10. 31..
 */

public class SigninActivity extends AppCompatActivity {
    Intent SigninToLogin = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        SigninToLogin = new Intent(this, LoginActivity.class);
    }

    public void ToLogin1(View v) {
        startActivity(SigninToLogin);
        this.finish();
    }

    public void ToLogin2(View v) {
        startActivity(SigninToLogin);
        this.finish();
    }

    public void GETSIGNIN(View v) {
        EditText passwordinput = (EditText)findViewById(R.id.passwordinput);
        EditText passwordcheckinput = (EditText)findViewById(R.id.passwordcheckinput);

        if(PassChk(passwordinput.getText().toString(), passwordcheckinput.getText().toString())==0) {
            Toast.makeText(getApplicationContext(),"비밀번호를 확인하세요.",Toast.LENGTH_SHORT).show();
        } else {
            EditText idinput = (EditText)findViewById(R.id.idinput);
            EditText nicknameinput = (EditText)findViewById(R.id.nicknameinput);

            String param = "ID=" + idinput.getText().toString()
                    + "&" + "PW=" + passwordinput.getText().toString()
                    + "&" + "NickName=" + nicknameinput.getText().toString();

            String url = "https://tshlab.com/login/signin" + "?" + param;
            WebView webview = new WebView(this);
            webview.loadUrl(url);

            ToLogin1(v);
            this.finish();
        }
    }

    public int PassChk(String pw, String pwchk) {
        TextView passwordcheckmessage = (TextView)findViewById(R.id.passwordcheckmessage);

        if(pw.equals(pwchk)) {
            passwordcheckmessage.setText("비밀번호가 맞습니다.");
            return 1;
        } else {
            passwordcheckmessage.setText("비밀번호가 틀립니다."+pw+" "+pwchk);
            return 0;
        }
    }
}
