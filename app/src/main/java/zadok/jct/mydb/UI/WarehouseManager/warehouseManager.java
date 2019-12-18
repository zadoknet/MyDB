package zadok.jct.mydb.UI.WarehouseManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import zadok.jct.mydb.R;
import zadok.jct.mydb.UI.WarehouseManager.AddParcelActivity.AddParcelActivity;
import zadok.jct.mydb.UI.WarehouseManager.HistoryParcelActivity.HistoryParcelActivity;


public class warehouseManager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warehouse_manager);

        Button AddParcel= findViewById(R.id.add_parcel);
        AddParcel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addParcelIntent= new Intent(warehouseManager.this, AddParcelActivity.class);
                startActivity(addParcelIntent);
            }
        });

        Button ParcelHistory= findViewById(R.id.parcel_history);
        ParcelHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent historyParcelIntent= new Intent(warehouseManager.this, HistoryParcelActivity.class);
                startActivity(historyParcelIntent);
            }
        });
    }
}
