package zadok.jct.mydb.UI.WarehouseManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.Locale;

import zadok.jct.mydb.R;
import zadok.jct.mydb.UI.WarehouseManager.AddParcelActivity.AddParcelActivity;
import zadok.jct.mydb.UI.WarehouseManager.HistoryParcelActivity.HistoryParcelActivity;
import zadok.jct.mydb.Utils.MyLocation;


public class warehouseManager extends AppCompatActivity {
    public static SharedPreferences getSharedPref() {
        return sharedPref;
    }

    private static SharedPreferences sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        {sharedPref=getSharedPreferences(getPackageName()+"_preferences",MODE_PRIVATE);}
        storeInSharedPreferenced(getLocationFromAddress("אביעד ירושלים ישראל"));
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
    private void storeInSharedPreferenced(Location inhibitorPlace) {
        {
            SharedPreferences.Editor editor = sharedPref.edit();
            if (inhibitorPlace != null) {
                editor.putFloat("INHIBITOR_LAT", (float) inhibitorPlace.getLatitude());
                editor.putFloat("INHIBITOR_LNG", (float) inhibitorPlace.getLongitude());
                editor.commit();
            }
        }
    }

    public MyLocation getLocationFromAddress(String strAddress) {

        //    Geocoder coder = new Geocoder(this);
        Geocoder coder = new Geocoder(this,  new Locale("he"));
        List<Address> address;

        try {
            address = coder.getFromLocationName(strAddress, 1);
            if (address == null) {
                return null;
            }
            Address location = address.get(0);
            double lat = location.getLatitude();
            double lng = location.getLongitude();
            return new MyLocation(lat,lng);
        } catch (Exception e) {
            return null;
        }
    }
}
