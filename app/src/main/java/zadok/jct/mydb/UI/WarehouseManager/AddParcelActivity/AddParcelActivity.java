package zadok.jct.mydb.UI.WarehouseManager.AddParcelActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.List;
import java.util.Locale;

import zadok.jct.mydb.DeliveryDetails;
import zadok.jct.mydb.Entitties.Parcel;
import zadok.jct.mydb.R;
import zadok.jct.mydb.Utils.PostStatus;
import zadok.jct.mydb.ViewModels.ParcelViewModel;

public class AddParcelActivity extends AppCompatActivity {
    private static final String TAG = "ZADOK";

    //**********define the View Model******************************************
    ParcelViewModel parcelViewModel = ViewModelProviders.of(this).get(ParcelViewModel .class);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //***************8Create the observer to AddParcel (for receive feedback)****************

        parcelViewModel.getStatusMessageViewModel().observe(this, new Observer<PostStatus>() {
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
        //******************************************************************************************

        //*************create the repository ******************************************

        setContentView(R.layout.activity_add_parcell);


        Resources resParcelType=getResources();
        String[] parcelType=resParcelType.getStringArray(R.array.parcelTypeArr);
        ArrayAdapter<String> typeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,parcelType);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner type = findViewById(R.id.parcel_type);
        type.setAdapter(typeAdapter);
        type.setPrompt("Parcel Type");
        type.setSelection(0);
        type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Resources resFragileType=getResources();
        String[] fragileType=resFragileType.getStringArray(R.array.fragileContentArr);
        ArrayAdapter<String> fragile = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, fragileType);
        fragile.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner isFragile= findViewById(R.id.fragile_content);
        isFragile.setAdapter(fragile);
        isFragile.setPrompt("Fragile Content");
        isFragile.setSelection(0);
        isFragile.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
        });

        Resources resWeight=getResources();
        String[] weightType=resWeight.getStringArray(R.array.weight);
        ArrayAdapter<String> weight = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, weightType);
        weight.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner setWeight= findViewById(R.id.weight);
        setWeight.setAdapter(weight);
        setWeight.setPrompt("Set Weight");
        setWeight.setSelection(0);
        setWeight.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /**
         *
         */
        Button DeliveryDetailsBtn=findViewById(R.id.delivery_details);
        DeliveryDetailsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deliveryStatusIntent=new Intent(AddParcelActivity.this, DeliveryDetails.class);
                startActivity(deliveryStatusIntent);
            }
        });
    }


    public Location getLocationFromAddress(String strAddress) {

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
            Location result=new Location("zadok");
            result.setLatitude(lat);
            result.setLongitude(lng);
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    private void addParcel(Parcel parcel)
    {
    parcelViewModel.addParcelToRepository(parcel);
    }

}
