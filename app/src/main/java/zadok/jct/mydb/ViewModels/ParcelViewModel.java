package zadok.jct.mydb.ViewModels;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import zadok.jct.mydb.Data.ParcelRepository;
import zadok.jct.mydb.Entitties.Parcel;
import zadok.jct.mydb.Utils.PostStatus;

public class ParcelViewModel extends AndroidViewModel {



    ParcelRepository rp;
    Context r = getApplication();
final String TAG="ZADOK";
    public ParcelViewModel(@NonNull Application application) {
        super(application);
        rp=ParcelRepository.getInstance(r);
    }


    public MutableLiveData<PostStatus> getStatusMessageViewModel(){
    return rp.getStatusMessageRepository();
}

public void addParcelToRepository(Parcel parcel)
{
    Log.i(TAG,"addParcel to addParcelToRepository");
    rp.addParcelParcelDataSource(parcel);
}

    //TODO:

}
