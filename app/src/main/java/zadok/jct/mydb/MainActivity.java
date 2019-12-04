package zadok.jct.mydb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView welcomeView = (TextView) findViewById(R.id.welcomeView);
        welcomeView.setTextSize((float) 20.0);
        //SystemClock.sleep(10000);
        Handler mainMenuHandler = new Handler();
        mainMenuHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setContentView(R.layout.main_menu);
                TextView mainMenuView=(TextView) findViewById(R.id.mainMenu);
                mainMenuView.setTextSize((float) 25);
            }
        },6000);



    }
}
