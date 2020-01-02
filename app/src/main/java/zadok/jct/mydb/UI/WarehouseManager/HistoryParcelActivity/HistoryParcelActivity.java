package zadok.jct.mydb.UI.WarehouseManager.HistoryParcelActivity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.List;

import zadok.jct.mydb.Entitties.Parcel;
import zadok.jct.mydb.R;
import zadok.jct.mydb.ViewModels.HistoryViewModel;

public class HistoryParcelActivity extends AppCompatActivity {
    final String TAG = "ZADOK";
    HistoryViewModel historyViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_parcel);
        setContentView(R.layout.activity_history_parcel);

        historyViewModel = ViewModelProviders.of(this).get(HistoryViewModel.class);

        historyViewModel.getParcelsLiveDate().observe(this, new Observer<List<Parcel>>() {
            @Override
            public void onChanged(List<Parcel> parcels) {
                Log.i(TAG, "This is parcel from the room" + parcels.toString());
            }
        });
        historyViewModel.getDataFromRoom();
    }
}
