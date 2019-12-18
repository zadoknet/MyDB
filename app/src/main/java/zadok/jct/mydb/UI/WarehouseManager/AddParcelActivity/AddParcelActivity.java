package zadok.jct.mydb.UI.WarehouseManager.AddParcelActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import zadok.jct.mydb.R;

public class AddParcelActivity extends AppCompatActivity {

   private String[] parcelTypeArr = {"Envelope", "Small Package", "Large Package"};
    private String[] fragileContentArr={"Yes","No"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_parcell);


        ArrayAdapter<String> typeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, parcelTypeArr);
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


        ArrayAdapter<String> fragile = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, fragileContentArr);
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

    }

}
