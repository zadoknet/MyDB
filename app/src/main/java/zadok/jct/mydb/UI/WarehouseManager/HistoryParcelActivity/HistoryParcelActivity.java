package zadok.jct.mydb.UI.WarehouseManager.HistoryParcelActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import zadok.jct.mydb.Entitties.Parcel;
import zadok.jct.mydb.R;
import zadok.jct.mydb.Utils.ParcelHistoryAdapter;
import zadok.jct.mydb.ViewModels.HistoryViewModel;

public class HistoryParcelActivity extends AppCompatActivity {
    final String TAG = "ZADOK";
    private RecyclerView rvParcelHistory;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager myLayoutManager;
    HistoryViewModel historyViewModel;
    public ArrayList<Parcel> myParcel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_parcel);

        //Lookup the recyclerview in activity layout
        rvParcelHistory=findViewById(R.id.rvParcelHistory);

       // historyViewModel.getDataFromRoom();
        //Initialize parcel list

        historyViewModel = ViewModelProviders.of(this).get(HistoryViewModel.class);
        historyViewModel.getParcelsLiveDate().observe(this, new Observer<List<Parcel>>() {
            @Override
            public void onChanged(List<Parcel> parcels) {
                myParcel.addAll(parcels);
                //historyViewModel.getDataFromRoom();
                Log.i(TAG, "This is parcel from the room" + parcels.toString());
                Log.i(TAG,""+getCompleteAddress(parcels.get(0).getInhibitorAddress().getLat(),parcels.get(0).getInhibitorAddress().getLng()));
            }
        });

        myLayoutManager=new LinearLayoutManager(this);
        rvParcelHistory.setLayoutManager(myLayoutManager);

        //
        myAdapter=new ParcelHistoryAdapter((myParcel));
        rvParcelHistory.setAdapter(myAdapter);

        //the size of view is static
        rvParcelHistory.setHasFixedSize(true);


        Log.i(TAG,"pass good");

    }
//************This function translate from lat/lng location to literal address**********************
    public String getCompleteAddress(double latitude, double longitude) {
        String location = "";
        try {
            //  Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            Geocoder geocoder = new Geocoder(this,  new Locale("he"));
            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
            if (addresses.size() > 0) {
                Address address = addresses.get(0);
                String state, city, zip, street;
                if (address.getAdminArea() != null) {
                    state = address.getAdminArea();
                } else {
                    state = "";
                }
                if (address.getLocality() != null) {
                    city = address.getLocality();
                } else {
                    city = "";
                }
                if (address.getPostalCode() != null) {
                    zip = address.getPostalCode();
                } else {
                    zip = "";
                }

                if (address.getThoroughfare() != null) {
                    street = address.getSubLocality() + "," + address.getThoroughfare();
                } else {
                    street = address.getSubLocality() + "," + address.getFeatureName();
                }
                location = street + "," + city + "," + zip + "," + state;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return location;
    }

}
