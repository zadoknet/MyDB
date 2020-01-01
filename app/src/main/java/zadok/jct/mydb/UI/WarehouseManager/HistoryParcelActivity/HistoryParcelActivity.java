package zadok.jct.mydb.UI.WarehouseManager.HistoryParcelActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import zadok.jct.mydb.R;
import zadok.jct.mydb.ViewModels.HistoryViewModel;

public class HistoryParcelActivity extends AppCompatActivity {
    HistoryViewModel historyViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_parcel);

        historyViewModel = ViewModelProviders.of(this).get(HistoryViewModel.class);
        historyViewModel.getParcelsLiveDate();
    }
}
