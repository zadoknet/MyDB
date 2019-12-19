package zadok.jct.mydb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import zadok.jct.mydb.Data.Firebase_DBManger;
import zadok.jct.mydb.Data.ParcelRepository;
import zadok.jct.mydb.Entitties.Parcel;
import zadok.jct.mydb.Utils.postStatus;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);
        TextView welcomeView = (TextView) findViewById(R.id.welcomeView);
        welcomeView.setTextSize((float) 20.0);

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
