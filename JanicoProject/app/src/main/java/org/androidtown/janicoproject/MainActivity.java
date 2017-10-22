package org.androidtown.janicoproject;

        import android.app.Activity;
        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.Button;
        import android.widget.ImageButton;
        import android.widget.ImageView;

public class MainActivity extends AppCompatActivity{

    ImageButton cheonggyecheon;
    ImageView cheonggyecheon_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cheonggyecheon = (ImageButton) findViewById(R.id.cheonggyecheon);
        cheonggyecheon.setOnClickListener(imageButtonHandler);
        cheonggyecheon_text=(ImageView) findViewById(R.id.cheonggyecheon_text);
    }

    //menu button
    public void menu(View view) {
        Intent intent = new Intent(this, CertificationActivity.class);
        startActivity(intent);
    }

    View.OnClickListener imageButtonHandler = new View.OnClickListener(){
        public void onClick(View v) {
            cheonggyecheon.setImageResource(R.drawable.cheonggyecheon);
            cheonggyecheon_text.setImageResource(R.drawable.cheonggyecheon_text);
        }
    };

}