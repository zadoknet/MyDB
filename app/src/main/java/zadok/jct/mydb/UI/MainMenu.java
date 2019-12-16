package zadok.jct.mydb.UI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import zadok.jct.mydb.R;
import zadok.jct.mydb.UI.WarehouseManager.warehouseManager;

public class MainMenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        Button wareHouseManager = findViewById(R.id.warehouseManager);
        wareHouseManager.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent buttonIntent = new Intent(MainMenu.this, warehouseManager.class);
                startActivity(buttonIntent);
            }
        });
    }
}
