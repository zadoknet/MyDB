package zadok.jct.mydb;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import zadok.jct.mydb.Utils.Methods;


import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class DeliveryDetails extends AppCompatActivity implements View.OnClickListener {

    private TextInputLayout textInputFName;
    private TextInputLayout textInputLName;
    private TextInputLayout textInputEmail;
    private TextInputLayout textInputAddress;
    private TextView textInputDate;
    private TextInputLayout textInputPhone;

    Button btnDatePicker;
    EditText txtDate;
    private int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_details);
        Resources resParcelStatus = getResources();
        String[] parcelStatus = resParcelStatus.getStringArray(R.array.parcel_status);
        ArrayAdapter<String> typeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, parcelStatus);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner type = findViewById(R.id.parcel_status_spinner);
        type.setAdapter(typeAdapter);
        type.setPrompt("Parcel Status");
        type.setSelection(0);
        type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnDatePicker=(Button)findViewById(R.id.btn_date);
        txtDate=(EditText)findViewById(R.id.in_date);
        btnDatePicker.setOnClickListener(this);

       /* Button AddBtn = findViewById(R.id.add_button);
        AddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

        btnDatePicker=(Button)findViewById(R.id.btn_date);

        textInputFName = findViewById(R.id.f_name);
        textInputLName = findViewById(R.id.l_name);
        textInputEmail = findViewById(R.id.email);
        textInputAddress = findViewById(R.id.recipient_address);
        textInputDate = findViewById(R.id.in_date);
        textInputPhone = findViewById(R.id.phone);
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

   /* public boolean validateDate() {
        String dateInput = textInputDate.getEditText().getText().toString().trim();
        if (dateInput.isEmpty()) {
            textInputDate.setError("Field can't be empty!");
            return false;
        } else if (!dateInput.matches("^[0-9]{4}([- /.])(((0[13578]|(10|12))\\1(0[1-9]|[1-2][0-9]|3[0-1]))|(02\\1(0[1-9]|[1-2][0-9]))|((0[469]|11)\\1(0[1-9]|[1-2][0-9]|30)))$")) {
            textInputDate.setError("Date is incorrect!");
            return false;
        } else {
            textInputDate.setError(null);
            return true;
        }
    }*/

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
        if (!validateAddress() |  !validateEmail() | !validateFName() | !validateLName() | !validatePhoneNumber()) {
            return;
        }
        String input = "Recipient Name :" + " " + textInputFName.getEditText().getText().toString() + " " + textInputLName.getEditText().getText().toString();
        input += "\n";
        input += "Recipient address :" + " " + textInputAddress.getEditText().getText().toString();
        input += "\n";
        input += "Recipient phone :" + " " + textInputPhone.getEditText().getText().toString();
        input += "\n";
        input += "Recipient email :" + " " + textInputEmail.getEditText().getText().toString();
        input += "\n";
        input += "Parcel delivery date :" + " " + textInputDate.getText().toString();
        input += "\n";
        input += "Parcel registration succeed !";
        Toast.makeText(this, input, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        if (v == btnDatePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


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
}
