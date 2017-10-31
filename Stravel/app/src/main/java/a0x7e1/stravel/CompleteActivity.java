package a0x7e1.stravel;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class CompleteActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete);
        Button close = (Button) findViewById(R.id.close);

        //닫기버튼 구현
        close.setOnClickListener(
                new ImageButton.OnClickListener() {
                    public void onClick(View v) {
                        finish();
                    }
                }
        );
    }
}