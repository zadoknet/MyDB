package zadok.jct.mydb.UI.WarehouseManager.AddParcelActivity;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import zadok.jct.mydb.R;

public class AddParcelActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
    }


}
