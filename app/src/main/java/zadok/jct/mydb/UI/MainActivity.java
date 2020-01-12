package zadok.jct.mydb.UI;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import zadok.jct.mydb.R;


public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);
        TextView welcomeView = findViewById(R.id.welcomeView);
        welcomeView.setTextSize((float) 20.0);
        //SystemClock.sleep(10000);
        final Handler mainMenuHandler = new Handler();
        mainMenuHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //setContentView(R.layout.main_menu);
                Intent i = new Intent(MainActivity.this,MainMenu.class);
                startActivity(i);
                TextView mainMenuView = findViewById(R.id.mainMenu);
//                mainMenuView.setTextSize((float) 25);
            }
        }, 100);


      /*  //find buttons & set buttons clicks
        Button warehauseManager = (Button) findViewById(R.id.warehouse_manager);
        warehauseManager.setOnClickListener(new View.OnClickListener() {

                                                @Override
                                                public void onClick(View v) {
                                                    setContentView(R.layout.);

                                                }
                                            }

        );*/


    }

}
