package zadok.jct.mydb.UI;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import zadok.jct.mydb.Entitties.Parcel;
import zadok.jct.mydb.R;
import zadok.jct.mydb.UI.WarehouseManager.warehouseManager;
import zadok.jct.mydb.Utils.PostStatus;
import zadok.jct.mydb.ViewModels.ParcelViewModel;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        final String TAG="ZADOK";

        ParcelViewModel viewModel = ViewModelProviders.of(this).get(ParcelViewModel .class);
        viewModel.getStatusMessageViewModel().observe(this, new Observer<PostStatus>() {
            @Override
            public void onChanged(PostStatus postStatus) {
                if(postStatus.getStatus()==PostStatus.savingStatus.SUCCESS)
                    Log.i(TAG,"saving success ViewModel");
                else if(postStatus.getStatus()==PostStatus.savingStatus.FAILED)
                    Log.i(TAG,"saving failed ViewModel");
            }
        });
        viewModel.addParcelToRepository(new Parcel(2344233,"zadok"));
        viewModel.addParcelToRepository(new Parcel(23,"zadok1"));





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


    }
}
