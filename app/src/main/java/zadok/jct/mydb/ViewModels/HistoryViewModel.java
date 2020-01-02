package zadok.jct.mydb.ViewModels;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import zadok.jct.mydb.Data.ParcelRepository;
import zadok.jct.mydb.Entitties.Parcel;

public class HistoryViewModel extends AndroidViewModel {
    ParcelRepository rp;
    Context r = getApplication();
    final String TAG="ZADOK";



    public HistoryViewModel(@NonNull Application application) {
        super(application);
        rp=new ParcelRepository(r);
    }
    public MutableLiveData<List<Parcel>> getParcelsLiveDate()
    {
        return rp.getParcelsLiveData();
    }

    public void getDataFromRoom() {
        rp.getDataFromRoom();
    }
}
