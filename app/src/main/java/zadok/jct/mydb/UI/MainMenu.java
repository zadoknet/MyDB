package zadok.jct.mydb.UI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.List;
import java.util.Locale;

import zadok.jct.mydb.Entitties.Parcel;
import zadok.jct.mydb.R;
import zadok.jct.mydb.UI.WarehouseManager.HistoryParcelActivity.HistoryParcelActivity;
import zadok.jct.mydb.UI.WarehouseManager.warehouseManager;
import zadok.jct.mydb.Utils.MyLocation;
import zadok.jct.mydb.Utils.PostStatus;
import zadok.jct.mydb.ViewModels.ParcelViewModel;

public class MainMenu extends AppCompatActivity {
    public static SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        final String TAG="ZADOK";
        {sharedPref=getSharedPreferences(getPackageName()+"_preferences",MODE_PRIVATE);}
        ParcelViewModel viewModel = ViewModelProviders.of(this).get(ParcelViewModel .class);
        viewModel.getStatusMessageViewModel().observe(this, new Observer<PostStatus>() {
            @Override
            public void onChanged(PostStatus postStatus) {
                if(postStatus.getStatus()==PostStatus.savingStatus.SUCCESS)
                {
                    Toast toast=Toast.makeText(getApplicationContext(),"saving sucess",Toast.LENGTH_LONG);
                    toast.show();
                    Log.i(TAG,"saving success ViewModel");}
                else if(postStatus.getStatus()==PostStatus.savingStatus.FAILED)
                    Log.i(TAG,"saving failed ViewModel");
            }
        });
        MyLocation location1=getLocationFromAddress("אביעד 4 ירושלים ישראל");
        MyLocation location2=getLocationFromAddress("נחל ניצנים בית שמש ישראל");
        Parcel parcel=new Parcel("1","נתנאל צדוק",location1);
        parcel.setStatus(Parcel.ParcelStatus.ACCEPTED);
        viewModel.addParcelToRepository(parcel);
        //viewModel.addParcelToRepository(new Parcel("2","zadok1",location2));
        //Inhibitor address
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
            editor.putFloat("INHIBITOR_LAT", (float) inhibitorPlace.getLatitude());
            editor.putFloat("INHIBITOR_LNG", (float) inhibitorPlace.getLongitude());
            editor.commit();
        }
    }
}
