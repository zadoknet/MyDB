package zadok.jct.mydb.UI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.Locale;

import zadok.jct.mydb.R;
import zadok.jct.mydb.UI.WarehouseManager.HistoryParcelActivity.HistoryParcelActivity;
import zadok.jct.mydb.UI.WarehouseManager.warehouseManager;
import zadok.jct.mydb.Utils.MyLocation;

public class MainMenu extends AppCompatActivity {
    public static SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        final String TAG="ZADOK";
        {sharedPref=getSharedPreferences(getPackageName()+"_preferences",MODE_PRIVATE);}
        storeInSharedPreferenced(getLocationFromAddress("אביעד ירושלים ישראל"));




        Button wareHouseManager = findViewById(R.id.warehouseManager);
        wareHouseManager.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent buttonIntent = new Intent(MainMenu.this, warehouseManager.class);
                startActivity(buttonIntent);
            }
        });

        Button  ShippingOrder=findViewById(R.id.shipping_order);
        ShippingOrder.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent buttonIntent = new Intent(MainMenu.this, ShippingOrder.class);
                startActivity(buttonIntent);
            }
        });

        final Button HistoryParcel=findViewById(R.id.track_shipping);
        HistoryParcel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent buttoIntent=new Intent(MainMenu.this, HistoryParcelActivity.class);
                startActivity(buttoIntent);
            }
        });


    }
    //todo: delete this function (getLccationFromAddress)
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



    private void storeInSharedPreferenced(Location inhibitorPlace)
    {
        {
            SharedPreferences.Editor editor = sharedPref.edit();
            if(inhibitorPlace!=null)
            {
            editor.putFloat("INHIBITOR_LAT", (float) inhibitorPlace.getLatitude());
            editor.putFloat("INHIBITOR_LNG", (float) inhibitorPlace.getLongitude());
            editor.commit();}
        }
    }
}
