package zadok.jct.mydb.UI.WarehouseManager.AddParcelActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import zadok.jct.mydb.DeliveryDetails;
import zadok.jct.mydb.Entitties.Parcel;
import zadok.jct.mydb.R;
import zadok.jct.mydb.Utils.PostStatus;
import zadok.jct.mydb.ViewModels.ParcelViewModel;

public class AddParcelActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnDatePicker;
    EditText txtDate;
    ParcelViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_parcell);

        viewModel= ViewModelProviders.of(this).get(ParcelViewModel.class);
        viewModel.getStatusMessageViewModel().observe(this, new Observer<PostStatus>() {
            @Override
            public void onChanged(PostStatus postStatus) {
                if(postStatus.getStatus()==PostStatus.savingStatus.SUCCESS)
                {
                    Toast.makeText(getApplicationContext(),"saving success",Toast.LENGTH_LONG).show();
                    }
                else if(postStatus.getStatus()==PostStatus.savingStatus.FAILED)
                {Toast.makeText(getApplicationContext(),"saving failed",Toast.LENGTH_LONG).show();
                    }
            }
        });
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

        btnDatePicker=findViewById(R.id.btn_date2);
        txtDate=findViewById(R.id.in_date2);
        btnDatePicker.setOnClickListener(this);

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

        Button AddParcelBtn=findViewById(R.id.add_parcel2);
        AddParcelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TextView FNameText=findViewById(R.id.f_name);
                //TextView LNameText=findViewById(R.id.l_name);
                Parcel parcel=new Parcel();
                parcel.setName("meerzon shelmo");
                parcel.setStatus(Parcel.ParcelStatus.ACCEPTED);
                viewModel.addParcelToRepository(parcel);

            }
        });
    }
    @Override
    public void onClick(View v) {
        if (v == btnDatePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR);
            int mMonth = c.get(Calendar.MONTH);
            int mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
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
}
