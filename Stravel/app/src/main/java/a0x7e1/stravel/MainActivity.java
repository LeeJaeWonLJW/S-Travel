package a0x7e1.stravel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Vector;

/**
 * Created by jaewon on 2017. 10. 4..
 */

public class MainActivity extends AppCompatActivity {

    int metro_chk=0; ImageButton imgbtn_metro = null;
    int bike_chk=0; ImageButton imgbtn_bike = null;
    int walk_chk=0; ImageButton imgbtn_walk = null;
    int bus_chk=0; ImageButton imgbtn_bus = null;
    int car_chk=0; ImageButton imgbtn_car = null;

    Intent MainToMap = null;
    Intent MainToProfile = null;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgbtn_metro = (ImageButton)findViewById(R.id.imgbtn_metro);
        imgbtn_bike = (ImageButton)findViewById(R.id.imgbtn_bike);
        imgbtn_walk = (ImageButton)findViewById(R.id.imgbtn_walk);
        imgbtn_bus = (ImageButton)findViewById(R.id.imgbtn_bus);
        imgbtn_car = (ImageButton)findViewById(R.id.imgbtn_car);

        MainToMap =  new Intent(MainActivity.this, MapActivity.class);
        MainToProfile = new Intent(MainActivity.this, SettingActivity.class);
    }

    public void metro(View v){
        if(metro_chk==0){
            imgbtn_metro.setImageResource(R.drawable.metro);
        }
        else if (metro_chk == 1){
            imgbtn_metro.setImageResource(R.drawable.metro_chk);
        }
        metro_chk=1-metro_chk;
    }

    public void bike(View v){
        if(bike_chk==0){
            imgbtn_bike.setImageResource(R.drawable.bike);
        }
        else if (bike_chk == 1){
            imgbtn_bike.setImageResource(R.drawable.bike_chk);
        }
        bike_chk=1-bike_chk;
    }

    public void walk(View v){
        if(walk_chk==0){
            imgbtn_walk.setImageResource(R.drawable.walk);
        }
        else if (walk_chk == 1){
            imgbtn_walk.setImageResource(R.drawable.walk_chk);
        }
        walk_chk=1-walk_chk;
    }

    public void bus(View v){
        if(bus_chk==0){
            imgbtn_bus.setImageResource(R.drawable.bus);
        }
        else if (bus_chk == 1){
            imgbtn_bus.setImageResource(R.drawable.bus_chk);
        }
        bus_chk=1-bus_chk;
    }

    public void car(View v){
        if(car_chk==0){
            imgbtn_car.setImageResource(R.drawable.car);
        }
        else if (car_chk == 1){
            imgbtn_car.setImageResource(R.drawable.car_chk);
        }
        car_chk=1-car_chk;
    }

    public void random(View v){
        bike_chk=RandomNumber(0,1);
        bus_chk=RandomNumber(0,1);
        car_chk=RandomNumber(0,1);
        metro_chk=RandomNumber(0,1);
        walk_chk=RandomNumber(0,1);

        bike(v);
        bus(v);
        car(v);
        metro(v);
        walk(v);
    }

    public void next(View v){
        startActivity(MainToMap);
        finish();
    }

    public void profile(View v) {
        startActivity(MainToProfile);
        finish();
    }

    public int RandomNumber(int min, int max){
        return (int)(Math.random()*(max-min+1))+min;
    }
}