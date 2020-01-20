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
import androidx.room.Ignore;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.annotations.NotNull;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import zadok.jct.mydb.Entitties.Parcel;
import zadok.jct.mydb.R;
import zadok.jct.mydb.UI.WarehouseManager.HistoryParcelActivity.HistoryParcelActivity;
import zadok.jct.mydb.Utils.MyLocation;
import zadok.jct.mydb.Utils.PostStatus;
import zadok.jct.mydb.ViewModels.ParcelViewModel;

public class AddParcelActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnDatePicker;
    Button btnDatePicker1;
    EditText txtDate;
    EditText txtDate1;
    ParcelViewModel viewModel;
    private TextInputLayout textInputFName;
    private TextInputLayout textInputLName;
    private TextInputLayout textInputEmail;
    private TextInputLayout textInputAddress;
    private TextInputLayout textInputPhone;
    private TextInputLayout textInputCarrier;
    Parcel simpleParcel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_parcell);

        viewModel = ViewModelProviders.of(this).get(ParcelViewModel.class);
        viewModel.getStatusMessageViewModel().observe(this, new Observer<PostStatus>() {
            @Override
            public void onChanged(PostStatus postStatus) {
                if (postStatus.getStatus() == PostStatus.savingStatus.SUCCESS) {
                    Toast toast = Toast.makeText(getApplicationContext(), "saving sucess", Toast.LENGTH_LONG);
                    toast.show();
                } else if (postStatus.getStatus() == PostStatus.savingStatus.FAILED) {
                    Toast toast = Toast.makeText(getApplicationContext(), "saving failed", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        Resources resParcelType = getResources();
        final String[] parcelType = resParcelType.getStringArray(R.array.parcelTypeArr);
        ArrayAdapter<String> typeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, parcelType);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner type = findViewById(R.id.parcel_type);
        type.setAdapter(typeAdapter);
        type.setPrompt("Parcel Type");
        type.setSelection(0);
        type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    simpleParcel.setType(Parcel.parcelType.ENVELOPE);
                } else if (position == 1) {
                    simpleParcel.setType(Parcel.parcelType.SMALL_PACKAGE);
                } else {
                    simpleParcel.setType(Parcel.parcelType.BIG_PACKAGE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnDatePicker1 = (Button) findViewById(R.id.btn_date);
        txtDate1 = findViewById(R.id.in_date);
        btnDatePicker1.setOnClickListener(this);

        btnDatePicker = (Button) findViewById(R.id.btn_date);
        textInputFName = findViewById(R.id.f_name);
        textInputLName = findViewById(R.id.l_name);
        textInputEmail = findViewById(R.id.email);
        textInputAddress = findViewById(R.id.recipient_address);
        textInputPhone = findViewById(R.id.phone);
        textInputCarrier=findViewById(R.id.carrier_name);

        Resources resParcelStatus = getResources();
        String[] parcelStatus = resParcelStatus.getStringArray(R.array.parcel_status);
        ArrayAdapter<String> statusAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, parcelStatus);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner statusS = findViewById(R.id.parcel_status_spinner);
        statusS.setAdapter(statusAdapter);
        statusS.setPrompt("Parcel Status");
        statusS.setSelection(0);
        statusS.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    simpleParcel.setStatus(Parcel.ParcelStatus.SENT);
                } else if (position == 1) {
                    simpleParcel.setStatus(Parcel.ParcelStatus.ACCEPTED_OFFER);
                } else if (position == 2) {
                    simpleParcel.setStatus(Parcel.ParcelStatus.ON_THE_WAY);
                } else {
                    simpleParcel.setStatus(Parcel.ParcelStatus.ACCEPTED);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnDatePicker = findViewById(R.id.btn_date2);
        txtDate = findViewById(R.id.in_date2);
        btnDatePicker.setOnClickListener(this);

        Resources resFragileType = getResources();
        String[] fragileType = resFragileType.getStringArray(R.array.fragileContentArr);
        ArrayAdapter<String> fragile = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, fragileType);
        fragile.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner isFragile = findViewById(R.id.fragile_content);
        isFragile.setAdapter(fragile);
        isFragile.setPrompt("Fragile Content");
        isFragile.setSelection(0);
        isFragile.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    simpleParcel.setFragile(true);
                }else simpleParcel.setFragile(false);
        }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Resources resWeight = getResources();
        String[] weightType = resWeight.getStringArray(R.array.weight);
        ArrayAdapter<String> weight = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, weightType);
        weight.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner setWeight = findViewById(R.id.weight);
        setWeight.setAdapter(weight);
        setWeight.setPrompt("Set Weight");
        setWeight.setSelection(0);
        setWeight.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    simpleParcel.setWeight(Parcel.ParcelWeight.HALF_KG);
                }else if(position==1){
                    simpleParcel.setWeight(Parcel.ParcelWeight.KG);
                }
                else if(position==2){
                    simpleParcel.setWeight(Parcel.ParcelWeight.FIVE_KG);
                }else simpleParcel.setWeight(Parcel.ParcelWeight.TWENTY_KG);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button AddParcelBtn = findViewById(R.id.add_parcel2);
        AddParcelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmInput(v);
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

                            txtDate.setText(dayOfMonth + "-" + ( monthOfYear + 1 ) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        } else if (v == btnDatePicker1) {

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

                            txtDate1.setText(dayOfMonth + "-" + ( monthOfYear + 1 ) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
    }


    public Location getLocationFromAddress(String strAddress) {

        //    Geocoder coder = new Geocoder(this);
        Geocoder coder = new Geocoder(this, new Locale("he"));
        List<Address> address;

        try {
            address = coder.getFromLocationName(strAddress, 1);
            if (address == null) {
                return null;
            }
            Address location = address.get(0);
            double lat = location.getLatitude();
            double lng = location.getLongitude();
            Location result = new Location("zadok");
            result.setLatitude(lat);
            result.setLongitude(lng);
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    private boolean validateEmail() {
        String emailInput = textInputEmail.getEditText().getText().toString().trim();
        if (emailInput.isEmpty()) {
            textInputEmail.setError("Field cant be empty!");
            return false;
        } else if (!emailInput.matches("(.+)(.@)(.+).(.+)")) {
            textInputEmail.setError("Not in email format!");
            return false;
        } else {
            textInputEmail.setError(null);
            return true;
        }
    }

    private boolean validateFName() {
        String textInput = textInputFName.getEditText().getText().toString().trim();
        if (textInput.isEmpty()) {
            textInputFName.setError("Field cant be empty!");
            return false;
        } else {
            textInputFName.setError(null);
            return true;
        }
    }

    private boolean validateLName() {
        String textInput = textInputLName.getEditText().getText().toString().trim();
        if (textInput.isEmpty()) {
            textInputLName.setError("Field cant be empty!");
            return false;
        } else {
            textInputLName.setError(null);
            return true;
        }
    }

    private boolean validateAddress() {
        String textInput = textInputAddress.getEditText().getText().toString().trim();
        if (textInput.isEmpty()) {
            textInputAddress.setError("Field cant be empty!");
            return false;
        } else {
            textInputAddress.setError(null);
            return true;
        }
    }

   /*public boolean validateDate() {
        String dateInput = txtDate.getText().toString().trim();
        if (dateInput.isEmpty()) {
            txtDate.setError("Field can't be empty!");
            return false;
        } else if (!dateInput.matches("^[0-9]{4}([- /.])(((0[13578]|(10|12))\\1(0[1-9]|[1-2][0-9]|3[0-1]))|(02\\1(0[1-9]|[1-2][0-9]))|((0[469]|11)\\1(0[1-9]|[1-2][0-9]|30)))$")) {
            txtDate.setError("Date is incorrect!");
            return false;
        } else {
            txtDate.setError(null);
            return true;
        }}*/


    private boolean validatePhoneNumber() {
        String phoneInput = textInputPhone.getEditText().getText().toString().trim();
        if (phoneInput.isEmpty()) {
            textInputPhone.setError("Field cant be empty!");
            return false;
        } else {
            textInputPhone.setError(null);
            return true;
        }
    }

    public void confirmInput(View v) {
        if (!validateAddress() | !validateEmail() | !validateFName() | !validateLName() | !validatePhoneNumber()) {
            return;
        } else {

            String input = "Recipient Name :" + " " + textInputFName.getEditText().getText().toString() + " " + textInputLName.getEditText().getText().toString();
            input += "\n";
            input += "Recipient address :" + " " + textInputAddress.getEditText().getText().toString();
            input += "\n";
            input += "Recipient phone :" + " " + textInputPhone.getEditText().getText().toString();
            input += "\n";
            input += "Recipient email :" + " " + textInputEmail.getEditText().getText().toString();
            input += "\n";
            input += "Parcel delivery date :" + " " + txtDate.getText().toString();
            input += "\n";
            input += "Parcel registration succeed !";
            Toast.makeText(this, input, Toast.LENGTH_LONG).show();
            simpleParcel.setName(textInputFName.getEditText().getText().toString() + " " + textInputLName.getEditText().getText().toString());
            simpleParcel.setInhibitorAddress(new MyLocation(getLocationFromAddress(textInputAddress.getEditText().getText().toString()).getLatitude(),
                    getLocationFromAddress(textInputAddress.getEditText().getText().toString()).getAltitude()));
            simpleParcel.setPhoneNumber(textInputPhone.getEditText().getText().toString());
            simpleParcel.setMail(textInputEmail.getEditText().getText().toString());
            simpleParcel.setCameToInhibitorTime(new Date(txtDate.getText().toString()));
            simpleParcel.setMessengerName(textInputCarrier.getEditText().getText().toString());
            viewModel.addParcelToRepository(simpleParcel);
            Toast.makeText(this, input, Toast.LENGTH_LONG).show();
            Intent returnToAddParcelActivity = new Intent(AddParcelActivity.this, HistoryParcelActivity.class);
            startActivity(returnToAddParcelActivity);
        }
    }
}
