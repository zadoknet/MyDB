package zadok.jct.mydb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView welcomeView = (TextView) findViewById(R.id.welcomeView);
        welcomeView.setTextSize((float) 20.0);

    }
}
