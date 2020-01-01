package zadok.jct.mydb;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import zadok.jct.mydb.Data.ParcelRepository;


public class MainActivity extends AppCompatActivity {
    final String TAG="ZADOK";
    ParcelRepository rep=new ParcelRepository(null);
    //todo:

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





        setContentView(R.layout.activity_main);
        TextView welcomeView = (TextView) findViewById(R.id.welcomeView);
        welcomeView.setTextSize((float) 20.0);

        Handler mainMenuHandler = new Handler();
 /*       mainMenuHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setContentView(R.layout.main_menu);
                TextView mainMenuView=(TextView) findViewById(R.id.mainMenu);
                mainMenuView.setTextSize((float) 25);
            }
        },6000); */


    }
}
